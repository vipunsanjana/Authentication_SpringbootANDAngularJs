package com.vipun.Auth.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "id",length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name ="name",length = 255)
    private String name;

    @Column(name ="email",length = 255)
    private String email;

    @Column(name ="password",length = 255)
    private String password;

}
