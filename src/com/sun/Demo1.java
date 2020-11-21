package com.sun;

/**
   *     压缩字符串
 * @author sunzexi
 *
 */
public class Demo1 {

	public static void main(String[] args) {
		System.out.println("hello world!");
		/*
		 * System.out.println("\10:"+'\10'); String str = "aaaabbbbcccddd";
		 * System.out.println(comp(str));
		 */
		Integer a = 127;
		Integer b = 127;
		System.out.println("a==b:"+(a==b));
	}
	
	public static String comp(String str) {
		StringBuffer buf = new StringBuffer();
		int i = 1;
		int count = 1;
		char ch = str.charAt(0);
		for(;;) {
			char c = (i==str.length()?'\10':str.charAt(i));
			if(c == ch) {
				count++;
			}else {
				if(count == 1) {
					buf.append(ch);
				}else {
					buf.append(count).append(ch);
				}
				count = 1;
				ch = c;
			}
			i++;
			if(i == str.length()+1) {
				break;
			}
		}
		return buf.toString();
	}
}
