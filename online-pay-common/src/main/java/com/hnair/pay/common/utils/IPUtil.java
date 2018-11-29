package com.hnair.pay.common.utils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 获取IP的工具类
 */
public final class IPUtil {
	/**
	 * 获取ip
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ipAddress = request.getHeader("x-forwarded-for");
		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}

		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}

		if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
			if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException var4) {
					var4.printStackTrace();
				}
				ipAddress = inet.getHostAddress();
			}
		}

		if (ipAddress != null && ipAddress.length() > 15 && ipAddress.indexOf(",") > 0) {
			ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
		}

		return ipAddress;
	}

	/**
	 * 获取本机ip
	 * @return
	 */
	public static String getServerIP() {
		try {
			InetAddress address = InetAddress.getLocalHost();
			String hostAddress = address.getHostAddress();
			return hostAddress;
		} catch (Exception e) {
			//nothing
		}
		return null;
	}
}