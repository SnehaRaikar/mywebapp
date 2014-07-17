package com.tutorial.model;

public class Course {
		private String courseName;
		private int courseId;

		public Course(int courseId, String courseName) {
			this.setCourseId(courseId);
			this.setCourseName(courseName);
		}
				
		public String getCourseName() {
			return courseName;
		}
		public void setCourseName(String courseName) {
			this.courseName= courseName;
		}
		public int getCourseId() {
			return courseId;
		}
		public void setCourseId(int courseId) {
			this.courseId= courseId;
		}		
	}
