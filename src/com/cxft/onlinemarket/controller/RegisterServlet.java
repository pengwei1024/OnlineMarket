package com.cxft.onlinemarket.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Encoded;

import com.cxft.onlinemarket.dao.UserDao;
import com.cxft.onlinemarket.model.MsgException;
import com.cxft.onlinemarket.model.User;
import com.cxft.onlinemarket.utils.EncodeUtil;
import com.cxft.onlinemarket.utils.EncryptionUtils;
import com.cxft.onlinemarket.utils.HttpRequest;
import com.cxft.onlinemarket.utils.Sha1Util;
import com.cxft.onlinemarket.utils.TimeUtil;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// �û�ע��servlet
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		UserDao dao = new UserDao();
		User user = null;
		String valistr = request.getParameter("valistr");
		String valistr2 = (String) request.getSession().getAttribute("valistr");
		System.out.println(valistr+":::"+valistr2);
		if (valistr == null || valistr2 == null || !valistr.equals(valistr2)) {
			request.setAttribute("msg", "��֤�벻��ȷ!");
			request.getRequestDispatcher("/register.jsp").forward(request,
					response);
			return;
		}
		try {
			user = new User();
			// �жϸ������Ƿ��Ѿ�ע��
			final String userEmail = request.getParameter("userEmail");
			if (!userEmail.matches("^\\w+@\\w+(\\.\\w+)+$")) {
				throw new MsgException("�����ʽ����ȷ!");
			}
			if (dao.findUserByUserEmail(userEmail)) {
				throw new MsgException("�����ѱ�ע��");
			} else {
				user.setUserName(request.getParameter("userName"));
				// ������ܴ洢
				String userPassword = request.getParameter("userPassword");
				userPassword = EncryptionUtils.createPwd(userEmail,
						userPassword);
				String token = EncryptionUtils.createToken(userEmail);
				user.setUserPassword(userPassword);
				user.setUserEmail(userEmail);
				user.setToken(token);
				dao.registerUser(user);
				// ��¼�û�
				request.getSession().setAttribute("user", user.getUserName());
				// 5.��ʾע��ɹ�3��ص���ҳ
				response.getWriter().write("��ϲ��ע��ɹ�!���¼....");
				long time = TimeUtil.getCurrentTime();
				// �����ʼ�����
				String emailUrl = "http://olmarket.sturgeon.mopaas.com/index.php";
				String activeUrl = "http://localhost:8080/OnlineMarket/servlet/ActiveUser"
						+ "?uid="
						+ userEmail
						+ "&token="
						+ token
						+ "&time="
						+ time;
				String subject = EncodeUtil.ToUtf8("��ϰ��������˺ż���");
				String body = EncodeUtil.ToUtf8("�װ��Ĵ�ϰ������ǻ�Ա: <a href='mailto:"
						+ userEmail + "' target='_blank'>" + userEmail
						+ "</a><br><br>" + "���������Ӽ����˺�:<br>" + "<a href='"
						+ activeUrl + "' target='_blank'>" + activeUrl
						+ "</a><br><br>������ǿ����Ŷ�<br>");
				String param = "to=" + userEmail + "&subject=" + subject
						+ "&body=" + body;
				HttpRequest.sendPost(emailUrl, param);
				response.setHeader("refresh","2;url=" + request.getContextPath());
			}
		} catch (MsgException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("/register.jsp").forward(request,
					response);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
