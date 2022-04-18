package com.example.demo.dao;

import com.example.demo.model.Transaksi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaksiRepo extends JpaRepository<Transaksi, Integer>{
    
    // public Transaksi findByIdTransaksi(int idTransaksi);
    public Integer findTopByOrderByIdTransaksiDesc();

}
