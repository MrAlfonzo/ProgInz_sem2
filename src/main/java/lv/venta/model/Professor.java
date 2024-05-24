package lv.venta.model;

import java.util.ArrayList;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "ProfessorTable")
@Entity
public class Professor extends Person{
	
	//ID nak no personas klases
	
//	@NotNull - janem nost jo ar SINGLE inheratance strategiju studenti un profesori bus viena tabula, kur studentiem nav degree
	@Column(name="Degree")
	private Degree degree;
	
	@ManyToMany
	@JoinTable(name = "ProfessorCourseTable",
	joinColumns = @JoinColumn(name = "Idp"),
	inverseJoinColumns = @JoinColumn(name = "Idc"))
	@ToString.Exclude
	private Collection<Course> courses = new ArrayList<>();
	

	public Professor(String name, String surname, Degree degree) {
		super(name, surname);
		setDegree(degree);
	}
	
	public void addCourse(Course course) {
		if(!courses.contains(course)) courses.add(course);
	}
	
	//TODO uztaisit ari iznjemshanas funkciju
}
