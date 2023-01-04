const animalConfig = {
    baseUrl: 'http://localhost:8080/api',
    headers: {
        'Content-Type':'application/json'
        }
    }

const addAnimalForm = document.getElementById('add-animal-form')
console.log("Hello")
const handleSubmit = async (e) => {
    console.log("second hello")
    e.preventDefault()

    let bodyObj = {
        species: document.getElementById('species').value,
//        name: document.getElementById('name').value,
//        dob: document.getElementById('dob').value,
//        gender: document.getElementById('gender').value,
//        intakeDate: document.getElementById('int-date').value,
//        intakeMethod: document.getElementById('int-method').value,
//        picture: document.getElementById('picture').value,
//        breed: document.getElementById('breed').value,
//        food: document.getElementById('food').value,
//        foodAmount: document.getElementById('food-amount').value,
//        availability: document.getElementById('availability').value,
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

    console.log("aaaaaa")
    const response = await fetch(`${animalConfig.baseUrl}/animal/add-animal`, {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: animalConfig.headers
    })
    console.log(response)
//        .catch(err => console.error(err.message))
    if (response.status === 200) {
        window.location.pathname = '/animal/animals.html';
    }
}
//addAnimalForm.addEventListener("submit", handleSubmit)
document.getElementById("submit-button").addEventListener("click", handleSubmit)



// get all animals

async function getAnimals() {
    await fetch(`${baseUrl}/animal/animals`, {
        method: "GET",
        headers: headers
    })
        .then(response => response.json())
        .then(data => createAnimalCards(data))
        .catch(err => console.error(err))
}


const createAnimalCards = (array) => {
    animalContainer.innerHTML = ''
    array.forEach(obj => {
        let animalCard = document.createElement("div")
        animalCard.classList.add("m-2")
        animalCard.innerHTML = `
            <div class="card d-flex" style="width: 18rem; height: 18rem;">
                <div class="card-body d-flex flex-column  justify-content-between" style="height: available">
                    <p class="card-text">${obj.body}</p>
                    <div class="d-flex justify-content-between">
                        <button class="btn btn-danger" onclick="handleDelete(${obj.id})">Delete</button>
                        //<button onclick="getNoteById(${obj.id})" type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#note-edit-modal">
                        data-bs-toggle="modal" data-bs-target="#animal-edit-modal">
                        Edit
                        </button>
                    </div>
                </div>
            </div>
        `
    animalContainer.append(animalCard);
    })
}

getAnimals();