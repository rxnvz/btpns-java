package org.example.restapi.controller;

import com.google.gson.Gson;
import org.example.db.model.Nasabah;
import org.example.restapi.rabbitmq.APIReceive;
import org.example.restapi.rabbitmq.APISend;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

@RestController
@RequestMapping("/api")
public class APIController {

    APISend send = new APISend();
    APIReceive recv = new APIReceive();
    //Auth nc = new Auth();

    // ---------------------- REGISTER ----------------------
    @RequestMapping(value = "/regis", method = RequestMethod.POST)
    public ResponseEntity<?> newNasabah(@RequestBody Nasabah nb) {
        try {
            send.insertNasabah(new Gson().toJson(nb));
        } catch (Exception e) {
            System.out.println("error register = " + e);
        }
        return new ResponseEntity<>("Nasabah berhasil dibuat, silahkan login", HttpStatus.OK);
    }




    // ---------------------- LOGIN ----------------------
    @RequestMapping(value = "/login", method = RequestMethod.PUT)
    public ResponseEntity<?> login(@RequestBody Nasabah nb) {
        try {
            send.doLogin(new Gson().toJson(nb));
        } catch (Exception e) {
            System.out.println("error login = " + e);
        }
        return new ResponseEntity<>("Berhasil login", HttpStatus.OK);
    }




    // ---------------------- SHOW DATA /THE/ NASABAH ----------------------
    @RequestMapping(value = "/data/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getData(@PathVariable("id") int id) throws IOException, TimeoutException {
        send.showData(Integer.toString(id));
        recv.receiveFromDB();
        return new ResponseEntity<>(recv.getMaba(), HttpStatus.OK);
    }
}
