package com.example.demo.entity.mapping;

import com.example.demo.entity.Barang;
import com.example.demo.entity.dto.BarangDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface BarangMapping {
    BarangMapping instance = Mappers.getMapper(BarangMapping.class);
    Barang toEntity(BarangDTO dto);
    BarangDTO toDto(Barang parm);
    List<BarangDTO> toListDto(List<Barang>barangList);
}
