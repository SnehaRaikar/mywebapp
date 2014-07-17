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
			} 
			.errors li { 
				list-style: none; 
			} 
		</style> 
	</head> 
	<body> 
		<div align="center" style="width: 600px; border:1px solid #000; margin:0 auto; margin-top: 100px;">
		<s:if test="hasActionErrors()"> 
			<div class="errors"> 
				<s:actionerror/> 
			</div> 
		</s:if>
		<br/>
		<s:form action="getCourseData"> 
			<h4>Please select the course you are interested in : </h4> 
		 
			<s:select label="Course" 
				headerKey="-1" headerValue="Select One"
				list="courseList"  listKey="courseId" listValue="courseName"
				name="selectedCourse" />
			<br/>
			<s:submit label="Submit" align="center" name="submit" onclick="validateForm()"/> 
		</s:form> 
		</div>
	</body> 
</html>

