<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ taglib prefix="s" uri="/struts-tags" %> 
<html> 
	<head> 
		<style type="text/css"> 
			.errors { 
				background-color:#FFCCCC; 
				border:1px solid #CC0000; 
				width:475px; 
				margin-bottom:8px; 
				padding-right: 50px;
			} 
			.errors li { 
				list-style: none; 
			} 
		</style>

		<script>
		function validateForm() {
			if(document.getElementById("name").value == "") {
				alert('Name is required');
				return false;
			} else if(document.getElementById("email").value == "") {
				alert('Email is required');
				return false;
			} else if(document.getElementById("username").value == "") {
				alert('Username is required');
				return false;
			} else if(document.getElementById("password").value == "") {
				alert('Password is required');
				return false;
			} else if(document.getElementById("confirmPassword").value == "") {
				alert('Please confirm your password by re-entering it in the Confirm Password field');
				return false;
			} else if(document.getElementById("password").value != document.getElementById("confirmPassword").value) {
				alert('Passwords do not match');
				return false;
			} else {
				// var successWindow = window.open("", "_self");
				// successWindow.document.write("<b>Thanks for subscribing for newsletters.</b>");
				return true;	
			}
		}
	</script>

	</head> 
	<body> 
		<div align="center" style="width: 600px; border:1px solid #000; margin:0 auto; margin-top: 100px;">
			<h1>Sign up</h1> 
			
			<s:form action="signup"> 
				<h4>Please enter the following details: </h4>
				<s:if test="hasActionErrors()"> 
					<div class="errors"> 
						<s:actionerror/> 
					</div> 
				</s:if>
				<s:textfield label="Name" name="user.name" id="name" />
				<s:textfield label="Email" name="user.email"  id="email"/>
				<s:textfield label="Username" name="user.username"  id="username"/> 
				<s:password label="Password" name="user.password"  id="password"/> 
				<s:password label="Confirm Password" name="user.confirmPassword"  id="confirmPassword"/>
				<s:submit label="Submit" name="submit" align="center"/> 
			</s:form> 
		</div>
	</body> 
</html>

