document.getElementById("registerBtn").addEventListener("click", function() {
    document.getElementById("registerModal").style.display = "flex";
});

document.getElementById("loginBtn").addEventListener("click", function() {
    document.getElementById("loginModal").style.display = "flex";
});

document.getElementById("closeRegister").addEventListener("click", function() {
    document.getElementById("registerModal").style.display = "none";
});

document.getElementById("closeLogin").addEventListener("click", function() {
    document.getElementById("loginModal").style.display = "none";
});

document.getElementById("registerForm").addEventListener("submit", function(e) {
    e.preventDefault();
    alert("Registration Successful!");
    document.getElementById("registerModal").style.display = "none";
});

document.getElementById("loginForm").addEventListener("submit", function(e) {
    e.preventDefault();
    alert("Login Successful!");
    document.getElementById("loginModal").style.display = "none";
});
