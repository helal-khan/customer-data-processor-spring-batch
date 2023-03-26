package io.helal.customerdataprocessor.repository;

import io.helal.customerdataprocessor.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmailOrPhone(String email, String phone);
}
