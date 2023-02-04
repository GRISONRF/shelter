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

    let date = new Date(document.getElementById('happenedAt').value);

    let day = ('0' + date.getDate()).slice(-2);
    let month = ('0' + (date.getMonth() + 1)).slice(-2);

    const monthNames = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
    let formattedDate = `${monthNames[month - 1]} / ${day}`;


    let bodyObj = {
        staffId: parseInt(document.getElementById('staff-select').value),
        name: document.getElementById('task').value,
        happenedAt: formattedDate
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