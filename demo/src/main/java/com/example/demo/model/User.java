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
@Table(name="user")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser")
    private Integer idUser;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password; 

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user_fk", referencedColumnName = "iduser")
    List<Barang> barang = new ArrayList<>();

    public User() {
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Barang> getBarang() {
        return barang;
    }

    public void setBarang(List<Barang> barang) {
        this.barang = barang;
    }

}
