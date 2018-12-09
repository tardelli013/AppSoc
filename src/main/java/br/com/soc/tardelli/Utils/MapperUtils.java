package br.com.soc.tardelli.Utils;

import br.com.soc.tardelli.model.Exam;
import br.com.soc.tardelli.model.ExamTypesEnum;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapperUtils {

    public static br.com.soc.tardelli.examws.Exam mapExam(Exam exam) {
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

    public static List<Exam> mapExamType(List<Exam> exams) {
        exams.forEach(exam -> exam.setExamType(ExamTypesEnum.getNameById(exam.getExamTypeId())));
        return exams;
    }

    public static Map<String, String> buildParameterMap(String q) {
        Map<String, String> parameterMap = new HashMap<>();
        if (q == null) {
            return parameterMap;
        }
        String[] parameters = q.split(",(?![^\\[]*\\])");

        for (int i = 0; i < parameters.length; i++) {
            String[] parameter = parameters[i].split(":(?![^\\[]*\\])");
            parameterMap.put(parameter[0].trim(), parameter[1].trim());
        }
        return parameterMap;
    }

}
