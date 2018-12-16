package other;

public class Sqrtx {

    public static int sqrt(int x) {
        long i = 1;
        while (i*i < x){
            i = 2*i;
        }
        while (i*i > x){
            i = (i + x/i)/2;
        }
        return (int) i;
    }

    public static int ssqrt(int x) {
        long r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }

    //牛顿无限逼近
    public static int sssqrt(int x) {
        long i = 1;
        while (i*i < x){
            i = 2*i;
        }
        while (i*i > x){
            i = i-1;
        }
        return (int) i;
    }


    public static void main(String[] args){
        ssqrt(100000000);
        System.out.println();
        sqrt(1000000000);
    }

}
