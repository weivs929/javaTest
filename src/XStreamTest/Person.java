package XStreamTest;

import java.util.List;

/**
 * Class
 * 
 * @author JiJW
 * @version 1.0 2015-1-30
 */
public class Person {
	   private String name; 
	    private String age; 
	    private Profile profile; 
	    private List<Address> addlist; 

	    public Person(String name, String age, Profile profile, List<Address> addlist) { 
	        this.name = name; 
	        this.age = age; 
	        this.profile = profile; 
	        this.addlist = addlist; 
	    } 

	    public String toString() { 
	        return "Person{" + 
	                "name='" + name + '\'' + 
	                ", age='" + age + '\'' + 
	                ", profile=" + profile + 
	                ", addlist=" + addlist + 
	                '}'; 
	    } 
}
