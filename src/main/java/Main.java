import Greedy.GreedyP1N1323;
import ZLeetcode.No88MergeSortedArray;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello LeetCode");
        var t = new GreedyP1N1323();
        var r = t.findMaxNum(6699);
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

