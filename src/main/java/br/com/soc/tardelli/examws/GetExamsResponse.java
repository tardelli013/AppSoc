//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.7 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2018.12.09 às 02:07:56 AM BRST 
//


package br.com.soc.tardelli.examws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="exam" type="{http://tardelli.soc.com.br/examws}exam"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "exam"
})
@XmlRootElement(name = "getExamsResponse")
public class GetExamsResponse {

    @XmlElement(required = true)
    protected Exam exam;

    /**
     * Obtém o valor da propriedade exam.
     * 
     * @return
     *     possible object is
     *     {@link Exam }
     *     
     */
    public Exam getExam() {
        return exam;
    }

    /**
     * Define o valor da propriedade exam.
     * 
     * @param value
     *     allowed object is
     *     {@link Exam }
     *     
     */
    public void setExam(Exam value) {
        this.exam = value;
    }

}
