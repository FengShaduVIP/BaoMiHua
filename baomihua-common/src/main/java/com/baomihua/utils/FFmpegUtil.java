package com.baomihua.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by BaoMi花 on 2018/9/28.
 */
public class FFmpegUtil {
    private final static String PATH = "E:\\123.avi";

    public static void main(String[] args) {
        if (!checkfile(PATH)) {   //判断路径是不是一个文件
            System.out.println(PATH + " is not file");
            return;
        }
        if (process()) {        //执行转码任务
            System.out.println("ok");
        }
    }

    /**
     * 判断传入路径是否存在文件
     * @param path
     * @return
     */
    private static boolean checkfile(String path) {
        File file = new File(path);
        if (!file.isFile()) {
            return false;
        }
        return true;
    }

    /**
     * 执行转码
     * @return
     */
    private static boolean process() {
        // 判断视频的类型
        int type = checkContentType();
        boolean status = false;
        //如果是ffmpeg可以转换的类型直接转码，否则先用mencoder转码成AVI
        if (type == 0) {
            System.out.println("直接将文件转为flv文件");
            status = processFLV(PATH);// 直接将文件转为flv文件
        } else if (type == 1) {
            String avifilepath = processAVI("");
            if (avifilepath == null)
                return false;// avi文件没有得到
            status = processFLV(avifilepath);// 将avi转为flv
        }
        return status;
    }

    private static int checkContentType() {
        String type = PATH.substring(PATH.lastIndexOf(".") + 1, PATH.length())
                .toLowerCase();
        // ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
        if (type.equals("avi")) {
            return 0;
        } else if (type.equals("mpg")) {
            return 0;
        } else if (type.equals("wmv")) {
            return 0;
        } else if (type.equals("3gp")) {
            return 0;
        } else if (type.equals("mov")) {
            return 0;
        } else if (type.equals("mp4")) {
            return 0;
        } else if (type.equals("asf")) {
            return 0;
        } else if (type.equals("asx")) {
            return 0;
        } else if (type.equals("flv")) {
            return 0;
        }
        // 对ffmpeg无法解析的文件格式(wmv9，rm，rmvb等),
        // 可以先用别的工具（mencoder）转换为avi(ffmpeg能解析的)格式.
        else if (type.equals("wmv9")) {
            return 1;
        } else if (type.equals("rm")) {
            return 1;
        } else if (type.equals("rmvb")) {
            return 1;
        }
        return 9;
    }

    // 对ffmpeg无法解析的文件格式(wmv9，rm，rmvb等), 可以先用别的工具（mencoder）转换为avi(ffmpeg能解析的)格式.
    private static String processAVI(String filePath) {
        List<String> commend = new ArrayList<String>();
        commend.add("D:\\ffmpeg\\mencoder");
        commend.add(filePath);
        commend.add("-oac");
        commend.add("lavc");
        commend.add("-lavcopts");
        commend.add("acodec=mp3:abitrate=64");
        commend.add("-ovc");
        commend.add("xvid");
        commend.add("-xvidencopts");
        commend.add("bitrate=600");
        commend.add("-of");
        commend.add("avi");
        commend.add("-o");
        commend.add("【存放转码后视频的路径，记住一定是.avi后缀的文件名】");
        try {
            //调用线程命令启动转码
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(commend);
            builder.start();
            return "【存放转码后视频的路径，记住一定是.avi后缀的文件名】";
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // ffmpeg能解析的格式：（asx，asf，mpg，wmv，3gp，mp4，mov，avi，flv等）
    private static boolean processFLV(String oldfilepath) {
        if (!checkfile(PATH)) {
            System.out.println(oldfilepath + " is not file");
            return false;
        }
        // 文件命名
        Calendar c = Calendar.getInstance();
        String savename = String.valueOf(c.getTimeInMillis())+ Math.round(Math.random() * 100000);
        List<String> commend = new ArrayList<String>();
        commend.add("D:\\FFmpeg\\ffmpeg.exe");// 添加转换工具路径
        commend.add("-i");// 添加参数＂-i＂，该参数指定要转换的文件
        commend.add(oldfilepath);// 添加要转换格式的视频文件的路径
        commend.add("-qscale");     //指定转换的质量
        commend.add("6");
        commend.add("-ab");  //设置音频码率
        commend.add("56");
        commend.add("-ar"); //设置声音的采样频率
        commend.add("22050");
        commend.add("-r"); //设置帧频
        commend.add("15");
        commend.add("-s");  //设置分辨率大小
        commend.add("600x500");
        commend.add("-f");
        commend.add("mp4");
            //commend.add("-y"); // 添加参数＂-y＂，该参数指定将覆盖已存在的文件
        commend.add("D:\\FFmpeg\\output\\demo1.mp4");

        // 创建一个List集合来保存从视频中截取图片的命令
        List<String> cutpic = new ArrayList<String>();
        cutpic.add("");
        cutpic.add("-i");
        //cutpic.add(upFilePath); // 同上（指定的文件即可以是转换为flv格式之前的文件，也可以是转换的flv文件）
        cutpic.add("-y");
        cutpic.add("-f");
        cutpic.add("image2");
        cutpic.add("-ss"); // 添加参数＂-ss＂，该参数指定截取的起始时间
        cutpic.add("17"); // 添加起始时间为第17秒
        cutpic.add("-t"); // 添加参数＂-t＂，该参数指定持续时间
        cutpic.add("0.001"); // 添加持续时间为1毫秒
        cutpic.add("-s"); // 添加参数＂-s＂，该参数指定截取的图片大小
        cutpic.add("800*280"); // 添加截取的图片大小为350*240
        //cutpic.add(mediaPicPath); // 添加截取的图片的保存路径
        try {
            Runtime runtime = Runtime.getRuntime();
            Process proce = null;
            //视频截图命令，封面图。  8是代表第8秒的时候截图
            String cmd = "";
            String cut = "     D:\\FFmpeg\\ffmpeg.exe   -i   "
                    + oldfilepath
                    + "   -y   -f   image2   -ss   8   -t   0.001   -s   600x500   D:\\FFmpeg\\output\\a.jpg";
            String cutCmd = cmd + cut;
            proce = runtime.exec(cutCmd);
            //调用线程命令进行转码
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(commend);
            builder.start();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
