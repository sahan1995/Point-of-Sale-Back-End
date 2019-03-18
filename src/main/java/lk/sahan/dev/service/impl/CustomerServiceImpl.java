package lk.sahan.dev.service.impl;

import lk.sahan.dev.dto.CustomerDTO;
import lk.sahan.dev.entity.Customer;
import lk.sahan.dev.repository.CustomerRepository;
import lk.sahan.dev.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

   @Autowired
   private CustomerRepository customerR;
   @Autowired
    private BCryptPasswordEncoder passwordEncoder;
   @Override
   public void saveCustomer(String cID, CustomerDTO customerDTO) {
       if(!cID.equals(customerDTO.getId())){
           throw new RuntimeException("ID's are Not Same");

       }

       String encode = passwordEncoder.encode(customerDTO.getPassword());
       System.out.println(encode);
       Customer customer = new Customer(customerDTO.getId(), customerDTO.getName(), customerDTO.getAddress(),customerDTO.getImageName(),customerDTO.getUsername(),encode);
       customerR.save(customer);


   }

   @Override
   public boolean updateCustomer(String cID, CustomerDTO customerDTO) {

       if(customerR.existsById(cID)){
           saveCustomer(cID,customerDTO);
           return true;
       }else {
           return false;
       }

   }

   @Override
   public boolean deleteCustomer(String cID) {
       customerR.deleteById(cID);
       return true;
   }

   @Override
   public CustomerDTO findById(String cID) {
       Optional<Customer> OPCus = customerR.findById(cID);
       if(OPCus.isPresent()){
           System.out.println("Find");
           Customer customer = OPCus.get();
           return new CustomerDTO(customer.getId(),customer.getName(),customer.getAddress(),customer.getImageName(),customer.getUsername(),customer.getPassword());
       }else{
           System.out.println("Not Found ");
           return null;
       }


   }

   @Override
   public List<CustomerDTO> findAll() {
       List<Customer> customers = customerR.findAll();
       ArrayList<CustomerDTO> customerDTOS = new ArrayList<>();
       customers.forEach(c->{
           customerDTOS.add(new CustomerDTO(c.getId(),c.getName(),c.getAddress(),c.getImageName(),c.getUsername(),c.getPassword()));
       });
       return customerDTOS;
   }
}
