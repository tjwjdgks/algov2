package study.algorithm.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10845 {
    class Node{
        int data;
        Node next;
        public Node(){
            this.next= null;
        }
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    class Queue{
        public int size;
        private Node head;
        private Node tail;
        public Queue(){
            this.head = null;
            this.tail = null;
            size = 0;
        }
        public void push(int data){
            Node curNode = new Node(data);
            if(head == null){
                head = curNode;
            }
            else{
                tail.next = curNode;
            }
            this.size++;
            tail = curNode;
        }
        public int pop(){
            if(isEmpty()==1) return -1;
            int popData = head.data;
            head = head.next;
            size--;
            return popData;
        }
        public int getSize(){
            return this.size;
        }
        public int isEmpty(){
            if(getSize() == 0)
                return 1;
            else return 0;
        }
        public int front(){
            if(isEmpty()==1) return -1;
            return head.data;
        }
        public int back(){
            if(isEmpty()==1) return -1;
            return tail.data;
        }
    }
    public void getAnswer() throws IOException {
        Queue queue = new Queue();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int commandLine = Integer.parseInt(br.readLine());
        for(int i=0; i<commandLine;i++){
            String[] tempArr = br.readLine().split(" ");
            switch(tempArr[0]){
                case "push" :
                    queue.push(Integer.parseInt(tempArr[1]));
                    break;
                case "pop" :
                    sb.append(queue.pop()).append("\n");
                    break;
                case "size" :
                    sb.append(queue.getSize()).append("\n");
                    break;
                case "empty" :
                    sb.append(queue.isEmpty()).append("\n");
                    break;
                case "front" :
                    sb.append(queue.front()).append("\n");
                    break;
                case "back" :
                    sb.append(queue.back()).append("\n");
                    break;
            }
        }
        System.out.print(sb.toString());
    }
}
