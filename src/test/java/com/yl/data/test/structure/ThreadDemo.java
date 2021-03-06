package com.yl.data.test.structure;

import com.yl.encrypt.ByteUtils;
import org.junit.Test;

import java.net.InetAddress;
import java.util.Base64;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Alex
 * @since 2019/5/31 16:20
 */
public class ThreadDemo {

    public static void main(String[] args) throws Exception{

        Lock lock = new ReentrantLock();
        lock.lock();

        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        readLock.lock();

        TheadClass theadClass = new TheadClass();

        new Thread(theadClass).start();

        while (true){
            //Thread.currentThread().sleep(5);
            if(theadClass.isFlag())
            System.err.println("------------");
        }
    }

    public static class TheadClass implements Runnable {

        private volatile boolean flag = false;

        @Override
        public void run() {

            try {
                Thread.currentThread().sleep(1000);
                flag = true;
                System.err.println("set true");
            }catch (Exception e){

            }

        }

        public boolean isFlag(){
            return flag;
        }
    }

    @Test
    public void demo_1() throws Exception{

        InetAddress localHost = InetAddress.getLocalHost();

        System.err.println(localHost.getHostName());
        System.err.println(localHost.getHostAddress());

        InetAddress[] baidus = InetAddress.getAllByName("www.baidu.com");
        for (InetAddress address : baidus) {
            System.err.println(address);
        }

        System.err.println("127.0.0.1".hashCode());

    }

    @Test
    public void demo_2() {

        int hash = "miss".hashCode() >> 16;

        System.err.println(hash);

        System.err.println(hash & 15);

        System.err.println(hash & 16);

        System.err.println(Long.MAX_VALUE);

    }

    @Test
    public void demo_3(){

        String s = ByteUtils.byte2hex(new byte[]{-1});

        System.err.println(s);

        byte b = -1;

        String hexString = Integer.toHexString(b);
        System.err.println(hexString);

        System.err.println(Integer.toHexString(255));

        System.err.println(new String(Base64.getDecoder().decode("5oGp5aOw")));
    }
}
