
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static int Prec(char ch){
	    /*switch(ch){
	        case '+':
	        case '_':
	               return 1;
	       case '*':
	       case '/':
	           return 2;
	       case '^':
	           return 3;
	    }
	    return -1;*/
	    if(ch == '+' || ch=='-')
	    return 1;
	    else if(ch == '*' || ch=='/')
	    return 2;
	    else if(ch == '^')
	    return 3;
	    return -1;
	}
    public static void inTopost(String str){
	    String result = new String("");
	    Stack<Character> st = new Stack<Character>();
	    for(int i=0 ;i<str.length();i++){
	        char c = str.charAt(i);
	        if(Character.isLetterOrDigit(c))
	            result = result+c;
	        else if(c == '(')
	            st.push(c);
	       else if(c == ')'){
	            while(!st.empty() && st.peek() != '(')
	                result = result+st.pop();
	                if(!st.empty() && st.peek() != '(')
	                     System.out.println("Invalid");
	                else
	                    st.pop();
	  	       }
	  	     else {
	  	         while(!st.empty() && Prec(c) <= Prec(st.peek()))
	  	            result = result+st.pop();
	  	            
	  	            st.push(c);
	  	     }
	    }
	    
	    while(!st.empty())
	        result = result + st.pop();
	   System.out.println(result);
	}
	
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		while(testcase > 0){
		   String str = br.readLine();
		    inTopost(str);
		    testcase--;
		}
	}
}