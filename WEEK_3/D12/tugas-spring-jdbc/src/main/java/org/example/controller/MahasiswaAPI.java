package org.example.controller;

import org.example.model.Detail;
import org.example.model.Mahasiswa;
import org.example.service.MahasiswaService;
import org.example.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MahasiswaAPI {

    public static final Logger logger = LoggerFactory.getLogger(MahasiswaAPI.class);

    @Autowired
    MahasiswaService mhsService;

    // ---------------------- GET ALL MAHASISWA ----------------------
    @RequestMapping (value = "/mhs/", method = RequestMethod.GET)
    public ResponseEntity<List<Mahasiswa>> listAllMaba() {
        List<Mahasiswa> mhs = mhsService.findAllMaba();
        if (mhs.isEmpty()) {
            return new ResponseEntity<>(mhs, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(mhs, HttpStatus.OK);
    }



    // ---------------------- GET MAHASISWA BY ID ----------------------
    @RequestMapping(value = "/mhs/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getMHS(@PathVariable("id") int id){
        logger.info("Fetching Maba with id {}", id);
        List<Mahasiswa> mhs = mhsService.findById(id);
        if (mhs.isEmpty()) {
            return new ResponseEntity<>(mhs, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(mhs, HttpStatus.OK);
    }


    // ---------------------- GET ALL DETAILS ----------------------
    @RequestMapping(value = "/details/", method = RequestMethod.GET)
    public ResponseEntity<List<Detail>> listAllDetails() {
        List<Detail> det = mhsService.findAllNilai();
        if (det.isEmpty()) {
            return new ResponseEntity<>(det, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(det, HttpStatus.OK);
    }


    // ---------------------- GET DETAILS BY ID ----------------------
    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getDetail(@PathVariable("id") int id) {
        logger.info("Fetching Details with id {}", id);
        List<Detail> det = mhsService.findAllNilai();
        if (det.isEmpty()) {
            return new ResponseEntity<>(det, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(det, HttpStatus.OK);
    }


        // ---------------------- REGIS MAHASISWA ----------------------
    @RequestMapping(value = "/mhs/", method = RequestMethod.POST)
    public ResponseEntity<?> createMaba(@RequestBody Mahasiswa m) {
        logger.info("Creating Mahasiswa : {}", m);
        if (mhsService.isMabaExist(m)) {
            logger.error("Unable to create. Mahasiswa with name {} already exist", m.getFullname());
            return new ResponseEntity<>(new CustomErrorType("Unable to create. Mahasiswa with name " +
                    m.getFullname() + " already exist."), HttpStatus.CONFLICT);
        }
        mhsService.regisMaba(m);
        return new ResponseEntity<>(m, HttpStatus.CREATED);
    }


    // ---------------------- ADD DETAILS ----------------------
    @RequestMapping(value = "/mhs/{id}/new", method = RequestMethod.POST)
    public ResponseEntity<?> addNilai(@PathVariable("id") int id, @RequestBody Detail n) {
        logger.info("Adding Details : {}", n);
        mhsService.addNilai(n, id);
        return new ResponseEntity<>(n, HttpStatus.CREATED);
    }


    // ---------------------- EDIT MAHASISWA ----------------------
    @RequestMapping(value = "/mhs/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> editMaba(@PathVariable("id") int id, @RequestBody Mahasiswa m) {
        logger.info("Updating Maba with id {}", id);
        List<Mahasiswa> maba = mhsService.findById(id);
        if (maba == null) {
            logger.error("Unable to update. Mahasiswa with id {} not found.", id);
            return new ResponseEntity<>(new CustomErrorType("Unable to upate. Mahasiswa with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        for (Mahasiswa mhs: maba) {
            mhs.setFullname(m.getFullname());
            mhs.setAddress(m.getAddress());
            mhs.setStatus(m.getStatus());
            mhsService.updateMaba(mhs);
        }
        return new ResponseEntity<>(maba, HttpStatus.OK);
    }


    // ---------------------- EDIT DETAILS ----------------------
    @RequestMapping(value = "/details/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> editNilai(@PathVariable("id") int id, @RequestBody Detail n) {
        logger.info("Updating Maba with id {}", id);
        List<Detail> det = mhsService.findNilaiById(id);
        if (det == null) {
            logger.error("Unable to update. Mahasiswa with id {} not found.", id);
            return new ResponseEntity<>(new CustomErrorType("Unable to upate. Nilai with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        for (Detail x: det) {
            x.setPhysics(n.getPhysics());
            x.setCalculus(n.getCalculus());
            x.setBiology(n.getBiology());
            mhsService.updateNilai(x);
        }
        return new ResponseEntity<>(det, HttpStatus.OK);
    }


    // ---------------------- ABSENSI MAHASISWA ----------------------
    @RequestMapping(value = "/mhs/{id}/absen", method = RequestMethod.PUT)
    public ResponseEntity<?> addAbsen(@PathVariable("id") int id) {
        logger.info("Updating Absensi Mahasiswa with id {}", id);
        List<Mahasiswa> maba = mhsService.findById(id);
        if (maba == null) {
            logger.error("Unable to update. Mahasiswa with id {} not found.", id);
            return new ResponseEntity<>(new CustomErrorType("Unable to upate. Mahasiswa with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        mhsService.absensi(id);
        return new ResponseEntity<>(maba, HttpStatus.OK);
    }
}
