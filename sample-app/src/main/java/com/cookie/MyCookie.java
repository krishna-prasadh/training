package com.cookie;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyCookie {

	public Cookie getCookieeByName(HttpServletRequest req, String cookieName) {

		Cookie selectCookie = null;
		Cookie[] cookies = req.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			Cookie localCookie = cookies[i];
			if (localCookie.getName().equals(cookieName)) {
				selectCookie = localCookie;
			}
		}

		return selectCookie;
	}

	public boolean getCookiee(HttpServletRequest req) {
		boolean cokk = false;
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("training")) {
					cokk = true;
				}
			}
		}

		return cokk;
	}

	public void setCookie(String name, String val, HttpServletResponse res) {

		Cookie c = new Cookie(name, val);
		res.addCookie(c);

	}

	public void deleteCookie(HttpServletRequest req,
			HttpServletResponse response) throws ServletException, IOException {

		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("training")) {
					cookies[i].setMaxAge(0);
					response.addCookie(cookies[i]);
				}
			}
		}
		RequestDispatcher rdp = req.getRequestDispatcher("index.html");
		rdp.forward(req, response);

	}
}
