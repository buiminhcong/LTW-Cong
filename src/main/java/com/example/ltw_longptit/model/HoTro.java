package com.example.ltw_longptit.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class HoTro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_yta")
    Yta yta;

    @ManyToOne
    @JoinColumn(name = "id_kham")
    Kham kham;

}
