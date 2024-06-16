/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4.bai2;

import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("==============MENU==============");
        Scanner sc = new Scanner(System.in);
        System.out.println("1 - Nhap va hien thong tin lop hoc");
        System.out.println("2 - Nhap va hien thong tin hoc sinh");
        System.out.println("3 - Nhap va hien thong tin giao vien");
        System.out.println("4 - Nhap va hien thong tin nhan vien");
        System.out.println("Vui long chon chuc nang: ");
        boolean flag = false;
        try {
            int n =  Integer.parseInt(sc.nextLine());
            flag = true;
        } catch (Exception e) {
            System.out.println("LAB 4 ERROR!!! Msg: " +e);
        }
        
        HocSinh p = new HocSinh();
        p.nhapThongTin(sc);
        System.out.println(p.toString());
    }
}
