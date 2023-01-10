import Greedy.GreedyP1N1323;
import Hashing.CountingE4N560;
import ZLeetcode.No88MergeSortedArray;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello LeetCode");
        var t = new CountingE4N560();
        var p1 = new int[]{-1, -1, 1};
        var r = t.subarraySum(p1, 1);
        System.out.println(r);
    }
}

class HonoursCourse {
    private List<Module> moduleList = new ArrayList<>();
    public boolean addModule(Module newModule) {
        if(moduleList.size() >= 6) {
            return false;
        } else {
            moduleList.add(newModule);
            return true;
        }
    }
}

