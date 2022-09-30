package com.example.demo.service;

import com.example.demo.entity.dto.PembayaranDTO;

import java.util.List;

public interface PembayaranService {
    PembayaranDTO save(PembayaranDTO param);

    List<PembayaranDTO> findAllData();

    PembayaranDTO update(PembayaranDTO param, Long id);

    Boolean delete(Long id);

    PembayaranDTO findById(Long id);
}
