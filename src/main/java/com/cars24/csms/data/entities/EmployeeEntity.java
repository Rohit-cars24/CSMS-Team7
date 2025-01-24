package com.cars24.csms.data.entities;


import com.cars24.csms.data.enums.EmployeeRole;
import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "employees")
@Entity
@Data

public class EmployeeEntity {

    @Id
    private int employee_id;

    @Column( name = "name" )
    private String name;

    @Column( name = "phone" )
    private String phone;

    @Column( name = "email" )
    private String email;

    @Column( name = "role" )
    private String role;

    @Column( name = "salary" )
    private double salary;

    @Column(name = "isActive")
    private boolean isActive;

    @Column(name = "user_id")
    private int user_id;

}
