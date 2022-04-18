package com.example.demo.controller;

import java.time.LocalDate;

import com.example.demo.model.Barang;
import com.example.demo.model.DetailTransaksi;
import com.example.demo.model.Transaksi;
import com.example.demo.services.BarangService;
import com.example.demo.services.DetailTransaksiService;
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
    
    @Autowired
    private TransaksiService tService;

    @Autowired
    private BarangService brgService;


    @Autowired
    private DetailTransaksiService detailService;




    @GetMapping("/process")
    public Transaksi getTheLatestId(){
        return tService.getLatestId();
    }

    @GetMapping("/process/{idTransaksi}")
    public Transaksi getData(@PathVariable int idTransaksi) {
        return tService.getDataById(idTransaksi);
    }


    @PostMapping("/process")
    public void saveANewTransaksi() {
        Transaksi trans = new Transaksi();
        trans.setIdTransaksi(0);
        trans.setTotalPrice(0);
        trans.setTransactionDate(LocalDate.now());
        tService.createNewTransaction(trans);

    }

    @PostMapping("/process/{idTransaksi}/detail/barang/{idBarang}")
    public void saveDetail(@PathVariable int idTransaksi, @PathVariable int idBarang, @RequestBody DetailTransaksi detailTransaksi) {
        
        detailTransaksi.setIdDetailTransaksi(0);
        Transaksi temp = tService.getDataById(idTransaksi);

        
        temp.getDetailTransaksi().add(detailTransaksi);
        

        tService.updateTrans(temp);

        DetailTransaksi detailTemp = detailService.getLatestDetailId();

        Barang brgTemp = brgService.findById(idBarang);
        
        detailTransaksi.setIdDetailTransaksi(detailTemp.getIdDetailTransaksi());
        brgTemp.getDetailTransaksi().add(detailTransaksi);
        brgService.saveBrg(brgTemp);
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
