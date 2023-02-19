const staffConfig = {
    baseUrl: 'http://localhost:8080/api/staff',
    headers: {'Content-Type':'application/json'}
}

let staffContainer = document.getElementById("staff-container")

///////////////  get all the staff /////////////////////

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

        const staffId = obj.id
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
                    <li style="font-size: 17px; width: 173px">${email}</li>
                    <li style="font-size: 17px; width: 161px;">${phone}</li>
                    <li style="font-size: 17px; cursor: pointer" class="delete-staff">&#128465;</li>
                    <li style="font-size: 17px; cursor: pointer" class="edit-staff">&#9998;</li>
                </ul>
            </div>
        `

        staffContainer.append(staffCard);

        ///////// delete staff ///////
        const deleteIcon = staffCard.querySelector('.delete-staff');
        //        const staffId = liElement.getAttribute('class');

        deleteIcon.addEventListener('click', () => {
          const modal = document.createElement('div');
          modal.classList.add('modal', 'fade', );
          modal.setAttribute('id', 'exampleModal');
          modal.setAttribute('tabindex', '-1');
          modal.setAttribute('role', 'dialog');
          modal.setAttribute('aria-labelledby', 'exampleModalLabel');
          modal.setAttribute('aria-hidden', 'true');
          modal.innerHTML = `
              <div>
                <div class="modal-dialog" role="document">
                  <div class="modal-content">
                    <div class="modal-header">
                      <h5 class="modal-title" id="exampleModalLabel">Confirm deletion</h5>
                      <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close" data-backdrop="false"></button>
                    </div>
                    <div class="modal-body">
                      Are you sure you want to delete this staff? All their information will be erased.
                    </div>
                    <div class="modal-footer">
                      <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                      <button type="button" class="btn btn-danger" id="confirm-delete">Delete</button>
                    </div>
                  </div>
                </div>
              </div>
          `;

          const confirmButton = modal.querySelector('#confirm-delete');

          confirmButton.addEventListener('click', async () => {

            const response = await fetch(`${staffConfig.baseUrl}/${staffId}`, {
              method: 'DELETE',
              headers: staffConfig.headers,
            });

            if (response.ok) {
              staffCard.remove();
              console.log('Staff deleted!');
              modal.remove();
              document.querySelector('.modal-backdrop').remove();
            }

          });

          const cancelButton = modal.querySelector('.btn-secondary');
          cancelButton.addEventListener('click', () => {
            modal.remove();
            document.querySelector('.modal-backdrop').remove();
          });

          document.body.appendChild(modal);
          const bsModal = new bootstrap.Modal(modal);
          bsModal.show();

          modal.addEventListener('hidden.bs.modal', () => {
            modal.remove();
            document.querySelector('.modal-backdrop').remove();
          });
        });


        ///////////////////////////////// edit staff /////////////////////////////////////////
        // Get the edit icon element
        let editIcon = staffCard.querySelector(".edit-staff");

        // Attach an event listener to the edit icon
        editIcon.addEventListener("click", () => {
            //create the modal to 'edit' the staff
            const modal = document.createElement('div');
            modal.classList.add('modal', 'fade', );
            modal.setAttribute('id', 'updateModal');
            modal.setAttribute('tabindex', '-1');
            modal.setAttribute('role', 'dialog');
            modal.setAttribute('aria-labelledby', 'updateModal');
            modal.setAttribute('aria-hidden', 'true');
            modal.innerHTML = `
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Edit Staff</h5>
                            <button type="button" class="close" data-bs-dismiss="modal" aria-label="Close" data-backdrop="false"></button>
                        </div>
                        <div class="modal-body">
                            <form>
                                <div class="row">
                                    <div class="form-group col-md-6">
                                        <label for="staffName2">Name</label>
                                        <input type="text" class="form-control" id="name2" aria-describedby="staffName2" placeholder="First and Last name" style="font-size: 12px;">
                                        <small id="staffName2" class="form-text text-muted"></small>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="staffRole2">Role/Position</label>
                                        <input type="text" class="form-control" id="role2" aria-describedby="staffRole2" placeholder="" style="font-size: 12px;">
                                        <small id="staffRole2" class="form-text text-muted"></small>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="staffEmail2">Email address</label>
                                    <input type="text" class="form-control" id="staffEmail2" aria-describedby="email2" placeholder="Enter email" style="font-size: 12px;">
                                </div>
                                <div class="form-group">
                                    <label for="staffPhone2">Phone Number</label>
                                    <input type="text" class="form-control" id="phone2" placeholder="(XXX) XXX-XXXX" style="font-size: 12px;">
                                </div>
                                <div class="form-group">
                                    <label for="staffAddress2">Mail Address</label>
                                    <input type="text" class="form-control" id="address2" placeholder="ex. 123 Street, 30222. City - State " style="font-size: 12px;">
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer" style="display: flex; justify-content: flex-end;">
                            <button type="button" class="btn" id="update-staff-button" style="margin: 30px; background-color: #cbab3c; color: #ffffff; font-size: medium; border-color: #d39e00;">Update Staff Info"</button>

                            <button type="button" class="btn" id="nada" data-dismiss="modal" style="margin: 30px; background-color: #d5571d;color: #ffffff;font-size: medium; border-color: #f8f9fa;">Close</button>
                        </div>
                    </div>
                </div>
            `;


            const updateButton = modal.querySelector("#update-staff-button");

            updateButton.addEventListener("click", async () => {

                let bodyUpdate = {
                    email: document.getElementById('staffEmail2').value,
                    password: "123test",
                    name: document.getElementById('name2').value,
                    phone: document.getElementById('phone2').value,
                    address: document.getElementById('address2').value,
                    role: document.getElementById('role2').value
                    }

                console.log(bodyUpdate)
                // Send a PUT request to update the staff
                const response = await fetch(`${staffConfig.baseUrl}/${staffId}`, {
                    method: "PUT",
                    body: JSON.stringify(bodyUpdate),
                    headers: staffConfig.headers
                });

                if (response.ok) {
                    console.log("Staff updated!");
                    window.location.reload();
                } else {
                    console.error("Failed to update staff.");
                }
            });

            const closeButton = modal.querySelector('#nada');
            closeButton.addEventListener('click', () => {
                modal.remove();
                document.querySelector('.modal-backdrop').remove();
            });

            document.body.appendChild(modal);
            const bsModal = new bootstrap.Modal(modal);
            bsModal.show();

            modal.addEventListener('hidden.bs.modal', () => {
                modal.remove();
                document.querySelector('.modal-backdrop').remove();
            });
        });

    });
}

getStaff();




///////////////////// Add a new staff  ////////////////////

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