package com.example.demo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "transaksi")
public class Transaksi {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaksi")
    private Integer idTransaksi;


    @Column(name = "tanggal_transaksi")
    private LocalDate transactionDate;

    @Column(name = "total")
    private long totalPrice;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_transaksi", referencedColumnName = "id_transaksi")
    List<DetailTransaksi> detailTransaksi = new ArrayList<>();

    public Integer getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(Integer idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<DetailTransaksi> getDetailTransaksi() {
        return detailTransaksi;
    }

    public void setDetailTransaksi(List<DetailTransaksi> detailTransaksi) {
        this.detailTransaksi = detailTransaksi;
    }
}
