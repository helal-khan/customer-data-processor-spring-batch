package io.helal.customerdataprocessor.configuration;

import io.helal.customerdataprocessor.configuration.mapper.MapperRegistry;
import io.helal.customerdataprocessor.entity.Customer;
import io.helal.customerdataprocessor.entity.InvalidCustomer;
import io.helal.customerdataprocessor.service.CustomerService;
import io.helal.customerdataprocessor.service.InvalidCustomerService;
import io.helal.customerdataprocessor.validator.CustomerValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerDataProcessor implements ItemProcessor<Customer, Customer> {

    private final CustomerService customerService;
    private final InvalidCustomerService invalidCustomerService;
    private final MapperRegistry mapperRegistry;


    @Override
    public Customer process(Customer customer) {

        if (!CustomerValidator.isValidMail(customer.getEmail()) || !CustomerValidator.isValidPhoneNumber(customer.getPhone())) {
            if (invalidCustomerService.findByEmailOrPhone(customer.getEmail(), customer.getPhone()) == null) {
                invalidCustomerService.saveInvalidCustomer(mapperRegistry.getMapper(Customer.class, InvalidCustomer.class).map(customer));
            }
            return null;
        } else if (customerService.findByEmailOrPhone(customer.getEmail(), customer.getPhone()) != null) {
            return null;
        } else {
            return customer;
        }
    }
}
