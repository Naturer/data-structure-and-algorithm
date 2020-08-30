package practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectDemo {

    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1,"张三","M",18,90,true));
        studentList.add(new Student(5,"yyh","M",18,91,true));
        studentList.add(new Student(2,"李四","M",18,55,false));
        studentList.add(new Student(3,"王五","F",20,100,true));
        studentList.add(new Student(4,"赵六","F",20,40,false));

        //根据年龄分组
        Map<Integer, List<Student>> collect = studentList.stream().collect(Collectors.groupingBy((s)->s.getAge()));
        //根据年龄分组，并计算出每组的数量
//        Map<Integer, Long> collect = studentList.stream().collect(Collectors.groupingBy(Student::getAge, Collectors.counting()));
        //根据年龄和是否及格分组
//        Map<Integer, Map<Boolean, List<Student>>> collect = studentList.stream().collect(Collectors.groupingBy(Student::getAge, Collectors.groupingBy(Student::getIsPass)));
        //根据年龄和是否及格分组，并计算出每组的数量
//        Map<Integer, Map<Boolean, Long>> collect = studentList.stream().collect(Collectors.groupingBy(Student::getAge, Collectors.groupingBy(Student::getIsPass, Collectors.counting())));
        //根据年龄与是否及格进行分组，并获取每组中分数最高的学生
//        Map<Integer, Map<Boolean, Optional<Student>>> collect = studentList.stream().collect(Collectors.groupingBy(Student::getAge, Collectors.groupingBy(Student::getIsPass, Collectors.maxBy(Comparator.comparing(Student::getScore)))));
//        Map<Integer, Map<Boolean, Student>> collect = studentList.stream().collect(Collectors.groupingBy(Student::getAge, Collectors.groupingBy(Student::getIsPass, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Student::getScore)), Optional::get))));


        System.out.println(collect);

        //多级分组
        /*Map<Integer, Map<String, List<Student>>> collect = studentList.stream().collect(Collectors.groupingBy(Student::getAge, Collectors.groupingBy(student -> {
            if (student.getIsPass()) {
                return "pass";
            } else {
                return " not pass";
            }
        })));
        System.out.println(collect);*/

        //根据年龄进行分组，获取并汇总人数
        /*Map<Integer, Long> collect = studentList.stream().collect(Collectors.groupingBy(Student::getAge, Collectors.counting()));
        System.out.println(collect);*/

        //根据年龄与是否及格进行分许，并汇总人数
       /* Map<Integer, Map<Boolean, Long>> collect = studentList.stream().collect(Collectors.groupingBy(Student::getAge, Collectors.groupingBy(Student::getIsPass, Collectors.counting())));
        System.out.println(collect);*/

        //根据年龄与是否及格进行分组，并获取每组中分数最高的学生
        /*Map<Integer, Map<Boolean, Student>> collect = studentList.stream().collect(
                Collectors.groupingBy(Student::getAge,
                        Collectors.groupingBy(Student::getIsPass,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(
                                                Comparator.comparing(Student::getScore)
                                        ), Optional::get
                                )))
        );*/

//        System.out.println(collect);


    }
}
