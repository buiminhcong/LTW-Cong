package com.example.ltw_longptit.model;

import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@Entity
@Data
@Table
public class Thuoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_thuoc")
    private long id;

    @Column
    @Min(value = 0 , message = "Giá phải lớn hơn 0")
    private double gia;

    @Column
    @NotBlank(message = "Thiếu Tên Thuốc")
    private  String ten;

    @Column
    @NotBlank(message = "Thiếu Tên Loại Thuốc")
    private String loaiThuoc;

}