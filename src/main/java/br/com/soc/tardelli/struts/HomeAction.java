package br.com.soc.tardelli.struts;

import br.com.soc.tardelli.model.Patient;
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
    private List<Patient> patients;

    @Autowired
    private PatientService patientService;

    @Action(value = "index", results = {
        @Result(name = "success", location = "/home.jsp")
    })
    public String index() {
        patients = patientService.retrievePatients();
        return SUCCESS;
    }

    public List<Patient> getPatients() {
        return patients;
    }
}
