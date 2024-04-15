package com.medisure.medisure_as.rest;

import com.medisure.medisure_as.dto.CustomUserDetails;
import com.medisure.medisure_as.dto.PasswordDto;
import com.medisure.medisure_as.entity.Authority;
import com.medisure.medisure_as.entity.User;
import com.medisure.medisure_as.jwt.JwtTokenProvider;
import com.medisure.medisure_as.repository.AuthorityRepository;
import com.medisure.medisure_as.repository.UserRepository;
import com.medisure.medisure_as.service.Contains;
import com.medisure.medisure_as.service.MailService;
import com.medisure.medisure_as.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserRest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityRepository authorityRepository;

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody User user) throws URISyntaxException {
        Optional<User> users = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        System.out.println(users);
        if(users.isPresent() == false){
            return ResponseEntity.status(401)
                    .body(null);
        }
        CustomUserDetails customUserDetails = new CustomUserDetails(users.get());
        String token = jwtTokenProvider.generateToken(customUserDetails);
        return ResponseEntity
                .created(new URI("/api/authen/" ))
                .body(token);
    }

    @PostMapping("/all/userlogged")
    public User getUserLogged(){
        return userService.getUserWithAuthority();
    }


    @PostMapping("/user/updateemail")
    public void updateEmail(@RequestParam("email") String email, @RequestParam("sex") Integer sex){
        User u = userService.getUserWithAuthority();
        u.setEmail(email);
        u.setSex(sex);
        userRepository.save(u);
    }

    @PostMapping("/admin/activeUser")
    public void activeOrUnactiveUser(@RequestParam("id") Long id){
        User user = userRepository.findById(id).get();
        if(user.getActived() == 1){
            user.setActived(0);
        }
        else{
            user.setActived(1);
        }
        userRepository.save(user);
    }


    @PostMapping("/public/regisacount")
    public ResponseEntity<User> regis(@RequestBody User user){
        if(userService.checkEmailexist(user.getEmail())){
            HttpHeaders headers = new HttpHeaders();
            headers.add("email already exist ", user.getEmail());
            return ResponseEntity.status(300).headers(headers)
                    .body(null);
        }
        else if(userRepository.findByUsername(user.getUsername()).isPresent() == true){
            HttpHeaders headers = new HttpHeaders();
            return ResponseEntity.status(500).headers(headers)
                    .body(null);
        }
        user.setAuthorities(authorityRepository.findByName(Contains.ROLE_USER));
        User result = userService.save(user);
        System.out.println("user regis: "+user);
        return ResponseEntity.status(200)
                .body(result);
    }

    @PostMapping("/public/addUserDoctor")
    public ResponseEntity<User> addUserDoctor(@RequestBody User user){
        if(user.getId() == null){
            if(userRepository.getUserByEmail(user.getEmail()).isPresent() == true){
                HttpHeaders headers = new HttpHeaders();
                return ResponseEntity.status(300).headers(headers)
                        .body(null);
            }
            if(userRepository.findByUsername(user.getUsername()).isPresent() == true){
                HttpHeaders headers = new HttpHeaders();
                return ResponseEntity.status(500).headers(headers)
                        .body(null);
            }
        }
        user.setAuthorities(authorityRepository.findByName(Contains.ROLE_DOCTOR));
        user.setCreated_date(new Timestamp(System.currentTimeMillis()));
        user.setActived(1);
        if(user.getId() == null){
            String pass = userService.randomPass();
            user.setPassword(passwordEncoder.encode(pass));
            mailService.sendEmail(user.getEmail(),"Your Password","your password: "+pass,false,false);
        }
        else{
            User u = userRepository.findById(user.getId()).get();
            user.setActived(u.getActived());
            user.setCreated_date(u.getCreated_date());
            user.setPassword(u.getPassword());
        }
        User result = userRepository.save(user);
        return ResponseEntity.status(200).body(result);
    }

    @PostMapping("/admin/addUserDoctor")
    public ResponseEntity<User> addUserForDoctor(@RequestBody User user){
        if(userService.checkEmailexist(user.getEmail())){
            HttpHeaders headers = new HttpHeaders();
            headers.add("email already exist ", user.getEmail());
            return ResponseEntity.status(300).headers(headers)
                    .body(null);
        }
        else if(userRepository.findByUsername(user.getUsername()).isPresent() == true){
            HttpHeaders headers = new HttpHeaders();
            return ResponseEntity.status(500).headers(headers)
                    .body(null);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActived(1);
        user.setActivation_key(null);
        user.setCreated_date(new Timestamp(System.currentTimeMillis()));
        user.setAuthorities(authorityRepository.findByName(Contains.ROLE_DOCTOR));
        User result = userRepository.save(user);
        System.out.println("user for doctor: "+user);
        return ResponseEntity.status(200)
                .body(result);
    }

    @PostMapping("/doctor/updateUserForDoctor")
    public ResponseEntity<User> aupdateUserForDoctor(@RequestBody User user){
        User u = userService.getUserWithAuthority();
        u.setEmail(user.getEmail());
        u.setSex(user.getSex());
        u.setAvatar(user.getAvatar());
        User result = userRepository.save(u);
        return ResponseEntity.status(200)
                .body(result);
    }

    @PostMapping("/all/changePassword")
    public void changePassword(@RequestBody PasswordDto passwordDto) throws Exception {
        User user = userService.getUserWithAuthority();
        if(passwordEncoder.matches(passwordDto.getOldPass(), user.getPassword())){
            user.setPassword(passwordEncoder.encode(passwordDto.getNewPass()));
        }
        else{
            throw new Exception("password failed");
        }
        userRepository.save(user);
    }

    @PostMapping("/resetpass")
    public ResponseEntity<String> resetPassword(@RequestBody String email) throws URISyntaxException {
        Optional<User> user = userRepository.getUserByEmail(email);
        if(user.isPresent() == false){
            return ResponseEntity.status(500)
                    .body("this email not exist");
        }
        else{
            String newPass = userService.randomPass();
            User users = user.get();
            users.setPassword(passwordEncoder.encode(newPass));
            userRepository.save(users);
            mailService.sendEmail(email,"reset your password","your new password: "+newPass,false, false);
        }
        return ResponseEntity.status(200)
                .body("check your email");
    }

    @GetMapping("/user/checkroleUser")
    public void checkroleUser(){
        System.out.println(("user"));
    }

    @GetMapping("/doctor/checkroleDoctor")
    public void checkroleDoctor(){
        System.out.println(("doctor"));
    }

    @GetMapping("/admin/checkroleAdmin")
    public void checkroleAdmin(){
        System.out.println(("admin"));
    }

    @GetMapping("/admin/getAllUserNotAdmin")
    public List<User> getUserNotAdmin(){
        return userRepository.findUserNotAdmin("ROLE_ADMIN");
    }


}
