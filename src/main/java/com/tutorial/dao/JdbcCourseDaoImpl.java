package com.tutorial.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.tutorial.model.Course;

public class JdbcCourseDaoImpl implements CourseDao {
	
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Course> getCourseList() {
		String sql = "SELECT COURSE_ID, COURSE_NAME FROM test.course";
		 
		Connection conn = null;
 		List<Course> courseList = new ArrayList<Course>();
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next())  {
				Course course = new Course(rs.getInt("COURSE_ID"), rs.getString("COURSE_NAME"));
				
				courseList.add(course);
			}
			rs.close();
			ps.close();
			return courseList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}
	}

}
