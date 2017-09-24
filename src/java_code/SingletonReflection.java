package java_code;

import java.lang.reflect.Constructor;


public class SingletonReflection {

	public static void main(String[] args) {
		Singleton instance1 = Singleton.instance;
		Singleton instance2 = null;
		
		try{
			Constructor<?>[] constructors = Singleton.class.getDeclaredConstructors();
			for(Constructor<?> c:constructors){
				c.setAccessible(true);
				instance2 = (Singleton)c.newInstance();
				break;
			}
		}catch(Exception e){
			System.err.println(e);
		}
		
		System.out.println("instance 1 hashcode():- "+instance1.hashCode());
		System.out.println("instance 2 hashcode():- "+instance2.hashCode());
	}

}

class Singleton{
	
	public static Singleton instance = new Singleton();
	
	private Singleton(){
		
	}
}
