import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class PairSort implements Comparator<Pair<Integer, Integer>>{
    @Override
    public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
        if(p1.getKey()==p2.getKey()){
            return p1.getValue()-p2.getValue();
        }else{
            return p1.getKey()-p2.getKey();
        }
    }
}
class Solution {
    public static void main(String[] args) {

        /*
        [[4, 6], [1, 3], [2,4], [3,4]]
=> [] => 0

[[1, 3], [5, 7], [4, 6], [7, 9], [9, 10]]

[[12, 15], [1, 12], [2, 3], [4, 7], [14, 16], [3, 4], [15, 17]]
         */
        System.out.println("Hello, World");
//        List<List<Integer>> input = List.of(List.of(1,3), List.of(4,6));
//        List<List<Integer>> input = List.of(List.of(1,3), List.of(4,6), List.of(3,4), List.of(2,4), List.of(2,4));
//        List<List<Integer>> input = List.of(List.of(1,3), List.of(5,7), List.of(4,6), List.of(7,9), List.of(9,10));
        List<List<Integer>> input = List.of(List.of(12,15), List.of(1,12), List.of(2,3), List.of(4,7), List.of(14,16), List.of(3,4), List.of(15,17));
        System.out.println(getMeeting(input));

    }

    public static int getMeeting(List<List<Integer>> lst){
        List<Pair<Integer, Integer>> entry = new ArrayList<>();
        for(int i=0;i<lst.size();i++){
            entry.add(new Pair(lst.get(i).get(0), 1));
            entry.add(new Pair(lst.get(i).get(1), 0));
        }

        Collections.sort(entry, new PairSort());
        System.out.println("entry = " + entry);
        int mx = 0;
        int res = 0;
        for(int i=0;i<entry.size();i++){
            Pair<Integer, Integer> curr = entry.get(i);
            if(curr.getValue()==0){
                res--;
            }else{
                res++;
            }
            mx = Math.max(mx, res);
        }
        return mx;
    }
}

