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
@Table(name="barang")
public class Barang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idbarang")
    private Integer idBarang;
    
    @Column(name="namabarang")
    private String namaBarang;

    @Column(name="jumlahbarang")
    private int jumlahBarang;

     
    @Column(name="harga")
    private float harga;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idbarang", referencedColumnName = "idbarang")
    List<DetailTransaksi> detailTransaksi = new ArrayList<>();

    public Integer getId() {
        return idBarang;
    }

    public void setId(Integer id) {
        idBarang = id;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public int getJumlahBarang() {
        return jumlahBarang;
    }

    public void setJumlahBarang(int jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }

  

    public float getHarga() {
        return harga;
    }

    public void setHarga(float harga) {
        this.harga = harga;
    }

    public List<DetailTransaksi> getDetailTransaksi() {
        return detailTransaksi;
    }

    public void setDetailTransaksi(List<DetailTransaksi> detailTransaksi) {
        this.detailTransaksi = detailTransaksi;
    }
}
