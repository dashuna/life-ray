<%@ include file="/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    	<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/1.17.0/TweenMax.min.js"></script>
		
     <section class="container">
        <div class="row">
            <div class="col-12 p-2">
                <div class="card mb text-center" style="background-image: url('${pageContext.request.contextPath}/imagenes/cercania.jpg')">
                    <div class="texto-linea">
                        <h2>Cercanía</h2>
                        <hr>
                        <p class="d-none">Entendemos las necesidades de las empresas desde el punto de vista de negocio, no sólo tecnológico</p>
                    </div>
                </div>
            </div>

            <div class=" col-md-4 p-2 agilidad">
                <div class="card mb text-center" style="background-image: url('${pageContext.request.contextPath}/imagenes/agilidad.jpg')">
                    <div class="texto-linea">
                        <h2>Agilidad</h2>
                        <hr>
                        <p>Velocidad de respuesta con nuestros clientes</p>
                    </div>
                </div>
            </div>

            <div class="col-md-8 p-2">
                <div class="card mb text-center d-flex align-content-center justify-content-center align-items-center flex-wrap" style="background-color: #0064ac;">
                    <!-- <p>70 clientes</p> -->
                    <div class="counter">0 </div>
                    <p class="clientes">clientes</p>
                </div>
            </div>

            <div class="col-lg-4 p-2">
                <div class="card mb text-center d-flex align-content-center justify-content-center align-items-center flex-wrap" style="background-color: #387ba0;">
                    <p class="consultores"> + </p>
                    <div class="numero" id="numero">0 </div>
                    <p class="consultores">consultores</p>
                    <img src="${pageContext.request.contextPath}/imagenes/metro1.svg" width="20px">
                </div>
            </div>

            <div class="col-lg-4 p-2 creatividad">
                <div class="card mb text-center" style="background-image: url('${pageContext.request.contextPath}/imagenes/creatividad.jpg')">
                    <div class="texto-linea">
                        <h2>Creatividad</h2>
                        <hr>
                        <p>Continua generación de ideas e innovación que impactan de manera real y tangible en el negocio de nuestros clientes</p>
                    </div>
                </div>
            </div>

            <div class="col-lg-4 p-2">
                <div class="card mb text-center" style="background-color: #22adbf;">
                    <p>+200 proveedores</p>
                </div>
            </div>

        </div>
    </section>