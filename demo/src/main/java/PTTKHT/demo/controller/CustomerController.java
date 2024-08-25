package PTTKHT.demo.controller;

import PTTKHT.demo.Service.CustomerService;
import PTTKHT.demo.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CustomerController {
    private CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customerLogin")
    public String cusLogin(Model model){

        model.addAttribute("customer",new Customer());

        return "customerLoginForm";
    }

    @PostMapping("/customerLogin")
    public String cusLogin(@ModelAttribute("customer")Customer customer, Model model){
        customerService.save(customer);
        model.addAttribute("customer",new Customer());
        return "customerLoginForm";
    }

    @PostMapping("/customerHome")
    public String cusHome(@ModelAttribute("customer")Customer customer, Model model){

        Customer tmpCustomer = customerService.findByUserName(customer.getUsername());
        if(tmpCustomer==null)return "notFoundForm";
        if (!customer.getPassword().equals(tmpCustomer.getPassword())) return "notFoundForm";
        model.addAttribute("customer",tmpCustomer);
        return "customerHomeForm";

    }

    @GetMapping("/customerHome")
    public String cusHomeRedirect(@ModelAttribute("customer")Customer customer,Model model){
        model.addAttribute("customer",customer);

        return "customerHomeForm";
    }

    @GetMapping("/customerHome/changePassword")
    public String cusUpdate(@RequestParam("customerId")String username,Model model){
        Customer customer = customerService.findByUserName(username);

        model.addAttribute("customer",customer);

        return "customerUpdateForm";
    }

    @PostMapping("/customerHome/save")
    public String save(@Valid @ModelAttribute("customer")Customer customer, Model model, BindingResult bindingResult){
        if(bindingResult.hasErrors()) return "customerUpdateForm";
        else {
            customerService.save(customer);
            model.addAttribute("customer", customer);
            return "customerHomeForm";
        }
    }

    @GetMapping("/customerLogin/forgotPassword")
    public String cusRecoverPass(Model theModel){
        theModel.addAttribute("customer",new Customer());
        return "ForgotPassword";
    }

    @GetMapping("/customerLogin/register")
    public String cusRegister(Model theModel){
        theModel.addAttribute("customer",new Customer());
        return "registerForm";
    }




}
