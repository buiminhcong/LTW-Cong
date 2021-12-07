package com.example.ltw_longptit.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table

public class Yta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_yta")
    private int id;
    @Column
    private int ytaThamNien;
    @Column
    private String ytaCMT;
    @Column
    private String ytaTen;
    @Column
    private String ytaSDT;
    @Column
    private String ytaDiaChi;
    @Column
    private String ytaNgaySinh;
}
