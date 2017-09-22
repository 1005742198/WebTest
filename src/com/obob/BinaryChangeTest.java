package com.obob;


public class BinaryChangeTest {
	
	public static char[] sixteen = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	
	public static String ten2Sixteen(long ten) {
		StringBuffer sixteenStr = new StringBuffer("");
		do {
			sixteenStr.append(sixteen[(int)(ten%16)]);
			ten = ten/16;
		} while (ten != 0);
		return sixteenStr.reverse().toString();
	}
	
	
	/**
	 * 
	 * @param sixteenStr
	 * @return
	 */
	public static long sixteen2Ten(String sixteenStr) {
		long result = 0;
		for(int i=sixteenStr.length(); i>0; i--) {
			result += countPerChar(sixteenStr.charAt(i-1), sixteenStr.length()-i + 1); 
		}
		return result;
	}
	private static long countPerChar(char m, int n) {
		long result = getIndex(m);
		while (n > 1) {
			result *= 16;
			n--;
		}
		return result;
	}
	
	private static int getIndex(char m) {
		for(int i=0; i<sixteen.length; i++) {
			if(sixteen[i] == m) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		long tenBinary = 845678992357836701L;
		System.out.println(ten2Sixteen(tenBinary));
		System.out.println(sixteen2Ten(ten2Sixteen(tenBinary)));
	}
}
