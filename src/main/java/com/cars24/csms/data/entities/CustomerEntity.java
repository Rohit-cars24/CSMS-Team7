
package com.cars24.csms.data.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.lang.NonNull;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="customers")
@Entity
@Data
public class CustomerEntity {
    @Id
    private int customer_id;
    //    @NonNull
    private String name;
    //    @NonNull
    private String phone;
    private String email;
    private String address;
    private int userId;
    private boolean isActive;

}
