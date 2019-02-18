
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main (String[] args) throws IOException {
		//code
		//Scanner s = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcase = Integer.parseInt(br.readLine());
		while(testcase != 0){
		    int size = Integer.parseInt(br.readLine());
		    String str[] = br.readLine().split(" ");
		    long [] arr = new long[size];
		    for(int i=0;i<size;i++){
			        arr[i] = Long.parseLong(str[i]);
		    }
		    findNext(arr , size);
		    System.out.println();
		    testcase--;
		}
	}
	public static void findNext(long arr[] , int size){
	    long [] res = new long[arr.length];
	    Stack<Long> st = new Stack<>();
	    for(int i=size-1 ; i>=0;i--){
	        if(!st.isEmpty()){
	            while(!st.isEmpty() && st.peek() <= arr[i])
	                st.pop();
	        }
	        res[i] = st.isEmpty() ? -1: st.peek();
	        st.push(arr[i]);
	    }
	    for(int i=0;i<res.length;i++){
	        System.out.print(res[i]+" ");
	    }
	}
}