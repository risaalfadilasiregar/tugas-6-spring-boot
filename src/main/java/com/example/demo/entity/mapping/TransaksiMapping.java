package com.example.demo.entity.mapping;

import com.example.demo.entity.Transaksi;
import com.example.demo.entity.dto.TransaksiDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TransaksiMapping {
    TransaksiMapping instance = Mappers.getMapper(TransaksiMapping.class);

    Transaksi toEntity(TransaksiDTO dto);

    TransaksiDTO toDto(Transaksi param);

    List<TransaksiDTO> toListDto(List<Transaksi> productList);
}
