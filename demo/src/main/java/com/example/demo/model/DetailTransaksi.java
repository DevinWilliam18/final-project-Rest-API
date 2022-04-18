package com.example.demo.model;


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
@Table(name = "detail_transaksi")
public class DetailTransaksi {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detail_transaksi")
    private Integer idDetailTransaksi;

    @Column(name = "jumlah_barang")
    private int jumlahBarang;

    @Column(name = "tot_harga")
    private int totalHarga;

    public Integer getIdDetailTransaksi() {
        return idDetailTransaksi;
    }

    public void setIdDetailTransaksi(Integer idDetailTransaksi) {
        this.idDetailTransaksi = idDetailTransaksi;
    }

    public int getJumlahBarang() {
        return jumlahBarang;
    }

    public void setJumlahBarang(int jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }

    public int getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    }
}
