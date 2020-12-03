import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution implements Comparator<int[]> {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0)
            return new int[0][2];
        Arrays.sort(intervals, this::compare);
        ArrayList<int[]> res = new ArrayList<>();
        for(int i=0;i<intervals.length;++i)
        {
            int l = intervals[i][0], r = intervals[i][1];
            if(res.size() == 0 || res.get(res.size()-1)[1]<l)
                res.add(intervals[i]);
            else
                res.get(res.size()-1)[1] = Math.max(res.get(res.size()-1)[1],r);
        }
        return res.toArray(new int[res.size()][2]);
    }
    public int compare(int[] a, int [] b)
    {
        return a[0]-b[0];
    }
}