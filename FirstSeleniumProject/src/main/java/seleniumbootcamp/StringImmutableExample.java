package seleniumbootcamp;

public class StringImmutableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1 = "Java";
		String str = s1;
		s1 = s1.concat("rules");
		
		System.out.println("String---->"+s1);

	}

}
