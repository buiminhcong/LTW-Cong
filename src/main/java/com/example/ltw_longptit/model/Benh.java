package com.example.ltw_longptit.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Data
@Entity
@Table
public class Benh {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_benh")
    private long id;

    @Column
    @NotBlank(message = "Tên bệnh không được để trống!")
    private String ten;

    @Column
    private String moTa;
}
