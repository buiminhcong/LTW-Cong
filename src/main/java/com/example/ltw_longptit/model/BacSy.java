package com.example.ltw_longptit.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table
public class BacSy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bs")
    private int id;
    @Column
    private String name;
}
