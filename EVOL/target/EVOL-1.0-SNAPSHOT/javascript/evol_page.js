/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function showVehicles(category) {
    
    const vehicles = getVehiclesForCategory(category);

 
    const vehicleListDiv = document.getElementById('vehicleList');
    vehicleListDiv.innerHTML = '';

    if (vehicles.length === 0) {
        vehicleListDiv.innerHTML = '<p>No vehicles available for this category.</p>';
    } else {
        vehicles.forEach(vehicle => {
            const vehicleItem = document.createElement('div');
            vehicleItem.classList.add('vehicle-item');
            vehicleItem.textContent = vehicle; // Replace with appropriate vehicle information

            vehicleListDiv.appendChild(vehicleItem);
        });
    }
}


function getVehiclesForCategory(category) {
    // Mock data, replace with actual data retrieval logic
    switch (category) {
        case 'cars':
            return ['Vehicle 1A', 'Vehicle 1B', 'Vehicle 1C'];
        case 'bikes':
            return ['Vehicle 2A', 'Vehicle 2B'];
        case 'scooters':
            return ['Vehicle 3A', 'Vehicle 3B', 'Vehicle 3C', 'Vehicle 3D'];
        case 'motorcycles':
            return ['Vehicle 4A'];
        default:
            return [];
    }
}
