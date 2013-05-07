import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapHashcodeTest {
public static void main(String[] args){
	HashMap<Integer,String> map = new HashMap<Integer,String>();
    List<Object> cacheKeytemp = new ArrayList<Object>();
    cacheKeytemp.add("MapHashcodeTest".intern());
      for(int i = 0 ; i < 3 ; i ++){  
  
    	  HashMap m1 = new HashMap();  
  
          m1.put("pp900_88", i);  
  
          m1.put("pp900_59", 30);  
  
          m1.put("pp900_62", 6);  
  
          m1.put("pp900_63", 4);  
  
          m1.put("pp900_60", "y");  
  
          m1.put("pp900_61", i);  
  
          int hs = m1.hashCode();  
          cacheKeytemp.add(hs);
          cacheKeytemp.add(m1);
          
          System.out.println("cacheKeytemp.m1.identityHashCode="+System.identityHashCode(m1)+
        		  "---"+"cacheKeytemp.m1.HashCode="+hs); 
     //     map.put(hs, map.get(hs)+","+i);

     //     System.out.println(i+"==="+m1.hashCode()+"==="+map.get(hs)+","+i);  
      }  
      System.out.println("cacheKeytemp==="+cacheKeytemp.toString());  
//      System.out.println(map.size());
//      for(Map.Entry en : map.entrySet()){
//    		System.out.println(en.getKey()+"="+en.getValue());
//    	  }
    //  System.out.println(map);  
      
	    List<Object> cacheKey = new ArrayList<Object>();
	    cacheKey.add("MapHashcodeTest".intern());
	    for(int i=3 ; i < 6 ; i ++){  
	    	  
	    	  HashMap m1 = new HashMap();  
	  
	          m1.put("pp900_59", 30);  
	          m1.put("pp900_88", i);  
	  
	          m1.put("pp900_62", 6);  
	  
	          m1.put("pp900_63", 4);  
	  
	          m1.put("pp900_60", "y");  
	  
	          m1.put("pp900_61", i);  
	  
	          int hs = m1.hashCode();
	          cacheKey.add(hs);
	          cacheKey.add(m1);
	          System.out.println("cacheKey.m1.identityHashCode="+System.identityHashCode(m1)+
	        		  "---"+"cacheKey.m1.HashCode="+hs); 
	    }
	    System.out.println("cacheKey==="+cacheKey.toString());
	    System.out.println("cacheKey.hashcode()="+cacheKey.hashCode()); 
	    System.out.println("cacheKeytemp.hashcode()="+cacheKeytemp.hashCode());  
        if(cacheKey.equals(cacheKeytemp)){
        	System.out.println("cacheKey===cacheKeytemp");  
        }else{
        	System.out.println("cacheKey!=!cacheKeytemp"); 
        }
        	
        
      
      
 } 
}

 