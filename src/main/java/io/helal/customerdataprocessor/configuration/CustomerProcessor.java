package io.helal.customerdataprocessor.configuration;

import io.helal.customerdataprocessor.entity.Customer;
import org.springframework.batch.item.ItemProcessor;

public class CustomerProcessor implements ItemProcessor<Customer, Customer> {

    @Override
    public Customer process(final Customer customer) throws Exception {
        return customer;
    }
}
