package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Course;

public interface ICourseRepo extends CrudRepository<Course, Integer>{

	//pēc noklusejuma public abstract
	//izpildīs so vaicājumu: select * from course_table where creditpoints=<argumentā padoto>;
	ArrayList<Course> findByCreditpoints(int credipoints);

	//pēc noklusejuma public abstract
	//izpildīs so vaicājumu:select * from course_table where idp = <argumentā padoto>;
	Course findByProfessorIdp(int id);
	//pēc noklusejuma public abstract
	//izpildīs so vaicājumu: select * from course_table as T1 JOIN grade_table as T2 ON T1.idc=T2.idc WHERE T2.ids=<argumentā padoto>;
	ArrayList<Course> findByGradesStudentIds(int id);

}
