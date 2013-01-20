package com.im1x;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

/**
 * 
 * @author Vitaly Batrakov
 *
 */
public class CheckLinkTest {

	CheckLink checkLink = new CheckLink();
	
	@Test
	public void testCheck() {
		assertEquals(1, checkLink.check("http://im1x.com", 2500));
		assertEquals(0, checkLink.check("http://im1x.com", 1));
		assertEquals(-1, checkLink.check("http://im1x.com:9999", 2500));
	}
	

}
