package basic.jdk8;

import java.util.Date;
import java.util.Objects;

public class Student {

    private Integer id;

    private String name;

    private String sex;

    private int age;

    private int score;

    private Date birthday;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isPass() {
        return isPass;
    }

    public void setPass(boolean pass) {
        isPass = pass;
    }

    private boolean isPass;

    public boolean getIsPass() {
        return isPass;
    }

    public void setIsPass(boolean pass) {
        isPass = pass;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Student() {
    }

    public Student(int id, String name, String sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    public Student(Integer id, String name, String sex, Date birthday) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
    }

    public Student(Integer id, String name, String sex, int age, Date birthday) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.birthday = birthday;
    }

    public Student(Integer id, String name, String sex, int age) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public Student(Integer id, String name, String sex, int age, boolean isPass) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.isPass = isPass;
    }

    public Student(Integer id, String name, String sex, int age, int score, boolean isPass) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.score = score;
        this.isPass = isPass;
    }

    @Override
    public String toString() {
        return "Student{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", sex='" + sex + '\'' +
                ", age=" + age +
//                ", score=" + score +
                ", birthday=" + birthday +
//                ", isPass=" + isPass +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                isPass == student.isPass &&
                Objects.equals(id, student.id) &&
                Objects.equals(name, student.name) &&
                Objects.equals(sex, student.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sex, age, isPass);
    }
}
