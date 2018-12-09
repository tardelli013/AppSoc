package br.com.soc.tardelli.controller;

import br.com.soc.tardelli.model.Exam;
import br.com.soc.tardelli.service.ExamService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExamRest {

    @Autowired
    private ExamService examService;

    @ApiOperation(value = "Exames",
            position = 1,
            notes = "Retorna todos os exames cadastrados ")
    @GetMapping(value = "/api/exams",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Exam> getExams() {
        return examService.retrieveExams();
    }
}
