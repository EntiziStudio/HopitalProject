package com.medisure.medisure_as.repository;

import com.medisure.medisure_as.entity.Doctors;
import com.medisure.medisure_as.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InvoiceRepository extends JpaRepository<Invoice,Long> {

    @Query("select i from Invoice i where i.schedule.id = ?1")
    public Invoice findBySchedule(Long idSchedule);

    @Query(value = "select sum(i.total_amount) from Invoice i where Month(i.created_date) =?1 and YEAR(i.created_date) = ?2", nativeQuery = true)
    public Double statitics(Integer month, Integer year);

    @Query("select count(d.id) from Invoice d")
    public Double getTotal();
}
