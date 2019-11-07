package com.zhenshuaiwei.ssmutils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;
/**
 * 
 * @ClassName: CaptchaUtil 
 * @Description: 生成验证码
 * @author:zsw 
 * @date: 2019年11月7日 下午3:49:08
 */
public class CaptchaUtil {
	private BufferedImage image;//图像缓冲区,内存图像
	private String str;//验证吗
	private static char code[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789".toCharArray();
	
	public BufferedImage getImage() {
		return this.image;
	}

	public String getStr() {
		return this.str;
	}

	public CaptchaUtil(){
		init();//初始化属性
	}

	private void init() {
		//在内存中创建图像，并为之设置宽高,得到一个内存图像
		int width = 90,height = 35;
		BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB );
		//获取图片的上下文，获取画笔
		Graphics g = image.getGraphics();
		//生成一个随即类
		Random random = new Random();
		//填充颜色，为验证吗背景设置颜色
		g.setColor(getRandColor(200,250));
		//填充矩形使用上面的颜色填充矩形
		g.fillRect(0, 0, width, height);
		//设定字体
		g.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		//随机产生155条背景的干扰线，
		//为背景干扰线设置颜色
		g.setColor(getRandColor(160, 200));
		for (int i = 0; i < 155; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int x1 = random.nextInt(12);
			int y1 = random.nextInt(12);
			g.drawLine(x, y, x+x1, y+y1);
		}
		//随机产生的验证吗4位
		String sRand = "";
		for (int i = 0; i < 4; i++) {
			String rand = String.valueOf(code[random.nextInt(code.length)]);
			sRand += rand;
			//将验证码显示到图像中
			//为验证码设置颜色
			g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
			//将单个字符输出到图形当中每次移动一定距离
			g.drawString(rand, 20* i + 10, 25);
		}
		//赋值验证吗
		this.str = sRand;
		//图像生效
		g.dispose();
		this.image = image;
	}


	private Color getRandColor(int fc, int bc) {
		//颜色传两个参数是为了保证在随机数在fc和bc之间
		Random random = new Random();
		if (fc > 255) {
			fc = 255;
		}
		if (bc > 255) {
			bc = 255;
		}
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r,g,b);
	}

}












