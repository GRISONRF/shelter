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

    let bodyObjDisp = {
        potty: document.getElementById('potty').value,
        leash: document.getElementById('leash').value,
        kids: document.getElementById('kids').value,
        otherAnimals: document.getElementById('other-animals').value,
        temper: document.getElementById('temper').value,
        crate: document.getElementById('crate').value,
        comments: document.getElementById('comments').value
    }
    console.log(bodyObjDisp);


    let quarantineRadios = document.getElementsByName('inlineRadioOptions');
    let quarantineValue;
    for (let i = 0; i < quarantineRadios.length; i++) {
        if (quarantineRadios[i].checked) {
            quarantineValue = quarantineRadios[i].nextElementSibling.textContent.trim();
            break;
        }
    }

    let medicalRestRadios = document.getElementsByName('inlineRadioOptions2');
    let medicalRestValue;
    for (let i = 0; i < medicalRestRadios.length; i++) {
        if (medicalRestRadios[i].checked) {
            medicalRestValue = medicalRestRadios[i].nextElementSibling.textContent.trim();
            break;
        }
    }

    let bodyObjHealth = {
            spayed: document.getElementById('spayed').value,
            stool: document.getElementById('stool').value,
            weight: document.getElementById('weight').value,
            allergy: document.getElementById('allergy').value,
            disability: document.getElementById('disability').value,
            quarantine: quarantineValue,
            medicalRest: medicalRestValue,
    }

    console.log(bodyObjHealth);

    let availabilityRadios = document.getElementsByName('availability');
        let availabilityValue;
        for (let i = 0; i < availabilityRadios.length; i++) {
            if (availabilityRadios[i].checked) {
                availabilityValue = availabilityRadios[i].nextElementSibling.textContent.trim();
                break;
            }
        }



    let bodyObj = {
        species: document.getElementById('species').value,
        name: document.getElementById('name').value,
        dob: document.getElementById('dob').value,
        gender: document.getElementById('gender').value,
        intakeDate: document.getElementById('int-date').value,
        intakeMethod: document.getElementById('int-method').value,
        picture: imgUrl,
        breed: document.getElementById('breed').value,
        food: document.getElementById('food').value,
        food_amount: document.getElementById('food-amount').value,
        availability: availabilityValue,
        disposition: bodyObjDisp,
        health: bodyObjHealth
//        availability: document.querySelector('input[name="availability"]:checked').innerHTML
    }
//// ADOPTION STUFF
//        adoptionDate: document.getElementById('adoption-date').value,
//        ownerName: document.getElementById('owner-name').value,
//        ownerPhone: document.getElementById('owner-phone').value,
//        ownerAddress: document.getElementById('owner-address').value,



    console.log(bodyObj)
    const response = await fetch(`${animalConfig.baseUrl}/animal/add-animal`, {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: animalConfig.headers
    })
    console.log(response)

    if (response.status === 200) {
        window.location.pathname = '/animal/animals.html';
    }
}
document.getElementById("submit-button").addEventListener("click", handleSubmit)



/*
 // Save the disposition in the repository
    const dispositionResponse = await fetch(`${animalConfig.baseUrl}/disposition/add-disposition`, {
        method: "POST",
        body: JSON.stringify(bodyObjDisp),
        headers: animalConfig.headers
    });
    if (!dispositionResponse.ok) {
        throw new Error(`Failed to save disposition: ${dispositionResponse.status}`);
    }

    const savedDisposition = await dispositionResponse.json();
    console.log(savedDisposition);*/