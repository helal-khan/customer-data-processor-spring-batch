package io.helal.customerdataprocessor.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "invalid_customers",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"phone"}, name = "ic_invalid_customers_phone"),
                @UniqueConstraint(columnNames = {"email"}, name = "ic_invalid_customers_email")
        }
)
public class InvalidCustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "ip_address")
    private String ipAddress;

}
