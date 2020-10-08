package java.other;

import java.util.ArrayList;

/**
 * 给定一个只包含数字的字符串，通过返回所有可能的有效IP地址组合来恢复它。
 */
public class Restore_ip_addresses {

    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<>();
        ArrayList<String> ip = new ArrayList<>();
        dfs(s,res,ip,0);
        return res;
    }

    public void dfs(String s,ArrayList<String> res,ArrayList<String> ip,int start){
        if (start == s.length() && ip.size() == 4){
            res.add(ip.get(0)+"."+ip.get(1)+"."+ip.get(2)+"."+ip.get(3));
            return;
        }
        if (s.length()-start > 3*(4-ip.size())){
            return;
        }
        if (s.length()-start < (4-ip.size())){
            return;
        }
        int num = 0;
        for (int i=start;i<start+3&&i<s.length();i++){
            num = num*10+(s.charAt(i)-'0');
            if (num <0 || num > 255){
                break;
            }
            ip.add(s.substring(start,i+1));
            dfs(s, res, ip, i+1);
            ip.remove(ip.size()-1);
            if (num == 0){
                break;
            }
        }
    }

}
