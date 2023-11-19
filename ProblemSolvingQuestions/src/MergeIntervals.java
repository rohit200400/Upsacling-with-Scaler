import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        int arr[][] = {{1,3},{8, 10}, {2, 6},{15,18} };
        int out[][] = merge(arr);
        System.out.println(out);
    }
    public static int[][] merge(int[][] intervals) {
        if(intervals.length == 1) return intervals;
        // sorting based on the first element
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> items = new ArrayList<>();
        for(int i = 0; i < intervals.length-1; i++){
            if(intervals[i+1][0] <= intervals[i][1]){
                intervals[i+1][0] = Math.min(intervals[i][0],intervals[i+1][0]);
                intervals[i+1][1] = Math.max(intervals[i][1],intervals[i+1][1]);
            }
            else{
                items.add(intervals[i]);
            }
        }
        items.add(intervals[intervals.length-1]);
        int[][] out = new int[items.size()][2];

        for(int i = 0; i < items.size(); i++){
            out[i] = new int[]{items.get(i)[0], items.get(i)[1]};
        }
        return out;
    }
}
