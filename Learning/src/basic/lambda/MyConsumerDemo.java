package basic.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class MyConsumerDemo {

    public static void foreach(List<String> list, Consumer consumer){
        list.forEach(consumer);
    }

    public static void main(String[] args) {
        String[] array = {"hello", "world", "I", "love", "you", "!"};
        List<String> list = Arrays.asList(array);
        foreach(list, System.out::println);
        list.forEach(System.out::print);
    }
}
