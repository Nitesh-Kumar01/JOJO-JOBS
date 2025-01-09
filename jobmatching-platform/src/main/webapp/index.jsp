<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Jojo Jobs</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Optional: Custom CSS -->
    <style>
        body {
            padding-top: 50px;
        }
        .container {
            text-align: center;
        }
        .btn-custom {
            width: 200px;
            margin-top: 20px;
        }
    </style>
</head>
<body>

    <div class="container">
        <!-- Heading -->
        <h1>Welcome to Jojo Jobs</h1>

        <!-- Buttons for Login and Register -->
        <div class="btn-group">
            <!-- Login Button -->
            <button type="button" class="btn btn-primary btn-custom" onclick="window.location.href='login.jsp'">Login</button>
            <!-- Register Button -->
            <button type="button" class="btn btn-success btn-custom" onclick="window.location.href='register.jsp'">Register</button>
        </div>

        <!-- Optional: Bootstrap JS and jQuery (needed for dropdowns, modals, etc.) -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </div>

</body>
</html>
