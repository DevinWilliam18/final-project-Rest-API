package com.example.demo.dao;

import com.example.demo.model.DetailTransaksi;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaksiDetailRepo extends JpaRepository<DetailTransaksi, Integer>{
    public DetailTransaksi findTopByOrderByIdDetailTransaksiDesc();
}
