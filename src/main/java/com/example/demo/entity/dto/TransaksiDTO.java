package com.example.demo.entity.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jdk.jfr.internal.Type;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TransaksiDTO {
    private Long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BarangDTO barang;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PembeliDTO pembeli;

    private Date tanggal;

    private String keterangan;

    public Type getTransaksi() {
        return null;
    }
}
