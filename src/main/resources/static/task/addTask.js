const taskConfig = {
    baseUrl: 'http://localhost:8080/',
    headers: {
        'Content-Type':'application/json'
        }
    }

const addTaskForm = document.getElementById('add-task-form')
console.log("Hello")
const handleSubmit = async (e) => {
    console.log("second hello")
    e.preventDefault()
    console.log(typeof document.getElementById('staff-select').value)

    let bodyObj = {
        staffId: document.getElementById('staff-select').value,
        task: document.getElementById('task').value,
        happenedAt: document.getElementById('happenedAt').value,
    }
    console.log(bodyObj)

    const response = await fetch(`${taskConfig.baseUrl}api/task/addTask`, {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: taskConfig.headers
    })
    console.log(response)
//        .catch(err => console.error(err.message))
    if (response.status === 200) {
        window.location.pathname = '/task/tasks.html';
    }
}
//addTaskForm.addEventListener("submit", handleSubmit)
document.getElementById("submit-button").addEventListener("click", handleSubmit)