package com.example.demo.services;

import java.util.List;

import com.example.demo.model.DetailTransaksi;

public interface DetailTransaksiService {
    void saveDetail(DetailTransaksi detail);
    void deleteDetail(int id);
    DetailTransaksi getDataByIdDetail(int trans);
    DetailTransaksi getLatestDetailId();
}
