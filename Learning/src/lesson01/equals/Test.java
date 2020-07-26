package lesson01.equals;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
	public static void main(String[] args) {
		System.out.println(3>>3);
		Student st1 = new Student("小明", 18);
		Student st2 = new Student("小明", 18);
		System.out.println(st1.equals(st2));
		System.out.println(st1.hashCode() == st2.hashCode());
		HashSet<Student> set = new HashSet<Student>();
		set.add(st1);
		set.add(st2);
		System.out.println(set);
	}
}
class Student{
	String name;
	Integer age;
	public Student(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Student other = (Student) obj;
//		if (age == null) {
//			if (other.age != null)
//				return false;
//		} else if (!age.equals(other.age))
//			return false;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		return true;
//	}
	
}