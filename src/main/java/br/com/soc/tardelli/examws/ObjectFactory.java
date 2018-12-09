//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.7 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2018.12.09 às 02:07:56 AM BRST 
//


package br.com.soc.tardelli.examws;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.soc.tardelli.examws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.soc.tardelli.examws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetExamsRequest }
     * 
     */
    public GetExamsRequest createGetExamsRequest() {
        return new GetExamsRequest();
    }

    /**
     * Create an instance of {@link GetExamsResponse }
     * 
     */
    public GetExamsResponse createGetExamsResponse() {
        return new GetExamsResponse();
    }

    /**
     * Create an instance of {@link Exam }
     * 
     */
    public Exam createExam() {
        return new Exam();
    }

}
