package basic.jdk8;

import java.util.Date;

public class Person<T> implements Comparable<T>{

    public String name;
    
    public int age;
    
    public Date birthday = null;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", birthday=" + birthday + "]\n";
    }

    @Override
    public int compareTo(T o) {
        if (this.age < ((Person)o).getAge()) {
            return -1;
        }
        if (this.age > ((Person)o).getAge()) {
            return 1;
        }
        return 0;
    }
    
}
