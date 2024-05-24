package lv.venta.service;



import java.util.ArrayList;

import lv.venta.model.Course;

public interface ICourseFilterService {

	public abstract ArrayList<Course> selectCoursesByCreditpoints(int credipoints) throws Exception;
	
	public abstract ArrayList<Course> selectCoursesByProfessorId(int id) throws Exception;
	
	public abstract ArrayList<Course> selectCoursesByStudentId(int id) throws Exception;
	
	
	
	
}
