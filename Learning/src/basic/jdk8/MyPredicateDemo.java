package basic.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class MyPredicateDemo {

    public static List<String> filter(List<String> list, Predicate<String> predicate){
        List<String> result = new ArrayList<>();

        list.forEach(o->{
            if (predicate.test(o))
                result.add(o);
        });
//        List<Integer> aaalist = new ArrayList<>();
//        aaalist.forEach(o->{
//            if (predicate.test(o))
//                result.add(o);
//        });
        return result;
    }

    public static void main(String[] args) {
        String[] array = {"hello", "world", "I", "love", "you", "!"};
        List<String> list = Arrays.asList(array);
        List<String> you1 = filter(list, new Predicate<String>() {

            @Override
            public boolean test(String o) {
                o.substring(1,5);
                return o.equals("you");
            }
        });
//        List<String> you = filter(list, (o)->o.equals("you"));
//        System.out.println(you);
//        List<String> you = filter(list, (o)->{
//            o.substring(1,5);
//            return true;
//        });
    }
}
