function count() {
    var counter = { var: 0 };
    TweenMax.to(counter, 2, {
        var: 70,
        onUpdate: function() {
            var number = Math.ceil(counter.var);
            $('.counter').html(number);
            if (number === counter.var) { count.kill(); }
        },
        onComplete: function() {
            count();
        },
        ease: Circ.easeOut
    });
}

count();
contarConsultores();
contarProyectos();

function contarConsultores() {
const numeroCons = document.getElementById('numeroCons');
let cantidadCons = 0;

let tiempoCons = setInterval(() => {
    cantidadCons += 1;
    numeroCons.textContent = cantidadCons;

    if (cantidadCons === 100) {
        clearInterval(tiempoCons);
    }

}, 20);
}

function contarProyectos() {
const numeroProy = document.getElementById('numeroProy');
let cantidadProy = 0;

let tiempoProy = setInterval(() => {
    cantidadProy += 1;
    numeroProy.textContent = cantidadProy;

    if (cantidadProy === 200) {
        clearInterval(tiempoProy);
    }

}, 20);
}