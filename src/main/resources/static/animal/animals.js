const animalConfig = {
    baseUrl: 'http://localhost:8080/api',
    headers: {
        'Content-Type':'application/json'
        }
    }

let animalContainer = document.getElementById("animal-container")


//get one animal
async function handleAnimalClick(animalId){
    await fetch(`${animalConfig.baseUrl}/animal/${animalId}`, {
        method: "GET",
        headers: taskConfig.headers
    })
    .then(response => response.json())
    .then(data => {
        const animalName = data.name
        console.log(data)
        })
//        .catch(err => console.error(err))

}

async function getAnimal() {
    console.log("inside getAnimal")

    await fetch(`${animalConfig.baseUrl}/animals`, {
        method: "GET",
        headers: taskConfig.headers
    })
        .then(response => response.json())

        .then(data => createTaskCards(data))
//        .catch(err => console.error(err))
}


// get all animals
async function getAnimals() {

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
        console.log(obj)

        const id = obj.id
        const species = obj.species
        const name = obj.name
        const dob = obj.dob
        const gender = obj.gender
        const availability = obj.availability


        let animalCard = document.createElement("div")
        animalCard.classList.add("m-2")
        animalCard.innerHTML = `
            <div class="animal-card">
                <ul class="animal-styling">
                    <li style="font-size: 17px; width: 100px">${species}</li>
                    <li onClick="handleAnimalClick(${id})'"style="font-size: 17px; width: 125px">${name}</li>
                    <li style="font-size: 17px; width: 100px">${dob}</li>
                    <li style="font-size: 17px; width: 100px;">${gender}</li>
                   <li style="font-size: 17px; width: 75px">${availability}</li>
                </ul>
            </div>
        `
    animalContainer.append(animalCard);
    })
}
getAnimals();


// add a new animal btn

const addAnimalBtn = document.getElementById('add-animal-btn')

addAnimalBtn.addEventListener("click", function() {
    document.location.href = '/animal/addAnimal.html'
})