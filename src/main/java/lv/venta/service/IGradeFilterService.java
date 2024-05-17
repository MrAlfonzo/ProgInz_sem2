package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Grade;

public interface IGradeFilterService {
	
	public abstract ArrayList<Grade> selectFailedGrades() throws Exception;
	
	public abstract ArrayList<Grade> selectGradesByStudentId(int id) throws Exception;
	
	public abstract float calculateAVGGradeInCourseId(int id) throws Exception;

}
