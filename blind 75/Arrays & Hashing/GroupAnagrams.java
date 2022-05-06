import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] char1 = str.toCharArray();
            Arrays.sort(char1);
            String new_str = new String(char1);

            if (map.isEmpty()) {
                List<String> new_list = new ArrayList<String>();
                new_list.add(str);
                map.put(new_str, new_list);
            } else {
                Boolean isFound = false;
                if (map.containsKey(new_str)) {
                    map.get(new_str).add(str);
                    isFound = true;
                }
                if (!isFound) {
                    List<String> new_list = new ArrayList<String>();
                    new_list.add(str);
                    map.put(new_str, new_list);
                }
            }
        }

        for (List<String> cur_list : map.values()) {
            list.add(cur_list);
        }

        return list;
    }
}
