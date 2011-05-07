package qualificationRound;

import static org.junit.Assert.*;

import org.junit.Test;

public class MagickaTest {

	@Test
	public void testCalc1() {
		
		String[] cs = {""};
		String[] ds = {""};
		int n = 2;
		String series = "EA";
		String[] ans = Magicka.calc(cs, ds, n, series);
		
		assertArrayEquals(new String[]{"E", "A"}, ans);
	}
	
	@Test
	public void testCalc2() {
		
		String[] cs = {"QRI"};
		String[] ds = {""};
		int n = 4;
		String series = "RRQR";
		String[] ans = Magicka.calc(cs, ds, n, series);
		
		assertArrayEquals(new String[]{"R", "I", "R"}, ans);
	}
	
	@Test
	public void testCalc3() {

		String[] cs = {"QFT"};
		String[] ds = {"QF"};
		int n = 7;
		String series = "FAQFDFQ";
		String[] ans = Magicka.calc(cs, ds, n, series);
		
		assertArrayEquals(new String[]{"F", "D", "T"}, ans);
	}
	
	@Test
	public void testCalc4() {

		String[] cs = {"EEZ"};
		String[] ds = {"QE"};
		int n = 7;
		String series = "QEEEERA";
		String[] ans = Magicka.calc(cs, ds, n, series);
		
		assertArrayEquals(new String[]{"Z", "E", "R", "A"}, ans);
	}
	
	@Test
	public void testCalc5() {
		
		String[] cs = {""};
		String[] ds = {"QW"};
		int n = 2;
		String series = "QW";
		String[] ans = Magicka.calc(cs, ds, n, series);
		
		assertArrayEquals(new String[]{}, ans);
	}

}
