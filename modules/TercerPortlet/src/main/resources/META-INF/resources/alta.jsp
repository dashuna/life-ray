<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<h1>Alta de Facturas</h1>

<p>
	<a href="portlet:renderURL /">Volver</a>
</p>


<!-- creamos el enlace para el formulario de alta de facturas -->
<portlet:actionURL name="altaFactura" var="altaFacturaURL"/>

<!-- vamos a crear un formulario html estandar, 
pero liferay tiene librerias con componentes para que los formularios sean mas bonitos -->
<form method="post" action="${altaFacturaURL}">
	<div>
		Numero: <input type="text" name="<portlet:namespace />numero"/>
	</div>
	<div>
		Cliente: <input type="text" name="<portlet:namespace />cliente"/>
	</div>
	<div>
		Importe: <input type="text" name="<portlet:namespace />importe"/>
	</div>
	
	<div>
		<input type="submit" value="Enviar" />
	</div>
</form>