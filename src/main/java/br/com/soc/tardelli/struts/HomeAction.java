package br.com.soc.tardelli.struts;

import br.com.soc.tardelli.model.Exam;
import br.com.soc.tardelli.model.ExamTypesEnum;
import br.com.soc.tardelli.model.Patient;
import br.com.soc.tardelli.service.ExamService;
import br.com.soc.tardelli.service.PatientService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Namespace("/home")
public class HomeAction extends ActionSupport {

    private static final long serialVersionUID = 1L;

    private String patientId;
    private String examTypesId;
    private String crm;

    private List<Patient> patients;
    private List<Exam> exams;
    private ExamTypesEnum[] examTypes = ExamTypesEnum.values();

    @Autowired
    private PatientService patientService;
    @Autowired
    private ExamService examService;

    @Action(value = "index", results = {
            @Result(name = "success", location = "/home.jsp")
    })
    public String index() {
        patients = patientService.retrievePatients();
        exams = examService.retrieveExams();
        return SUCCESS;
    }

    @Action(value = "/saveExam", results = {
            @Result(name = "success", location = "/home.jsp")
    })
    public String saveExam() {
        Exam exam = new Exam();

        String patientId = getPatientId().substring(0,2);
        String examTypeId = getExamTypesId().substring(0,2);

        exam.setPatientId(Integer.valueOf(patientId.trim()));
        exam.setExamTypeId(Integer.valueOf(examTypeId.trim()));
        exam.setCrmRequester(getCrm());

        examService.insertExam(exam);

        patients = patientService.retrievePatients();
        exams = examService.retrieveExams();

        setPatientId("");
        setExamTypesId("");
        setCrm("");
        return SUCCESS;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public ExamTypesEnum[] getExamTypes() {
        return examTypes;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getExamTypesId() {
        return examTypesId;
    }

    public void setExamTypesId(String examTypesId) {
        this.examTypesId = examTypesId;
    }
}
