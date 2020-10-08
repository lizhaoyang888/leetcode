package java.other;

public class Test {

//    public static void main(String[] args){
//        Double d1 = 11.3;
//        Double d2 = 11.3;
//        Integer s1 = 11;
//        Integer s2 = 11;
//        Integer s3 = new Integer(11);
//        Integer s4 = 333;
//        Integer s5 = 333;
//        System.out.println(d1 == d2);
//        System.out.println(s1 == s2);
//        System.out.println(s1 == s3);
//        System.out.println(s1.equals(s3));
//        System.out.println(s4 == s5);
//    }

    public static void main(String[] args) {
        int i = 0;
        i = i++;
        System.out.println(i);
        for (int j = 0; j < 50; j++) {
            i = i++;
        }
        System.out.println(i);
    }

}
