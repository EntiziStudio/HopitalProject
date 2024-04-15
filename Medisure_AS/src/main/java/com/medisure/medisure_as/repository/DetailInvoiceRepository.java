package com.medisure.medisure_as.repository;

import com.medisure.medisure_as.entity.DetailInvoice;
import com.medisure.medisure_as.entity.Doctors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DetailInvoiceRepository extends JpaRepository<DetailInvoice,Long> {

    @Query(value = "SELECT * from detail_invoice d inner join invoice i on i.id = d.invoice_id where i.schedule_id = ?1", nativeQuery = true)
    public List<DetailInvoice> findByInvoice(Long id);
}
