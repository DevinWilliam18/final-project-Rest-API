package com.example.demo.controller;

import java.util.List;
import com.example.demo.model.Barang;
import com.example.demo.services.BarangService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestBarang {
    
    private BarangService brgService;
    
    @Autowired
    public RestBarang(BarangService brgService) {
        this.brgService = brgService;
    }



    @GetMapping("/barang")
    public List<Barang> getAll() {
        return brgService.findAll();
    }

    

    @PostMapping("/barang")
    public Barang saveBarang(@RequestBody Barang brg){
        
        //this is to force a new item instead of update
        brg.setId(0);
        brgService.saveBrg(brg);

        return brg;
    }

    @PutMapping("/barang")
    public void updateBarang(@RequestBody Barang brg) {
        brgService.saveBrg(brg);
    }

    
}
