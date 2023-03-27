package io.helal.customerdataprocessor.repository;

import io.helal.customerdataprocessor.entity.InvalidCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InvalidCustomerRepository extends JpaRepository<InvalidCustomer, Long> {
}
