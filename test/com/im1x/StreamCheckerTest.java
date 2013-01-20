package com.im1x;

import java.io.File;

import junit.framework.Assert;

import org.junit.Test;

public class StreamCheckerTest {
	StreamChecker streamChecker = new StreamChecker();


	@Test
	public void testCheckDirs() {
		Assert.assertFalse(streamChecker.checkDirs());
		
		streamChecker.setInputDir("Not empty");
		streamChecker.setOutputDir("Not empty");
		
		Assert.assertTrue(streamChecker.checkDirs());
	}
	
	@Test
	public void testExistOrCreateDirs() {
		String inD = System.getProperty("user.dir") + System.getProperty("file.separator") + "input";
		String outD = System.getProperty("user.dir") + System.getProperty("file.separator") + "output";

		streamChecker.setInputDir(inD);
		streamChecker.setOutputDir(outD);
		
		Assert.assertTrue(streamChecker.existOrCreateDirs());
		
		new File(inD).delete();
		new File(outD).delete();
	}

}
