package lk.sahan.dev.service;

import lk.sahan.dev.dto.CustomerDTO;
import lk.sahan.dev.entity.Customer;

import java.util.List;

public interface CustomerService {
    void saveCustomer(String cID, CustomerDTO customerDTO);
    boolean updateCustomer(String cID, CustomerDTO customerDTO);
    boolean  deleteCustomer(String cID);
    CustomerDTO findById(String cID);
    List<CustomerDTO> findAll();

}
