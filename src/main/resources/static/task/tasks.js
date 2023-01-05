const taskConfig = {
    baseUrl: 'http://localhost:8080/api/task',
    headers: {'Content-Type':'application/json'}
}

let taskContainer = document.getElementById("task-container")

//get all the task

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
    console.log(array)
    taskContainer.innerHTML = ''

    array.forEach(obj => {
        console.log(obj)

        const taskId = obj.id
        const name = obj.name
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
                    <li><text class="delete" onclick="handleDeleteTask(${taskId})">delete</text></li>
                </ul>
            </div>
        `
    taskContainer.append(taskCard);
    })



async function handleDeleteTask(taskId){
    await fetch(`${taskConfig.baseUrl}/` + taskId, {
        method: "DELETE",
        headers: taskConfig.headers
    })
        .catch(err => console.error(err))

    return findAllTasks();
}
}

getTask();