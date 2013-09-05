import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

public class Wca2 {
    public static void main(String[] args)  {
     int schyoutchik=0;
     StringBuffer sb = new StringBuffer();
     sb.setLength(0);
     Map<String, Integer> map = new HashMap<String,Integer>();
      int x=0;
      do{
    	  	try {
					x=System.in.read();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (Character.isLetter(x)){
				sb.append((char)x);}
			else{
				
					schyoutchik=1;
			      for( Entry<String, Integer> entry : map.entrySet() ){
						if ( sb.toString().equals( entry.getKey() )){
							schyoutchik++;	
						}}
			      map.put(sb.toString(), schyoutchik);
				sb.setLength(0);	
				
      }
        } while(x!=13);  
      System.out.println(map);     
    }
    }
