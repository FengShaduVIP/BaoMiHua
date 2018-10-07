package com.baomihua.utils.jif;

/**
 * Created by BaoMi花 on 2018/9/30.
 */
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.imageio.ImageIO;

/**
 * 网上找了很多资料都没有生成gif图片的例子。但是生成水印的文件到不少，
 * 如果我们把gif图片合成水印后，图片就不动了，所以我写了个小例子供大家参考。
 * （如果你想在某个图片上打印个动感图标，这个类就能很好地实现，
 * 前提是你必须先将动感图标分解成几张单独的gif图片。当然你可以用程序来实现。）
 */
public class MakeOver {

    public static void main(String[] args) {

        MakeOver mo = new MakeOver();
        mo.CreateGIF("e:/pic/test.gif","e:/map.gif","e:/pic/",82,395);
        //参数列表：输出图片地址，加水印的图片地址，动态图标地址，纵坐标，横坐标
        //注意：此 e:/pic/ 目录下的文件如下 1.gif 2.gif 3.gif 。。。。
    }


    public void CreateGIF(String outputFileName,String path1,String path2,int height,int weidth){
        try {
            // 指定Frame的文件
            AnimatedGifEncoder e = new AnimatedGifEncoder();
            OutputStream os = new FileOutputStream(outputFileName); //输出图片
            e.start(os);// 开始处理
            e.setQuality(15); //设置图片质量
            e.setRepeat(0);  //设置循环
            e.setDelay(500); // 设置延迟时间
            MakeOver abc = new MakeOver();  //实例化图片合成类
            String path3 = "";     //动态图片地址
            for (int i = 1; i < 3; i++) {  //此处只添加 2 张gif图片
                path3 = path2 + i +".gif";
                BufferedImage im = abc.pressImage(path3,path1, weidth, height);
                e.addFrame(im);// 循环加入Frame
            }
            e.finish();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }


    public  BufferedImage pressImage(String pressImg,
                                     String targetImg, int x, int y) {
        try {
            // 目标文件
            File _file = new File(targetImg);
            Image src = ImageIO.read(_file);
            int wideth = src.getWidth(null);
            int height = src.getHeight(null);
            BufferedImage image = new BufferedImage(wideth, height,
                    BufferedImage.TYPE_INT_RGB);
            Graphics g = image.createGraphics();
            g.drawImage(src, 0, 0, wideth, height, null);
            // 水印文件
            File _filebiao = new File(pressImg);
            Image src_biao = ImageIO.read(_filebiao);
            int wideth_biao = src_biao.getWidth(null);
            int height_biao = src_biao.getHeight(null);
            g.drawImage(src_biao, x,
                    y, wideth_biao, height_biao, null);
            // 水印文件结束
            g.dispose();
            return image;
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return null;
    }
}

