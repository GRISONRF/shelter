const animalConfig = {
    baseUrl: 'http://localhost:8080/api',
    headers: {
        'Content-Type':'application/json'
        }
    }
//const animalProfileUrl = animalConfig.baseUrl + '/animal/animal-profile/'
const animalProfileUrl = 'http://localhost:8080/animalPage/'


let animalContainer = document.getElementById("animal-container")


//get one animal
async function handleAnimalClick(animalId){
    await fetch(`${animalConfig.baseUrl}/animal/animal-profile/${animalId}`, {
        method: "GET",
        headers: animalConfig.headers
    })
    .then(response => response.json())
    .then(data => {
        const animalName = data.name
        console.log(data)
        window.location.replace(animalProfileUrl + data.id)

        })


}

async function getAnimal() {
    console.log("inside getAnimal")

    await fetch(`${animalConfig.baseUrl}/animals`, {
        method: "GET",
        headers: animalConfig.headers
    })
        .then(response => response.json())

        .then(data => createAnimalCards(data))
//        .catch(err => console.error(err))
}


//// get all animals
//async function getAnimals() {
//
//    await fetch(`${animalConfig.baseUrl}/animal/animals`, {
//        method: "GET",
//        headers: animalConfig.headers
//    })
//        .then(response => response.json())
//
//        .then(data => createAnimalCards(data))
////        .catch(err => console.error(err))
//}
const select = document.getElementById("filter-select");


const filterAnimals = (data, selection) => {
    console.log(data)
    switch (selection) {
        case "Cats":
            return data.filter(animal => animal.species === "Cat");
        case "Dogs":
            return data.filter(animal => animal.species === "Dog");
        case "Female":
            return data.filter(animal => animal.gender === "Female");
        case "Male":
            return data.filter(animal => animal.gender === "Male");
        case "Available":
            return data.filter(animal => animal.availability === "Available");
        default:
            return data;
    }
}

select.addEventListener('change', () => {
    const selectedOption = select.selectedOptions[0].innerHTML;
    getAnimalsByFilter(selectedOption);
  });

async function getAnimalsByFilter(selection) {
    await fetch(`${animalConfig.baseUrl}/animal/animals`, {
        method: "GET",
        headers: animalConfig.headers
    })
        .then(response => response.json())
        .then(data => {
            console.log(data)
            createAnimalCards(filterAnimals(data, selection));
        })
}

const getAnimals = async () => {
    await fetch(`${animalConfig.baseUrl}/animal/animals`, {
        method: "GET",
        headers: animalConfig.headers
    })
        .then(response => response.json())
        .then(data => {
            console.log(data)
            const selection = document.getElementById("filter-select").value;
                createAnimalCards(data);
        })
}



const createAnimalCards = (array) => {
    console.log(array);
    animalContainer.innerHTML = ''

    array.forEach(obj => {
        console.log(obj)

        const id = obj.id
        const picture = obj.picture
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
                    <li style="font-size: 17px; width: 100px">
                        <img src="${picture}" width="100" height="100" alt="Animal Image">
                    </li>
                    <li style="font-size: 17px; width: 100px">${species}</li>
                    <li onClick="handleAnimalClick(${id})"style="font-size: 17px; width: 125px">${name}</li>
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

///////////////////////// filter ////////////////////

//document.getElementById("filter-select").addEventListener("change", function() {
//    let filter = this.value;
//    if(filter !== "all"){
//        let filteredAnimals = array.filter(animal => animal[filter] === filter);
//        createAnimalsCards(filteredAnimals);
//    }else{
//        createAnimalsCards(array);
//    }
//});
///////////////////////// end of filter ////////////////////

