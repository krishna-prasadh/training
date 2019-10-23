/**
 * validations file
 */
	/* $(document).ready(function() {
	 $('#email').on('blur', function() {
	 valiadteEmail();
	 });
	 }); */

	 function removeValiadtion(id) {
		console.log(id);
		document.getElementById(id + '_validation').style.display = "none";
	} 

	function valiadteEmail() {
		var valid_email = false;
		var email = document.getElementById('email').value;
		var filter = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
		if (!filter.test(email)) {
			valid_email = false;
			document.getElementById('email_validation').style.display = "block";
		} else {
			valid_email = true;
			document.getElementById('email_validation').style.display = "none";
		}
		return valid_email;
	}
	function validatePassword() {
		var valid_pwd = false;
		var password = document.getElementById('password').value;
		var password_regex = new RegExp(
				"^(((?=.*[a-z])(?=.*[A-Z]))|((?=.*[a-z])(?=.*[0-9]))|((?=.*[A-Z])(?=.*[0-9])))(?=.{8,})");

		//password valiadation
		if (!password_regex.test(password)) {
			valid_pwd = false;
			document.getElementById('password_validation').style.display = "block";

		} else {
			valid_pwd = true;
			document.getElementById('password_validation').style.display = "none";
		}
		return valid_pwd;
	}
	function form_submit() {
		console.log("form validation");
		var valid_email = valiadteEmail();
		var valid_pwd = validatePassword();
		/* var email = document.getElementById('email').value;
		var password = document.getElementById('password').value;
		console.log(email)
		console.log(password);
		// email validation
		var filter = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
		if (!filter.test(email)) {
			valid_email = false;
			document.getElementById('email_validation').style.display = "block";
		} else {
			valid_email = true;
			document.getElementById('email_validation').style.display = "none";
		}
		var password_regex = new RegExp(
				"^(((?=.*[a-z])(?=.*[A-Z]))|((?=.*[a-z])(?=.*[0-9]))|((?=.*[A-Z])(?=.*[0-9])))(?=.{6,})");

		//password valiadation
		if (!password_regex.test(password)) {
			valid_pwd = false;
			document.getElementById('password_validation').style.display = "block";

		} else {
			valid_pwd = true;
			document.getElementById('password_validation').style.display = "none";
		} */
		if (valid_pwd && valid_email) {
			console.log("submit form here");
			document.getElementById('add_form').submit();
		}

	}