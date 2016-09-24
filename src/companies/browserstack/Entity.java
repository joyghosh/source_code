package companies.browserstack;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.text.DateFormatter;

/**
 * 
 * @author Joy Ghosh
 *
 */
public class Entity {
	
	private Map<String, String> attributes;
	
	public Entity(){
		attributes = new HashMap<String, String>();
	}
	
	public void set(String key, String value){
		attributes.put(key, value);
	}
	
	public String value(String key){
		return attributes.get(key);
	}
	
	public boolean equals(String key, String value){
		boolean result = false;
		
		switch(key){
			case "ID":  result =  (new Integer(attributes.get(key))).equals(new Integer(value));
						break;
			case "NAME": result = attributes.get(key).equals(value);
						 break;
			case "DATE": DateFormat df = DateFormat.getInstance();
						try {
							result = df.parse(attributes.get(key)).equals(df.parse(value));
						} catch (ParseException e) {
							System.err.println(e.getMessage());
						}
						 break;
			case "SCORE": result =  (new Integer(attributes.get(key))).equals(new Integer(value));
						  break;
			default: result = false;
		}
		return result;
	}
	
	public boolean notEquals(String key, String value){
		return false;
	}
	
	public boolean lessThan(String key, String value){
		return false;
	}
	
	public boolean moreThan(String key, String value){
		return false;
	}
	
	public boolean lessThanEquals(String key, String value){
		return (lessThan(key, value) || equals(key, value));
	}
	
	public boolean moreThanEquals(String key, String value){
		return (moreThan(key, value) || equals(key, value));
	}
}
