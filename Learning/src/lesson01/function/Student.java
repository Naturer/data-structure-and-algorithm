package lesson01.function;

public class Student implements Person {
	static int a = 1;

	public void eat() {
		int a = 10;
		System.out.println(Student.a);
	}
	public static int swim() {
		int a = 33645;
		System.out.println(a);
		return a;
	}
	public static void main(String[] args) {
		Student stu = new Student();
		stu.a = 2;
		System.out.println(stu.a);
		stu.eat();
		
		System.out.println(new Student().a);
		String aString = "aa";
	}

	public Student() {
		System.out.println("run constructor...");
	}
}
