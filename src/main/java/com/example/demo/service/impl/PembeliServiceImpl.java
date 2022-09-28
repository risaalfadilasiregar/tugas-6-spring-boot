package com.example.demo.service.impl;

import com.example.demo.entity.Pembeli;
import com.example.demo.entity.dto.PembeliDTO;
import com.example.demo.entity.mapping.PembeliMapping;
import com.example.demo.repository.PembeliRepository;
import com.example.demo.service.PembelianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PembeliServiceImpl implements PembelianService {
    @Autowired
    private PembeliRepository repository;

    @Override
    public PembeliDTO save(PembeliDTO param) {

        PembeliDTO data = repository.save(PembeliMapping.instance.toEntity(param));
        return PembeliMapping.instance.toDto(data);
    }

    @Override
    public List<PembeliDTO> findAllData() {
        return PembeliMapping.instance.toListDto(repository.findAll());
    }

    @Override
    public PembeliDTO update(PembeliDTO param, Long id) {

        Pembeli data = repository.findById(id).orElse(null);
        if (data != null){
            data.setNama_pembeli(param.getNama_pembeli()==null ? data.getNama_pembeli():param.getNama_pembeli());
            data.setJk(param.getJk()== null ? data.getJk() : param.getJk());
            data.setNo_telp(param.getNo_telp()== null ? data.getNo_telp() : param.getNo_telp());
            data.setAlamat(param.getAlamat()== null ? data.getAlamat() : param.getAlamat());

            return PembeliMapping.instance.toDto(repository.save(data));
        }
        return PembeliMapping.instance.toDto(data);
    }

    @Override
    public Boolean delete(Long id) {
        Pembeli data = repository.findById(id).orElse(null);

        if (data != null){
            repository.delete(data);
            return true;
        }

        return false;
    }

    @Override
    public PembeliDTO findById(Long id) {
        return PembeliMapping.instance.toDto(repository.findById(id).orElse(null));
    }
}
