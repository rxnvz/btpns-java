package org.example.controller;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.example.entities.Mahasiswa;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping("/api")
public class MahasiswaAPI {

    RestAPISend restAPISend = new RestAPISend();
    RestAPIReceive APIRecv = new RestAPIReceive();

    // ---------------------- SHOW ALL MABA ----------------------
    @RequestMapping(value = "/maba/", method = RequestMethod.GET)
    public ResponseEntity<?> semuaMaba() throws IOException, TimeoutException {
        restAPISend.allMaba();
        APIRecv.receiveFromDB();
        return new ResponseEntity<>(APIRecv.getMaba(), HttpStatus.OK);
    }



    // ---------------------- CREATE NEW MABA ----------------------
    @RequestMapping(value = "/maba/", method = RequestMethod.POST)
    public ResponseEntity<?> tambahMaba(@RequestBody Mahasiswa maba){
        try {
            restAPISend.insertMhs(new Gson().toJson(maba));
        } catch (Exception e){
            System.out.println("error = " + e);
        }
        return new ResponseEntity<>("Maba Berhasil Dibuat", HttpStatus.OK);
    }



    // ---------------------- UPDATE MABA ----------------------
    @RequestMapping(value = "/maba/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateMaba(@PathVariable("id") int id, @RequestBody Mahasiswa maba) {
        maba.setIdMhs(id);
        try {
            restAPISend.updateMhsById(new Gson().toJson(maba));
        }catch (Exception e){
            System.out.println("error = " + e);
        }
        return new ResponseEntity<>("Update Maba Berhasil", HttpStatus.OK);
    }



    // ---------------------- ABSENSI MABA ----------------------
    @RequestMapping(value = "/maba/{id}/absen", method = RequestMethod.PUT)
    public ResponseEntity<?> absensiMaba(@PathVariable("id") int id) {
        try {
            restAPISend.absensiMhs(Integer.toString(id));
        } catch (Exception e){
            System.out.println("error = " + e);
        }
        return new ResponseEntity<>("Absensi Maba Berhasil", HttpStatus.OK);
    }
}
