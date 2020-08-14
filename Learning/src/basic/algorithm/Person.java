package basic.algorithm;

public class Person {

    public double age;
    
    public String name;

    private int intAge;

    public int getIntAge() {
        return (int) (age * 100);
    }

    public void setIntAge(int intAge) {
        this.intAge = intAge;
    }

    public Person(double age, String name) {
        super();
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person [age=" + age + ", name=" + name + "]";
    }
    
}
