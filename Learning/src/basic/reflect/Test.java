package basic.reflect;

import java.lang.reflect.Proxy;
import java.util.Collections;

public class Test {

    public static void main(String[] args) {
        Agent agent = new Agent(new Singer() {
            
            @Override
            public void sing() {
                System.out.println(11);
            }
        });
        Singer proxy = (Singer) Proxy.newProxyInstance(Zhou.class.getClassLoader(), new Class<?>[] {Singer.class}, agent);
        proxy.sing();
    }
}
