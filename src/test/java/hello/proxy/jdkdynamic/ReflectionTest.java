package hello.proxy.jdkDynamic;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public class ReflectionTest {

    @Test
    void reflection0(){
        Hello target = new Hello();

        log.info("start");
        String result1 = target.callA();
        log.info("result1:{}", result1);

        log.info("start");
        String result2 = target.callB();
        log.info("result1:{}", result2);

    }

    @Test
    void reflection1() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class classHello = Class.forName("hello.proxy.jdkDynamic.ReflectionTest$Hello");

        Hello target = new Hello();
        Method methodCallA = classHello.getMethod("callA");
        Object result1 = methodCallA.invoke(target);
        log.info("result1 : {}", result1);
        Method methodCallB = classHello.getMethod("callB");
        Object result2 = methodCallB.invoke(target);
        log.info("result2 : {}", result2);
    }

    @Test
    void reflection2() throws Exception {
        Class classHello = Class.forName("hello.proxy.jdkDynamic.ReflectionTest$Hello");

        Hello target = new Hello();
        dynamicCall(classHello.getMethod("callA"), target);
        dynamicCall(classHello.getMethod("callB"), target);
    }

    private void dynamicCall(Method method, Object target) throws Exception {
        log.info("start");
        Object result = method.invoke(target);
        log.info("result:{}", result);
    }
    @Slf4j
    public static class Hello{

        public String callA(){
            return "a";
        }
        public String callB(){
            return "b";
        }
    }
}


