
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static void post(String s){
        int n = s.length();
        Stack<Integer> st = new Stack<Integer>();
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                //System.out.print("c is "+c);
                st.push(c-'0');
            }
            else{
                int val1 = st.pop();
                int val2 = st.pop();
                if(c=='+'){
                    st.push(val1+val2);
                }
                if(c=='-'){
                    st.push(val2-val1);
                }
                if(c=='*'){
                    st.push(val1*val2);
                }
                if(c=='/'){
                    st.push(val2/val1);
                }
            }
        }
        int res = st.pop();
        System.out.println(res);
    }
    
    
	public static void main (String[] args) {
		//code
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i=0;i<t;i++){
		    String s = in.next();
		    post(s);
		}
		
	}
}