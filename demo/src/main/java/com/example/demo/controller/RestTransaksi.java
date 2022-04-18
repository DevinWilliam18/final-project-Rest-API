package com.example.demo.controller;

import java.time.LocalDate;

import com.example.demo.model.Barang;
import com.example.demo.model.DetailTransaksi;
import com.example.demo.model.Transaksi;
import com.example.demo.services.BarangService;
import com.example.demo.services.TransaksiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestTransaksi {
    
    private TransaksiService tService;

    // private BarangService brgService;

    
    @Autowired
    public RestTransaksi(TransaksiService tService) {
        this.tService = tService;
    }

    

    // @Autowired
    // public RestTransaksi(BarangService brgService) {
    //     this.brgService = brgService;
    // }




    @GetMapping("/process")
    public int getTheLatestId(){
        return tService.getLatestId();
    }

    @GetMapping("/process/{idTransaksi}")
    public Transaksi getData(@PathVariable int idTransaksi) {
        return tService.getDataById(idTransaksi);
    }


    @PostMapping("/process")
    public void saveANewTransaksi(@RequestBody Transaksi trans) {
        trans.setIdTransaksi(0);
        trans.setTotalPrice(0);
        trans.setTransactionDate(LocalDate.now());
        tService.createNewTransaction(trans);

    }

    @PostMapping("/process/{idTransaksi}/detail/barang/{idBarang}")
    public void saveDetail(@PathVariable int idTransaksi, @PathVariable int idBarang, @RequestBody DetailTransaksi detailTransaksi) {
        
        detailTransaksi.setIdDetailTransaksi(0);
        Transaksi temp = tService.getDataById(idTransaksi);

        // Barang brgTemp = brgService.findById(idBarang);

        temp.getDetailTransaksi().add(detailTransaksi);
        // brgTemp.getDetailTransaksi().add(detailTransaksi);

        tService.updateTrans(temp);
    }

    @PutMapping("/process/{idTransaksi}")
    public void updateTransaksi(@PathVariable int idTransaksi, @RequestBody Transaksi transaksi) {
        Transaksi temp = tService.getDataById(idTransaksi);
        transaksi.setTransactionDate(temp.getTransactionDate());
        transaksi.setIdTransaksi(idTransaksi);

        tService.updateTrans(transaksi);

    }

    @DeleteMapping("/process/{idTransaksi}")
    public void deleteTransaksi(@PathVariable int idTransaksi) {
        tService.deleteTransaction(idTransaksi);
    }
}
