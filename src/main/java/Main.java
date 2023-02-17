import Greedy.GreedyP1N1323;
import Hashing.CountingE4N560;
import LinkedList.ListNode;
import LinkedList.ReverseE1N24;
import ZLeetcode.No88MergeSortedArray;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello LeetCode");
        var t = new ReverseE1N24();
        var l4 = new ListNode(4, null);
        var l3 = new ListNode(3, l4);
        var l2 = new ListNode(2, l3);
        var l1 = new ListNode(1, l2);
        t.swapPairs(l1);
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

