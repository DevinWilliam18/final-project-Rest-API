package com.example.demo.controller;

import com.example.demo.model.DetailTransaksi;
import com.example.demo.services.DetailTransaksiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestDetailTransaksi {
    
    private DetailTransaksiService detailService;

    
    @Autowired
    public RestDetailTransaksi(DetailTransaksiService detailService) {
        this.detailService = detailService;
    }

    @GetMapping("/process/{idTransaksi}/detail/{idDetail}")
    public DetailTransaksi getDetail(@PathVariable int idTransaksi, @PathVariable int idDetail) {
        return detailService.getDataByIdDetail(idDetail);
    }

    @PutMapping("/process/{idTransaksi}/detail/{idDetail}")
    public void updateDetail(@PathVariable int idTransaksi, @PathVariable int idDetail, @RequestBody DetailTransaksi detail) {
        
        detail.setIdDetailTransaksi(idDetail);
        detailService.saveDetail(detail);
    }

    @DeleteMapping("/process/{idTransaksi}/detail/{idDetail}")
    public void deleteMapping(@PathVariable int idTransaksi, @PathVariable int idDetail) {
        detailService.deleteDetail(idDetail);
    }



}
