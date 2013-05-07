
public class stringreplace {
public static void main(String[] args) {
	String ss = "ORLANE (**WATSON'S-ABERDEEN)--";
	System.out.println(ss);
	ss = ss.replaceAll("'", "’");
	System.out.println(ss);
	ss = ss.replaceAll("--", "——");
	System.out.println(ss);
	
	
}
}
