package com.cars24.csms.data.entities;

import com.cars24.csms.data.enums.Servicenamecheck;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NonNull;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="services")
@Entity
@Data
class ServiceEntity {
@Id
    private int service_id;

@Column(name = "service_name",nullable = false)
    private String service_name;

@Column(name = "price",nullable = false)
    private int price;

}
