package com.OnlineMedicalShop.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OnlineMedicalShop.exception.EmailAlreadyExistException;
import com.OnlineMedicalShop.exception.EmailIdFormatException;
import com.OnlineMedicalShop.model.Admin;
import com.OnlineMedicalShop.model.Medicine;
import com.OnlineMedicalShop.model.Payment;
import com.OnlineMedicalShop.repository.AdminRepository;
import com.OnlineMedicalShop.repository.medicineRepository;
import com.OnlineMedicalShop.service.AdminService;
import com.OnlineMedicalShop.service.MedicineService;
import com.OnlineMedicalShop.repository.PaymentRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
public class AdminController {
    @Autowired
    AdminService adminservice;
    
    @Autowired
    AdminRepository adminrepo;
    
    @Autowired
    MedicineService medicineservice;
    
    @Autowired
    medicineRepository medicinerepo;
    
    @Autowired
    PaymentRepository paymentrepo;
    
    @RequestMapping("/adminlogin")
    public Boolean adminlogin(@RequestBody Admin a) {
        
        if(adminservice.verifyAdmin(a.getEmail(), a.getPassword())){
            return true;
        }
        else{
            return false;
        }
    }
    
    @RequestMapping("/createadminaccount")
    public Boolean createAccount(@RequestBody @Valid Admin a) {
        adminrepo.save(a);
        if(adminservice.checkEntry(a.getEmail())) {
        return true;
        }
        else {
            return false;
        }
    }
    @GetMapping("/getallMedicinedetails")
    public List<Medicine> getall(){
        return medicineservice.getAllMedicine();
    }
    @PostMapping("/addmedicine")
    public Boolean addMedicine(@RequestBody Medicine f) {
        System.out.println("medicine");
        Medicine f1 = medicineservice.addMedicine(f);
        if(f1!=null) {
            return true;
        }
        else {
            return false;
        }
    }
    @PutMapping("/updatemedicine/{id}")
    public Boolean updateMedicine(@PathVariable int id,@RequestBody Medicine f) {
        return medicineservice.updateMedicine(f, id);
    }
    
    @DeleteMapping("/deletemedicine/{id}")
    public Boolean deleteMedicine(@PathVariable int id) {
        return medicineservice.deleteMedicine(id);
    }



   @GetMapping("/alltransactions")
    public List<Payment> allpayment() {
        return paymentrepo.findAll();
    }
}
