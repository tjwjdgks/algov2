package study.algorithm.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ20058 {
    int [] dy = {0,1,0,-1};
    int [] dx = {1,0,-1,0};
    public void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int [][] array = new int[1<<N][];
        for(int i=0;i<(1<<N);i++){
            array[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(num->Integer.parseInt(num)).toArray();
        }
        int [] numArr = Arrays.stream(br.readLine().split(" ")).mapToInt(num->Integer.parseInt(num)).toArray();
        for(int i=0;i<Q;i++){
            rotateRecursive(array,0,0,array.length-1,array.length-1,N-numArr[i]);
            array = removeIce(array);
        }

        boolean [][] check = new boolean[array.length][array.length];
        int totalIce = 0;
        int maxMountCount = 0;

        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length;j++){
                if(array[i][j] == 0 || check[i][j]) continue;

                check[i][j] = true;
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i,j});
                totalIce +=array[i][j];
                int tempCount = 1;
                while(!queue.isEmpty()){
                    int[] poll = queue.poll();
                    for(int k=0;k<4;k++){
                        int tempy = poll[0] + dy[k];
                        int tempx = poll[1] + dx[k];
                        if(tempy>=0 && tempx>=0 && tempy<array.length && tempx<array.length && !check[tempy][tempx] && array[tempy][tempx] !=0) {
                            totalIce += array[tempy][tempx];
                            check[tempy][tempx] = true;
                            queue.add(new int[]{tempy,tempx});
                            tempCount+=1;
                        }
                    }
                }
                if(tempCount>1)
                    maxMountCount = Math.max(maxMountCount,tempCount);
            }
        }
        System.out.println(totalIce);
        System.out.println(maxMountCount);
    }

    private int[][] removeIce(int[][] array) {
        int [][] temparry = new int[array.length][array.length];
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length;j++){
                temparry[i][j] = array[i][j];
            }
        }

        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length;j++){
                int count = 0;
                if(array[i][j] == 0 ) continue;

                for(int k=0;k<4;k++){
                    int tempy = i + dy[k];
                    int tempx = j + dx[k];
                    if(tempy>=0 && tempx>=0 && tempy<array.length && tempx<array.length && array[tempy][tempx] !=0){
                        count++;
                    }
                }
                if(count<3){
                    temparry[i][j] -=1;
                }
            }
        }
        return temparry;
    }

    private void rotateRecursive(int[][] array, int minX,int minY, int maxX, int maxY, int count) {
        if(count == 0){
            rotate(array,minX,minY,maxX,maxY);
            return;
        }
        // 0,0, n/2,n/2
        int middleX = (minX+maxX)/2;
        int middleY = (minY+maxY)/2;

        rotateRecursive(array,minX,minY,middleX,middleY,count-1);

        rotateRecursive(array,middleX+1,minY,maxX,middleY,count-1);

        rotateRecursive(array,minX,middleY+1,middleX,maxY,count-1);

        rotateRecursive(array,middleX+1,middleY+1,maxX,maxY,count-1);
    }

    private void rotate(int[][] array, int minX, int minY, int maxX, int maxY) {
        int[][] tempArr = new int[maxX - minX + 1][maxY - minY + 1];

        for (int i = minY; i <=maxY; i++) {
            for (int j = minX; j <=maxX; j++) {
                tempArr[j-minX][maxY-i] =array[i][j];
            }
        }

        for (int i = minY; i <= maxY; i++) {
            for (int j = minX; j <= maxX; j++) {
                array[i][j] = tempArr[i-minY][j-minX];
            }
        }
    }

}
