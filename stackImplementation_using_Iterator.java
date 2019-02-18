import java.lang.*;
import java.util.*;
class stack_using_ll implements Iterable<Integer> {
        Node head;
        int size;

        class Node {
                int data;
                Node next;

                Node(int data) {
                        this.data = data;
                        next = null;
                }
        }

        stack_using_ll() {
                head = null;
                size = 0;
        }

        public void push(int data) {
                Node nn = new Node(data);
                nn.next = head;
                head = nn;
                size++;
        }

        public int pop() {
                Node temp = head;
                head = head.next;
                size--;
                return temp.data;
        }

        public boolean isEmpty() {
                return size==0;
        }

        public int size() {
                return size;
        }

        public  Iterator<Integer> iterator(){
                return new itr();
        }

        private class itr implements Iterator<Integer> {
                Node temp = head;

                public boolean hasNext() {
                        return (temp.next != null);
                }

                public Integer next() {
                        int t = temp.data;
                        temp = temp.next;
                        return t;
                }
        }
        public static void print(Iterable<Integer> i) {
                Iterator<Integer> it = i.iterator();
                while(it.hasNext()) {
                        System.out.println(it.next());
                }
                System.out.println(it.next());
        }
        public static void main(String[] args) {

                stack_using_ll list = new stack_using_ll();
                list.push(10);
                list.push(20);
                list.push(30);
                list.push(40);

                System.out.println("size "+list.size());

                System.out.println("popped "+list.pop());

                print(list);
        }
}