package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Grade;

public interface IGradeRepo extends CrudRepository<Grade, Integer>{

	//pēc noklusejuma public abstract
	//izpildīs so vaicājumu: select * from grade_table where grvalue< <argumentā padoto>;
	ArrayList<Grade> findByGrvalueLessThan(int i);
	
	//pēc noklusejuma public abstract
	//izpildīs so vaicājumu: select * from grade_table where ids= <argumenta padotais>;
	ArrayList<Grade> findByStudentIds(int id);

	//pēc noklusejuma public abstract
	@Query(nativeQuery = true, value = "select avg(grvalue) from grade_table where idc=?1;")// ?1 nozīmē, ka funkcijā pirmais arguments tiek ievietots šajā "?1" vietā
	float calculateAVGGradeInCourseById(int id);

}
