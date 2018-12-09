package br.com.soc.tardelli.controller;

import br.com.soc.tardelli.model.Exam;
import br.com.soc.tardelli.service.ExamService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExamRest {

    @Autowired
    private ExamService examService;

    @ApiOperation(value = "Buscar Exames",
            position = 1,
            notes = "Retorna todos os exames cadastrados ")
    @GetMapping(value = "/api/exams",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Exam> getExams() {
        return examService.retrieveExams();
    }

    @ApiOperation(value = "Buscar Exame",
            position = 2,
            notes = "Retorna Exame de acordo com os parametros da URL" +

                    "Parametro \"q\" utilizado para agrupar parametros de consulta. " +
                    "\n \n" +
                    "A sintaxe da consulta é chave:valor separados por ':' " +
                    "\n \n" +
                    "Parametros Disponiveis:" +
                    "\n \n" +
                    " id = identificação do exame" +
                    "\n \n" +
                    " patientId = identificação do paciente" +
                    "\n \n" +
                    " examTypeId = identificação do tipo de exame " +
                    "\n \n" +
                    " crmRequester = CRM do medico solicitante" +
                    "\n \n" +
                    " Exemplo de consulta: \"id:16,patientId:4,crmRequester:213-43\" \n" +
                    "")
    @GetMapping(value = "/api/exam",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Exam> getExam(@RequestParam String q) {
        return examService.findExam(q);
    }

    @ApiOperation(value = "Atualizar Exame",
            position = 3,
            notes = "atualiza um registro existente")
    @PutMapping(value = "/api/exam",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Exam updateExam(@RequestBody Exam exam) {
        return examService.updateExam(exam);
    }

    @ApiOperation(value = "Inserir Exames",
            position = 4,
            notes = "Inserir exame")
    @PostMapping(value = "/api/exam",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Exam insertExam(@RequestBody Exam exam) {
        return examService.insertExam(exam);
    }

    @ApiOperation(value = "Remover Exame",
            position = 5,
            notes = "Remove exame de acordo com id")
    @DeleteMapping(value = "/api/exam",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void deleteExam(@RequestParam Integer id) {
        examService.deleteExam(id);
    }
}
