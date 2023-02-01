//const taskConfig = {
//    baseUrl: 'http://localhost:8080/api/task',
//    headers: {'Content-Type':'application/json'}
//}
//const staffConfig = {
//    baseUrl: 'http://localhost:8080/api/staff',
//    headers: {'Content-Type':'application/json'}
//}

//async function handleDeleteTask(taskId) {
////    console.log(staffId)
//    console.log(taskId)
//  await fetch(`${taskConfig.baseUrl}/${taskId}`, {
//    method: "DELETE",
//    headers: taskConfig.headers
//  })
//    .then(response => response.json())
//    .then(data => {
//      console.log(data);
//      // make another fetch call to retrieve updated data
//      return fetch(`${staffConfig.baseUrl}/dashboard?staffId=${staffId}`)
//        .then(response => response.json())
//        .then(data => {
//          // update the page with the updated data
//        })
////        .catch(err => console.error(err));
//    })
////    .catch(err => console.error(err));
//}


/*
dashboard:
display the dashboard info depending on which staff
when deleting the task:

call handle delete task:
    call the task id and delete it from the database
    call the dashboard again with the staffID



*/

//async function handleDeleteTask(taskId) {
//    console.log(taskId);
//    const taskRow = document.querySelector(`tr[data-task-id="${taskId}"]`);
//    taskRow.remove();
//}

//function handleDeleteTask(taskId) {
//    console.log("inside of here")
//    const taskElement = document.querySelector([data-task-id='${taskId}']);
//    taskElement.classList.add('hidden');
//}
