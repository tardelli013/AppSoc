package br.com.soc.tardelli.ws;

import br.com.soc.tardelli.examws.GetExamsRequest;
import br.com.soc.tardelli.examws.GetExamsResponse;
import br.com.soc.tardelli.model.Exam;
import br.com.soc.tardelli.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.GregorianCalendar;

@Endpoint
public class ExamSoapEndpoint {

    private static final String NAMESPACE_URI = "http://tardelli.soc.com.br/examws";

    private ExamService examService;

    @Autowired
    public ExamSoapEndpoint(ExamService examService) {
        this.examService = examService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getExamsRequest")
    @ResponsePayload
    public GetExamsResponse getCountry(@RequestPayload GetExamsRequest request) {
        GetExamsResponse response = new GetExamsResponse();

        response.setExam(mapExam(examService.findById(request.getId())));
        return response;
    }

    private br.com.soc.tardelli.examws.Exam mapExam(Exam exam) {
        br.com.soc.tardelli.examws.Exam newExam = new br.com.soc.tardelli.examws.Exam();
        newExam.setAge(exam.getPatient().getAge());
        newExam.setCrmRequester(exam.getCrmRequester());
        newExam.setExamId(exam.getId());

        GregorianCalendar c = new GregorianCalendar();
        c.setTime(exam.getExaminationDate());
        XMLGregorianCalendar date2 = null;

        try {
            date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }

        newExam.setExaminationDate(date2);
        newExam.setExamType(exam.getExamType());
        newExam.setExamTypeId(exam.getExamTypeId());
        newExam.setName(exam.getPatient().getFirstName() + " " + exam.getPatient().getLastName());
        newExam.setGender(exam.getPatient().getGender().equalsIgnoreCase("M") ? "Masculino" : "Feminino");
        newExam.setPatientId(exam.getExamTypeId());

        return newExam;
    }
}
