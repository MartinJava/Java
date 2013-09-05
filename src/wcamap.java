import java.io.IOException;
import java.util.*;
import java.util.Iterator;

public class wcamap {
    public static void main(String[] args)  {
     String word;
     int count;
     StringBuffer sb = new StringBuffer();
     sb.setLength(0);
        ArrayList Wcarray= new ArrayList();
      int x=0;
      do{
    	
        	
				try {
					x=System.in.read();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				sb.append((char)x);
				if(Character.isLetter(x)==false){
					Wcarray.add(sb);
					sb.setLength(0);
					
				}
        	
        } while(x!=13);
      Wcarray.add(sb);
        
      Iterator<String> userIterator =Wcarray.iterator();
      while (userIterator.hasNext()) {
          String username = userIterator.next();
          
          System.out.println(username+" -повторяется"+Collections.frequency(Wcarray,username));
    }
    }
}