//Let's define some variables to represent the form data
//At the beginning, the form is empty, and therefore, not valid

//Data to send
var formData = {
    username: "",
    email: "",
    password: "",
    buyer: false,
    seller: false
}

//This data will be read but not be sent as part of the form submission
var formValid= false;
var repPassword="";
var tosCheckBox=false;


//Function to read the form
function readForm(){
   formData.username = document.getElementById("name").value.trim();
   formData.email = document.getElementById("email").value.trim();
   formData.password = document.getElementById("password").value.trim();
   repPassword = document.getElementById("repPassword").value.trim();

    //Read the buyer and seller checkboxes 
    formData.buyer = document.getElementById("buyer").checked;
    formData.seller = document.getElementById("seller").checked;

    tosCheckBox = document.getElementById("tos").checked;

}

//Function to validate the form
function validateForm() {
    formValid = false;
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
// Validate that all required fields are filled
    if(formData.username === ""){
        alert("Username box is empty!");
    } else if(formData.email === ""){
        alert("Email box is emtpy!");
    } else if(formData.password === ""){
        alert("Password box is emtpy!");
    } else if(repPassword === ""){
        alert("Re-type password box is emtpy!");
    }
// Verify that the email address is in a valid format
    if (!formData.email.match(mailformat)){
        alert("Invalid e-mail address. Please enter your e-mail again.");
    }
// Perform password strength and matching checks
    if(!formData.password.match(repPassword)){
        alert("Your Re-type password is not matching with Password");
    }
// Validate that the required checkboxes are selected
    if(!formData.buyer && !formData.seller){
        alert("Choose if you want to buy or sell produce");
    } 
    if(!tosCheckBox){
        alert("You have to accept the Terms of Use and Privacy Policy")
    }
    formValid = true;
}

//Function to write the Registration success on the page
function createNewParagraph(content){
    var text = document.createTextNode(content);
    var paragraph = document.createElement("p");
    paragraph.appendChild(text);
    paragraph.style = "white-space: pre;"
    paragraph.id = "hiddenParagraph";

    var element = document.getElementById("hiddenSection");
    var existingParagraph = document.getElementById("hiddenParagraph")
    element.replaceChild(paragraph, existingParagraph);
}

//Function  to submit the form, this should be called by the Register button
//on click
function submitForm(){
    readForm();
// call the validation function
    validateForm();
    if (formValid){
        var formText = formData.username +" registered as:\n";
        formText += formData.buyer?"buyer\n":"";
        formText += formData.seller?"seller":"";

        console.log(formText);
        createNewParagraph(formText);
    }
}

function checkName(){
    let name = document.getElementById("name").value.trim();
    if(name === ""){
        alert("Please enter your name.");
    } else {
        document.getElementById("hedgehogForm").submit();
    }
}
