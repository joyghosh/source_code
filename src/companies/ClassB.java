package companies;

public class ClassB extends ClassA {
	
	//overriding
	public StringBuffer method(){
		System.out.println("Method Class B.");
		return new StringBuffer();
	}
	
	public void method1(){
		System.out.println("Static method Class B.");
	}
}
