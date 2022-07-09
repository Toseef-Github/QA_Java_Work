'use strict';

const output = document.getElementById('output');

document.getElementById('carForm').addEventListener("submit", function (event) {
    event.preventDefault();

    const form = event.target;

    const car = {
        name: form.carMake.value,
        age: form.carReg.value,
        species: form.carModel.value,
    }

    axios.post("/createCar", car)
        .then(res => {
            console.log("RESPONSE: ", res);
            form.carMake.focus();
            form.reset();
            renderCars();
        })
        .catch(err => console.error(err));

    console.log("car: ", car);
});

function renderCars() {
    axios.get("/getCars")
        .then(res => {
            console.log("cars: ", res.data);
            output.innerHTML = "";
            for (let car of res.data) {
                const carCol = document.createElement("div");
                carCol.className = "col";

                const carCard = document.createElement("div");
                carCard.className = "card";
                carCol.appendChild(carCard);

                const carDiv = document.createElement("div");
                carDiv.className = "card-body";
                carCard.appendChild(carDiv);

                const carMake = document.createElement("h2");
                carMake.innerText = car.make;
                carDiv.appendChild(carMake);

                const carReg = document.createElement("p");
                carReg.innerText = car.reg + " years old.";
                carDiv.appendChild(carReg);

                const carModel = document.createElement("p");
                carModel.innerText = car.model;
                carModel.classList.add("btn", "btn-alert");
                carDiv.appendChild(carModel);

                const carDelete = document.createElement("button");
                carDelete.innerText = "DESTROY";
                carDelete.addEventListener("click", function () {
                    deleteCar(car.id);
                });

                carDiv.appendChild(carDelete);

                output.appendChild(carCol);
            }
        })
        .catch(err => console.error(err));
}

function deleteCar(id) {
    axios.delete("/removeCar/" + id)
        .then(res => {
            console.log(res);
            renderCars();
        })
        .catch(err => console.error(err));
}


renderCars();