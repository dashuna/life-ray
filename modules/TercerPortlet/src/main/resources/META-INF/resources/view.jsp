<%@ include file="/init.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<portlet:renderURL var='cercania'>
	<portlet:param name='jspPage' value='/cercania.jsp'/>
</portlet:renderURL>

<portlet:renderURL var='alta'>
	<portlet:param name='jspPage' value='/alta.jsp'/>
</portlet:renderURL>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/gsap/1.17.0/TweenMax.min.js"></script>

<!-- Contenido de cercanía -->
<section class="container">
	<div class="row">
		<div class="col-12 p-2">
			<div class="card mb text-center"
				style="background-image: url('${pageContext.request.contextPath}/imagenes/cercania.jpg')">
				<div class="texto-linea">
					<h2>
						<a href="${cercania}">Cercanía</a>
					</h2>
					<hr>
					<p class="d-none">Entendemos las necesidades de las empresas
						desde el punto de vista de negocio, no sólo tecnológico</p>
				</div>
			</div>
		</div>

		<div class=" col-md-4 p-2 agilidad">
			<div class="card mb text-center"
				style="background-image: url('${pageContext.request.contextPath}/imagenes/agilidad.jpg')">
				<div class="texto-linea">
					<h2>
						<a href="${alta}">Agilidad</a>
					</h2>
					<hr>
					<p>Velocidad de respuesta con nuestros clientes</p>
				</div>
			</div>
		</div>

		<div class="col-md-8 p-2">
			<div
				class="card mb text-center d-flex align-content-center justify-content-center align-items-center flex-wrap"
				style="background-color: #0064ac;">
				<!-- <p>70 clientes</p> -->
				<div class="counter">0</div>
				<p class="clientes">clientes</p>
			</div>
		</div>

		<div class="col-lg-4 p-2">
			<div
				class="card mb text-center d-flex flex-row align-content-center justify-content-center align-items-center flex-wrap"
				style="background-color: #387ba0;">
				<p class="consultores">+</p>
				<div class="numero" id="numeroCons">0</div>
				<p class="consultores">consultores</p>
				<img src="${pageContext.request.contextPath}/imagenes/metro1.svg"
					width="20px">                                          
			</div>
		</div>

		<div class="col-lg-4 p-2 creatividad">
			<div class="card mb text-center"
				style="background-image: url('${pageContext.request.contextPath}/imagenes/creatividad.jpg')">
				<div class="texto-linea">
					<h2>Creatividad</h2>
					<hr>
					<p>Continua generación de ideas e innovación que impactan de
						manera real y tangible en el negocio de nuestros clientes</p>
				</div>
			</div>
		</div>

		<div class="col-lg-4 p-2">
			<div
				class="card mb text-center d-flex flex-row align-content-center justify-content-center align-items-center flex-wrap"
				style="background-color: #22adbf;">
				<p class="proyectos">+</p>
				<div class="numero" id="numeroProy">0</div>
				<p class="proyectos">proyectos</p>
			</div>
		</div>

	</div>
</section>

<!-- Contenido con vídeo -->
            <section class="container">
                <!-- style="background-color: #faf9f9;" -->
                <div class="video-container">
                    <div>
                        <h2>Cubrimos el ciclo completo de transformación digital</h2>
                    </div>

                    <div class="row flex-column">
                        <!-- <div class="row"> -->
                        <div class="col-lg-3 align-self-start text-center">
                            <div class="card card-icon mb flex-row align-content-center align-items-center justify-content-center" style="background-color:#0064ac;">
                                <a href="#" class="enlace-icon">
                                    <span>ESTRATEGIA Y CONCEPTUALIZACIÓN</span>
                                    <img src="${pageContext.request.contextPath}/imagenes/strategy.png">
                                </a>
                            </div>
                        </div>
                        <!-- </div> -->

                        <div class="row m-0 align-items-center">
                            <div class="col-lg-3  text-center">
                                <div class="card card-icon mb flex-row align-content-center align-items-center justify-content-center" style="background-color:#0064ac;">
                                    <a href="#" class="enlace-icon">
                                        <span>USER EXPERIENCE</span>
                                        <img src="${pageContext.request.contextPath}/imagenes/user.png">
                                    </a>
                                </div>
                            </div>

                            <div class="col-lg-3  text-center">
                                <div class="card card-icon mb flex-row align-content-center align-items-center justify-content-center" style="background-color:#0064ac;">
                                    <a href="#" class="enlace-icon">
                                        <span>INGENIERÍA DE SOFTWARE</span>
                                        <img src="${pageContext.request.contextPath}/imagenes/responsive.png">
                                    </a>
                                </div>
                            </div>

                            <div class="col-lg-3  text-center">
                                <div class="card card-icon mb flex-row align-content-center align-items-center justify-content-center" style="background-color:#0064ac;">
                                    <a href="#" class="enlace-icon">
                                        <span>SOFTWARE QUALITY ASSURANCE</span>
                                        <img src="${pageContext.request.contextPath}/imagenes/assurance.png">
                                    </a>
                                </div>
                            </div>
                        </div>

                        <!-- <div class="row"> -->
                        <!-- <div class="col-lg-3 col-lg-offset-3 text-center"> -->
                        <div class="col-lg-3 align-self-end text-center">
                            <div class="card card-icon mb flex-row align-content-center align-items-center justify-content-center" style="background-color:#0064ac;">
                                <a href="#" class="enlace-icon">
                                    <span>OUTSOURCING</span>
                                    <img src="${pageContext.request.contextPath}/imagenes/team.png">
                                </a>
                            </div>
                        </div>
                        <!-- </div> -->
                    </div>

                    <video autoplay loop muted class="fillWidth visible-lg">
                        <!-- poster="imagenes/video-poster.jpg" -->
                    <source src="https://www.grupo-sade.com/Content/Videos/Wall-Sketching.mp4" type="video/mp4; "/>        
                    Your browser does not support the video tag.
                    </video>
                </div>
            </section>

            <!-- Contenido con tecnologías -->
            <section class="cobertura">
                <div class="container">
                    <div class="row">
                        <h2>Proporcionamos cobertura tecnológica a todos los ámbitos de la cadena de valor</h2>
                    </div>

                    <div class="row">
                        <div class="col-lg-6">
                            <div class="row">
                                <div class="card" style="background-color: #898a8d;">
                                    <img src="${pageContext.request.contextPath}/imagenes/java-logo.png">
                                </div>
                                <div class="card" style="background-color: #898a8d;">
                                    <img src="${pageContext.request.contextPath}/imagenes/net_blanco.png">
                                </div>
                            </div>

                            <div class="row">
                                <div class="card" style="background-color: #22ADBF;">
                                    <img src="${pageContext.request.contextPath}/imagenes/liferay.png">
                                </div>
                                <div class="card" style="background-color: #22ADBF;">
                                    <img src="${pageContext.request.contextPath}/imagenes/sharepoint.png">
                                </div>
                            </div>

                            <div class="row">
                                <div class="card">
                                    <p>Explotación de información corporativa</p>
                                    <p>Automatización de procesos de negocio</p>
                                </div>
                            </div>

                        </div>

                        <div class="col-lg-3">
                            <div class="row">
                                <div class="card" style="background-color: #0064AC;">
                                    <img src="${pageContext.request.contextPath}/imagenes/xamagon.png">
                                </div>
                            </div>

                            <div class="row">
                                <div class="card" style="background-color: #0064AC;">
                                    <img src="${pageContext.request.contextPath}/imagenes/android.png">
                                </div>
                                <div class="card" style="background-color: #0064AC;">
                                    <img src="${pageContext.request.contextPath}/imagenes/apple.png">
                                </div>
                                <div class="card" style="background-color: #0064AC;">
                                    <img src="${pageContext.request.contextPath}/imagenes/windows.png">
                                </div>
                            </div>

                            <div class="col-lg-3">
                                <div class="row">
                                    <div class="card" style="background-color: #0064AC;">
                                        <p>Digitalización&ECM</p>
                                        <p>Apps B2C/B2B/b2E</p>
                                    </div>

                                    <div class="card" style="background-color: #0064AC;">
                                        <p>Portales y eCommerce</p>
                                        <p>Entornos de colaboracion omnicanal</p>
                                    </div>
                                </div>
                            </div>
                        </div>
            </section>

<script src="${pageContext.request.contextPath}/js/main.js"></script>