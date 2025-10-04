document.addEventListener("DOMContentLoaded", function () {
    // Profile edit toggle
    let editStatus = false;

    const editBtn = document.getElementById("edit-profile-button");
    const profileDetails = document.getElementById("profile-details");
    const profileEdit = document.getElementById("profile-edit");

    editBtn.addEventListener("click", function () {
        if (!editStatus) {
            profileDetails.style.display = "none";
            profileEdit.style.display = "block";
            editBtn.textContent = "Back";
            editStatus = true;
        } else {
            profileDetails.style.display = "block";
            profileEdit.style.display = "none";
            editBtn.textContent = "Edit";
            editStatus = false;
        }
    });

    // Add post form submission
    const postForm = document.getElementById("add-post-form");

    postForm.addEventListener("submit", function (event) {
        event.preventDefault();
        console.log("you have clicked on submit..");

        const formData = new FormData(postForm);

        fetch("AddPostServlet", {
            method: "POST",
            body: formData
        })
        .then(response => response.text())
        .then(data => {
            if (data.trim() === 'done') {
                swal("Good job!", "Saved successfully", "success");
            } else {
                swal("Error!!", "Something went wrong try again...", "error");
            }
        })
        .catch(error => {
            console.error("Error:", error);
            swal("Error!!", "Something went wrong try again...", "error");
        });
    });
});
