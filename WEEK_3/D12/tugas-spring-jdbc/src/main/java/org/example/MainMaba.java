package org.example;

import org.example.model.Detail;
import org.example.model.Mahasiswa;
import org.example.service.MahasiswaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication(scanBasePackages={"org.example"})

public class MainMaba implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(MainMaba.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("MahasiswaService")
    private MahasiswaService mhsService;

    public static void main(String[] args) {
        SpringApplication.run(MainMaba.class, args);
    }

    public void run(String... args) throws Exception {
        log.info("start application.....");
        runJDBC();
    }

    public  void runJDBC() {

        log.info("Creating tables for testing...");

        jdbcTemplate.execute("DROP TABLE IF EXISTS header");
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS header(idMhs SERIAL, fullname VARCHAR(50), address VARCHAR (60), status VARCHAR(30), absensi INT(11))");

        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setFullname("Soleh Said");
        mahasiswa.setAddress("Jakarta");
        mahasiswa.setStatus("Active");
        mahasiswa.setAbsensi(0);

        log.info("Saving...{}", mahasiswa.getFullname());
        int idMhs=mhsService.regisMaba(mahasiswa);
        System.out.println("Id Mahasiswa: "+idMhs);

        jdbcTemplate.execute("DROP TABLE IF EXISTS detail");
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS detail(idDetail SERIAL, idMhs INT(11), physics INT (11), calculus INT (11), biology INT(11))");

        Detail nilai = new Detail();
        nilai.setPhysics(80);
        nilai.setCalculus(70);
        nilai.setBiology(85);

        mhsService.addNilai(nilai, idMhs);
    }
}
