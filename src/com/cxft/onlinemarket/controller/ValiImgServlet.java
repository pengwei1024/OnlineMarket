package com.cxft.onlinemarket.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValiImgServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setDateHeader("Expires", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		// 1.���ڴ��й�����һ��ͼƬ
		int height = 30;
		int width = 120;
		int xpyl = 5;
		int ypyl = 22;
		int bang = 20;
		BufferedImage img = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		// 2.��ȡͼ���ϵĻ���
		Graphics2D g = (Graphics2D) img.getGraphics();
		// 3.���ñ���ɫ
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, width, height);
		// 4.���ñ߿�
		g.setColor(Color.BLUE);
		g.drawRect(0, 0, width - 1, height - 1);
		// 5.��������
		for (int i = 0; i < 3; i++) {
			g.setColor(Color.RED);
			g.drawLine(randNum(0, width), randNum(0, height),
					randNum(0, width), randNum(0, height));
		}
		// 6.д��
		String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			g.setColor(new Color(randNum(0, 255), randNum(0, 255), randNum(0,
					255)));
			g.setFont(new Font("����", Font.BOLD, bang));
			int r = randNum(-45, 45);
			g.rotate(1.0 * r / 180 * Math.PI, xpyl + (i * 30), ypyl);
			String s = base.charAt(randNum(0, base.length() - 1)) + "";
			buffer.append(s);
			g.drawString(s, xpyl + (i * 30), ypyl);
			g.rotate(1.0 * -r / 180 * Math.PI, xpyl + (i * 30), ypyl);
		}
		request.getSession().setAttribute("valistr", buffer.toString());
		System.out.println(buffer.toString());
		// ��ͼƬ����������
		ImageIO.write(img, "jpg", response.getOutputStream());
	}

	private Random rand = new Random();
	private int randNum(int begin, int end) {
		return rand.nextInt(end - begin) + begin;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
