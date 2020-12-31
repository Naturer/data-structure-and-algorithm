package basic.jdk8.stream;

import basic.jdk8.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class Demo2 {

    public static void main(String[] args) throws ParseException {

        //java8  查询年龄小于20岁的学生,并且根据年龄进行排序，得到学生姓名，生成新集合
        List<Student> studentList = new ArrayList<>();
//        studentList.add(new Student(1,"张三","M",19, new Date()));
        studentList.add(new Student(1,"张三","M",19, null));
        studentList.add(new Student(1,"李四","M",20, new SimpleDateFormat("yyyy-MM-dd").parse("2020-11-27")));
        studentList.add(new Student(1,"王五","F",29, new SimpleDateFormat("yyyy-MM-dd").parse("2020-11-25")));
        studentList.add(new Student(1,"赵六","F",20, new SimpleDateFormat("yyyy-MM-dd").parse("2020-11-19")));
        studentList.add(new Student(1,"赵六","F",19, new SimpleDateFormat("yyyy-MM-dd").parse("2020-11-19")));
        studentList.add(new Student(1,"赵六","F",20, new SimpleDateFormat("yyyy-MM-dd").parse("2020-11-10")));
        studentList.add(new Student(1,"赵六","F",20, new SimpleDateFormat("yyyy-MM-dd").parse("2020-11-12")));

        //按照时间正序排序，一下几种方式等价：
//        List<Student> collect = studentList.stream().sorted(Comparator.comparing(Student::getAge)).collect(Collectors.toList());
//        List<Student> collect = studentList.stream().sorted((s1,s2) -> Integer.valueOf(s1.getAge()).compareTo(s2.getAge())).collect(Collectors.toList());
//        List<Student> collect = studentList.stream().sorted((s1,s2) -> Integer.compare(s1.getAge(), s2.getAge())).collect(Collectors.toList());
//        List<Student> collect = studentList.stream().sorted(Comparator.comparingInt(Student::getAge)).collect(Collectors.toList());

//        List<Student> collect = studentList.stream().sorted(new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return Integer.compare(o1.getAge(),o2.getAge());
//            }
//        }).collect(Collectors.toList());

        //单独对于int类型的排序：
//        List<Integer> ageList = studentList.stream().map(Student::getAge).collect(Collectors.toList());
//        List<Integer> collect2= ageList.stream().sorted().collect(Collectors.toList());
//        ageList.sort(Integer::compare);
//        Collections.sort(ageList,Integer::compare);
//        ageList.sort((a1, a2) -> Integer.compare(a2, a1));
//        Collections.sort(ageList, Integer::compareTo);


//        System.out.println(ageList);
//        System.out.println(collect2);

        //按照倒序排，怎么排：
//        List<Student> collect = studentList.stream().sorted((s1,s2) -> Integer.compare(s2.getAge(), s1.getAge())).collect(Collectors.toList());
        //Date类型可以使用Comparable的CompareTo方法：见公司代码

        //对于null值怎么处理：
//        studentList.sort((b1,b2)->b1.getBirthday().compareTo(b2.getBirthday()));
//        studentList.sort(Comparator.comparing(Student::getBirthday));


        //先按照年龄，再按照生日排怎么排：
//        studentList.sort((s1,s2)->{
//            int a1 = s1.getAge();
//            int a2 = s2.getAge();
//            Date b1 = s1.getBirthday();
//            Date b2 = s2.getBirthday();
//            return a1 < a2 ? -1 : ((a1 == a2) ? b1.compareTo(b2) : 1);
//        });

//        List<Student> collect = studentList.stream().sorted(Comparator.comparing(Student::getAge).thenComparing(Student::getBirthday, Comparator.nullsLast(Comparator.naturalOrder()))).collect(Collectors.toList());
//        studentList.stream().sorted(Comparator.comparing(Student::getAge));


        //Comparator.comparing使用时null值

        //Comparator.comparing怎么降序排序
//        List<Student> collect = studentList.stream().sorted(Comparator.comparing(Student::getAge).reversed()).collect(Collectors.toList());

        //其他
        String collect = studentList.stream().map(Student::getName).collect(Collectors.joining(","));

        System.out.println(collect);
//        System.out.println(studentList);

    }
}
