package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Barang;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BarangRepo extends JpaRepository<Barang, Integer>{

    Barang findByIdBarang(int idBarang);
    
}
