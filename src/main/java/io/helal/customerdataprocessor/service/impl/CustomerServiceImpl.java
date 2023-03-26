package io.helal.customerdataprocessor.service.impl;

import io.helal.customerdataprocessor.entity.Customer;
import io.helal.customerdataprocessor.repository.CustomerRepository;
import io.helal.customerdataprocessor.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;


    @Override
    public Customer findByEmailOrPhone(String email, String phone) {
        return customerRepository.findByEmailOrPhone(email, phone).orElse(null);
    }
}
