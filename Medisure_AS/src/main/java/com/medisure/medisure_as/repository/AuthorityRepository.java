package com.medisure.medisure_as.repository;

import com.medisure.medisure_as.entity.Authority;
import com.medisure.medisure_as.entity.DetailInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface AuthorityRepository extends JpaRepository<Authority,String> {

    @Query("select a from Authority a where a.name = ?1")
    public Set<Authority> findByName(String name);
}
