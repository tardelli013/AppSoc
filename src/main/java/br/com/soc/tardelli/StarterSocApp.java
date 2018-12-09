package br.com.soc.tardelli;

import br.com.soc.tardelli.service.ExamService;
import br.com.soc.tardelli.service.PatientService;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StarterSocApp extends SpringBootServletInitializer implements ApplicationRunner {
    private static final Logger log = LoggerFactory.getLogger(StarterSocApp.class);

    @Autowired
    private PatientService patientService;
    @Autowired
    private ExamService examService;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(StarterSocApp.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(StarterSocApp.class, args);
        log.info("Started application at {}", "http://localhost:8080/home");
        log.info("Started Swagger at {}", "http://localhost:8080/swagger-ui.html");
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean<StrutsPrepareAndExecuteFilter> registrationBean = new FilterRegistrationBean<>();
        StrutsPrepareAndExecuteFilter filter = new StrutsPrepareAndExecuteFilter();
        registrationBean.setFilter(filter);
        registrationBean.setOrder(1);
        return registrationBean;
    }

    @Override
    public void run(ApplicationArguments args) {
        patientService.putPatients();
        examService.putExams();
    }

}
