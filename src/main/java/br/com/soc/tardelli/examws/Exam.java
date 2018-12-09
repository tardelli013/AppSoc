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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java de exam complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="exam">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="examId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="patientId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="age" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="gender" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="examTypeId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="examType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="crmRequester" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="examinationDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exam", propOrder = {
    "examId",
    "patientId",
    "name",
    "age",
    "gender",
    "examTypeId",
    "examType",
    "crmRequester",
    "examinationDate"
})
public class Exam {

    protected int examId;
    protected int patientId;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String age;
    @XmlElement(required = true)
    protected String gender;
    protected int examTypeId;
    @XmlElement(required = true)
    protected String examType;
    @XmlElement(required = true)
    protected String crmRequester;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar examinationDate;

    /**
     * Obtém o valor da propriedade examId.
     * 
     */
    public int getExamId() {
        return examId;
    }

    /**
     * Define o valor da propriedade examId.
     * 
     */
    public void setExamId(int value) {
        this.examId = value;
    }

    /**
     * Obtém o valor da propriedade patientId.
     * 
     */
    public int getPatientId() {
        return patientId;
    }

    /**
     * Define o valor da propriedade patientId.
     * 
     */
    public void setPatientId(int value) {
        this.patientId = value;
    }

    /**
     * Obtém o valor da propriedade name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Define o valor da propriedade name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtém o valor da propriedade age.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAge() {
        return age;
    }

    /**
     * Define o valor da propriedade age.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAge(String value) {
        this.age = value;
    }

    /**
     * Obtém o valor da propriedade gender.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGender() {
        return gender;
    }

    /**
     * Define o valor da propriedade gender.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGender(String value) {
        this.gender = value;
    }

    /**
     * Obtém o valor da propriedade examTypeId.
     * 
     */
    public int getExamTypeId() {
        return examTypeId;
    }

    /**
     * Define o valor da propriedade examTypeId.
     * 
     */
    public void setExamTypeId(int value) {
        this.examTypeId = value;
    }

    /**
     * Obtém o valor da propriedade examType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExamType() {
        return examType;
    }

    /**
     * Define o valor da propriedade examType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExamType(String value) {
        this.examType = value;
    }

    /**
     * Obtém o valor da propriedade crmRequester.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCrmRequester() {
        return crmRequester;
    }

    /**
     * Define o valor da propriedade crmRequester.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCrmRequester(String value) {
        this.crmRequester = value;
    }

    /**
     * Obtém o valor da propriedade examinationDate.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExaminationDate() {
        return examinationDate;
    }

    /**
     * Define o valor da propriedade examinationDate.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExaminationDate(XMLGregorianCalendar value) {
        this.examinationDate = value;
    }

}
