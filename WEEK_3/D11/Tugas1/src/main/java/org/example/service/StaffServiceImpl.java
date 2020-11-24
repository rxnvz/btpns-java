package org.example.service;

import com.sun.xml.internal.bind.v2.model.core.ID;
import org.example.model.Staff;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service("staffService") //ini buat, deklarasi(?) buat manggil method-method di class ini pas di class lain
                        // jadi nanti kalo class lain mau make fungsi di class ini, tinggal nulis staffService.(method)
public class StaffServiceImpl implements StaffService {

    public static HashMap<Long, Staff> staffs = new HashMap<>();
    public static HashMap<String, Long> nameStaff = new HashMap<>();

    // -------------------------- AMBIL SEMUA DATA STAFF --------------------------
    public ArrayList<Staff> findAllStaff() {
        return new ArrayList<>(staffs.values()); // returning all data in ArrayList Staff
    }

    // -------------------------- AMBIL DATA STAFF BY ID --------------------------
    public Staff findById(long IDKaryawan) {
        return staffs.get(IDKaryawan); //get staff where ID
    }

    // -------------------------- AMBIL DATA STAFF BY NAME --------------------------
    public Staff findByName(String nama) {

        if (nameStaff.get(nama) != null) {
            return staffs.get(nameStaff.get(nama)); // kalo nama staffnya ngga ada
        }

        return null; // kalo staff-nya ngga ada, return null
    }

    // -------------------------- SIMPEN STAFF BARU --------------------------
    public void saveStaff(Staff staff) {
        synchronized (this) {
            staffs.put(staff.getIDKaryawan(), staff);
            nameStaff.put(staff.getNama(), staff.getIDKaryawan());
        }
    }

    // -------------------------- UPDATE STAFF --------------------------
    public void updateStaff(Staff staff) {
        synchronized (this) {
            staffs.put(staff.getIDKaryawan(), staff);
            nameStaff.put(staff.getNama(), staff.getIDKaryawan());
        }
    }

    // -------------------------- DELETE STAFF BY ID --------------------------
    public void deletStaffById(long IDKaryawan) {
        synchronized (this) {
            nameStaff.remove(staffs.get(IDKaryawan).getNama());
            staffs.remove(IDKaryawan);
        }
    }

    // -------------------------- DELETE ALL STAFF --------------------------
    public void deletAll() {
        staffs.clear();
    }

    // -------------------------- CHECKING IS STAF EXIST? --------------------------
    public boolean isStaffExist(Staff staff) {
        return findByName(staff.getNama()) != null;
    }
}

// Setelahnya, pindah ke CustomErrorType
