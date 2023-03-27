package io.helal.customerdataprocessor.configuration;

import io.helal.customerdataprocessor.configuration.mapper.MapperRegistry;
import io.helal.customerdataprocessor.entity.Customer;
import io.helal.customerdataprocessor.entity.InvalidCustomer;
import io.helal.customerdataprocessor.repository.InvalidCustomerRepository;
import io.helal.customerdataprocessor.validator.CustomerValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomerDataProcessor implements ItemProcessor<Customer, Customer> {

    private final InvalidCustomerRepository invalidCustomerRepository;
    private final MapperRegistry mapperRegistry;
    private final Set<Customer> processedCustomer = new HashSet<>();
    private final Set<InvalidCustomer> processedInvalidCustomer = new HashSet<>();


    @Override
    public Customer process(Customer customer) {

        InvalidCustomer invalidCustomer = mapperRegistry.getMapper(Customer.class, InvalidCustomer.class).map(customer);
        if ((!CustomerValidator.isValidMail(customer.getEmail()) || !CustomerValidator.isValidPhoneNumber(customer.getPhone())) && !processedInvalidCustomer.contains(invalidCustomer)) {
            invalidCustomerRepository.save(invalidCustomer);
            processedInvalidCustomer.add(invalidCustomer);
            return null;
        } else if (processedCustomer.contains(customer)) {
            return null;
        } else {
            processedCustomer.add(customer);
            return customer;
        }
    }
}
