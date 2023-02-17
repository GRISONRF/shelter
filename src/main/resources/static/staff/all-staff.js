const staffConfig = {
    baseUrl: 'http://localhost:8080/api/staff',
    headers: {'Content-Type':'application/json'}
}

let staffContainer = document.getElementById("staff-container")

//get all the staff

async function getStaff() {

    await fetch(`${staffConfig.baseUrl}/staff`, {
        method: "GET",
        headers: staffConfig.headers
    })
        .then(response => response.json())

        .then(data => createStaffCards(data))
//        .catch(err => console.error(err))
}

const createStaffCards = (array) => {
    console.log(array)
    staffContainer.innerHTML = ''

    array.forEach(obj => {
        console.log(obj)

        const name = obj.name
        const role = obj.role
        const email = obj.email
        const phone = obj.phone

        let staffCard = document.createElement("div")
        staffCard.classList.add("m-2")
        staffCard.innerHTML = `
            <div class="staff-card">
                <ul class="staff-styling">
                    <li style="font-size: 17px; width: 100px">${name}</li>
                    <li style="font-size: 17px; width: 115px">${role}</li>
                    <li style="font-size: 17px; width: 130px">${email}</li>
                    <li style="font-size: 17px; width: 124px;">${phone}</li>
                    <li style="font-size: 17px;">&#128465;</li>
                    <li style="font-size: 17px;">&#9998;</li>


                </ul>
            </div>
        `
    staffContainer.append(staffCard);
    })
}
getStaff();

///////////////////// Add a new staff member ////////////////////

/*const staffConfig = {
    baseUrl: 'http://localhost:8080/api/staff',
    headers: {'Content-Type':'application/json'}
}*/


const addStaffButton = document.getElementById('add-staff-button');

addStaffButton.addEventListener("click", async () => {

    let bodyObjStaff = {
        email: document.getElementById('staffEmail').value,
        password: document.getElementById('staffPassword').value,
        name: document.getElementById('name').value,
        phone: document.getElementById('staffPhone').value,
        address: document.getElementById('staffAddress').value,
        role: document.getElementById('staffRole').value
    }
    console.log(bodyObjStaff)

    const response = await fetch(`${staffConfig.baseUrl}/add`, {
        method: "POST",
        body: JSON.stringify(bodyObjStaff),
        headers: staffConfig.headers,
        })

    if (response.ok) {
        console.log("Staff added!!!")
        window.location.reload();
    } else {
        console.log("got an error :(")
    }
});