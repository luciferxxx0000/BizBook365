// script.js

// Function to add a new row
function addRow(button) {
    const row = button.closest('tr'); // get the current row
    const tbody = row.closest('tbody'); // get the tbody
    const clone = row.cloneNode(true); // clone the row

    // Reset the select dropdown and quantity
    const select = clone.querySelector('select');
    select.selectedIndex = 0; // reset to "-- Select Item --"
    
    const quantityInput = clone.querySelector('input[type="number"]');
    quantityInput.value = 1; // reset quantity

    // Change the '+' button in the clone to a remove button
    const btn = clone.querySelector('button');
    btn.textContent = '-';
    btn.setAttribute('onclick', 'removeRow(this)');

    tbody.appendChild(clone);
}

// Function to remove a row
function removeRow(button) {
    const row = button.closest('tr');
    const tbody = row.closest('tbody');
    // Only remove if more than one row exists
    if(tbody.rows.length > 1){
        row.remove();
    } else {
        alert("At least one item row is required!");
    }
}
