package PTTKHT.demo.controller;

import PTTKHT.demo.Service.CustomerService;
import PTTKHT.demo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String cusHome(@ModelAttribute("customer")Customer customer){

        Customer tmpCustomer = customerService.findByUserName(customer.getUsername());
        if(tmpCustomer==null)return "notFoundForm";
        if (!customer.getPassword().equals(tmpCustomer.getPassword())) return "notFoundForm";

        return "customerHomeForm";

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

    @GetMapping("/home")
    public String home(Model model){
        List<Customer> theList = customerService.findAll();
        model.addAttribute("customer",theList.get(0));
        return "homeForm";
    }
}
