package leetCode;

public class strParam {

	public static void main(String[] args) {
	   String s = "()()";
	   int length = s.length(); 
       char[] symbol = new char[length];
       int ctr = 0,ptr = 0;
       String str = "";
       for(int i=0; i<length; i++)
       {
    	   if(symbol[0] == '\0') 
    	   {
    		   symbol[ctr] = s.charAt(i);
        	   ptr = i;
           }
    	   else if(symbol[ctr] == s.charAt(i))
    	   {
    		   ctr++;
        	   symbol[ctr] = s.charAt(i);
           }
    	   else
    	   {
    		   if(ctr != 0)
    		   {
    			   symbol[ctr] = '\0';
    			   ctr--;
    	       }
    		   else
    		   {
    			   symbol[ctr] = '\0';
    			   str += s.substring(ptr+1, i);
    			   System.out.println(" str is "+str);
               }
    	   }

    	}
	}
}
