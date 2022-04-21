package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5670 {
    public static long total = 0;
    static class Trie{
        Trie [] arr;
        int arrsize;
        boolean endcheck;
        public Trie(){
            arr = new Trie[26];
            arrsize = 0;
            endcheck = false;
        }
        public void insert(String s , int idx){
            int arridx = s.charAt(idx) - 'a';
            if(arr[arridx] == null){
                arr[arridx] = new Trie();
                arrsize++;
            }
            if(s.length()-1 == idx)
                arr[arridx].endcheck = true;
            else
                arr[arridx].insert(s,idx+1);
        }
        public void find(String s, int idx){
            if(s.length() == idx ) return;
            int arridx = s.charAt(idx) - 'a';
            if(idx == 0){
                total++;
            }
            else{
                if(arrsize>1){
                    total++;
                }
                else if(endcheck)
                    total++;
            }
            arr[arridx].find(s,idx+1);
        }
    }
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        StringBuffer sb = new StringBuffer();
        while((str =br.readLine())!=null){
            if(str.isEmpty()) break;
            int cases = Integer.parseInt(str);
            String [] sarr = new String[cases];
            Trie trie = new Trie();
            total = 0;
            for(int i=0;i<cases;i++){
                sarr[i] = br.readLine();
                trie.insert(sarr[i],0);
            }
            for(int i=0;i<cases;i++){
                trie.find(sarr[i],0);
            }
            String s = String.format("%.2f",(double)total/cases);
            sb.append(s).append("\n");
        }
        System.out.println(sb.toString());
    }
}
