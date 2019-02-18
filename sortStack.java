
import java.util.Scanner;
import java.util.Stack;
class SortedStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			Stack<Integer> s=new Stack<>();
			int n=sc.nextInt();
			while(n-->0)
			s.push(sc.nextInt());
			Main g=new Main();
			Stack<Integer> a=g.sort(s);
			while(!a.empty()){
				System.out.print(a.peek()+" ");
				a.pop();
			}
			System.out.println();
		}
	}
}

/*Complete the function below*/
class Main{
    public void sortInsert(Stack<Integer> s , int x){
        if(s.empty() || x > s.peek()){
            s.push(x);
            return;
        }
        int t = s.pop();
        sortInsert(s,x);
        s.push(t);
    }
	public Stack<Integer> sort(Stack<Integer> s)
	{
		//add code here.
		if(!s.empty()){
		    int temp = s.pop();
		    sort(s);
		    sortInsert(s,temp);
		}
		return s;
	}
}