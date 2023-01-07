package Heap;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * K Closest Points to Origin
 *
 * Solution
 * Given an array of points where points[i] = [xi, yi]
 * represents a point on the X-Y plane and an integer k,
 * return the k closest points to the origin (0, 0).
 *
 * The distance between two points on the X-Y plane
 * is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
 *
 * You may return the answer in any order.
 * The answer is guaranteed to be unique (except for the order that it is in).
 *
 * 难点在于用最小堆时如何判断大小！！！不能一直试
 * 升序：< return -1, = return 0, > return 1
 * 降序：< return 1, = return 0, > return -1
 */
public class TopKP2N973 {
    public int[][] kClosest(int[][] points, int k) {
        class Point {
            int x, y;
            double distance() {
                double x = this.x;
                double y = this.y;
                return Math.sqrt(x * x + y * y);
            }
        }
        Set<Point> pointSet = new HashSet<Point>();
        for(var point : points) {
            var p = new Point();
            p.x = point[0];
            p.y = point[1];
            pointSet.add(p);
        }
        var minHeap = new PriorityQueue<Point>((a, b) -> {
            if(a.distance() > b.distance()) {
                return 1;
            } else if(a.distance() < b.distance()) {
                return -1;
            } else {
                return 0;
            }
        });
        for(var p : pointSet) {
            minHeap.add(p);
        }
        while(minHeap.size() > k) {
            minHeap.remove();
        }
        int[][] ret = new int[k][2];
        int i = 0;
        while(minHeap.size() > 0) {
            var p = minHeap.remove();
            ret[i][0] = p.x;
            ret[i][1] = p.y;
            i++;
        }
        return ret;
    }
}
