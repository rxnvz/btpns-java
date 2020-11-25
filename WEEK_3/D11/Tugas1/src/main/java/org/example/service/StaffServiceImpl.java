package org.example.service;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.example.model.Staff;
import org.example.util.ConnectionManager;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

@Service("staffService") //ini buat, deklarasi(?) buat manggil method-method di class ini pas di class lain
                        // jadi nanti kalo class lain mau make fungsi di class ini, tinggal nulis staffService.(method)
public class StaffServiceImpl implements StaffService {

    public static HashMap<Long, Staff> staffs = new HashMap<>();
    public static HashMap<String, Long> nameStaff = new HashMap<>();
    public static Connection con;
    public static Statement stmt;
    public static ConnectionManager c = new ConnectionManager();

    // -------------------------- AMBIL SEMUA DATA STAFF --------------------------
    public ArrayList<Staff> findAllStaff() {
        ArrayList<Staff> st = new ArrayList<Staff>();
        try {
            con = c.on();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM staff");
            while (rs.next()) {
                Staff s = new Staff();
                s.setIDKaryawan(rs.getLong(1));
                s.setNama(rs.getString(2));
                s.setEmail(rs.getString(3));
                s.setPulsa(rs.getInt(4));
                s.setMakan(rs.getInt(5));
                s.setGajiPokok(rs.getInt(6));
                s.setAbsensiHari(rs.getInt(7));
                st.add(s);
            }
        } catch (Exception e) {
            System.out.println("ERROR! -- " + e);
        }
        c.off();
        return st; // returning all data in ArrayList Staff
//        return new ArrayList<>(staffs.values());
    }

    // -------------------------- AMBIL DATA STAFF BY ID --------------------------
    public Staff findById(long IDKaryawan) {
        Staff s = new Staff();
        try {
            con = c.on();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM staff WHERE id = '"+IDKaryawan+"'");
            while (rs.next()) {

                s.setIDKaryawan(rs.getLong(1));
                s.setNama(rs.getString(2));
                s.setEmail(rs.getString(3));
                s.setPulsa(rs.getInt(4));
                s.setMakan(rs.getInt(5));
                s.setGajiPokok(rs.getInt(6));
                s.setAbsensiHari(rs.getInt(7));
            }
        } catch (Exception e) {
            System.out.println("ERROR! -- " + e);
        }
        c.off();
        return s;
//        return staffs.get(IDKaryawan); //get staff where ID
    }

    // -------------------------- AMBIL DATA STAFF BY NAME --------------------------
    public Staff findByName(String nama) {
        if (nameStaff.get(nama) != null) {
            return staffs.get(nameStaff.get(nama)); // kalo nama staffnya ngga ada
        }
        return null;
    }

    // -------------------------- SIMPAN STAFF BARU --------------------------
    public void saveStaff(Staff staff) {
        synchronized (this) {
            try {
                con = c.on();
                stmt = con.createStatement();
                stmt.executeUpdate("INSERT INTO staff VALUES (null, " +
                        "'"+staff.getNama()+"', " +
                        "'"+staff.getEmail()+"', " +
                        "'"+staff.getPulsa()+"', " +
                        "'"+staff.getMakan()+"', " +
                        "'"+staff.getGajiPokok()+"'," +
                        "'"+staff.getAbsensiHari()+"')");

            } catch (Exception e) {
                System.out.println("ERROR! -- " + e);
            }
        }
        c.off();
    }

    // -------------------------- UPDATE STAFF --------------------------
    public void updateStaff(Staff staff) {
        synchronized (this) {
            try {
                con = c.on();
                stmt = con.createStatement();
                stmt.executeUpdate("UPDATE staff SET " +
                        "nama = '"+staff.getNama()+"', " +
                        "email = '"+staff.getEmail()+"', " +
                        "tunjanganPulsa = '"+staff.getPulsa()+"', " +
                        "tunjanganMakan = '"+staff.getMakan()+"', " +
                        "gajiPokok = '"+staff.getGajiPokok()+"'," +
                        "absensi = '"+staff.getAbsensiHari()+"'" +
                        "WHERE id = '"+staff.getIDKaryawan()+"'");
            } catch (Exception e) {
                System.out.println("ERROR! -- " + e);
            }
            c.off();
//            staffs.put(staff.getIDKaryawan(), staff);
//            nameStaff.put(staff.getNama(), staff.getIDKaryawan());
        }
    }

    // -------------------------- DELETE STAFF BY ID --------------------------
    public void deletStaffById(long IDKaryawan) {
        synchronized (this) {
            try {
                con = c.on();
                stmt = con.createStatement();
                stmt.executeUpdate("DELETE FROM staff WHERE id = '"+IDKaryawan+"' ");
            } catch (Exception e) {
                System.out.println("ERROR! -- " + e);
            }
            c.off();
//            nameStaff.remove(staffs.get(IDKaryawan).getNama());
//            staffs.remove(IDKaryawan);
        }
    }

    // -------------------------- DELETE ALL STAFF --------------------------
    public void deletAll() {
        try {
            con = c.on();
            stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM staff");
        } catch (Exception e) {
            System.out.println("ERROR! -- " + e);
        }
        c.off();
    }

    // -------------------------- CHECKING IS STAF EXIST? --------------------------
    public boolean isStaffExist(Staff staff) {
        return findByName(staff.getNama()) != null;
    }
}

// Setelahnya, pindah ke CustomErrorType
