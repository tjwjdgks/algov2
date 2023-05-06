package study.algorithm.study.dk.week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Jerry {
    static class Robot{
        // E, N , W , S
        private static int[] dy = {0,1,0,-1};
        private static int[] dx = {1,0,-1,0};
        int x;
        int y;
        int dir;
        public Robot(int x , int y, String dir){
            this.x = x;
            this.y = y;
            switch(dir){
                case "E" : this.dir = 0;
                    break;
                case "N" : this.dir = 1;
                    break;
                case "W" : this.dir = 2;
                    break;
                case "S" : this.dir = 3;
                    break;
            }
        }
        public void doCommand(String command){
            switch (command){
                case "L" : turnLeft();
                    break;
                case "R" : turnRight();
                    break;
                case "F" : goForward();
            }
            
        }
        private void turnLeft(){
            this.dir = (this.dir+1) == 4 ? 0 : this.dir+1;
        }
        private void turnRight(){
            this.dir = (this.dir-1) == -1 ? 3: this.dir-1;
        }
        private void goForward(){
            this.y += dy[this.dir];
            this.x += dx[this.dir];
        }
        public int[] getForwardCord(){
            return new int[]{this.y+dy[this.dir], this.x+dx[this.dir]};
        }
    }
    static class Order{
        int robotIndex;
        String command;
        int iterateCount;

        public Order(int robotIndex, String command, int iterateCount) {
            this.robotIndex = robotIndex;
            this.command = command;
            this.iterateCount = iterateCount;
        }
    }
    public static void getAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [][] checkMap = new int[B][A];
        List<Robot> robots = new ArrayList<>();
        for(int i=0;i<N;i++){
            String[] arr = br.readLine().split(" ");
            int x = Integer.parseInt(arr[0])-1;
            int y = Integer.parseInt(arr[1])-1;
            robots.add(new Robot(x,y,arr[2]));
            checkMap[y][x] = i+1;
        }
        List<Order> orders = new ArrayList<>();
        for(int i=0;i<M;i++){
            String[] arr = br.readLine().split(" ");
            orders.add(new Order(Integer.parseInt(arr[0])-1,arr[1],Integer.parseInt(arr[2])));
        }
        boolean flag = true;
        while(flag){
            flag = false;
            for(Order o : orders){
                if(o.iterateCount<=0) continue;
                flag = true;
                Robot robot = robots.get(o.robotIndex);
                if(o.command.equals("F")){
                    int[] nextCord = robot.getForwardCord();
                    if(nextCord[0]>=0 && nextCord[1]>=0 && nextCord[0]<B&& nextCord[1]<A){
                        if(checkMap[nextCord[0]][nextCord[1]]==0){
                            checkMap[robot.y][robot.x] = 1;
                            checkMap[nextCord[0]][nextCord[1]] = o.robotIndex+1;
                            robot.doCommand("F");
                        }
                        else{
                            System.out.println(String.format("Robot %d crashes into robot %d",o.robotIndex+1,checkMap[nextCord[0]][nextCord[1]]));
                            return;
                        }
                    }
                    else{
                        System.out.println(String.format("Robot %d crashes into the wall",o.robotIndex+1));
                        return;
                    }
                }
                else{
                    robot.doCommand(o.command);
                }
            }
        }
        System.out.println("OK");
    }
    public static void main(String [] args) throws IOException {
        getAnswer();
    }
}
