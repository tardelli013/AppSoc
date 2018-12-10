<%@ page contentType = "text/html; charset = UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Soc Exames</title>

<sb:head/>
</head>
<body>

   <div class="jumbotron text-center">
     <h1>App Soc Exames</h1>
   </div>

   <div class="row">
     <div class="col-sm-1"></div>
     <div class="col-sm-9">
        <s:form theme="bootstrap"
        action="saveExam"
        cssClass="well form-vertical" label="Adicionar exame">

             <s:select
                tooltip="Paciente"
                label="Paciente"
                list="patients"
                name="patientId"
                emptyOption="true"
                headerKey="Paciente"
                headerValue="Paciente"/>

             <s:select
                 tooltip="Tipo Exame"
                 label="Tipo Exame"
                 list="examTypes"
                 name="examTypesId"
                 emptyOption="true"
                 headerKey="Tipo Exame"
                 headerValue="Tipo Exame"/>

             <s:textfield
                 label="CRM Medico"
                 name="crm"
                 tooltip="Medico requisitante"/>


               <s:submit cssClass="btn btn-primary" />
           </s:form>
     </div>
     <div class="col-sm-1"></div>
   </div>

   <div class="row">
     <div class="col-sm-1"></div>
     <div class="col-sm-9">
        <s:form  enctype="multipart/form-data" theme="bootstrap"
                cssClass="well form-vertical" label="Exames cadastrados">

        <table class="table table-striped">
            <tr>
                <th>#</th>
                <th>Exame</th>
                <th>Nome</th>
                <th>Sobrenome</th>
                <th>CRM Medico</th>
                <th>Data Exame</th>
                <th>Idade</th>
                <th>Sexo</th>
            </tr>
            <s:iterator value="exams">
                <tr class="<s:if test="id%2==0">even</s:if><s:else>odd</s:else>">
                    <td><s:property value="id"/></td>
                    <td><s:property value="examType"/></td>
                    <td><s:property value="patient.firstName"/></td>
                    <td><s:property value="patient.lastName"/></td>
                    <td><s:property value="crmRequester"/></td>
                    <td><s:property value="examinationDate"/></td>
                    <td><s:property value="patient.age"/></td>
                    <td><s:if test="patient.gender.equals(\"M\")">Masc</s:if><s:else>Fem</s:else></td>
                </tr>
            </s:iterator>
        </table>

        </s:form>

     </div>
     <div class="col-sm-1"></div>
   </div>



</body>
</html>
