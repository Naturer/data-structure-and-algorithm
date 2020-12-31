package basic.jdk8.stream;

import basic.jdk8.Person;
import basic.jdk8.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapDemo {

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1,"张三","M",19,true));
        studentList.add(new Student(2,"李四","M",18,false));
        studentList.add(new Student(3,"王五","F",21,true));
        studentList.add(new Student(4,"赵六","F",20,false));

        //提出name信息，转换为一个新的集合
        List<String> result = studentList.stream().map(Student::getName).collect(Collectors.toList());
        List<Person<Object>> collect = studentList.stream().map((s) -> new Person<Object>(s.getName(), 1)).collect(Collectors.toList());

        System.out.println(collect);
    }
}
