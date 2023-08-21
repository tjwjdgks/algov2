package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int [][] array = new int[s.length()][26];
        int firstIndex = s.charAt(0) - 'a';
        array[0][firstIndex] = 1;
        for(int i=1;i< s.length();i++){
            int index = s.charAt(i) - 'a';
            for(int j=0;j<26;j++){
                if(j == index){
                    array[i][j] = array[i-1][j]+1;
                }
                else{
                    array[i][j] = array[i-1][j];
                }
            }
        }
        int n  = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<n;i++){
            String [] sArr = br.readLine().split(" ");
            int alphaIndex = sArr[0].charAt(0) - 'a';
            int l = Integer.parseInt(sArr[1]);
            int r = Integer.parseInt(sArr[2]);
            if(l-1<0){
                sb.append(array[r][alphaIndex]);
            }
            else{
                sb.append(array[r][alphaIndex] - array[l-1][alphaIndex]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
