package entity;

import java.util.List;
import java.util.Set;

public class Student implements Comparable<Student> {
	//姓名
	private String name;
	//学号
	private String id;
	//成绩
	private List<Grade> grades;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public int compareTo(Student o) {
		Double sumScore =this.getGrades().stream().mapToDouble(Grade::getScore).sum();
		int result=sumScore.compareTo(o.getGrades().stream().mapToDouble(Grade::getScore).sum());
		if(result==0) {
			return this.getId().compareTo(o.getId());
		}
		return -result;
	}

	public Student(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}

	public Student() {
		super();
	}

	@Override
	public String toString() {
		return "Student [姓名=" + name + ", 学号=" + id + ", 总分=" + grades.stream().mapToDouble(Grade::getScore).sum() + "]";
	}
	
	
}
