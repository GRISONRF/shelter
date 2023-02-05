console.log("inside the animal page js")


//document.getElementById('edit-button').addEventListener('click', function() {
//    var inputs = document.querySelectorAll('input');
//        inputs.forEach(function(input) {
//            input.disabled = !input.disabled;
//        });
//    });
//
//const editAnimalButton = document.getElementById("editAnimalButton");
//const animalForm = document.getElementById("animalForm");
//
//editAnimalButton.addEventListener("click", function() {
//        animalForm.style.display = "block";
//});


// This function will make the input fields visible and allow the user to edit the animal's information
function enableEdit() {
  document.getElementById("animal-info").style.display = "block";
  document.getElementById("save-button").style.display = "inline-block";
}

// This function will save the updated animal information to the database
function saveAnimal() {
  // Get the updated animal information from the input fields
  const name = document.getElementById("name").value;
  const species = document.getElementById("species").value;
  const breed = document.getElementById("breed").value;
  const age = document.getElementById("age").value;

  // Make an AJAX request to the server to update the animal information in the database
  const xhr = new XMLHttpRequest();
  xhr.open("PUT", "/api/animals/" + animalId, true);
  xhr.setRequestHeader("Content-Type", "application/json");
  xhr.send(JSON.stringify({ name, species, breed, age }));

  xhr.onload = function() {
    if (xhr.status === 200) {
      // If the update was successful, update the displayed information on the page
      document.getElementById("animal-name").innerHTML = name;
      document.getElementById("animal-species").innerHTML = species;
      document.getElementById("animal-breed").innerHTML = breed;
      document.getElementById("animal-age").innerHTML = age;

      // Hide the input fields and the save button
      document.getElementById("animal-info").style.display = "none";
      document.getElementById("save-button").style.display = "none";
    }
  };
}


