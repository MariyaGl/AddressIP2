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
        Integer i13 = Integer.parseInt(s1.substring(16,24), 2);

        return i11 + "." + i12 + "." + i13 + "." + i14;
    }

    public static int ipToInt(String ip) throws UnknownHostException {
        return new BigInteger(1, InetAddress.getByName(ip).getAddress()).intValue();
    }

        boolean isCorrectIP = false;
        try {
            while (!isCorrectIP) {
                Scanner sc1 = new Scanner(System.in);
                try {
                    isCorrectIP = true;
                } catch (UnknownHostException e) {
                    // throw new RuntimeException(e);
                }
            }
        } catch (Exception e) {
            System.out.println("Что-то пошло не так " + e);
        }
    }
}