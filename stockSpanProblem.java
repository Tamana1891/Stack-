
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void stockProblem(int[] price , int n){
        int[] S=new int[n];
        Stack<Integer> st= new Stack<>(); 
        st.push(0);  
        S[0] = 1; 
        for (int i = 1; i < n; i++) 
        { 
  
            while (!st.empty() && price[st.peek()] <= price[i]) 
              {  st.pop();} 
      
            S[i] = (st.empty())? (i + 1) : (i - st.peek()); 
      
            st.push(i); 
            
        } 
         for (int i = 0; i < n; i++) 
         {
             System.out.print(S[i]+" ");
         }
         System.out.println();
    }
	public static void main (String[] args) {
		//code
		Scanner s = new Scanner(System.in);
		int testcase = s.nextInt();
		while(testcase > 0){
		    int size = s.nextInt();
		    int[] arr = new int[size];
		    for(int i=0;i<size;i++)
		        arr[i] = s.nextInt();
		    stockProblem(arr , size);
		    testcase--;
		}
	}
}