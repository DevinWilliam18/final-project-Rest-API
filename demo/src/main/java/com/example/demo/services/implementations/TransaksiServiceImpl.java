package com.example.demo.services.implementations;

import java.util.Optional;

import com.example.demo.dao.BarangRepo;
import com.example.demo.dao.TransaksiRepo;
import com.example.demo.model.Transaksi;
import com.example.demo.services.TransaksiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransaksiServiceImpl implements TransaksiService{

    private TransaksiRepo transaksiRepo;


    @Autowired
    public TransaksiServiceImpl(TransaksiRepo transaksiRepo) {
        this.transaksiRepo = transaksiRepo;
    }

    



    @Override
    public Transaksi getLatestId() {
        
        return transaksiRepo.findTopByOrderByIdTransaksiDesc();
    }

    @Override
    public Transaksi getDataById(int id) {
        Optional<Transaksi> result = transaksiRepo.findById(id);
        Transaksi tempTransaksi = null;
        if (result.isPresent()) {
            tempTransaksi = result.get();
        }else{
            throw new RuntimeException("Did not find transaksi id - " + id);
        }
        return tempTransaksi;
    }

    @Override
    public void createNewTransaction(Transaksi trans) {
        transaksiRepo.save(trans);
    }

    @Override
    public void deleteTransaction(int id) {
        transaksiRepo.deleteById(id);
    }

    @Override
    public void updateTrans(Transaksi trans) {
        transaksiRepo.save(trans);
        
    }
    
}
