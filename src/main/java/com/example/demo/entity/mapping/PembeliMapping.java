package com.example.demo.entity.mapping;

import com.example.demo.entity.Pembeli;
import com.example.demo.entity.dto.PembeliDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PembeliMapping {
    PembeliMapping instance = Mappers.getMapper(PembeliMapping.class);

    Pembeli toEntity(PembeliDTO dto);
    PembeliDTO toDto(PembeliDTO parm);
    List<PembeliDTO>toListDto(List<Pembeli>pembeliList);
}
