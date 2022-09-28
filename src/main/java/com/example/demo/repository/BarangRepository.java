package com.example.demo.repository;

import com.example.demo.entity.Barang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarangRepository extends JpaRepository<Barang, Long> {

}
