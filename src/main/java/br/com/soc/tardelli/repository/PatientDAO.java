package br.com.soc.tardelli.repository;

import br.com.soc.tardelli.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PatientDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Patient> getPatients() {
        return jdbcTemplate.query("SELECT id, first_name, last_name, age, gender FROM patients",
            (rs, rowNum) -> new Patient(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("age"), rs.getString("gender")));
    }

    public void insertBatch() {
        jdbcTemplate.execute("DROP TABLE patients IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE patients(id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255), age VARCHAR(3), gender VARCHAR(1))");
        jdbcTemplate.batchUpdate("INSERT INTO patients(first_name, last_name, age, gender) VALUES (?,?,?,?)", userData());
    }

    private List<Object[]> userData() {
        List<Object[]> patients = new ArrayList<>();
        patients.add("Tardelli Moura 30 M".split(" "));
        patients.add("Lara Moura 1 F".split(" "));
        patients.add("Debora Moura 29 F".split(" "));
        patients.add("João Silva 20 M".split(" "));
        patients.add("Ronlado Nazário 19 M".split(" "));
        patients.add("Ana Santos 19 F".split(" "));
        patients.add("Bruna Nune 15 F".split(" "));
        patients.add("Alex Alves 40 M".split(" "));
        patients.add("Ceasar Rodrigues 39 M".split(" "));
        patients.add("Paula Soares 22 F".split(" "));
        return patients;
    }

}
