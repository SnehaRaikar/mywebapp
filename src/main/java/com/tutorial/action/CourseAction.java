package com.tutorial.action;

import java.util.ArrayList;
import java.util.List;

import com.tutorial.model.Course;
import com.tutorial.service.CourseService;

public class CourseAction {
	
	private List<Course> courseList = new ArrayList<Course>();
	
	private CourseService courseService;

	private Course selectedCourse;
	
	public void setCourseService(CourseService courseService) 	{
		this.courseService= courseService;
	}

	public List<Course> getCourseList() {
		return this.courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
	
	public Course getSelectedCourse() {
		return this.selectedCourse;
	}

	public void setSelectedCourse(Course selectedCourse) {
		this.selectedCourse = selectedCourse;
	}

	public String execute() {
		this.setCourseList(this.courseService.getCourseList());
		return "SUCCESS";
	}
	
	
}
