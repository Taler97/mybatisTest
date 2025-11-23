package org.example.service;

import org.example.DTO.UserPermissionDTO;
import org.example.mapper.UserMapper;
import org.example.utils.MyBatisUtil;

import java.util.Scanner;

public class UserService {
    public static void login(){

        boolean loginFlag=false;
        while (!loginFlag) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入用户名");
            String unameInput = scanner.nextLine();
            System.out.println("请输入密码");
            String pwdInput = scanner.nextLine();
            loginFlag = checkUnameAndPwd(unameInput, pwdInput);
            UserPermissionDTO userPermissionDTO=getUserDTO(unameInput);
            userPermissionDTO.displayUserInfo();
        }
        System.out.println("day6完成");
    }
    private static boolean checkUnameAndPwd(String unameInput,String pwdInput){
        String pwd= MyBatisUtil.executeQuery(UserMapper.class,userMapper -> userMapper.getPwdByUname(unameInput));
        if (pwd.equals(pwdInput)){
            System.out.println("登陆成功");
                return true;
        }else{
            System.out.println("请重新输入用户名或密码");
            return false;
        }
    }
    private static UserPermissionDTO getUserDTO(String uname){
        return MyBatisUtil.executeQuery(UserMapper.class,userMapper -> userMapper.selectUserAuthInfo(uname));
    }
}
