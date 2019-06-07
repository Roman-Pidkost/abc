var collapsing_div = document.getElementsByClassName("col_div")[0];
var btn = document.getElementsByClassName("btn-js")[0];

btn.addEventListener("click", function () {
    collapsing_div.classList.toggle("collapse");
    collapsing_div.classList.toggle("navbar-collapse");
    collapsing_div.classList.toggle("col_div");
});