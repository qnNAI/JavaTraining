$(document).ready(function () {
    var inputs = document.getElementsByName("productAmount");
    var buttons = document.getElementsByName("changeBtn");

    for (var i = 0; i < inputs.length; i++) {
        inputs[i].addEventListener("input", listener.bind({
            button: buttons[i],
            input: inputs[i],
        }));
        // inputs[i].addEventListener("input", function () {
        //     buttons[i].toggleClass("hidden-element");
        // });
        // inputs[i].addEventListener("keyup", function () {
        //     buttons[i].toggleClass("hidden-element");
        // });
    }

});

var listener = function() {
    if (parseInt($(this.input).attr('value')) !== parseInt($(this.input).val())) {
        $(this.button).removeClass('hidden-element');
    } else {
        $(this.button).addClass('hidden-element');
    }
};