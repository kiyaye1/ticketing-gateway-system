$(document).ready(function () {
    $('#loginForm').submit(function (e) {
        e.preventDefault();

        $.ajax({
            type: 'POST',
            url: '/login',
            data: $(this).serialize(),
            success: function () {
                $.get("/api/current-role", function (role) {
                    if (role === "ADMIN") {
                        window.location.href = "/html/dashboard-admin.html";
                    } else if (role === "MANAGER") {
                        window.location.href = "/html/dashboard-manager.html";
                    } else {
                        window.location.href = "/html/dashboard-user.html";
                    }
                });
            },
            error: function () {
                alert("Login failed. Check email or password.");
            }
        });
    });
});
