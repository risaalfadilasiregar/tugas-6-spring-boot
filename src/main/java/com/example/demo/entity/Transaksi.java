package com.example.demo.entity;

import com.example.demo.entity.dto.TransaksiDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table( name = "transaksi")
@Getter
@Setter

public class Transaksi extends TransaksiDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BIGINT(11")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_barang")
    private Barang barang;

    @ManyToOne
    @JoinColumn(name = "id_pembeli")
    private Pembeli pembeli;

    @Column
    private Date tanggalBayar;

    @Column(columnDefinition = "VARCHAR(100)")
    private String keterangan;

    @OneToMany(mappedBy = "transaksi")
    private List<Pembayaran> pembayaranList;


}
