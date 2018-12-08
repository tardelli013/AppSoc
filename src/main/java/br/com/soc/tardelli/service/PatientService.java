package br.com.soc.tardelli.service;

import br.com.soc.tardelli.repository.PatientDAO;
import br.com.soc.tardelli.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientDAO patientDAO;

    public void putPatients() {
        patientDAO.insertBatch();
    }

    public List<Patient> retrievePatients() {
        return patientDAO.getPatients();
    }

}
