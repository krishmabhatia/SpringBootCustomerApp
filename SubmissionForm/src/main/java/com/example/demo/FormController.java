package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
    @Autowired
    CustomersRepo repo;
    
    @RequestMapping("/")
    public String formfill() {
        return "FillForm";
    }
    
    @RequestMapping("/details")
    public String details(Customers customer) {
        repo.save(customer);
        return "ViewCustomers";
    }
    
   @PostMapping("/getdetails")
    public ModelAndView getdetails(@RequestParam int cid) {
    ModelAndView mv = new ModelAndView("Retrieve");
        Customers customer = repo.findById(cid).orElse(null);
        mv.addObject(customer);
        return mv;
    }
}
