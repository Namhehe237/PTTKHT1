package PTTKHT.demo.Service;

import PTTKHT.demo.Repository.CustomerRepository;
import PTTKHT.demo.model.Customer;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findByUserName(String userName){
        Optional<Customer> res = customerRepository.findById(userName);

        Customer tmp = null;

        if (res.isPresent())
            tmp = res.get();

        return tmp;
    }

    public List<Customer> findAll(){
        return customerRepository.findAll();
    }
    public Customer save(Customer customer){

        return customerRepository.save(customer);
    }
}
