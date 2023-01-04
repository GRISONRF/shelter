const animalConfig = {
    baseUrl: 'http://localhost:8080/api',
    headers: {
        'Content-Type':'application/json'
        }
    }

let animalContainer = document.getElementById("animal-container")

// get all animals

async function getAnimals() {
    console.log("getanimals");
    await fetch(`${animalConfig.baseUrl}/animal/animals`, {
        method: "GET",
        headers: animalConfig.headers
    })
        .then(response => response.json())

        .then(data => createAnimalCards(data))
//        .catch(err => console.error(err))
}



const createAnimalCards = (array) => {
    console.log(array);
    animalContainer.innerHTML = ''
    array.forEach(obj => {
        let animalCard = document.createElement("div")
        animalCard.classList.add("m-2")
        animalCard.innerHTML = `
            <div class="card d-flex" style="width: 18rem; height: 18rem;">
                <div class="card-body d-flex flex-column  justify-content-between" style="height: available">
                    <p class="card-text">${obj.species}</p>
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