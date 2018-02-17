<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.GregorianCalendar" %>
<%
    GregorianCalendar currentDate = new GregorianCalendar();
    int currentYear = currentDate.get(Calendar.YEAR);

%>
<em><p align="center">
    &COPY; Copyright<%=currentYear%> GROUP EIGHT<br>
    TRANSFORMING LIVES THROUGH QUALITY EDUCATION</br>
    Last Updated:<%= new java.util.Date()%>

</p></em>