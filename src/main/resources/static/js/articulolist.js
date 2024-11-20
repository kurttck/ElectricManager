/* para crear articulo */
document.addEventListener("DOMContentLoaded", function () {
  const button = document.getElementById("createProductButton");
  const drawer = document.getElementById("drawer-create-product-default");

  button.addEventListener("click", function () {
    drawer.classList.remove("-translate-x-full");
    drawer.classList.add("translate-x-0");
  });
});

document.addEventListener("DOMContentLoaded", function () {
  const closeButton = document.getElementById("closeDrawerButton");
  const drawer = document.getElementById("drawer-create-product-default");
  const closeButton2 = document.getElementById("close-button");

  closeButton.addEventListener("click", function () {
    drawer.classList.remove("translate-x-0");
    drawer.classList.add("-translate-x-full");
  });

  closeButton2.addEventListener("click", function () {
    drawer.classList.remove("translate-x-0");
    drawer.classList.add("-translate-x-full");
  });
});

/* para modificar articulo */
document.addEventListener("DOMContentLoaded", function () {
  const buttonUpdate = document.getElementById("updateProductButton");
  const drawerUpdate = document.getElementById("drawer-update-product-default");

  const closeButtonUpdate = document.getElementById("close-buttonUpdate");

  console.log("hola update");

  buttonUpdate.addEventListener("click", function () {
    // Mover el drawer desde la derecha
    drawerUpdate.classList.remove("translate-x-full");
    drawerUpdate.classList.add("translate-x-0");
  });

  closeButtonUpdate.addEventListener("click", function () {
    drawerUpdate.classList.remove("translate-x-0");
    drawerUpdate.classList.add("translate-x-full");
  });
});

/*PARA TRAER LA INFORMACION DEL ARTICULO*/

function mostrarArticulo(id){

}