var token = localStorage.getItem("token");
async function loadAllScheduleTeacher() {
    var startdate = document.getElementById("startdate").value
    var enddate = document.getElementById("enddate").value
    var url = 'http://localhost:8080/api/doctor/getScheduleByDoctor'
    if(startdate != "" && enddate != ""){
        url = 'http://localhost:8080/api/doctor/getScheduleByDoctor?from='+startdate+'&to='+enddate
    }
    const response = await fetch(url, {
        method: 'GET',
        headers: new Headers({
            'Authorization': 'Bearer '+token
        })
    });
    var listresult = await response.json(); 
    console.log(listresult)
    var main = '';
    for(i=0; i< listresult.length; i++){
        main += `<tr>
                    <td><a href="tel:${listresult[i].patientRecord.phone}" class="btn btn-success btn_table"><i class="fa fa-phone"></i> call</a></td>
                    <td><a href="mailto:${listresult[i].patientRecord.user.email}" target="_blank" class="btn btn-success btn_table"><i class="fa fa-envelope"></i> send</a></td>
                    <td><button onclick="loadNote(${listresult[i].id})" class="btn btn-success btn_table"  data-toggle="modal" data-target=".bd-example-modal-lg"><i class="fa fa-list"></i> Note</button></td>
                    <td>${listresult[i].bookingDate}</td>
                    <td>${listresult[i].bookingTime}-${listresult[i].toTime}</td>
                    <td>${listresult[i].patientRecord.fulllName}</td>
                    <td>${listresult[i].patientRecord.phone}</td>
                    <td>${listresult[i].patientRecord.description}</td>
                </tr>`
    }
    document.getElementById("listschedule").innerHTML = main
    $('#example').DataTable();
}

async function loadNote(id) {
    var url = 'http://localhost:8080/api/doctor/getScheduleByIdRoleDoctor?id='+id
    const response = await fetch(url, {
        method: 'GET',
        headers: new Headers({
            'Authorization': 'Bearer '+token
        })
    });
    var result = await response.json(); 
    document.getElementById("medicines").value = result.medicines
    document.getElementById("note").value = result.note
    document.getElementById("idschedule").value = id
}

async function addNote(){
    var idschedule = document.getElementById("idschedule").value
    var medicines = document.getElementById("medicines").value
    var note = document.getElementById("note").value
    var schedule = {
        "id":idschedule,
        "medicines":medicines,
        "note":note
    }
    var url = 'http://localhost:8080/api/doctor/updateSchedule';
    const response = await fetch(url, {
        method: 'POST',
        headers: new Headers({
            'Authorization': 'Bearer '+token, 
            'Content-Type': 'application/json'
         }),
        body:JSON.stringify(schedule)
    });
    if(response.status < 300){
        swal({
            title: "Notification", 
            text: "save note successful!", 
            type: "success"
          },
        function(){ 
            window.location.reload();
        });
    }
    else{
        swal({
            title: "Notification", 
            text: "save error!", 
            type: "error"
          },
        function(){ 
        });
    }
}
