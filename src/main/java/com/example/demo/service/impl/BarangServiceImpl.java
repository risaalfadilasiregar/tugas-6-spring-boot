package com.example.demo.service.impl;

import com.example.demo.entity.Barang;
import com.example.demo.entity.dto.BarangDTO;
import com.example.demo.entity.mapping.BarangMapping;
import com.example.demo.repository.BarangRepository;
import com.example.demo.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarangServiceImpl implements BarangService {
    @Autowired
    private BarangRepository repository;

    @Override
    public BarangDTO save(BarangDTO param) {
        Barang data = repository.save(BarangMapping.instance.toEntity(param));
        return BarangMapping.instance.toDto(data);
    }

    @Override
    public List<BarangDTO> findAllData() {
        return BarangMapping.instance.toListDto(repository.findAll());

    }

    @Override
    public BarangDTO update(BarangDTO param, Long id) {
        Barang data = repository.findById(id).orElse(null);

        if (data != null) {
            data.setNama_barang(param.getNama_barang() == null ? data.getNama_barang() : param.getNama_barang());
            data.setHarga_barang(param.getHarga_barang() == null ? data.getHarga_barang() : param.getHarga_barang());
            data.setStok(param.getStok() == null ? data.getStok() : param.getStok());


            return BarangMapping.instance.toDto(data);
        }
        return BarangMapping.instance.toDto(data);

    }

    @Override
    public Boolean delete(Long id) {
        Barang data = repository.findById(id).orElse(null);

        if (data != null) {
            repository.delete(data);
            return true;
        }

        return false;
    }

    @Override
    public BarangDTO findById(Long id) {
        return BarangMapping.instance.toDto(repository.findById(id).orElse(null));
    }
}
