package com.heweather.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

public class GetIP {
	private static final String UNKNOWN="unknow";
	private static final String LOCALHOST="127.0.0.1";
	private static final String SEPARATOR=",";
	
	/**
	 * @description 根据http请求获取客户端IP
	 * @param request 客户端发送的http请求
	 * @return 客户端的IP地址
	 */
	public static String getIpInfo(HttpServletRequest request) {
		String ip;
		try {
			ip=request.getHeader("x-forwarded-for");
			if(ip==null || ip.length()==0 || UNKNOWN.equalsIgnoreCase(ip)) {
				ip = request.getHeader("Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
                if (LOCALHOST.equals(ip)) {
                    InetAddress inet = null;
                    try {
                        inet = InetAddress.getLocalHost();
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    }
                    ip = inet.getHostAddress();
                }
            }
            // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
            // "***.***.***.***".length()
            if (ip != null && ip.length() > 15) {
                if (ip.indexOf(SEPARATOR) > 0) {
                    ip = ip.substring(0, ip.indexOf(","));
                }
            }
		}catch(Exception e) {
			ip="";
			e.printStackTrace();
		}
		return ip;
	}

}
