package com.example.demo.service;

import com.example.demo.entity.dto.BarangDTO;
import java.util.List;

public interface BarangService {
    BarangDTO save(BarangDTO param);

    List<BarangDTO> findAllData();

    BarangDTO update(BarangDTO param, Long id);

    Boolean delete(Long id);

    BarangDTO findById(Long id);
}