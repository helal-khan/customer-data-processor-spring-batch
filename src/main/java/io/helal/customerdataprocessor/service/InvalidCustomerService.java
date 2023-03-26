package io.helal.customerdataprocessor.service;

import io.helal.customerdataprocessor.entity.InvalidCustomer;

public interface InvalidCustomerService {

    void saveInvalidCustomer(InvalidCustomer invalidCustomer);

    InvalidCustomer findByEmailOrPhone(String email, String phone);
}
