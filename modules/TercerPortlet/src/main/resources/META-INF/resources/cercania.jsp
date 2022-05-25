<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<h1>Prueba de nueva p�gina Cercan�a</h1>

<p>
	<a href="portlet:renderURL /">Volver</a>
</p>

<table>
	<tr>
		<th>Numero</th>
		<th>Cliente</th>
		<th>Importe</th>
	</tr>
	
	<c:forEach var='f' items='${ facturas }'>
		<tr>
			<td>${f.numero}</td>
			<td>${f.cliente}</td>
			<td>${f.importe}</td>
		</tr>
	</c:forEach>
</table>

<div style="margin-top: 15px">
	<portlet:resourceURL var="exportCSV" />
	<a href="${exportCSV}">Exportar a CSV</a>
</div>