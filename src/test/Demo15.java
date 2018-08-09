package test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Demo15 {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address);
    }
}
