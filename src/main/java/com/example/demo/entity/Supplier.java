package com.example.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "supplier")
@Getter
@Setter
@NoArgsConstructor
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BIGINT(11)")
    private Long id;

    @Column
    private String nama_supplier;

    @Column
    private String no_telp;

    @Column
    private String alamat;

    @OneToMany(mappedBy = "supplier")
    private List<Barang>barangList;


}
