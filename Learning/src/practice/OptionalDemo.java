package practice;

import practice.domain.Company;
import practice.domain.Job;
import practice.domain.Student;

import java.util.Optional;
import java.util.function.Function;

public class OptionalDemo {

    public static void main(String[] args) {
        Company company = new Company("11");
        Job job = new Job(company);
        Student student = new Student();
        student.setJob(job);
        Optional<Student> studentOptional = Optional.ofNullable(student);
//        o1.ifPresent(System.out::println);
        if (studentOptional.isPresent()) {
            Optional<Job> job1 = studentOptional.flatMap((s)->Optional.ofNullable(s.getJob()));
            if (job1.isPresent()) {
                System.out.println(job1);
            }

            Optional<String> s2 = studentOptional.flatMap((s) -> Optional.ofNullable(s.getJob())).flatMap((j) ->
                    Optional.ofNullable(j.getCompany())
            ).flatMap((c) -> Optional.ofNullable(c.getName()));

            String s1 = studentOptional.flatMap((s) -> Optional.ofNullable(s.getJob())).flatMap((j) ->
                    Optional.ofNullable(j.getCompany())
            ).flatMap((c) -> Optional.ofNullable(c.getName())).orElseGet(() -> {
                System.out.println("延迟加载");
                return "123";
            });

            String s3 = studentOptional.flatMap((s) -> Optional.ofNullable(s.getJob())).flatMap((j) ->
                    Optional.ofNullable(j.getCompany())
            ).flatMap((c) -> Optional.ofNullable(c.getName())).orElse("12");

            System.out.println(s1);
        }
        System.out.println(student);

    }
}
