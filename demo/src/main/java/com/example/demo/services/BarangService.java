package com.example.demo.services;

import java.util.List;

import com.example.demo.model.Barang;

public interface BarangService {
    
    public List<Barang> findAll();
    public Barang findById(int id);
    public void saveBrg(Barang brg);
    public void deleteBrg(int idBarang);
    
}
