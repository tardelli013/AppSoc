package br.com.soc.tardelli.controller;

import br.com.soc.tardelli.model.Patient;
import br.com.soc.tardelli.service.PatientService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRest {

    @Autowired
    private PatientService patientService;

    @ApiOperation(value = "Pacientes",
            position = 1,
            notes = "Retorna os pacientes cadastrados ")
    @GetMapping(value = "/api/patient",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Patient> getPatients() {
        return patientService.retrievePatients();
    }
}
