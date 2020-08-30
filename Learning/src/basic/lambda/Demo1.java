package basic.lambda;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;

public class Demo1 {

    public static void main(String[] args) throws ParseException {
        ArrayList<Person> list = new ArrayList<Person>();
        Person p1 = new Person();
        p1.setName("num1");
        p1.setAge(111);
        p1.setBirthday(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1994-09-01 20:00:00"));
        
        Person p2 = new Person();
        p2.setName("num1");
        p2.setAge(222);
        p2.setBirthday(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1994-09-01 22:02:00"));
        
        Person p3 = new Person();
        p3.setName("num1");
        p3.setAge(333);
        p3.setBirthday(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1994-09-01 23:03:00"));
        
        Person p4 = new Person();
        p4.setName("num1");
        p4.setAge(444);
        p4.setBirthday(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1994-09-01 24:03:00"));
        
        list.add(p3);
        list.add(p1);
        list.add(p4);
        list.add(p2);
        System.out.println(list);
//        list.stream().sorted(Comparator.comparing(Person::getAge));
//        list.stream().sorted(new Comparator<Person>() {
//
//            @Override
//            public int compare(Person o1, Person o2) {
//                long thisTime = o1.getBirthday().getTime();
//                long anotherTime = o2.getBirthday().getTime();
//                return (thisTime<anotherTime ? -1 : (thisTime==anotherTime ? 0 : 1));
//            }
//        });
        
        
        list.sort(new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getBirthday() == null || o2.getBirthday() == null) {
                    return 0;
                }
                long thisTime = o1.getBirthday().getTime();
                long anotherTime = o2.getBirthday().getTime();
                return (thisTime<anotherTime ? -1 : (thisTime==anotherTime ? 0 : 1));
            }
        });
        
        System.out.println(list);
    }
    
}
