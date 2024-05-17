package lv.venta;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.model.Course;
import lv.venta.model.Degree;
import lv.venta.model.Grade;
import lv.venta.model.Professor;
import lv.venta.model.Student;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IProfessorRepo;
import lv.venta.repo.IStudentRepo;

@SpringBootApplication
public class ProgInzSeminar2Application {

	public static void main(String[] args) {
		SpringApplication.run(ProgInzSeminar2Application.class, args);
	}
	
	@Bean //izsaucas automātiski, kas palaiž sistēmu
	public CommandLineRunner testDB(IStudentRepo studRepo, IProfessorRepo profRepo,
			ICourseRepo courseRepo, IGradeRepo gradeRepo) {
		
		
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				Professor p1 = new Professor("Karina", "Skirmante", Degree.mg);
				Professor p2 = new Professor("Vija", "Vagale", Degree.phd);
				Professor p3 = new Professor("Raita", "Rollande", Degree.phd);
				profRepo.save(p1);
				profRepo.save(p2);
				profRepo.save(p3);
				
				Student s1 = new Student("Janis", "Berzins");
				Student s2 = new Student("Liga", "Jauka");
				Student s3 = new Student("Baiba", "Nejauka");
				studRepo.save(s1);
				studRepo.save(s2);
				studRepo.save(s3);
				
				Course c1 = new Course("Datu strukturas un algoritmi", 2, p1);
				Course c2 = new Course("Datubazes", 2, p2);
				Course c3 = new Course("Programmaturas inzenierija I", 4, p3);//TODO būs nepieciesmas pievienot arī p1 kā professoru
				courseRepo.save(c1);
				courseRepo.save(c2);
				courseRepo.save(c3);
				
				
				gradeRepo.save(new Grade(4, c1, s1));//Janis nopelnīja 4 DataStr
				gradeRepo.save(new Grade(7, c2, s1));//Janis nopelnīja 7 DB
				gradeRepo.save(new Grade(10, c3, s1));//Janis nopelnīja 10 ProgInz
				gradeRepo.save(new Grade(5, c1, s2));//Liga nopelnīja 5 DataStr
				gradeRepo.save(new Grade(9, c3, s2));//Liga nopelnīja 9 ProgInz
				gradeRepo.save(new Grade(6, c2, s3));//Baiba nopelnīja 6 DB
				gradeRepo.save(new Grade(10, c3, s3));//Baiba nopelnīja 10 ProgInz
				
				
			}
		};
		
		//TODO
		//izveidot servisu-interfeisu priekš kursu filtrācijas
		//○ selectCoursesByProfessor() - return all courses of specific professor;
		//○ selectCoursesByStudent() - return all courses where specific student is involved;
		//izveidot servisu-interfeisu priekš atzīmju filtrācijas
		
		//
		//selectGradesByStudent() - return all grades of specific student;
		//○ calculateAVGGradeInCourse() - return average grade in specific course;
		
		//abiem interfeisiem uztaisīt atbilstošas servisa klases
	}

}
