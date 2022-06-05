package study.algorithm.BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
public class BOJ1966 {
    public void getAnswer() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        for(int i=0; i<cases;i++){
            st = new StringTokenizer(bufferedReader.readLine());
            int curarrnum = Integer.parseInt(st.nextToken());
            int targetidx = Integer.parseInt(st.nextToken());
            int arr[] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
            ArrayDeque<int[]> deque = new ArrayDeque<>();
            int [] tempnumandidx;
            for(int j =0; j<arr.length;j++){
                tempnumandidx = new int[2];
                tempnumandidx[0] = arr[j];
                tempnumandidx[1] = j;
                deque.add(tempnumandidx);
            }
            int count = 0;
            while(true){
                int[] temps = deque.removeFirst();
                boolean check = true;
                for(int[] k : deque){
                    if(temps[0]< k[0]){
                        check = false;
                        deque.addLast(temps);
                        break;
                    }
                }
                if(check == true){
                    count++;
                    if(temps[1] == targetidx)
                        break;
                }
            }
            sb.append(count+"\n");
        }
        System.out.println(sb.toString());
    }
}
