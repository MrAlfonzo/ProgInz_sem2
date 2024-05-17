package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.model.Course;
import lv.venta.service.ICourseFilterService;

@Controller
@RequestMapping("/course")
public class CourseFilterController {
	//TODO izveidot trīs kontrolieru funkcijas, kur katrā izsauc konkrēto servisa funkciju
	
	@Autowired
	private ICourseFilterService courseFilterService;
	
	
	@GetMapping("/filter/creditpoints/{param}")//localhost:8080/course/filter/creditpoints/2
	public String getCourseFilterByCreditpoints(@PathVariable("param") int param, Model model) {
		
		try
		{
			ArrayList<Course> selectedCourses = courseFilterService.selectCoursesByCreditpoints(param);
			model.addAttribute("mydata", selectedCourses);//padodam izfiltrētos kursus uz course-show-all-page.html lapu
			model.addAttribute("msg", "Courses filtered by creditpoints");
			return "course-show-all-page";//parādām pašu course-show-all-page.html lapu interneta pārlūkā
		}catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());//padod kļudas ziņu uz error-page.html lapu
			return "error-page";//parādām pašu error-page.html lapu interneta pārlūkā
		}
		
	}
	
	@GetMapping("/filter/professor/{id}")//localhost:8080/course/filter/professor/2
	public String getCourseFilterByProfessorId(@PathVariable("id") int id, Model model) {
		
		try
		{
			Course selectedCourse = courseFilterService.selectCourseByProfessorId(id);
			model.addAttribute("mydata", selectedCourse);//padodam izfiltrētos kursus uz course-show-one-page.html lapu
			model.addAttribute("msg", "Course filtered by professor");
			return "course-show-one-page";//parādām pašu course-show-one-page.html lapu interneta pārlūkā
		}catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());//padod kļudas ziņu uz error-page.html lapu
			return "error-page";//parādām pašu error-page.html lapu interneta pārlūkā
		}
		
	}
	
	
	
	

	@GetMapping("/filter/student/{id}")//localhost:8080/course/filter/student/2
	public String getCourseFilterByStudentId(@PathVariable("id") int id, Model model) {
		
		try
		{
			ArrayList<Course> selectedCourses = courseFilterService.selectCoursesByStudentId(id);
			model.addAttribute("mydata", selectedCourses);//padodam izfiltrētos kursus uz course-show-all-page.html lapu
			model.addAttribute("msg", "Courses filtered by student id");
			return "course-show-all-page";//parādām pašu course-show-all-page.html lapu interneta pārlūkā
		}catch (Exception e) {
			model.addAttribute("mydata", e.getMessage());//padod kļudas ziņu uz error-page.html lapu
			return "error-page";//parādām pašu error-page.html lapu interneta pārlūkā
		}
		
	}
	
	
	
}
