function cambia(){
      var hola=document.getElementsByClassName("menuDiv")[0];
      var cambiaIcono = document.getElementById("button-toggle-navigation");
      cambiaIcono.classList.toggle("isActive");
      hola.classList.toggle("show");
  }