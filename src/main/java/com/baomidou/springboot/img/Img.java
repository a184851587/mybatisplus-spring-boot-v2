package com.baomidou.springboot.img;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Img {

    public static void main(String[] args) throws IOException {

        Thumbnails.of("").asBufferedImage();

        Thumbnails.of("G:\\img\\shop-share-bg.png")
                .size(1280,1024)
                .watermark(Positions.BOTTOM_LEFT,
                        ImageIO.read(new File("G:\\img\\icon_brand_phone.png")),1.0f)
                .outputQuality(0.8f)
                .toFile("G:\\img\\bg.png");
    }

    public void aa() throws IOException {





    }
}
