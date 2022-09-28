package com.example.demo.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "barang")
@Getter
@Setter

public class Barang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_barang;

    @Column
    private String nama_barang;

    @Column
    private Double harga_barang;

    @Column
    private Integer stok;
}
