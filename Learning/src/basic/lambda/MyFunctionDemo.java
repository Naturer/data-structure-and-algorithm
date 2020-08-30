package basic.lambda;

import basic.algorithm.Person;

import java.util.function.Function;

public class MyFunctionDemo {

    public static void main(String[] args) {
        System.out.println(f("WWWW", o -> new Person(26,"yyh")));
        //等价于下面的实例方法引用：
        Function<Person, Integer> function = Person::getIntAge;
        System.out.println(function.apply(new Person(21,"yyh")));
    }

    public static Object f(Object obj, Function function){

        return function.apply(obj);
    }

}
