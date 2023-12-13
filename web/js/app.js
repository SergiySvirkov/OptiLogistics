// app.js

document.addEventListener('DOMContentLoaded', function () {
    // Sample shipment data (replace with actual data from the server)
    const shipmentsData = [
        { id: 1, origin: 'Warehouse A', destination: 'Customer X', status: 'In Transit' },
        { id: 2, origin: 'Warehouse B', destination: 'Customer Y', status: 'Delivered' },
        { id: 3, origin: 'Warehouse C', destination: 'Customer Z', status: 'Pending' }
    ];

    // Select DOM elements
    const shipmentsList = document.getElementById('shipments');
    const detailsContainer = document.getElementById('details-container');

    // Populate shipment list
    shipmentsData.forEach(shipment => {
        const listItem = document.createElement('li');
        listItem.textContent = `Shipment ${shipment.id}: ${shipment.origin} to ${shipment.destination} (${shipment.status})`;
        listItem.addEventListener('click', () => displayShipmentDetails(shipment));
        shipmentsList.appendChild(listItem);
    });

    // Function to display shipment details
    function displayShipmentDetails(shipment) {
        // Clear previous details
        detailsContainer.innerHTML = '';

        // Create and append details to the container
        const detailsHeading = document.createElement('h3');
        detailsHeading.textContent = `Shipment ${shipment.id} Details:`;
        detailsContainer.appendChild(detailsHeading);

        const detailsList = document.createElement('ul');
        const keys = Object.keys(shipment);
        keys.forEach(key => {
            const listItem = document.createElement('li');
            listItem.textContent = `${key.charAt(0).toUpperCase() + key.slice(1)}: ${shipment[key]}`;
            detailsList.appendChild(listItem);
        });

        detailsContainer.appendChild(detailsList);
    }
});
