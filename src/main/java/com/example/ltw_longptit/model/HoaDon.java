package com.example.ltw_longptit.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_donthuoc")
    private int id;
    @Column
    private String date;

    @OneToOne
    @JoinColumn(name = "id_kham")//name="tên cột khóa ngoại"
    Kham kham;

    @Column
    private int tongTien;
}
