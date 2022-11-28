package com.OnlineMedicalShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.OnlineMedicalShop.model.LoginUser;
import com.OnlineMedicalShop.model.Medicine;
import com.OnlineMedicalShop.model.Payment;
import com.OnlineMedicalShop.model.Signup;
import com.OnlineMedicalShop.repository.medicineRepository;
import com.OnlineMedicalShop.service.MedicineService;
import com.OnlineMedicalShop.service.signupService;
import com.OnlineMedicalShop.repository.PaymentRepository;
import com.OnlineMedicalShop.repository.SignupRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
public class SignupController {
    @Autowired
    SignupRepository surepo;
    @Autowired
    signupService sus;
    @Autowired
    medicineRepository medrepo;
    @Autowired
    MedicineService medservice;
    @Autowired
    PaymentRepository paymentrepo;
    
    @RequestMapping("/signup")
    public Boolean create(@RequestBody Signup su) {
        System.out.println("in signup");
        surepo.save(su);
        if(sus.checkEntry(su.getEmail())) {
            return true;
            }
            else {
                return false;
            }
    }
    @RequestMapping(value ="/signin", method= RequestMethod.POST)
    public Boolean userlogin(@RequestBody LoginUser lu) {
        if(sus.verifyUser(lu.getEmail(), lu.getPassword())){
            return true;
        }
        else{
            return false;
        }
    }
    @PutMapping("/updateuser/{id}")
    public Boolean updateuser(@PathVariable int id,@RequestBody Signup su) {
        return sus.updateUser(id, su);
    }
    @GetMapping("/showallmed")
    public List<Medicine> showallmedicine(){
        return medrepo.findAllbyInstock();
    }



   @GetMapping("products/{id}")
    public ResponseEntity<Medicine> getProductById(@PathVariable int id) {
        Medicine product = medrepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Oops! Nothing found."));
        return ResponseEntity.ok(product);
    }
    @GetMapping("products/search/{keyword}")
    public List<Medicine> getSearchProducts(@PathVariable String keyword) {
        return medrepo.homeSearch(keyword);
    }
    
    @GetMapping("/medicine/sort/price")
    public List<Medicine> sortByPrice(){
        return medrepo.sortbyMedicinePrice();
    }



   @GetMapping("/Medicine/sort/price/dsc")
    public List<Medicine> sortByPriceDsc(){
        return medrepo.sortbyPriceHigh();
    }
    
   
    @PostMapping("/payment")
    public boolean paymentGateWay(@RequestBody Payment payment) {
        paymentrepo.save(payment);
        return true;
        
    }
    }
