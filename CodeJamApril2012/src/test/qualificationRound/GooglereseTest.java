package test.qualificationRound;

import static org.junit.Assert.*;

import org.junit.Test;

import qualificationRound.Googlerese;

public class GooglereseTest {

	@Test
	public void test() {

		String result = Googlerese.translate("ejp mysljylc kd kxveddknmc re jsicpdrysi");
		assertEquals("our language is impossible to understand", result);
		
		result = Googlerese.translate("rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd");
		assertEquals("there are twenty six factorial possibilities", result);
		
		result = Googlerese.translate("de kr kd eoya kw aej tysr re ujdr lkgc jv");
		assertEquals("so it is okay if you want to just give up", result);
	}

}
