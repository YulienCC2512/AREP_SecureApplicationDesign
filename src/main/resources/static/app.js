const API_URL = "http://localhost:8080/api/properties";

// Toggle desplegable
document.querySelectorAll(".toggle").forEach(title => {
    title.addEventListener("click", () => {
        const content = title.nextElementSibling;
        content.style.display = content.style.display === "block" ? "none" : "block";
    });
});

// Create
document.getElementById("createForm").addEventListener("submit", async (e) => {
    e.preventDefault();
    const property = {
        address: document.getElementById("createAddress").value,
        price: parseFloat(document.getElementById("createPrice").value),
        size: parseFloat(document.getElementById("createSize").value),
        description: document.getElementById("createDescription").value
    };
    const res = await fetch(API_URL, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(property)
    });
    alert(res.ok ? "Property created!" : "Error creating property");
});

// Get All
async function getAll() {
    const res = await fetch(API_URL);
    const data = await res.json();
    const list = document.getElementById("allProperties");
    list.innerHTML = "";
    data.forEach(p => {
        const li = document.createElement("li");
        li.textContent = `ID: ${p.id} | ${p.address} | $${p.price} | ${p.size}m²`;
        list.appendChild(li);
    });
}

// Get by ID
async function getById() {
    const id = document.getElementById("getId").value;
    const res = await fetch(`${API_URL}/${id}`);
    if (res.ok) {
        const data = await res.json();
        document.getElementById("getResult").textContent = JSON.stringify(data, null, 2);
    } else {
        document.getElementById("getResult").textContent = "Property not found.";
    }
}

// Update
document.getElementById("updateForm").addEventListener("submit", async (e) => {
    e.preventDefault();
    const id = document.getElementById("updateId").value;
    const property = {
        address: document.getElementById("updateAddress").value,
        price: parseFloat(document.getElementById("updatePrice").value),
        size: parseFloat(document.getElementById("updateSize").value),
        description: document.getElementById("updateDescription").value
    };
    const res = await fetch(`${API_URL}/${id}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(property)
    });
    alert(res.ok ? "Property updated!" : "Error updating property");
});

// Delete
async function deleteProperty() {
    const id = document.getElementById("deleteId").value;
    const res = await fetch(`${API_URL}/${id}`, { method: "DELETE" });
    document.getElementById("deleteMsg").textContent = res.ok
        ? "Property deleted!"
        : "Error deleting property.";
}

