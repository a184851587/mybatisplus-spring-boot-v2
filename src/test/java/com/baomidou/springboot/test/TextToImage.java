package com.xmliu.example.texttoimage;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

/**
 * Created by diyan on 2019/6/12.
 * 如果一行文字长度超过了既定的宽度，那么主动执行换行操作
 */
public class TextToImage {

    public static void main(String[] args) throws Exception {
        String message = "辽宁省大连市高新区创业e港";
        String[] strArr = message.split("\n");
        int image_height = 32; // 每张图片的高度
        int line_height = 20; // 每行或者每个文字的高度
        int every_line = image_height / line_height; // 每张图片有多少行文字

        createImage(strArr, new Font("宋体", Font.PLAIN, 22), 350, image_height,  every_line, line_height);

    }


    /**
     * 根据str,font的样式等生成图片
     * https://blog.csdn.net/sinat_28505133/article/details/54669111
     *
     * @param strArr
     * @param font
     * @param width
     * @param image_height
     * @throws Exception
     */
    public static void createImage(String[] strArr, Font font,
                                   int width, int image_height, int every_line, int line_height) throws Exception {

        FontMetrics fm = sun.font.FontDesignMetrics.getMetrics(font);
        int stringWidth = fm.charWidth('字');// 标点符号也算一个字
        int line_string_num = width % stringWidth == 0 ? (width / stringWidth) : (width / stringWidth) + 1;
        System.out.println("每行=" + line_string_num);

        List<String> listStr = new ArrayList<String>();
        List<String> newList = new ArrayList<String>();
        for (int h = 0; h < strArr.length; h++) {
            listStr.add(strArr[h]);
        }
        for (int j = 0; j < listStr.size(); j++) {
            if( listStr.get(j).length() > line_string_num){
                newList.add(listStr.get(j).substring(0,line_string_num));
                listStr.add(j+1,listStr.get(j).substring(line_string_num));
                listStr.set(j,listStr.get(j).substring(0,line_string_num));
            }else{
                newList.add(listStr.get(j));
            }
        }

        int a = newList.size();
        int b = every_line;
        int imgNum = a % b == 0 ? (a / b) : (a / b) + 1;

        for (int m = 0; m < imgNum; m++) {
            String filePath = "C:\\Users\\diyan\\Pictures\\d" + m + ".jpg";
            File outFile = new File(filePath);
            // 创建图片
            BufferedImage image = new BufferedImage(width, image_height,
                    BufferedImage.TYPE_INT_BGR);
            Graphics g = image.getGraphics();
            g.setClip(0, 0, width, image_height);
            g.setColor(Color.white); // 背景色白色
            g.fillRect(0, 0, width, image_height);
            g.setColor(Color.black);//  字体颜色黑色
            g.setFont(font);// 设置画笔字体
            // 每张多少行，当到最后一张时判断是否填充满
            for (int i = 0; i < every_line; i++) {
                int index = i + m * every_line;
                if (newList.size() - 1 >= index) {
                    System.out.println("每行实际=" + newList.get(index).length());
                    g.drawString(newList.get(index), 0, line_height * (i + 1));
                }
            }
            g.dispose();
            ImageIO.write(image, "jpg", outFile);// 输出png图片
        }
    }

}

