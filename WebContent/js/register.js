document.addEventListener('DOMContentLoaded', function () {
    console.log("register.js loaded successfully........");

    const form = document.getElementById('reg-form');
    const submitBtn = document.getElementById('submit-btn');
    const loader = document.getElementById('loader');

    form.addEventListener('submit', function (event) {
        console.log("Form submit triggered!");
        event.preventDefault();

        const formData = new FormData(form);

        submitBtn.style.display = 'none';
        loader.style.display = 'block';

        const xhr = new XMLHttpRequest();
        xhr.open('POST', 'RegisterServlet', true);

        xhr.onload = function () {
            submitBtn.style.display = 'inline-block';
            loader.style.display = 'none';

            const response = xhr.responseText.trim();

            if (response === 'DONE') {
                swal("Registered successfully..We are going to redirect to login page")
                    .then(() => {
                        window.location = "login_page.jsp";
                    });
            } else {
                swal(response);
            }
        };

        xhr.onerror = function () {
            submitBtn.style.display = 'inline-block';
            loader.style.display = 'none';
            swal("Something went wrong..try again");
        };

        xhr.send(formData);
    });
});
