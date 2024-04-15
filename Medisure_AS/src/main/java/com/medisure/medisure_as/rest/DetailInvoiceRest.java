package com.medisure.medisure_as.rest;

import com.medisure.medisure_as.dto.ProcessDto;
import com.medisure.medisure_as.entity.DetailInvoice;
import com.medisure.medisure_as.entity.Invoice;
import com.medisure.medisure_as.entity.MedicalProcess;
import com.medisure.medisure_as.repository.DetailInvoiceRepository;
import com.medisure.medisure_as.repository.InvoiceRepository;
import com.medisure.medisure_as.repository.MedicalProcessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class DetailInvoiceRest {

    @Autowired
    private DetailInvoiceRepository detailInvoiceRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private MedicalProcessRepository medicalProcessRepository;

    @GetMapping("/admin/detailInvoiceByInvoiceId")
    public List<DetailInvoice> detailByInvoiceId(@RequestParam("id") Long scheduleId){
        return detailInvoiceRepository.findByInvoice(scheduleId);
    }

    @GetMapping("/user/detailInvoiceByInvoiceId")
    public List<DetailInvoice> detailByInvoiceIdUser(@RequestParam("id") Long scheduleId){
        return detailInvoiceRepository.findByInvoice(scheduleId);
    }

    @DeleteMapping("/admin/deleteDetailInvoice")
    public void deleteDetail(@RequestParam("id") Long id) throws Exception {
        DetailInvoice detailInvoice = detailInvoiceRepository.findById(id).get();
        Invoice invoice = detailInvoice.getInvoice();
        invoice.setTotalAmount(invoice.getTotalAmount() - detailInvoice.getMedicalProcess().getPrice());
        if(invoice.getTotalAmount() == 0){
            throw new Exception("invoice can't equal 0");
        }
        invoiceRepository.save(invoice);
        detailInvoiceRepository.deleteById(id);
    }

    @PostMapping("/admin/addProcessToDetail")
    public void addProcess(@RequestBody ProcessDto processDto){
        Invoice invoice = invoiceRepository.findBySchedule(processDto.getScheduleId());
        System.out.println("===== invoice: "+invoice);
        Double total = 0D;
        for(Long idProcess: processDto.getListProcess()){
            DetailInvoice detailInvoice = new DetailInvoice();
            detailInvoice.setInvoice(invoice);
            MedicalProcess me = medicalProcessRepository.findById(idProcess).get();
            detailInvoice.setMedicalProcess(me);
            detailInvoiceRepository.save(detailInvoice);
            total += me.getPrice();
        }
        invoice.setTotalAmount(invoice.getTotalAmount() + total);
        invoiceRepository.save(invoice);
    }

}
