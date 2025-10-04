// Function to handle like/dislike toggle
function doLike(postId, userId, element) {
    console.log("Clicked Post ID:", postId, "User ID:", userId);

    const counterEl = element.querySelector(".like-counter");

    // Get current like count safely
    let count = parseInt(counterEl.innerText);
    count = isNaN(count) ? 0 : count;

    // Determine if currently liked (you can also use a class toggle or server-side data)
    const isLiked = element.classList.contains("liked");

    // Set operation based on current state
    const operation = isLiked ? "dislike" : "like";

    // Prepare data
    const likeInfo = new URLSearchParams();
    likeInfo.append("userid", userId);
    likeInfo.append("postid", postId);
    likeInfo.append("operation", operation);

    // Send AJAX request using Fetch API
    fetch("LikeServlet", {
        method: "POST",
        headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: likeInfo.toString()
    })
    .then(response => response.text())
    .then(data => {
        if (data.trim() === "true") {
            if (operation === "like") {
                counterEl.innerText = count + 1;
                element.classList.add("liked");
                element.classList.remove("btn-outline-light");
                element.classList.add("btn-success");
            } else {
                counterEl.innerText = Math.max(count - 1, 0);
                element.classList.remove("liked");
                element.classList.remove("btn-success");
                element.classList.add("btn-outline-light");
            }
        } else {
            console.error("Server response was not 'true':", data);
        }
    })
    .catch(error => {
        console.error("Error in like/dislike:", error);
    });
}
