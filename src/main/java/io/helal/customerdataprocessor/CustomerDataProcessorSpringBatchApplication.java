package io.helal.customerdataprocessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class CustomerDataProcessorSpringBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerDataProcessorSpringBatchApplication.class, args);
	}

}
