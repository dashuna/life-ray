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

const numero = document.getElementById("numero");
let cantidad = 0;

let tiempo = setInterval(() => {
    cantidad += 1;
    numero.textContent = cantidad;

    if (cantidad === 100) {
        clearInterval(tiempo);
    }

}, 20);