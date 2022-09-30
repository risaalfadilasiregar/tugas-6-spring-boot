package com.example.demo.entity.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PembayaranDTO {
    private Long id;
    private Date tanggalBayar;
    private Double totalBayar;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private TransaksiDTO transaksi;
}
