package com.cars24.csms.data.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "User_Details")
public class AppUserDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column( name = "id" )
    private Integer id;

    @Column( name = "username")
    private String username;

    @Column( name = "password")
    private String password;

    @Column( name = "is_enabled" )
    private Boolean is_enabled;

}
