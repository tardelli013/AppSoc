package br.com.soc.tardelli.model;

import br.com.soc.tardelli.config.JsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

public class Exam {
    private Integer id;
    private Integer patientId;
    private Patient patient;
    private Integer examTypeId;
    private String ExamType;
    private String crmRequester;
    private Date examinationDate;

    public Exam(Integer id, Integer patientId, Integer examTypeId, String crmRequester, Date examinationDate, String firstName, String lastName, String age, String gender) {
        this.id = id;
        this.patientId = patientId;
        this.examTypeId = examTypeId;
        this.crmRequester = crmRequester;
        this.examinationDate = examinationDate;

        this.patient = new Patient(patientId, firstName, lastName, age, gender);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Integer getExamTypeId() {
        return examTypeId;
    }

    public void setExamTypeId(Integer examTypeId) {
        this.examTypeId = examTypeId;
    }

    public String getExamType() {
        return ExamType;
    }

    public void setExamType(String examType) {
        ExamType = examType;
    }

    public String getCrmRequester() {
        return crmRequester;
    }

    public void setCrmRequester(String crmRequester) {
        this.crmRequester = crmRequester;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    public Date getExaminationDate() {
        return examinationDate;
    }

    public void setExaminationDate(Date examinationDate) {
        this.examinationDate = examinationDate;
    }
}