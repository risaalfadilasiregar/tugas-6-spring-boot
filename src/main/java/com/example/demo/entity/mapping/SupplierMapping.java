package com.example.demo.entity.mapping;

import com.example.demo.entity.Supplier;
import com.example.demo.entity.dto.SupplierDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface SupplierMapping {
        SupplierMapping instance = Mappers.getMapper(SupplierMapping.class);
        Supplier toEntity(SupplierDTO dto);
        SupplierDTO toDto(Supplier parm);
        List<SupplierDTO> toListDto(List<Supplier> supplierList);
    }

