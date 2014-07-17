package com.tutorial.service;

import java.util.List;

import com.tutorial.dao.CourseDao;
import com.tutorial.model.Course;

public class CourseServiceImpl implements CourseService{
	
	private CourseDao courseDao;
	
	public void setCourseDao(CourseDao courseDao) {
		this.courseDao= courseDao;
	}

	public List<Course> getCourseList() {
		return courseDao.getCourseList();
	}

}
