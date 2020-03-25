package other;

/**
 * @Author: lichaoyang
 * @Date: 2020-02-04 16:00
 */

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * 该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 */
public class StringtoInteger {


    public static int StrToInt(String str) {
        int len = str.length();
        if (len == 0){
            return 0;
        }
        int begin=0;
        while (begin < len && (str.charAt(begin) == '0' || str.charAt(begin) == ' ')){
            begin++;
        }
        boolean flag = true;//判断是否为正数
        if (begin < len && str.charAt(begin) == '+'){
            begin++;
        }else if (begin < len && str.charAt(begin) == '-'){
            begin++;
            flag=false;
        }
        long result=0;//最终整数结果
        int idx=0;//整数的个数  超过10就违规
        while (begin<len){
            if (str.charAt(begin)>='0' && str.charAt(begin)<='9'){
                if (idx>10){
                    return flag?Integer.MAX_VALUE:Integer.MIN_VALUE;
                }
                result=result*10+str.charAt(begin)-'0';
                //判断溢出
                if (result > Integer.MAX_VALUE){
                    return flag?Integer.MAX_VALUE:Integer.MIN_VALUE;
                }
            }else {
                return (int) (flag?result:-1*result);
            }
            begin++;
            idx++;
        }
        return (int) (flag?result:-1*result);
    }

    public static void main(String[] args) {
        System.out.println(StrToInt("+2147483647"));
        System.out.println(StrToInt("   -42"));
        System.out.println(StrToInt("4193 with words"));
        System.out.println(StrToInt("words and 987"));
        System.out.println(StrToInt(" "));
        System.out.println(StrToInt("2147483648"));
        System.out.println(StrToInt("-21474836489"));
        System.out.println(StrToInt("10000000000000000000000000000000000000000000000000000000000000000522545459"));
        System.out.println(StrToInt("00000000000000000000000000000000000000000000000000000000000000000522545459"));
    }
}
