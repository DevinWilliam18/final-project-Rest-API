package com.example.demo.services.implementations;

import java.util.List;

import com.example.demo.dao.BarangRepo;
import com.example.demo.model.Barang;
import com.example.demo.services.BarangService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BarangServiceImpl implements BarangService{

    private BarangRepo brgRepo;
    
    
    @Autowired
    public BarangServiceImpl(BarangRepo brgRepo) {
        this.brgRepo = brgRepo;
    }

    @Override
    public List<Barang> findAll() {
        
        return brgRepo.findAll();
    }

    // @Override
    // public List<Barang> findById(int id) {
    //     List<Barang> findBarang = brgRepo.findByIduser(id);

    //     return findBarang;
    // }


    @Override
    public void saveBrg(Barang brg) {

        // TODO Auto-generated method stub
        brgRepo.save(brg);
    }
    
}
