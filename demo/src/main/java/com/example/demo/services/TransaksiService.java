package com.example.demo.services;

import com.example.demo.model.Transaksi;

public interface TransaksiService {
    int getLatestId();
    Transaksi getDataById(int id);
    void createNewTransaction(Transaksi trans);
    void deleteTransaction(int id);
    void updateTrans(Transaksi trans);
}
