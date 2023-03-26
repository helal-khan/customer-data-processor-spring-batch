package io.helal.customerdataprocessor.service;

import io.helal.customerdataprocessor.entity.Customer;

public interface CustomerService {

    Customer findByEmailOrPhone(String email, String phone);
}
