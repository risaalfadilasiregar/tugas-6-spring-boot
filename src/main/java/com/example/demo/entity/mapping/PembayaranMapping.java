package com.example.demo.entity.mapping;

import com.example.demo.entity.Pembayaran;
import com.example.demo.entity.dto.PembayaranDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PembayaranMapping {

    PembayaranMapping instance = Mappers.getMapper(PembayaranMapping.class);

    Pembayaran toEntity(PembayaranDTO dto);

    PembayaranDTO toDto(Pembayaran param);

    List<PembayaranDTO> toListDto(List<Pembayaran> productList);
}
