const taskConfig = {
    baseUrl: 'http://localhost:8080/api/task',
    headers: {'Content-Type':'application/json'}
}

let taskContainer = document.getElementById("task-container")

//delete task
async function handleDeleteTask(taskId){
    await fetch(`${taskConfig.baseUrl}/` + taskId, {
        method: "DELETE",
        headers: taskConfig.headers
    })
        .catch(err => console.error(err))

    return getTask();
}

// get all the tasks to create the cards
async function getTask() {
    console.log("inside getTask")

    await fetch(`${taskConfig.baseUrl}/tasks`, {
        method: "GET",
        headers: taskConfig.headers
    })
        .then(response => response.json())

        .then(data => createTaskCards(data))
//        .catch(err => console.error(err))
}

const createTaskCards = (array) => {
    console.log(array + "create task cards")
    taskContainer.innerHTML = ''

    array.forEach(obj => {

        const taskId = obj.id
        const name = obj.staffDto.name
        const task = obj.task
        const happenedAt = obj.happenedAt

        let taskCard = document.createElement("div")
        taskCard.classList.add("m-2")
        taskCard.innerHTML = `
            <div class="task-card">
                <ul class="task-styling">
                    <li style="font-size: 17px; width: 100px">${name}</li>
                    <li style="font-size: 17px; width: 125px">${task}</li>
                    <li style="font-size: 17px; width: 100px">${happenedAt}</li>
                    <li><button class="delete" onclick="handleDeleteTask(${taskId})">delete</button></li>
                </ul>
            </div>
        `
    taskContainer.append(taskCard);
    })


}
getTask();

const staffConfig = {
    baseUrl: 'http://localhost:8080/staff',
    headers: {'Content-Type':'application/json'}
}

async function getStaff() {
    console.log("inside of get staff")
    const response = await fetch(`${staffConfig.baseUrl}/all`, {
        method: "GET",
        headers: staffConfig.headers
    });
    const data = await response.json();
    console.log(data)
    return data;
}


const addTaskBtn = document.getElementById('add-task-btn');

addTaskBtn.addEventListener("click", function() {
    window.location.href = '/taskPage/newTask';
});





