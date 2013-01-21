package com.im1x;

import static org.junit.Assert.*;
import org.junit.Test;

import java.net.ConnectException;

/**
 * 
 * @author Vitaly Batrakov
 *
 */
public class CheckLinkTest {

	CheckLink checkLink = new CheckLink();
	
	@Test(expected = ConnectException.class)
	public void testCheck() throws ConnectException {
		assertEquals(1, checkLink.check("http://im1x.com", 2500));
		assertEquals(0, checkLink.check("http://im1x.com", 1));
		checkLink.check("http://im1x.com:9999", 2500);
	}
}
