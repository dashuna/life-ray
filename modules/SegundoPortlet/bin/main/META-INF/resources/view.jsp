<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<h1>Carousel GrupoSade</h1>
<h2>Aquí está mi slider de Sade</h2>

<section>
	<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
	  <ol class="carousel-indicators">
	    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
	    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
	    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
	    <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
	  </ol>
	  <div class="carousel-inner w-100">
	    <div class="carousel-item active">
	      <img class="d-block" src="${pageContext.request.contextPath}/images/soluciones_yservicios_web.jpg">
	      	<div class="carousel-caption d-none d-md-block">
		  		<h5>SOMOS TU PARTNER EN TRANSFORMACIÓN DIGITAL</h5>
                <p>SOMOS GRUPO SADE</p>
	  		</div>
	    </div>
	    <div class="carousel-item">  
	      <img class="d-block" src="${pageContext.request.contextPath}/images/enfoque_integral_web.jpg">
	      <div class="carousel-caption d-none d-md-block">
		    	<h5>ENFOQUE INTEGRAL</h5>
                <p>Acompañamos a nuestros clientes a lo largo de todas las etapas de su transformación digital</p>
	  		</div>
	    </div>
	    <div class="carousel-item">
	      <img class="d-block" src="${pageContext.request.contextPath}/images/grupo-sade_web.jpg">
	      <div class="carousel-caption d-none d-md-block">
		    	<h5>SOLUCIONES Y SERVICIOS</h5>
                <p>Soluciones de software eficientes, rentables y sostenibles</p>
	  		</div>
	    </div>
	    <div class="carousel-item">
	      <img class="d-block" src="${pageContext.request.contextPath}/images/inday-banner.jpg">
	      <div class="carousel-caption d-none d-md-block">
		    	<h5>INDAY APORTA EL VALOR Y LOS RESULTADOS NECESARIOS EN LOS PROCESOS DE REPORTING EN MOVILIDAD</h5>
                <p></p>
	  		</div>
	    </div>
	  </div>
	  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
	    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	    <span class="sr-only">Previous</span>
	  </a>
	  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
	    <span class="carousel-control-next-icon" aria-hidden="true"></span>
	    <span class="sr-only">Next</span>
	  </a>
	</div>
</section>