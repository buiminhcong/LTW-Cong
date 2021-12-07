package com.example.ltw_longptit.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class ThuocSuDung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_thuoc_sd")
    private int id;
    @Column
    private int soLuong;

    @ManyToOne
    @JoinColumn(name = "id_thuoc")//name="tên cột khóa ngoại"
    Thuoc thuoc;
    @ManyToOne
    @JoinColumn(name = "id_donthuoc")//name="tên cột khóa ngoại"
    HoaDon hoaDon;


}
