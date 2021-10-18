import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.Method;

public class TTT {

    private Log logger = LogFactory.getLog(TTT.class);

    public static void main(String... args)
        throws ClassNotFoundException{

        Class clazz = Class.forName("java.lang.String");
        System.out.println("clazz : " + clazz);
        System.out.println("class name : " + clazz.getName());
        System.out.println("class loader : " + clazz.getClassLoader());

        Method[] methods = clazz.getDeclaredMethods();

        for(Method method : methods){
            System.out.print("method : " + method.getName());
            System.out.print(" / modifier : " + method.getModifiers());
            System.out.println(" / return type: " + method.getReturnType());
        }


    } //main
} //end class
