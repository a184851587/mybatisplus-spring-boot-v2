package  com.baomidou.springboot.test;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Position;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Paths;


public class test {


    //C:\Users\Administrator\Desktop\test.jpg
    //自定义拼接图片位置
    @Test
    public void test10() {
        try {
            BufferedImage bufferedImage = Thumbnails.of("G:\\img\\shop-share-bg.png").scale(1).outputQuality(1).asBufferedImage();
            BufferedImage bufferedImage1 = roundImage(bufferedImage, bufferedImage.getWidth(), bufferedImage.getHeight(), 200);
            BufferedImage text = handleTextWaterMark("1233344421313");
           /* System.out.println(System.currentTimeMillis());
            //输出目录
            String rootPath = "G:\\img\\";


            //这里文字的size，建议设置大一点，其实就是像素会高一点，然后缩放后，效果会好点，最好是你实际输出的倍数，然后缩放的时候，直接按倍数缩放即可。
            Font font = new Font("微软雅黑", Font.PLAIN, 130);
            BufferedImage text = ImageDemo.createImage("4442131231231231", font, Paths.get(rootPath, "sojson-image.png").toFile());*/
            //Thumbnails.of(text).size(32,400).toFile("G:\\img\\text");

            Thumbnails.of(bufferedImage1).watermark(new Position() {
                @Override
                public Point calculate(int enclosingWidth,
                                       int enclosingHeight,
                                       int width,
                                       int height,
                                       int insetLeft,
                                       int insetRight,
                                       int insetTop,
                                       int insetBottom) {
                    System.out.println(enclosingWidth);
                    System.out.println(enclosingHeight);
                    System.out.println(width);
                    System.out.println(height);
                    System.out.println(insetLeft);
                    System.out.println(insetRight);
                    System.out.println(insetTop);
                    System.out.println(insetBottom);
                    return new Point(552, 1004);//左上角对其
                }
            }, Thumbnails.of("G:\\img\\aa.png").size(148,148).outputQuality(1).asBufferedImage(), 1)
                    .watermark(new Position() {
                        @Override
                        public Point calculate(int enclosingWidth,
                                               int enclosingHeight,
                                               int width,
                                               int height,
                                               int insetLeft,
                                               int insetRight,
                                               int insetTop,
                                               int insetBottom) {
                            System.out.println(enclosingWidth);
                            System.out.println(enclosingHeight);
                            System.out.println(width);
                            System.out.println(height);
                            System.out.println(insetLeft);
                            System.out.println(insetRight);
                            System.out.println(insetTop);
                            System.out.println(insetBottom);
                            return new Point(50, 1004);//左上角对其
                        }
                    }, Thumbnails.of(text).size(300,32).keepAspectRatio(false).asBufferedImage(), 1)
                    .scale(1).outputQuality(1).toFile("G:\\img\\posint.png");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //利用画笔加圆角
    static BufferedImage roundImage(BufferedImage image, int width, int height, int cornerRadius) {
        BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = outputImage.createGraphics();
        g2.setComposite(AlphaComposite.Src);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.WHITE);
        g2.fill(new RoundRectangle2D.Float(0, 0, width, height, cornerRadius, cornerRadius));
        g2.setComposite(AlphaComposite.SrcAtop);
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
        return outputImage;
    }


    //搞一张白底图片
    @Test
    public void test11() {

        BufferedImage bi = new BufferedImage(500, 500, BufferedImage.TYPE_INT_BGR);
        Graphics2D dg = bi.createGraphics();
        dg.setColor(Color.WHITE);//设置笔刷白色
        dg.fillRect(0, 0, bi.getWidth(), bi.getHeight());//填充整个屏幕
        try {
            Thumbnails.of(bi).scale(1).outputQuality(1).toFile("C:\\Users\\Administrator\\Desktop\\test2.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return java.awt.image.BufferedImage
     * @throws
     * @description 操纵文字型水印
     * @params [address, dealerName, latitudeCommaLongitude, date]
     */
    private BufferedImage handleTextWaterMark(String test) throws IOException {

        Font font = new Font("宋体",Font.BOLD,32);
        BufferedImage image = new BufferedImage(300, 32, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        image = g.getDeviceConfiguration().createCompatibleImage(300, 32, Transparency.TRANSLUCENT);

        int y = 0;
        int divider30 = 30;

        g = image.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.black);
        g.setFont(font);

        if (StringUtils.isNotBlank(test)) {
            g.drawString(  test, 5, y += divider30);
        }


        g.dispose();
        ImageIO.write(image, "png",  Paths.get("G:\\img\\", "aas-image.png").toFile());
        return image;
    }


    }


