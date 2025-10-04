// Toggle Edit Profile
document.addEventListener("DOMContentLoaded", function () {
    let editStatus = false;

    const editButton = document.getElementById("edit-profile-button");
    const profileDetails = document.getElementById("profile-details");
    const profileEdit = document.getElementById("profile-edit");

    editButton.addEventListener("click", function () {
        if (!editStatus) {
            profileDetails.style.display = "none";
            profileEdit.style.display = "block";
            editStatus = true;
            this.textContent = "Back";
        } else {
            profileDetails.style.display = "block";
            profileEdit.style.display = "none";
            editStatus = false;
            this.textContent = "Edit";
        }
    });
});

// Add Post via AJAX
document.addEventListener("DOMContentLoaded", function () {
    const addPostForm = document.getElementById("add-post-form");

    addPostForm.addEventListener("submit", function (event) {
        event.preventDefault();
        console.log("you have clicked on submit..");

        const formData = new FormData(this);

        fetch("AddPostServlet", {
            method: "POST",
            body: formData
        })
            .then(response => response.text())
            .then(data => {
                if (data.trim() === "DONE") {
                    swal("Good job!", "saved successfully", "success");
                } else {
                    swal("Error!!", "Something went wrong try again...", "error");
                }
            })
            .catch(error => {
                swal("Error!!", "Something went wrong try again...", "error");
            });
    });
});

// Load Posts by Category
function getPosts(catId, temp) {
    const loader = document.getElementById("loader");
    const postContainer = document.getElementById("post-container");
    const links = document.querySelectorAll(".c-link");

    loader.style.display = "block";
    postContainer.style.display = "none";

    links.forEach(link => link.classList.remove("active"));

    fetch(`load_posts.jsp?cid=${encodeURIComponent(catId)}`)
        .then(response => response.text())
        .then(data => {
            loader.style.display = "none";
            postContainer.style.display = "block";
            postContainer.innerHTML = data;
            temp.classList.add("active");
        });
}

// Call getPosts on initial load
document.addEventListener("DOMContentLoaded", function () {
    const allPostRef = document.querySelectorAll('.c-link')[0];
    getPosts(0, allPostRef);
});
