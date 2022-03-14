package study.algorithm.BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2309 {
    public static int [] arr = new int[9];
    public static boolean check = false;
    public static void dfs(int idx,int count,int num, String s){
        if(check == true) return;
        if(count == 7){
            if(num == 100){
                System.out.println(s);
                check = true;
            }
            return;
        }
        for(int i=idx+1;i<arr.length;i++){
            if(count ==0)
                dfs(i,count+1,num+arr[i],s+arr[i]);
            else
                dfs(i,count+1,num+arr[i],s+"\n"+arr[i]);

        }
    }
    public static void getAnswer(){
        Scanner scanner = new Scanner(System.in);
        for(int i=0;i<9;i++){
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        dfs(-1,0,0,"");
    }
}
