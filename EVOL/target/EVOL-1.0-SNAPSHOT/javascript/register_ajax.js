/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */



function registerPOST() {
    let form = document.getElementById("register-form");
    let formData = new FormData(form);

    const data = {};

    formData.forEach((value, key) => (data[key] = value));
    
    data["has_driving_license"] = document.getElementById("driving_license").checked;
    
    var jsonData = JSON.stringify(data);
    var xhr = new XMLHttpRequest();
    xhr.onload = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                const responseData = JSON.parse(xhr.responseText);
                console.log(xhr.responseText);
                $("#message").html("registration was successful!").css({
                    color: 'green',
                    textShadow: '2px 2px 8px #ffffff'
                });
               
            } else if (xhr.status !== 200) {
                $("#message").html("registration was not successful!").css({
                    color: 'red',
                    textShadow: '2px 2px 8px #ffffff'
                });
            }
        }

    };
    xhr.open("POST", "registerClient");
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.send(jsonData);

}


 function validateCreditCard() {
            
    var creditCardNumber = document.getElementById("credit_card_number").value;
    var expirationDate = document.getElementById("expiration_date").value;
    var cvv = document.getElementById("cvv").value;

    // Validate credit card number (for simplicity, assuming it has 16 digits)
    var isCreditCardValid = /^\d{16}$/.test(creditCardNumber);

   
    // Validate expiration date (check if it's not in the past)
    if (isExpirationDateValid) {
        var currentYear = new Date().getFullYear() % 100; // Get last two digits of the current year
        var inputYear = parseInt(expirationDate[1], 10);

        isExpirationDateValid = inputYear >= currentYear;
    }

    // Validate CVV (for simplicity, assuming it has 3 digits)
    var isCvvValid = /^\d{3}$/.test(cvv);

    var validationMessage = document.getElementById("message");
    var submitButton = document.getElementById("submit");

    if (isCreditCardValid && isExpirationDateValid && isCvvValid) {
        submitButton.disabled = false;
        submitButton.style.cursor = "pointer";
    } else {
        validationMessage.textContent = "Please check the validity of the fields.";
        validationMessage.style.color = "red";
        submitButton.disabled = true;
        submitButton.style.cursor = "not-allowed";
    }
}