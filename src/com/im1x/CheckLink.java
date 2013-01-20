package com.im1x;

import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;

/**
 * 
 * @author Vitaly Batrakov
 *
 */
public class CheckLink {
	/**
	 * 
	 * @param urlp - url for check
	 * @param timeout timeout (ms)
	 * @return code: -1 - error, 0 - timeout, 1 - good, 2 - good&psw 
	 */
	public int check(String urlp, int timeout) {
		try {
			URL url = new URL(urlp);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(timeout);
			//conn.setReadTimeout(5000);
			conn.connect();
			System.out.println(conn.getResponseCode());

			if (conn.getResponseCode() == 200) {
				conn.disconnect();
				return 1;
			} else if (conn.getResponseCode() == 401) {
				conn.disconnect();
				return 2;
			}
			System.out.println(conn.getResponseCode());
		} catch (SocketTimeoutException e) {
			System.out.println("timeout");
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}
