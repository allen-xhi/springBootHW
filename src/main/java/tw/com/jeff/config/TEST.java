package tw.com.jeff.config;

public class TEST {

	public static void main(String[] args) {
	String a = "%abc";
	String b = "abc456";
	String c = "ad489$%^";
	String d = "幹fda456DFFD";
	boolean A = a.contains("%");
	boolean B = a.contains("b");
	boolean C = a.contains("d");
	System.out.println("A ="+ A);
	System.out.println("B =" + B);
	System.out.println("C =" + C);
	String regex1 =  "^[A-Za-z0-9\u4e00-\u9fa5]+$";
	String regex2 =  "^[0-9]+$";
	String numbertest = "";
	String numbertest1 = "4564656";
	String numbertest2 = "4564656@#$";
	boolean H = numbertest.matches(regex2);
	boolean I = numbertest1.matches(regex2);
	boolean J = numbertest2.matches(regex2);
	 boolean D = a.matches(regex1);
	 boolean E = b.matches(regex1);
	 boolean F = c.matches(regex1);
	 boolean G = d.matches(regex1);
	System.out.println("D = "+D);
	System.out.println("E = "+E);
	System.out.println("F = "+F);
	System.out.println("G = "+G);
	System.out.println("H = "+H);
	System.out.println("I = "+I);
	System.out.println("J = "+J);
	}

}
