package br.com.soc.tardelli.service;

import br.com.soc.tardelli.Utils.MapperUtils;
import br.com.soc.tardelli.model.Patient;
import br.com.soc.tardelli.repository.PatientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    public List<Patient> findPatient(String q) {
        Map<String, String> parameterMap = MapperUtils.buildParameterMap(q);

        return patientDAO.getPatients(parameterMap);
    }

    public Patient updatePatient(Patient patient) {
        return patientDAO.update(patient);
    }

    public Patient insertPatient(Patient patient) {
        return patientDAO.insert(patient);
    }

    public void deletePatient(Integer id) {
        patientDAO.delete(id);
    }

}
