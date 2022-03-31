package study.algorithm.BOJ;

import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1927 {
    static class Heap {
        int[] dataarr;
        int datalength;

        public Heap(int datasize) {
            dataarr = new int[datasize + 1];
            dataarr[0] = -1;
            datalength = 1;
        }

        public void insert(int data) {
            int index = datalength;
            dataarr[datalength] = data;
            while (index != 1) {
                int pindex = index / 2;
                if (dataarr[pindex] > dataarr[index]) {
                    int temp = dataarr[pindex];
                    dataarr[pindex] = dataarr[index];
                    dataarr[index] = temp;
                    index = pindex;
                } else break;
            }
            datalength++;
        }

        public int remove() {
            if (datalength == 1) return 0;
            int maxdata = dataarr[1];
            dataarr[1] = dataarr[datalength - 1];
            datalength--;
            step(1);
            return maxdata;
        }

        public void step(int index) {
            int p = index;
            int c1 = index * 2;
            int c2 = index * 2 + 1;
            if (c1 < datalength && dataarr[p] > dataarr[c1]) {
                p = c1;
            }
            if (c2 < datalength && dataarr[p] > dataarr[c2]) {
                p = c2;
            }
            if (p != index) {
                int temp = dataarr[p];
                dataarr[p] = dataarr[index];
                dataarr[index] = temp;
                step(p);
            }
        }
    }
    public static void getAnswer(){
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        StringBuffer sb = new StringBuffer();
        //Heap h = new Heap(cases);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<cases;i++){
            int command = scanner.nextInt();
            if(command ==0){
                int val = 0;
                if(!pq.isEmpty())
                    val = pq.poll();
                sb.append(val+" ");
            }
            else{
                pq.add(command);
            }
        }
        System.out.println(sb.toString());
    }
}
