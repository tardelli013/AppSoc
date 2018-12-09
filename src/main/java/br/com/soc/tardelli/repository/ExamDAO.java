package br.com.soc.tardelli.repository;

import br.com.soc.tardelli.model.Exam;
import br.com.soc.tardelli.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ExamDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Exam> getExams() {
        List<Exam> list = jdbcTemplate.query(
                "SELECT e.id, e.patient_id, e.exam_type_id, e.crm_requester, e.examination_date, p.first_name, p.last_name, p.age, p.gender " +
                     "FROM exam e " +
                     "INNER JOIN patients p ON (p.id = e.patient_id) ",

            (rs, rowNum) -> new Exam(rs.getInt("id"), rs.getInt("patient_id"), rs.getInt("exam_type_id"), rs.getString("crm_requester"), rs.getDate("examination_date"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("age"), rs.getString("gender")));

        return list;
    }

    public void insertBatch() {
        jdbcTemplate.execute("DROP TABLE exam IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE exam(id SERIAL, patient_id INT, exam_type_id INT, crm_requester VARCHAR(30), examination_date DATE)");
        jdbcTemplate.batchUpdate("INSERT INTO exam(patient_id, exam_type_id, crm_requester, examination_date) VALUES (?,?,?,CURRENT_DATE())", userData());
    }

    private List<Object[]> userData() {
        List<Object[]> patients = new ArrayList<>();
        patients.add("1 2 12003-67".split(" "));
        patients.add("2 5 19023-47".split(" "));
        patients.add("3 5 14823-4".split(" "));
        patients.add("1 3 12366-74".split(" "));
        patients.add("1 7 233-4".split(" "));
        patients.add("2 2 1343-5".split(" "));
        patients.add("4 2 123-4".split(" "));
        patients.add("1 8 123-4".split(" "));
        patients.add("5 7 4342-4".split(" "));
        patients.add("2 9 23564-4".split(" "));
        return patients;
    }

}
