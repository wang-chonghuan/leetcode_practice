import ZLeetcode.No88MergeSortedArray;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello LeetCode");
        No88MergeSortedArray.test();
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

