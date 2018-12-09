package br.com.soc.tardelli.controller;

import br.com.soc.tardelli.model.Patient;
import br.com.soc.tardelli.service.PatientService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientRest {

    @Autowired
    private PatientService patientService;

    @ApiOperation(value = "Pacientes",
            position = 1,
            notes = "Retorna todos os pacientes cadastrados ")
    @GetMapping(value = "/api/patients",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Patient> getPatients() {
        return patientService.retrievePatients();
    }


    @ApiOperation(value = "Buscar Paciente",
            position = 2,
            notes = "Retorna Pacientes de acordo com os parametros da URL" +

                    "Parametro \"q\" utilizado para agrupar parametros de consulta. " +
                    "\n \n" +
                    "A sintaxe da consulta é chave:valor separados por ':' " +
                    "\n \n" +
                    "Parametros Disponiveis:" +
                    "\n \n" +
                    " id = identificação do paciente" +
                    "\n \n" +
                    " firstName = pesquisar pelo primeiro nome do paciente" +
                    "\n \n" +
                    " lastName = sobre nome do paciente" +
                    "\n \n" +
                    " age = idade do paciente " +
                    "\n \n" +
                    " Exemplo de consulta: \"firstName:Tardelli,lastName:Moura\" \n" +
                    "")
    @GetMapping(value = "/api/patient",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Patient> getPatients(@RequestParam String q) {
        return patientService.findPatient(q);
    }

    @ApiOperation(value = "Atualizar Paciente",
            position = 3,
            notes = "atualiza um registro existente")
    @PutMapping(value = "/api/patient",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Patient updatePatient(@RequestBody Patient patient) {
        return patientService.updatePatient(patient);
    }

    @ApiOperation(value = "Inserir Paciente",
            position = 4,
            notes = "Inserir paciente")
    @PostMapping(value = "/api/patient",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Patient insertPatient(@RequestBody Patient patient) {
        return patientService.insertPatient(patient);
    }

    @ApiOperation(value = "Remover Paciente",
            position = 5,
            notes = "Remove paciente de acordo com id")
    @DeleteMapping(value = "/api/patient",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void deletePatient(@RequestParam Integer id) {
        patientService.deletePatient(id);
    }
}
