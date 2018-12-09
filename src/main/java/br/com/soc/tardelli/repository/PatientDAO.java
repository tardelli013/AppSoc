package br.com.soc.tardelli.repository;

import br.com.soc.tardelli.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

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

    public List<Patient> getPatients(Map<String, String> parameterMap) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT id, first_name, last_name, age, gender FROM patients ");
        query.append("WHERE 0 = 0 ");

        if (parameterMap.containsKey("id")) {
            query.append(" AND id = ").append(parameterMap.get("id"));
        }

        if (parameterMap.containsKey("firstName")) {
            query.append(" AND first_name = '").append(parameterMap.get("firstName")).append("'");
        }

        if (parameterMap.containsKey("lastName")) {
            query.append(" AND last_name = '").append(parameterMap.get("lastName")).append("'");
        }

        if (parameterMap.containsKey("age")) {
            query.append(" AND age = '").append(parameterMap.get("age")).append("'");
        }

        if (parameterMap.containsKey("gender")) {
            query.append(" AND gender = '").append(parameterMap.get("gender")).append("'");
        }

        return jdbcTemplate.query(query.toString(), (rs, rowNum) -> new Patient(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("age"), rs.getString("gender")));
    }

    public Patient update(Patient patient) {
        StringBuilder query = new StringBuilder();
        query.append("UPDATE patients SET ");

        if (Objects.nonNull(patient.getFirstName())) {
            query.append(" first_name = '").append(patient.getFirstName()).append("',");
        }

        if (Objects.nonNull(patient.getLastName())) {
            query.append(" last_name = '").append(patient.getLastName()).append("',");
        }

        if (Objects.nonNull(patient.getAge())) {
            query.append(" age = '").append(patient.getAge()).append("',");
        }

        if (Objects.nonNull(patient.getGender())) {
            query.append(" gender = '").append(patient.getGender()).append("'");
        }

        query.append(" WHERE id = ").append(patient.getId());

        jdbcTemplate.update(query.toString());

        Map<String, String> parameterMap = new HashMap<>();
        parameterMap.put("id", patient.getId().toString());

        List<Patient> patients = getPatients(parameterMap);

        return patients.size() > 0 ? patients.get(0) : null;
    }

    public Patient insert(Patient patient) {
        StringBuilder query = new StringBuilder();
        query.append("INSERT INTO patients(first_name, last_name, age, gender) VALUES (?,?,?,?)");

        Object[] objects = {patient.getFirstName(), patient.getLastName(), patient.getAge(), patient.getGender()};

        jdbcTemplate.update(query.toString(), objects);

        return patient;
    }

    public void delete(Integer id) {
        Object[] params = {id};

        jdbcTemplate.update("DELETE FROM patients WHERE id = ? ", params);
    }

}
