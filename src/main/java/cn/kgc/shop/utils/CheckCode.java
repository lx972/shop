package cn.kgc.shop.utils;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 * 生成验证码
 */
public class CheckCode {

	public CheckCode() {
	}


	/**
	 * 获取随机颜色
	 * @param s
	 * @param e
	 * @return
	 */
	public static Color getRandColor(int s, int e) {
		Random random = new Random();
		if (s > 255) {
			s = 255;
		}
		if (e > 255) {
			e = 255;
		}
		//随机生成RGB颜色中的r值
		int r = s + random.nextInt(e - s);
		//随机生成RGB颜色中的g值
		int g = s + random.nextInt(e - s);
		//随机生成RGB颜色中的b值
		int b = s + random.nextInt(e - s);
		return new Color(r, g, b);
	}

	/**
	 *
	 * @param width	验证码的宽度
	 * @param height	验证码的高度
	 * @param os	输出流，图片通过这输出到前台
	 * @return	随机生成的验证码
	 */
	public static String outputImage(int width, int height, OutputStream os) {
		//创建一个图片缓存绘制区域
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//获取Graphics类的对象
		Graphics g = image.getGraphics();
		//实例化一个Random对象
		Random random = new Random();
		//通过Font构造字体
		Font mFont = new Font("宋体", Font.BOLD, 22);
		//绘制验证码背景
		g.fillRect(0, 0, width, height);
		//设置字体
		g.setFont(mFont);
		//设置颜色
		g.setColor(getRandColor(180, 200));
		// 画随机的线条
		for (int i = 0; i < 100; i++) {
			int x = random.nextInt(width - 1);
			int y = random.nextInt(height - 1);
			int x1 = random.nextInt(3) + 1;
			int y1 = random.nextInt(6) + 1;
			//绘制直线
            g.drawLine(x, y, x + x1, y + y1);
		}
        /**************************画一条折线********************************/
		//创建一个供画笔选择线条粗细的对象
		BasicStroke bs=new BasicStroke(2f,BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL);
		//通过Graphics类的对象创建一个Graphics2D类的对象
		Graphics2D g2d = (Graphics2D) g;
		//改变线条的粗细
		g2d.setStroke(bs);
		//设置当前颜色为预定义颜色中的灰色
		g.setColor(Color.GRAY);
		//指定端点的个数
        int lineNumber=4;
		//定义保存x轴坐标的数组
		int[] xPoints=new int[lineNumber];
		//定义保存x轴坐标的数组
		int[] yPoints=new int[lineNumber];
        //通过循环为x轴坐标和y轴坐标的数组赋值
		for(int j=0;j<lineNumber;j++){
			xPoints[j]=random.nextInt(width - 1);
			yPoints[j]=random.nextInt(height - 1);
		}
		//绘制折线
		g.drawPolyline(xPoints, yPoints,lineNumber);
        /*******************************************************************/
        //验证码存在这里
		String sRand = "";
		// 输出随机的验证文字
         for (int i = 0; i < 4; i++) {
			 //生成A~Z的字母
            char ctmp = (char)(random.nextInt(26) + 65);
			sRand += ctmp;
			Color color = new Color(20 + random.nextInt(110), 20 + random
					.nextInt(110), 20 + random.nextInt(110));
			 //设置颜色
			g.setColor(color);
			/** **随机缩放文字并将文字旋转指定角度* */
			// 将文字旋转指定角度
			Graphics2D g2d_word = (Graphics2D) g;
			AffineTransform trans = new AffineTransform();
			trans.rotate(random.nextInt(45) * 3.14 / 180, 22 * i + 8, 7);
			// 缩放文字
			float scaleSize = random.nextFloat() +0.8f;
			if (scaleSize > 1f)	{
				scaleSize = 1f;
			}
			 //进行缩放
			trans.scale(scaleSize, scaleSize);
			g2d_word.setTransform(trans);
			/** ********************* */
			g.drawString(String.valueOf(ctmp), width/6 * i+23, height/2);

		}
         //关闭图片绘制
		g.dispose();
		try {
			// 将生成的验证码输出到os输出流中
			ImageIO.write(image, "JPEG", os);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sRand;
	}

}
