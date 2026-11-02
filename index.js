
document.getElementById("StudentForm").addEventListener("submit", function(event) {

    event.preventDefault();

       let student = {
        name: document.getElementById("name").value,
        age: Number(document.getElementById("age").value),
        gender: document.getElementById("gender").value,
        department: document.getElementById("department").value,
        email: document.getElementById("email").value,
        phone: Number(document.getElementById("phone").value),
        city: document.getElementById("city").value,
        mark: Number(document.getElementById("mark").value),
        fees: Number(document.getElementById("fees").value)
    };

    console.log(student);

    fetch("http://localhost:8334/api/save", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(student)
    })

    .then(response => {
        if (!response.ok) {
            throw new Error("Student Registration Failed");
        }
        return response.json();
    })

    .then(data => {
        alert("Student Registered Successfully!");
        console.log(data);
    })

    .catch(error => {
        alert("Error: " + error.message);
        console.log(error);
    });

});
