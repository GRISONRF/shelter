let loginForm = document.getElementById('login-form')
let loginEmail = document.getElementById('login-email')
let loginPassword = document.getElementById('login-password')

const headers = {
    'Content-Type': 'application/json'
}

const baseUrl = 'http://localhost:8080/api/staff'

const handleSubmit = async (e) =>{
    e.preventDefault()

    let bodyObj = {
        email: loginEmail.value,
        password: loginPassword.value
    }
    console.log(bodyObj);

    const response = await fetch(`${baseUrl}/login`, {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
//        .catch(err => console.error(err.message))
    console.log(response)

    const responseArr = await response.json()
//    console.log(responseArr)

    if (response.status === 200){
        document.cookie = `userId=${responseArr[1]}`
        console.log(document.cookie)
        window.location.replace(responseArr[0])
        console.log(document.cookie)

    }
}

loginForm.addEventListener("submit", handleSubmit)