<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ taglib prefix="s" uri="/struts-tags" %> 
<html> 
	<head> 
		<style type="text/css"> 
			.errors { 
				background-color:#FFCCCC; 
				border:1px solid #CC0000; 
				width:400px; 
				margin-bottom:8px;
				padding-right: 50px; 
			} 
			.errors li { 
				list-style: none; 
			} 
		</style> 
	</head> 
	<body>
		<div align="center" style="width: 600px; border:1px solid #000; margin:0 auto; margin-top: 100px;">
			<h1>Login</h1> 
			<s:if test="hasActionErrors()"> 
				<div class="errors"> 
					<s:actionerror/> 
				</div> 
			</s:if> 
			<s:form action="login"> 
				<s:textfield label="Username" name="username"/> <br/>
				<s:password label="Password" name="password"/> 
				<s:submit value="Login" name="Login" align="center"/> 
			</s:form>
		</div>  
<br/>
<center><b>If you are a new user, please <a href="/mywebapp/signup.jsp">Sign up</a></b></center>
</body> 
</html>

