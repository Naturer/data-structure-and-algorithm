package basic.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Agent implements InvocationHandler{
    
    private Object singer;
    
    public Agent(Object singer) {
        super();
        this.singer = singer;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(singer, args);
        return null;
    }

}
