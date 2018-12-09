<%@ page contentType = "text/html; charset = UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Information</title>

    <sb:head/>

    <style>
        body {
            font-family: verdana;
        }

        table {
            width: 500px;

        }

        table, th, td {
            border: 1px solid black;
            padding: 2px;
        }

        th {
            background-color: #00439A;
            color: #FFFFFF;
        }

        tr.odd {
            background-color: #CFCFCF;
        }

        tr.even {
            background-color: #1076F5;
        }
    </style>
</head>
<body>

    <s:actionerror theme="bootstrap"/>
    <s:actionmessage theme="bootstrap"/>
    <s:fielderror theme="bootstrap"/>


    <s:form action="index" enctype="multipart/form-data" theme="bootstrap" cssClass="form-horizontal"
            label="A sample horizontal Form">
        <s:textfield
                label="Name"
                name="name"
                tooltip="Enter your Name here"/>

        <s:textfield
                label="Textfield with Error"
                name="error"/>

        <s:textarea
                tooltip="Enter your Biography"
                label="Biography"
                name="bio"
                cols="20"
                rows="3"/>

        <s:select
                tooltip="Choose Your Favourite Color"
                label="Favorite Color"
                list="{'Red', 'Blue', 'Green'}"
                name="favouriteColor"
                emptyOption="true"
                headerKey="None"
                headerValue="None"/>

        <s:checkboxlist
                tooltip="Choose your Friends"
                label="Friends"
                list="{'Wes', 'Patrick', 'Jason', 'Jay', 'Toby', 'Rene'}"
                name="friends"/>

        <s:radio
                tooltip="Choose your Best Friend"
                label="Best Friend"
                list="{'Wes', 'Patrick', 'Jason', 'Jay', 'Toby', 'Rene'}"
                name="bestFriend"
                cssErrorClass="foo"/>

        <s:checkbox
                tooltip="Confirmed that your are Over 18"
                label="Age 18+"
                name="legalAge"/>

        <s:submit cssClass="btn"/>
    </s:form>


<h1>Patients Information</h1>

<table>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Age</th>
        <th>Gender</th>
    </tr>
    <s:iterator value="patients">
        <tr class="<s:if test="id%2==0">even</s:if><s:else>odd</s:else>">
            <td align="center"><s:property value="id"/></td>
            <td><s:property value="firstName"/></td>
            <td><s:property value="lastName"/></td>
            <td align="center"><s:property value="age"/></td>
            <td><s:if test="gender.equals(\"M\")">Male</s:if><s:else>Female</s:else></td>
        </tr>
    </s:iterator>
</table>


</body>
</html>
