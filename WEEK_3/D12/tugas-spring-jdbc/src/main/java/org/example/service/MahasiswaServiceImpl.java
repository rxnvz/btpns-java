package org.example.service;

import org.example.model.Detail;
import org.example.model.Mahasiswa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Service("MahasiswaService")
public class MahasiswaServiceImpl implements MahasiswaService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Qualifier("Mahasiswa")

    public List<Mahasiswa> findAllMaba() {
        return jdbcTemplate.query(
                "SELECT * FROM header",
                (rs, rowNum) ->
                        new Mahasiswa(
                                rs.getInt("idMhs"),
                                rs.getString("fullname"),
                                rs.getString("address"),
                                rs.getString("status"),
                                rs.getInt("absensi")
                        )
        );
    }

    public List<Mahasiswa> findById(int idMhs) {
        return jdbcTemplate.query(
                "SELECT * FROM header WHERE idMhs='"+idMhs+"'",
                (rs, rowNum) ->
                        new Mahasiswa(
                                rs.getInt("idMhs"),
                                rs.getString("fullname"),
                                rs.getString("address"),
                                rs.getString("status"),
                                rs.getInt("absensi")
                        )
        );
    }

    public int regisMaba(Mahasiswa mhs) {
        return jdbcTemplate.update(
                "INSERT INTO header VALUES (?,?,?,?,?)",
                null, mhs.getFullname(), mhs.getAddress(), mhs.getStatus(), mhs.getAbsensi()
        );
    }

    public int updateMaba(Mahasiswa mhs) {
        return jdbcTemplate.update(
                "UPDATE header SET fullname=?, address=?, status=?, absensi=? WHERE idMhs=?",
                    mhs.getFullname(), mhs.getAddress(), mhs.getStatus(), mhs.getAbsensi(), mhs.getIdMhs()
        );
    }

    public int absensi(int idMhs) {
        return jdbcTemplate.update(
                "UPDATE header SET absensi = absensi+1 WHERE idMhs=?",
                idMhs
        );
    }





    public List<Detail> findAllNilai() {
        return jdbcTemplate.query(
                "SELECT * FROM detail",
                (rs, rowNum) ->
                        new Detail(
                                rs.getInt("idDetail"),
                                rs.getInt("idMhs"),
                                rs.getInt("physics"),
                                rs.getInt("calculus"),
                                rs.getInt("biology")
                        )
        );
    }

    public List<Detail> findNilaiById(int idMhs) {
        return jdbcTemplate.query(
                "SELECT * FROM detail WHERE idMhs='"+idMhs+"'",
                (rs, rowNum) ->
                        new Detail(
                                rs.getInt("idDetail"),
                                rs.getInt("idMhs"),
                                rs.getInt("physics"),
                                rs.getInt("calculus"),
                                rs.getInt("biology")
                        )
        );
    }

    public int addNilai(Detail det, int idMhs) {
        return jdbcTemplate.update(
                "INSERT INTO  detail VALUE (?,?,?,?,?)",
                null, idMhs, det.getPhysics(), det.getCalculus(), det.getBiology()
        );
    }

    public int updateNilai(Detail det) {
        return jdbcTemplate.update(
                "UPDATE detail SET physics=?, calculus=?, biology=? WHERE idMhs=?",
                det.getPhysics(), det.getCalculus(), det.getBiology(), det.getIdMhs()
        );
    }





    public boolean isMabaExist(Mahasiswa mhs) {
        List<Mahasiswa> m = jdbcTemplate.query(
                "Select * from header where fullname='"+mhs.getFullname()+"'",
                new BeanPropertyRowMapper(Mahasiswa.class));

//        return customers;
//       jdbcTemplate.execute("Select * from header where fullName='"+mhs.getFullName()+"'");
        if (m.size()!=0){
            return true;
        } else {
            return false;
        }
    }

    public boolean isDetailExist(Detail det) {
        List<Detail> n = jdbcTemplate.query(
                "Select * from detail where idMhs='"+det.getIdMhs()+"'",
                new BeanPropertyRowMapper(Detail.class));

//        return customers;
//       jdbcTemplate.execute("Select * from header where fullName='"+mhs.getFullName()+"'");
        if (n.size()!=0){
            return true;
        } else {
            return false;
        }
    }
}
