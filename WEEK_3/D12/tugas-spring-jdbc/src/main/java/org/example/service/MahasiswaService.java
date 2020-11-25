package org.example.service;

import org.example.model.Detail;
import org.example.model.Mahasiswa;

import java.util.List;

public interface MahasiswaService {
    List<Mahasiswa> findAllMaba();
    List<Mahasiswa> findById(int idMhs);
    int regisMaba(Mahasiswa mhs);
    int updateMaba(Mahasiswa mhs);
    int absensi(int idMhs);

    List<Detail> findAllNilai();
    List<Detail> findNilaiById(int idMhs);
    int addNilai(Detail det, int idMhs);
    int updateNilai(Detail det);

    boolean isMabaExist(Mahasiswa mhs);
    boolean isDetailExist(Detail det);
}
