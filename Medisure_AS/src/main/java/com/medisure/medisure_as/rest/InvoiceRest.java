package com.medisure.medisure_as.rest;

import com.medisure.medisure_as.dto.InvoiceDto;
import com.medisure.medisure_as.entity.DetailInvoice;
import com.medisure.medisure_as.entity.Invoice;
import com.medisure.medisure_as.entity.MedicalProcess;
import com.medisure.medisure_as.entity.Schedule;
import com.medisure.medisure_as.repository.DetailInvoiceRepository;
import com.medisure.medisure_as.repository.InvoiceRepository;
import com.medisure.medisure_as.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class InvoiceRest {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private DetailInvoiceRepository detailInvoiceRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @PostMapping("/admin/addinvoice")
    public void save(@RequestBody InvoiceDto invoiceDto){
        Schedule schedule = scheduleRepository.findById(invoiceDto.getSchedule().getId()).get();
        schedule.setPaid(1);
        scheduleRepository.save(schedule);
        Invoice invoice = new Invoice();
        invoice.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        invoice.setSchedule(invoiceDto.getSchedule());
        invoice.setNote(invoiceDto.getNote());
        invoice.setTotalAmount(invoiceDto.getTotalAmount());
        Invoice result = invoiceRepository.save(invoice);
        for(Long idprocess: invoiceDto.getListProcess()){
            DetailInvoice d = new DetailInvoice();
            d.setInvoice(result);
            MedicalProcess me = new MedicalProcess();
            me.setId(idprocess);
            d.setMedicalProcess(me);
            detailInvoiceRepository.save(d);
        }
    }

    @DeleteMapping("/admin/deleteInvoice")
    public void deleteScheduleByAdmin(@RequestParam("id") Long id) throws Exception {
        Invoice invoice = invoiceRepository.findBySchedule(id);
        List<DetailInvoice> list = detailInvoiceRepository.findByInvoice(id);
        for(DetailInvoice d : list){
            detailInvoiceRepository.delete(d);
        }
        invoiceRepository.delete(invoice);
        Schedule schedule = scheduleRepository.findById(id).get();
        schedule.setPaid(0);
        scheduleRepository.save(schedule);
    }

    @GetMapping("/admin/statitic")
    public List<Double> getstatitic(@RequestParam("year") Integer year){
        List<Double> list = new ArrayList<>();
        for(int i=1; i<13; i++){
            Double val = invoiceRepository.statitics(i, year);
            if(val == null){
                val = 0D;
            }
            list.add(val);
        }
        return list;
    }
}
