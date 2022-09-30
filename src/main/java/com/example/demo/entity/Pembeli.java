package com.example.demo.entity;

import com.example.demo.entity.dto.PembeliDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "pembeli")
@Getter
@Setter
public class Pembeli extends PembeliDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nama_pembeli;

    @Column
    private String jk;

    @Column
    private String no_telp;

    @Column
    private String alamat;

    @OneToMany(mappedBy = "pembeli")
    private List<Transaksi> transaksiList;


}
