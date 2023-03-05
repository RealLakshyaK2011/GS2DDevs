package test.event;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public final class EventBus {
    private static final List<Method> eventMethods = new ArrayList<>();
    public static void post(Event event){
        for (Method meth : eventMethods) {
            try {
                meth.invoke(null, event);
            } catch (Exception e) {
                System.out.println("Event Method Not In A Event Method Format!");
                System.exit(3);
            }
        }
    }
    public static <T> void registerEventMethod(Class<T> clazz, String name){
        try {
            eventMethods.add(clazz.getMethod(name));
        } catch (NoSuchMethodException e) {
            System.out.println("Wrong Method Name Provided!");
            System.exit(17);
        }
    }
}
