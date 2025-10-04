// Wait until the DOM is fully loaded
document.addEventListener("DOMContentLoaded", function () {
	
	// Get the toggle button, password input field, and eye icon
    const toggleBtn = document.getElementById("togglePassword");
    const passwordInput = document.getElementById("exampleInputPassword1");
    const eyeIcon = document.getElementById("eyeIcon");

    if (toggleBtn && passwordInput && eyeIcon) {
        
        // Add a click event listener to the toggle button
        toggleBtn.addEventListener("click", function () {
			
			// Check if the current type is 'password'
            const isPassword = passwordInput.getAttribute("type") === "password";
            
            // Toggle the input type between 'text' and 'password'
            passwordInput.setAttribute("type", isPassword ? "text" : "password");

			// Toggle the eye icon between 'eye' and 'eye-slash'
            eyeIcon.classList.toggle("fa-eye");
            eyeIcon.classList.toggle("fa-eye-slash");
        });
    }
});
