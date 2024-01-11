/*
 * Click `Run` to execute the snippet below!
 */

import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;



/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */



// cost_matrix = {0, 1, 3, 2};

// time_matrix = {3, 2, 1, 1};



class Databricks {

//    public class Pair<K, V> {
//
//        private final K element0;
//        private final V element1;
//
//        public Pair(K element0, V element1) {
//            this.element0 = element0;
//            this.element1 = element1;
//        }
//
//        public K getKey() {
//            return element0;
//        }
//
//        public V getValue() {
//            return element1;
//        }
//    }
    static int [] xDir = {-1, 0, 1, 0};
    static int [] yDir = {0, 1, 0, -1};


    static Map<Character, Pair<Integer, Integer>> mp = new HashMap<>();


    public static void main(String[] args) {

        char [][] grid  = {
                {'3', '3', 'S', '2', 'X', 'X'},
                {'3', '1', '1', '2', 'X', '2'},
                {'3', '1', '1', '2', '2', '2'},
                {'3', '1', '1', '1', 'D', '3'},
                {'3', '3', '3', '3', '3', '4'},
                {'4', '4', '4', '4', '4', '4'}
        };

         int [] cost_matrix = {0, 1, 3, 2};

        int []time_matrix = {3, 2, 1, 1};
        int m = grid.length;
        int n = grid[0].length;

        Pair<Integer, Integer> source = getLocation(grid, 'S');
        Pair<Integer, Integer> destination = getLocation(grid,'D');
        int minTime = Integer.MAX_VALUE;
        int minCost = Integer.MAX_VALUE;
        char result='-';
        for(int i=0;i<4;i++){
            int x = source.getKey()+xDir[i];
            int y = source.getValue()+yDir[i];

            if(isValid(x, y, m, n)){
                int hop = getMinHop(grid,m, n, source, destination, grid[x][y]);
                System.out.println(hop+"  "+grid[x][y]);
                int indx= (int)grid[x][y]-48;
                System.out.println(indx);
                int time = hop*time_matrix[indx-1];
                int cost = hop*cost_matrix[indx-1];
                System.out.println("time & cost = "+ time+"    "+cost);
                if(minTime>time){
                    result= grid[x][y];
                    minTime = Math.min(time, minTime);
                }
                else if(minTime==time && minCost> cost){
                    result= grid[x][y];
                    minCost = Math.min(cost, minCost);
                }

            }
        }
        System.out.println(result);
        System.out.println("hello");
    }


    public static int getMinHop(char[][] grid, int m, int n, Pair<Integer, Integer> source, Pair<Integer, Integer>destination, char medium){

        int [][] visited = new int [m][n];
        Queue<Pair<Pair<Integer, Integer>, Integer>> q = new LinkedList<>();
        q.add(new Pair(source, 0));
        visited[source.getKey()][source.getValue()]=1;
        while(q.size()>0){
            Pair<Pair<Integer, Integer>, Integer> curr = q.remove();
            Pair<Integer, Integer> location = curr.getKey();
            int hop =  curr.getValue();
            for(int i=0;i<4;i++){
                int x = location.getKey()+ xDir[i];
                int y = location.getValue()+yDir[i];
                if(isValid(x,y,m,n) && visited[x][y]==0){
                    if(x==destination.getKey() && y==destination.getValue()){
                        return hop;
                    } else if(grid[x][y]==medium){
                        q.add(new Pair(new Pair(x,y), hop+1));
                        visited[x][y]=1;

                    }
                }
            }
        }
        return -1;
    }

    public static boolean isValid(int x, int y , int m , int n){
        return (x>=0 && x<m && y>=0 && y<n);
    }

    public static Pair<Integer, Integer> getLocation(char[][] grid, char search){
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==search){
                    return new Pair(i,j);
                }
            }
        }
        return new Pair(-1,-1);
    }
}





/*
You live in San Francisco city and want to minimize your commute time to the Databricks HQ.

Given a 2D matrix of the San Francisco grid and the time as well as cost matrix of all the available transportation
modes, return the fastest mode of transportation. If there are multiple such modes then return one with the least cost.


Rules:
1. The input grid represents the city blocks, so the commuter is only allowed to travel along the horizontal and vertical axes.
Diagonal traversal is not permitted.
2. The commuter can only move to the neighboring cells with the same transportation mode.

Sample Input:

2D Grid:              Legend:
|3|3|S|2|X|X|         X = Roadblock
|3|1|1|2|X|2|         S = Source
|3|1|1|2|2|2|         D = Destination
|3|1|1|1|D|3|         1 = Walk, 2 = Bike, 3 = Car, 4 = Train
|3|3|3|3|3|4|
|4|4|4|4|4|4|

Transportation Modes:        ["Walk", "Bike", "Car", "Train"]
Cost Matrix (Dollars/Block): [0,      1,      3,     2]
Time Matrix (Minutes/Block): [3,      2,      1,     1]

NOTE: In this example, we are only counting the blocks between 'S' and 'D' to compute the minimum time & dollar cost.

Sample Output: Bike
*/





/*
  => source =>
  1 => 4  => <0 12>
  2 => 4. => <4, 8>

 */

