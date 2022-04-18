package com.example.demo.services.implementations;

import java.util.List;
import java.util.Optional;

import com.example.demo.dao.TransaksiDetailRepo;
import com.example.demo.model.DetailTransaksi;
import com.example.demo.services.DetailTransaksiService;

import org.hibernate.boot.TempTableDdlTransactionHandling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransaksiDetailServiceImpl implements DetailTransaksiService{


    private TransaksiDetailRepo detailRepo;

    @Autowired
    public TransaksiDetailServiceImpl(TransaksiDetailRepo detailRepo) {
        this.detailRepo = detailRepo;
    }

    @Override
    public void saveDetail(DetailTransaksi detail) {
        detailRepo.save(detail);
        
    }

    @Override
    public void deleteDetail(int id) {
        detailRepo.deleteById(id);
    }

    @Override
    public DetailTransaksi getDataByIdDetail(int detailTrans) {
    
        Optional<DetailTransaksi> result = detailRepo.findById(detailTrans);

        DetailTransaksi temp = null;
        if (result.isPresent()) {
            temp = result.get();
        }else{
            throw new RuntimeException("Did not find DetailTransaksi id - " + detailTrans);
        }
        return temp;

    }

    @Override
    public DetailTransaksi getLatestDetailId() {
        // TODO Auto-generated method stub
        return detailRepo.findTopByOrderByIdDetailTransaksiDesc();
    }

   
    
}
