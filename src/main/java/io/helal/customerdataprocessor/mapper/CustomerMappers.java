package io.helal.customerdataprocessor.mapper;


import io.helal.customerdataprocessor.configuration.mapper.Mapper;
import io.helal.customerdataprocessor.configuration.mapper.MapperRegistry;
import io.helal.customerdataprocessor.entity.Customer;
import io.helal.customerdataprocessor.entity.InvalidCustomer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class CustomerMappers {

    private final MapperRegistry mapperRegistry;

    @PostConstruct
    private void registerMappers() {
        mapperRegistry.addMapper(Customer.class, InvalidCustomer.class, CustomerToInvalidCustomerMapper());
    }

    private Mapper<Customer, InvalidCustomer> CustomerToInvalidCustomerMapper() {
        return customer -> InvalidCustomer.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .city(customer.getCity())
                .state(customer.getState())
                .zipCode(customer.getZipCode())
                .phone(customer.getPhone())
                .email(customer.getEmail())
                .ipAddress(customer.getIpAddress())
                .build();
    }
}
