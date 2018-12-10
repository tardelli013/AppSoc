package br.com.soc.tardelli.ws;

import br.com.soc.tardelli.Utils.MapperUtils;
import br.com.soc.tardelli.examws.GetExamsRequest;
import br.com.soc.tardelli.examws.GetExamsResponse;
import br.com.soc.tardelli.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

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

        response.setExam(MapperUtils.mapExam(examService.findById(request.getId())));
        return response;
    }

}
