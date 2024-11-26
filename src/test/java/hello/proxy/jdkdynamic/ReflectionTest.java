package hello.proxy.jdkdynamic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public class ReflectionTest {

    @Test
    void reflectionTest(){
        Hello target = new Hello();

        log.info("start");
        String res = target.callA();
        log.info("result = {}", res);


        log.info("start");
        String res2 = target.callB();
        log.info("result = {}", res2);
    }
    @Test
    void reflectionTest1() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Class<?> aClass = Class.forName("hello.proxy.jdkdynamic.ReflectionTest$Hello");

        Hello target = new Hello();
        Method methodCallA = aClass.getMethod("callA");
        methodCallA.invoke(target);
    }

    @Test
    void reflectionTest2() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> aClass = Class.forName("hello.proxy.jdkdynamic.ReflectionTest$Hello");

        // 공통 처리 로직을 다른 메소드에 대해서도 실행할 수 잇음.
        // callA, callB에 대해서 공통 로깅 로직을 추가함.
        // dynamicCall이라는 공통 메소드로 callA, callB를 호출할 수 있음.
        dynamicCall(aClass.getMethod("callA"), new Hello());
        dynamicCall(aClass.getMethod("callB"), new Hello());
    }

    private Object dynamicCall(Method method, Object target) throws InvocationTargetException, IllegalAccessException {
        log.info("start");
        String res2 = (String) method.invoke(target);
        log.info("result = {}", res2);
        return res2;
    }



    private static class Hello{
        public String callA(){
            return "A";
        }
        public String callB(){
            return "B";
        }
    }
}
