document.getElementById("user-photo").addEventListener("click", function () {
  const menu = document.getElementById("dropdown-menu");
  if (menu.classList.contains("menu-hidden")) {
    menu.classList.remove("menu-hidden");
  } else {
    menu.classList.add("menu-hidden");
  }
});

// Close the menu when clicking outside
document.addEventListener("click", function (event) {
  const menu = document.getElementById("dropdown-menu");
  const userPhoto = document.getElementById("user-photo");
  if (!userPhoto.contains(event.target) && !menu.contains(event.target)) {
    menu.classList.add("menu-hidden");
  }
});
