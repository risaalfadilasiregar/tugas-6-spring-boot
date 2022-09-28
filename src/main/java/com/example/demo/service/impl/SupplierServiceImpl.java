package com.example.demo.service.impl;

import com.example.demo.entity.Supplier;
import com.example.demo.entity.dto.SupplierDTO;
import com.example.demo.entity.mapping.SupplierMapping;
import com.example.demo.repository.SupplierRepository;
import com.example.demo.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierRepository repository;

    @Override
    public SupplierDTO save(SupplierDTO param) {
        Supplier data = repository.save(SupplierMapping.instance.toEntity(param));
        return SupplierMapping.instance.toDto(data);
    }

    @Override
    public List<SupplierDTO> findAllData()
    {
        return SupplierMapping.instance.toListDto(repository.findAll());
    }

    @Override
    public SupplierDTO update(SupplierDTO param, Long id) {
        Supplier data = repository.findById(id).orElse(null);

        if (data != null) {
            data.setNama_supplier(param.getNama_supplier() == null ? data.getNama_supplier() : param.getNama_supplier());
            data.setNo_telp(param.getNo_telp() != null ? param.getNo_telp() : data.getNo_telp());
            data.setAlamat(param.getAlamat() != null ? param.getAlamat() : data.getAlamat());

            return SupplierMapping.instance.toDto(repository.save(data));
        }

        return SupplierMapping.instance.toDto(data);
    }

    @Override
    public Boolean delete(Long id) {
        Supplier data = repository.findById(id).orElse(null);

        if (data != null){
            repository.delete(data);
            return true;
        }

        return false;
    }

    @Override
    public SupplierDTO findById(Long id) {
        return SupplierMapping.instance.toDto(repository.findById(id).orElse(null));
    }
}
