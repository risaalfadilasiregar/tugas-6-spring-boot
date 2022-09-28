package com.example.demo.entity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BarangDTO {
    private Long id_barang;

    private String nama_barang;

    private Double harga_barang;

    private Integer stok;

    private String id_supplier;
}
