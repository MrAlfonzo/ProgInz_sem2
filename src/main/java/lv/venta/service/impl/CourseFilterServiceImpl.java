package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Course;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IProfessorRepo;
import lv.venta.repo.IStudentRepo;
import lv.venta.service.ICourseFilterService;

@Service
public class CourseFilterServiceImpl implements ICourseFilterService{

	@Autowired
	private ICourseRepo courseRepo;
	
	@Autowired
	private IProfessorRepo profRepo;
	
	@Autowired
	private IStudentRepo studRepo;
	
	@Override
	public ArrayList<Course> selectCoursesByCreditpoints(int credipoints) throws Exception {
		if(credipoints < 1 || credipoints > 20) throw new Exception("Problems with input args");
		
		ArrayList<Course> result = courseRepo.findByCreditpoints(credipoints);
		
		if(result.isEmpty()) throw new Exception("There is no course with " + credipoints + " creditpoints");
		
		return result;
	}

	@Override
	public Course selectCourseByProfessorId(int id) throws Exception {
		if(id < 1) throw new Exception("Id should be positive");

		if(!profRepo.existsById(id)) throw new Exception("Professor with " + id + "doesn't exists");
		
		Course result = courseRepo.findByProfessorIdp(id);
		
		if(result == null) throw new Exception("There is no course linkage to this Professor");
					
		return result;
	}

	@Override
	public ArrayList<Course> selectCoursesByStudentId(int id) throws Exception {
		if(id < 1) throw new Exception("Id should be positive");
		
		if(!studRepo.existsById(id)) throw new Exception("Student with " + id + "doesn't exists");
		
		ArrayList<Course> result = courseRepo.findByGradesStudentIds(id);
		
		if(result.isEmpty()) throw new Exception("There is no course for this student");
		
		return result;
	}

}
