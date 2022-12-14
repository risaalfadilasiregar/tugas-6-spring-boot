package com.example.demo.entity.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BarangDTO {
    private Long id_barang;

    private String nama_barang;

    private Double harga_barang;

    private Integer stok;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private SupplierDTO supplier;

}
