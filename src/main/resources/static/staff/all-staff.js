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
                    <li style="font-size: 17px; width: 125px">${role}</li>
                    <li style="font-size: 17px; width: 100px">${email}</li>
                    <li style="font-size: 17px; width: 100px;">${phone}</li>
                </ul>
            </div>
        `
    staffContainer.append(staffCard);
    })
}
getStaff();