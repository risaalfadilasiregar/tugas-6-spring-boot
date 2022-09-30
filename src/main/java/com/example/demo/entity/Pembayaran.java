package com.example.demo.entity;

import com.example.demo.entity.dto.PembayaranDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table( name = "pembayaran")
@Getter
@Setter
public class Pembayaran extends PembayaranDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BIGINT(11)")
    private Long id;

    @Column
    private Date tanggalBayar;

    @Column(columnDefinition = "INT(11)")
    private Integer totalBayar;

    @ManyToOne
    @JoinColumn(name = "id_transaksi")
    private Transaksi transaksi;

}
