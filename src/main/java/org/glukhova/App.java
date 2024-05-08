package org.glukhova;

import java.net.*;
import java.math.BigInteger;
import java.util.Scanner;

public class App {

    public static String intToIp(int i) {
        int b0 = (i >> 24) & 0xFF;
        int b1 = (i >> 16) & 0xFF;
        int b2 = (i >> 8) & 0xFF;
        int b3 = i & 0xFF;
        return b0 + "." + b1 + "." + b2 + "." + b3;
    }

    public static String intToIpParse(String s1) {
        // 11000000 10101000 00000010 00000000
        Integer i11 = Integer.parseInt(s1.substring(0, 8), 2);
        Integer i12 = Integer.parseInt(s1.substring(8, 16), 2);
        Integer i13 = Integer.parseInt(s1.substring(16, 24), 2);
        Integer i14 = Integer.parseInt(s1.substring(24, 32), 2);

        return i11 + "." + i12 + "." + i13 + "." + i14;
    }


    public static int ipToInt(String ip) throws UnknownHostException {
        return new BigInteger(1, InetAddress.getByName(ip).getAddress()).intValue();
    }

    public static void main(String[] args) throws UnknownHostException {
        String ip1 = "192.168.1.253";
        String ip2 = "192.168.2.1";

        boolean isCorrectIP = false;
 ////// выделить в метод
        try {
            while (!isCorrectIP) {
                System.out.println("Введите IP ");
                Scanner sc1 = new Scanner(System.in);
               // String ip1 = "";
                ip1 = sc1.nextLine();
                isCorrectIP = true;
                try {
                    InetAddress internetAddressName =  InetAddress.getByName(ip1) ;
                    isCorrectIP = true;
                } catch (UnknownHostException e) {
                   // throw new RuntimeException(e);
                    isCorrectIP = false;
                }

                /*try {
                    byte[] arr01 = InetAddress.getByName(ip1).getAddress();
                    isCorrectIP = true;
                } catch (UnknownHostException e) {
                    System.out.println("Неверный формат IP" + e);
                    isCorrectIP = false;
                }*/
            }
        } catch (Exception e) {
            System.out.println("Что-то пошло не так" + e);
        }

///////////////////

        byte[] arr1 = InetAddress.getByName(ip1).getAddress();
        byte[] arr2 = InetAddress.getByName(ip2).getAddress();

        int arr1int = ipToInt(ip1);
        int arr2int = ipToInt(ip2);

        System.out.println("arr1int =" + arr1int + " toBinaryString" + Integer.toBinaryString(arr1int));
        System.out.println("arr2int =" + arr2int + " toBinaryString" + Integer.toBinaryString(arr2int));

        for (int i = arr1int; i <= arr2int; i++) {
            System.out.println("Вариант 1 IP = " + intToIp(i));

            try {
                String s1 = Integer.toBinaryString(i);
                System.out.println("Вариант 2 IP = " + intToIpParse(s1));
            } catch (Exception e) {
                System.out.println("Exception =" + e);
            }
        }
    }
}