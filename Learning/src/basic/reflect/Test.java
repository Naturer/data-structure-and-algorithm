package basic.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    final static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
//        Agent agent = new Agent(new Singer() {
//
//            @Override
//            public void sing() {
//                System.out.println(11);
//            }
//        });
//        Singer proxy = (Singer) Proxy.newProxyInstance(Zhou.class.getClassLoader(), new Class<?>[] {Singer.class}, agent);
//        proxy.sing();


        System.out.println(list);
        list.add(121);
        System.out.println(list);
        list.add(55555);
        System.out.println(list);

        List listProxy = (List) Proxy.newProxyInstance(ArrayList.class.getClassLoader(), ArrayList.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (args != null){
                    args[0] = args[0] + "_YYH";
                }
                return method.invoke(list, args);
            }
        });
//        List listProxy2 = (List) Proxy.newProxyInstance(ArrayList.class.getClassLoader(), ArrayList.class.getInterfaces(),
//                ( proxy,  method,  args2)->{
//            args2[0] += "_YYH";
//            return method.invoke(list, args2);
//        });
        listProxy.add("abc");
        listProxy.add(123);
        System.out.println(listProxy.size());
        System.out.println(listProxy);
    }
}