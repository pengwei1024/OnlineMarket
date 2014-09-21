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

	// 用户注册servlet
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
			request.setAttribute("msg", "验证码不正确!");
			request.getRequestDispatcher("/register.jsp").forward(request,
					response);
			return;
		}
		try {
			user = new User();
			// 判断该邮箱是否已经注册
			final String userEmail = request.getParameter("userEmail");
			if (!userEmail.matches("^\\w+@\\w+(\\.\\w+)+$")) {
				throw new MsgException("邮箱格式不正确!");
			}
			if (dao.findUserByUserEmail(userEmail)) {
				throw new MsgException("邮箱已被注册");
			} else {
				user.setUserName(request.getParameter("userName"));
				// 密码加密存储
				String userPassword = request.getParameter("userPassword");
				userPassword = EncryptionUtils.createPwd(userEmail,
						userPassword);
				String token = EncryptionUtils.createToken(userEmail);
				user.setUserPassword(userPassword);
				user.setUserEmail(userEmail);
				user.setToken(token);
				dao.registerUser(user);
				// 登录用户
				request.getSession().setAttribute("user", user.getUserName());
				// 5.提示注册成功3秒回到主页
				response.getWriter().write("恭喜您注册成功!请登录....");
				long time = TimeUtil.getCurrentTime();
				// 发送邮件激活
				String emailUrl = "http://olmarket.sturgeon.mopaas.com/index.php";
				String activeUrl = "http://localhost:8080/OnlineMarket/servlet/ActiveUser"
						+ "?uid="
						+ userEmail
						+ "&token="
						+ token
						+ "&time="
						+ time;
				String subject = EncodeUtil.ToUtf8("传习在线书城账号激活");
				String body = EncodeUtil.ToUtf8("亲爱的传习在线书城会员: <a href='mailto:"
						+ userEmail + "' target='_blank'>" + userEmail
						+ "</a><br><br>" + "请点击此链接激活账号:<br>" + "<a href='"
						+ activeUrl + "' target='_blank'>" + activeUrl
						+ "</a><br><br>在线书城开发团队<br>");
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
