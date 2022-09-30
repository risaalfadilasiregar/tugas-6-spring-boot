package com.example.demo.service.impl;

import com.example.demo.entity.Pembayaran;
import com.example.demo.entity.Transaksi;
import com.example.demo.entity.dto.PembayaranDTO;
import com.example.demo.entity.mapping.PembayaranMapping;
import com.example.demo.entity.mapping.TransaksiMapping;
import com.example.demo.repository.PembayaranRepository;
import com.example.demo.repository.TransaksiRepository;
import com.example.demo.service.PembayaranService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

public class PembayaranServiceImpl implements PembayaranService {

    @Autowired
    private PembayaranRepository repository;

    @Autowired
    private TransaksiRepository transaksiRepository;
    @Override
    public PembayaranDTO save(PembayaranDTO param) {

        Transaksi transaksi = TransaksiMapping.instance.toEntity(param.getTransaksi());

        Pembayaran data = PembayaranMapping.instance.toEntity(param);

        if (param.getTransaksi() != null) {
            transaksi = transaksiRepository.save(transaksi);

            data.getTransaksi().setId(transaksi.getId());
        }

        data = repository.save(data);

        return PembayaranMapping.instance.toDto(data);
    }

    @Override
    public List<PembayaranDTO> findAllData() {

        return PembayaranMapping.instance.toListDto(repository.findAll());
    }

    @Override
    public PembayaranDTO update(PembayaranDTO param, Long id) {
        Pembayaran data = repository.findById(id).orElse(null);

        if (data != null) {
            data.setTanggalBayar(param.getTanggalBayar() == null ? data.getTanggalBayar() : param.getTanggalBayar());
            data.setTotalBayar(param.getTotalBayar() != null ? param.getTotalBayar() : data.getTotalBayar());

            return PembayaranMapping.instance.toDto(repository.save(data));
        }

        return PembayaranMapping.instance.toDto(data);
    }

    @Override
    public Boolean delete(Long id) {
        Pembayaran data = repository.findById(id).orElse(null);

        if (data != null){
            repository.delete(data);
            return true;
        }

        return false;
    }

    @Override
    public PembayaranDTO findById(Long id) {
        return PembayaranMapping.instance.toDto(repository.findById(id).orElse(null));
    }
}
