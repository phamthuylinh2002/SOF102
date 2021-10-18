
package utils;

import enity.NhanVien;

public class Auth {
    public static NhanVien user=null;
    public static void clear(){
        Auth.user=null;
    }
    public static boolean isLogin(){
        return Auth.user!=null;
    }
    public static boolean isManager(){
        System.out.println(user.isVaiTro());
        return Auth.isLogin()&& user.isVaiTro();
        
    }
}