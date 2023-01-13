document.addEventListener("DOMContentLoaded", function() {
    let staffData = JSON.parse(sessionStorage.getItem("staffData"));
    let staffSelect = document.getElementById("staff-select");
    staffData.forEach(staff => {
        let option = document.createElement("option");
        option.value = staff.id;
        option.text = staff.name;
        staffSelect.add(option);
    });
});
