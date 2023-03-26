package io.helal.customerdataprocessor.service.impl;

import io.helal.customerdataprocessor.entity.InvalidCustomer;
import io.helal.customerdataprocessor.repository.InvalidCustomerRepository;
import io.helal.customerdataprocessor.service.InvalidCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvalidCustomerServiceImpl implements InvalidCustomerService {

    private final InvalidCustomerRepository invalidCustomerRepository;


    @Override
    public void saveInvalidCustomer(InvalidCustomer invalidCustomer) {
        invalidCustomerRepository.save(invalidCustomer);
    }

    @Override
    public InvalidCustomer findByEmailOrPhone(String email, String phone) {
        return invalidCustomerRepository.findByEmailOrPhone(email, phone).orElse(null);
    }
}
