package java.proxy;

/**
 * @Author: lichaoyang
 * @Date: 2020-09-15 16:07
 */
public class RealSubject implements Subject{

    @Override
    public void hello(String str) {
        System.out.println("Hello  " + str);
    }

    @Override
    public String bye() {
        System.out.println("Goodbye");
        return "Over";
    }

}
