package com.example.demo.service;

import com.example.demo.entity.dto.TransaksiDTO;

import java.util.List;

public interface TransaksiService {
    TransaksiDTO save(TransaksiDTO param);

    List<TransaksiDTO> findAllData();

    TransaksiDTO update(TransaksiDTO param, Long id);

    Boolean delete(Long id);

    TransaksiDTO findById(Long id);
}
