
package map;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Demo {

    @Test
    public void test3() {
        
        Person p1 = new Person("yyh", 18);
        Person p2 = new Person("yyh", 18);
        HashMap<Object, Object> map = new HashMap<>();
        map.put(p1, 111);
        map.put(p2, 222);
//        System.out.println(map.size());
//        System.out.println(map.containsKey(p1));
        System.out.println(System.identityHashCode(map));
        System.out.println(map);
    }
    
    @Test
    public void test1() {
        Map<Object, Object> map = new HashMap<Object, Object>();
        Person p1 = new Person("lalala",111);
        System.out.println(p1.hashCode());
        
        Person p2 = new Person("yyyy",2);

        map.put(p1, "55");
        map.put(p2, "56");
        
        
        map.put(p2, "33");
        System.out.println(p2.hashCode());
    }
//    111111111111111111111111111111111111111111111111111111111111111
    @Test
    public void test2() {
        System.out.println("================");
        int a = Integer.MAX_VALUE;
        System.out.println(a);
        System.out.println(a*31);
        
//        System.out.println(Long.MAX_VALUE);
//        4294967295
//        System.out.println("111111111111111111111111111111111111111111111111111111111111111".substring(31));
//        long bit = 9223372036854775807l;
//        System.out.println((int)(bit));
    }
    
    static class Person{
        String name;
        Integer age;
        
        public Person(String name, Integer age) {
            super();
            this.name = name;
            this.age = age;
        }
        
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public Integer getAge() {
            return age;
        }
        public void setAge(Integer age) {
            this.age = age;
        }
        
//        @Override
//        public int hashCode() {
//            final int prime = 31;
//            int result = 1;
//            result = prime * result + ((age == null) ? 0 : age.hashCode());
//            result = prime * result + ((name == null) ? 0 : name.hashCode());
//            return result;
//        }
//        
//        @Override
//        public boolean equals(Object obj) {
//            if (this == obj)
//                return true;
//            if (obj == null)
//                return false;
//            if (getClass() != obj.getClass())
//                return false;
//            Person other = (Person) obj;
//            if (age == null) {
//                if (other.age != null)
//                    return false;
//            } else if (!age.equals(other.age))
//                return false;
//            if (name == null) {
//                if (other.name != null)
//                    return false;
//            } else if (!name.equals(other.name))
//                return false;
//            return true;
//        }
        
    }
}
