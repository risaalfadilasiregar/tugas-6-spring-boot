package com.example.demo.service.impl;

import com.example.demo.entity.Barang;
import com.example.demo.entity.Pembayaran;
import com.example.demo.entity.Transaksi;
import com.example.demo.entity.dto.TransaksiDTO;
import com.example.demo.entity.mapping.BarangMapping;
import com.example.demo.entity.mapping.PembayaranMapping;
import com.example.demo.entity.mapping.TransaksiMapping;
import com.example.demo.repository.BarangRepository;
import com.example.demo.repository.PembayaranRepository;
import com.example.demo.repository.TransaksiRepository;
import com.example.demo.service.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TransaksiServiceImpl implements TransaksiService {

    @Autowired
    private TransaksiRepository repository;
    @Autowired
    private BarangRepository barangRepository;
    @Override
    public TransaksiDTO save(TransaksiDTO param) {
        Barang barang = BarangMapping.instance.toEntity(param.getBarang());

        Transaksi data = TransaksiMapping.instance.toEntity(param);

        if (param.getTransaksi() != null) {
            barang = barangRepository.save(barang);

            data.getTransaksi().setId(barang.getId_barang());
        }

        data = repository.save(data);

        return TransaksiMapping.instance.toDto(data);
    }

    @Override
    public List<TransaksiDTO> findAllData() {
        return TransaksiMapping.instance.toListDto(repository.findAll());
    }

    @Override
    public TransaksiDTO update(TransaksiDTO param, Long id) {
        Transaksi data = repository.findById(id).orElse(null);

        if (data != null) {
            data.setTanggal(param.getTanggal() == null ? data.getTanggal() : param.getTanggal());
            data.setKeterangan(param.getKeterangan() != null ? param.getKeterangan() : data.getKeterangan());

            return TransaksiMapping.instance.toDto(repository.save(data));
        }

        return TransaksiMapping.instance.toDto(data);
    }

    @Override
    public Boolean delete(Long id) {
        Transaksi data = repository.findById(id).orElse(null);

        if (data != null){
            repository.delete(data);
            return true;
        }

        return false;
    }

    @Override
    public TransaksiDTO findById(Long id) {
        return TransaksiMapping.instance.toDto(repository.findById(id).orElse(null));

    }
}
