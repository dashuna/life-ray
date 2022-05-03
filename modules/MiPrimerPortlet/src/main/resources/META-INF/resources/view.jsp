<%@page import="java.util.ArrayList"%>
<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>

<h1>Este es mi primer Portlet</h1>

<% String portlet = "Portlet"; 
	Integer num1 = 43;
	Integer num2 = 11;
	//List<String>listado_meses = new ArrayList();
	List<String> meses = Arrays.asList("enero", "marzo", "junio", "agosto");
	// Al cerrar las etiquetas de jsp, perdemos la variable. Por lo que hay que agregarlo en el contexto de la pagina
	pageContext.setAttribute("meses", meses);
%>

<p><%=portlet + " " + (num1 + num2) %></p>

<!-- etiquetas de jsp -->
<c:forEach var="mes" items="${meses}">
	   <p><c:out value="${mes}" /></p>
</c:forEach>

<!--
<c:forEach var = "i" begin = "1" end = "5">
         Item <c:out value = "${i}"/><p>
</c:forEach>
-->

<%
    String meses_año[]={"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre"};
  	for (int i = 0 ; i < meses_año.length; i++){
	%><p><%=meses_año[i]%></p>
<% } %>

