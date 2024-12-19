document.addEventListener("DOMContentLoaded", () => {
    const recipeForm = document.getElementById("recipe-form");
  
    const titleInput = document.getElementById("recipe-title");
    const descriptionInput = document.getElementById("recipe-description");
    const ingredientsInput = document.getElementById("recipe-ingredients");
    const stepsInput = document.getElementById("recipe-steps");
    const imageInput = document.getElementById("recipe-image");
  
    const previewSection = document.getElementById("preview-section");
    const previewTitle = document.getElementById("preview-title");
    const previewDescription = document.getElementById("preview-description");
    const previewIngredients = document.getElementById("preview-ingredients");
    const previewSteps = document.getElementById("preview-steps");
    const previewImage = document.getElementById("preview-image");
  
    // Show live preview
    [titleInput, descriptionInput, ingredientsInput, stepsInput].forEach((input) => {
      input.addEventListener("input", () => {
        previewTitle.textContent = titleInput.value || "N/A";
        previewDescription.textContent = descriptionInput.value || "N/A";
        previewIngredients.textContent = ingredientsInput.value || "N/A";
        previewSteps.textContent = stepsInput.value || "N/A";
        previewSection.style.display = "block";
      });
    });
  
    // Handle image upload and preview
    imageInput.addEventListener("change", (e) => {
      const file = e.target.files[0];
      if (file && file.type.startsWith("image/")) {
        const reader = new FileReader();
        reader.onload = (e) => {
          previewImage.src = e.target.result;
          previewImage.style.display = "block";
        };
        reader.readAsDataURL(file);
      } else {
        previewImage.style.display = "none";
      }
    });
  
    // Form validation on submit
    recipeForm.addEventListener("submit", (e) => {
      e.preventDefault(); // Prevent actual submission for demo
  
      let isValid = true;
      [titleInput, descriptionInput, ingredientsInput, stepsInput].forEach((input) => {
        if (!input.value.trim()) {
          input.classList.add("is-invalid");
          isValid = false;
        } else {
          input.classList.remove("is-invalid");
        }
      });
  
      if (isValid) {
        alert("Recipe saved successfully!");
        recipeForm.reset();
        previewSection.style.display = "none";
      }
    });
  });
  