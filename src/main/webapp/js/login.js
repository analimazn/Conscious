function validate(){
	let username = document.getElementById("username").value;
	let password = document.getElementById("password").value;

	if (username == "mesario" && password == "mesario123") {
		window.location = "admin_one/home.html";
		return false;
	} else if (username == "chefesecao" && password == "chefesecao123") {
		window.location = "admin_two/home.html";
		return false;
	} else if (username == "eleitor" && password == "eleitor123") {
		window.location = "elector/home.html";
		return false;
	} else {
		alert ("Insert a valid user!");
	}
}