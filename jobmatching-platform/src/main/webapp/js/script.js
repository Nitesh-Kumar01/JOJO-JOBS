// Function to show the Login form
function showLoginForm() {
    document.getElementById('loginForm').style.display = 'block';
    document.getElementById('registerForm').style.display = 'none';
    document.getElementById('loginTab').style.backgroundColor = '#007bff';
    document.getElementById('registerTab').style.backgroundColor = '#ccc';
}

// Function to show the Register form
function showRegisterForm() {
    document.getElementById('registerForm').style.display = 'block';
    document.getElementById('loginForm').style.display = 'none';
    document.getElementById('registerTab').style.backgroundColor = '#007bff';
    document.getElementById('loginTab').style.backgroundColor = '#ccc';
}

// Handle Login Form Submission
document.getElementById('loginFormElement').addEventListener('submit', function (e) {
    e.preventDefault();

    // Get user input
    const email = document.getElementById('loginEmail').value;
    const password = document.getElementById('loginPassword').value;

    // Simulate an API call (for demonstration purposes)
    const storedEmail = localStorage.getItem('userEmail');
    const storedPassword = localStorage.getItem('userPassword');

    if (email === storedEmail && password === storedPassword) {
        showPopupMessage('Login successful! Redirecting...');
        setTimeout(() => {
            window.location.href = 'index.html'; // Redirect to homepage or another page
        }, 2000);
    } else {
        showPopupMessage('Invalid credentials! Please try again.');
    }
});

// Handle Registration Form Submission
document.getElementById('registerFormElement').addEventListener('submit', function (e) {
    e.preventDefault();

    // Get user input
    const name = document.getElementById('registerName').value;
    const email = document.getElementById('registerEmail').value;
    const password = document.getElementById('registerPassword').value;
    const confirmPassword = document.getElementById('confirmPassword').value;

    // Validate password confirmation
    if (password !== confirmPassword) {
        showPopupMessage('Passwords do not match! Please try again.');
        return;
    }

    // Store user details in localStorage (for simulation)
    localStorage.setItem('userEmail', email);
    localStorage.setItem('userPassword', password);

    showPopupMessage('Registration successful! Please login.');
    setTimeout(() => {
        showLoginForm(); // Redirect to Login form after successful registration
    }, 2000);
});

// Function to show popup message
function showPopupMessage(message) {
    const popup = document.getElementById('popupMessage');
    const popupText = document.getElementById('popupText');
    const popupOkBtn = document.getElementById('popupOkBtn');
    popupText.textContent = message;
    popup.style.display = 'flex';

    // Show OK button when necessary (for login success or failure)
    if (message === 'Login successful! Redirecting...') {
        popupOkBtn.style.display = 'block'; // Show OK button
        popupOkBtn.addEventListener('click', function () {
            window.location.href = 'login.html'; // Redirect to login page
        });
    } else {
        popupOkBtn.style.display = 'none'; // Hide OK button for other messages
    }
}

// Close popup when the close button is clicked
document.getElementById('popupCloseBtn').addEventListener('click', function () {
    document.getElementById('popupMessage').style.display = 'none';
});
