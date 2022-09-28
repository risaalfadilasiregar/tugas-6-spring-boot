package com.example.demo.service;

import com.example.demo.entity.dto.PembeliDTO;

import java.util.List;

public interface PembelianService {
    PembeliDTO save(PembeliDTO param);

    List<PembeliDTO> findAllData();

    PembeliDTO update(PembeliDTO param, Long id);

    Boolean delete(Long id);

    PembeliDTO findById(Long id);
}
