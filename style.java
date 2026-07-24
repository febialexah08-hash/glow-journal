let history = JSON.parse(localStorage.getItem("skinHistory")) || [];

displayHistory();

function saveData() {

    const date = document.getElementById("date").value;
    const condition = document.getElementById("condition").value;
    const water = document.getElementById("water").value;
    const notes = document.getElementById("notes").value;

    const cleanser = document.getElementById("cleanser").checked;
    const toner = document.getElementById("toner").checked;
    const moisturizer = document.getElementById("moisturizer").checked;
    const sunscreen = document.getElementById("sunscreen").checked;

    if (date === "") {
        alert("Please select a date.");
        return;
    }

    const entry = {
        date,
        condition,
        water,
        notes,
        cleanser,
        toner,
        moisturizer,
        sunscreen
    };

    history.unshift(entry);

    localStorage.setItem("skinHistory", JSON.stringify(history));

    displayHistory();

    document.getElementById("date").value = "";
    document.getElementById("water").value = "";
    document.getElementById("notes").value = "";
    document.getElementById("cleanser").checked = false;
    document.getElementById("toner").checked = false;
    document.getElementById("moisturizer").checked = false;
    document.getElementById("sunscreen").checked = false;
}

function displayHistory() {

    const historyList = document.getElementById("historyList");

    historyList.innerHTML = "";

    history.forEach((item, index) => {

        historyList.innerHTML += `
        <div class="entry">
            <h3>${item.date}</h3>
            <p><strong>Condition:</strong> ${item.condition}</p>
            <p><strong>Water:</strong> ${item.water} glasses</p>
            <p><strong>Routine:</strong>
            ${item.cleanser ? "✔️ Cleanser " : ""}
            ${item.toner ? "✔️ Toner " : ""}
            ${item.moisturizer ? "✔️ Moisturizer " : ""}
            ${item.sunscreen ? "✔️ Sunscreen" : ""}
            </p>
            <p><strong>Notes:</strong> ${item.notes}</p>

            <button onclick="deleteEntry(${index})">🗑️ Delete</button>
        </div>
        `;
    });

}
