const animalConfig = {
    baseUrl: 'http://localhost:8080/api',
    headers: {
        'Content-Type':'application/json'
        }
    }
let imgUrl = null;

document.addEventListener("DOMContentLoaded", () => {
  console.log("Hello World!");
  var myWidget = cloudinary.createUploadWidget({
        cloudName: 'dwn0hs3si',
        uploadPreset: 'emgrvd7m'}, (error, result) => {
          if (!error && result && result.event === "success") {
            console.log('Done! Here is the image info: ', result.info.url);
            imgUrl = result.info.url;
          }
        }
      )

      document.getElementById("upload_widget").addEventListener("click", function(){

          myWidget.open();
        }, false);
});

const imageInput = document.getElementById('image');
const addAnimalForm = document.getElementById('add-animal-form')
console.log("Hello")
const handleSubmit = async (e) => {
    console.log("second hello")
    e.preventDefault();

    let bodyObj = {
        species: document.getElementById('species').value,
        name: document.getElementById('name').value,
        dob: document.getElementById('dob').value,
        gender: document.getElementById('gender').value,
        intakeDate: document.getElementById('int-date').value,
        intakeMethod: document.getElementById('int-method').value,
        image: imgUrl,
        breed: document.getElementById('breed').value,
        food: document.getElementById('food').value,
        foodAmount: document.getElementById('food-amount').value,
        availability: document.querySelector('input[name="availability"]:checked').value
//// ADOPTION STUFF
//        adoptionDate: document.getElementById('adoption-date').value,
//        ownerName: document.getElementById('owner-name').value,
//        ownerPhone: document.getElementById('owner-phone').value,
//        ownerAddress: document.getElementById('owner-address').value,
// DISPOSITION STUFF
//        potty: document.getElementById('potty').value,
//        leash: document.getElementById('leash').value,
//        kids: document.getElementById('kids').value,
//        otherAnimals: document.getElementById('other-animals').value,
//        temper: document.getElementById('temper').value,
//        crate: document.getElementById('crate').value,
//        comments: document.getElementById('comments').value,
////HEALTH STUFF
//        spayed: document.getElementById('spayed').value,
//        stool: document.getElementById('stool').value,
//        allergy: document.getElementById('allergy').value,
//        disability: document.getElementById('disability').value,
//        quarantine: document.getElementById('quarantine').value,
//        medicalRest: document.getElementById('rest').value,

    }
    console.log(bodyObj)
    const response = await fetch(`${animalConfig.baseUrl}/animal/add-animal`, {
        method: "POST",
        body: JSON.stringify(bodyObj),
//        headers: animalConfig.headers
    })
    console.log(response)
//        .catch(err => console.error(err.message))
    if (response.status === 200) {
        window.location.pathname = '/animal/animals.html';
    }
}
//addAnimalForm.addEventListener("submit", handleSubmit)
document.getElementById("submit-button").addEventListener("click", handleSubmit)