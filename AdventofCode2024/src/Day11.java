import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: wangshengbin
 * @Date: 2024/12/11 16:50
 * @Description:
 */
public class Day11 {

    public static void main(String[] args) {
        String str = "5178527 8525 22 376299 3 69312 0 275";
        String[] split = str.split(" ");
        List<String> collect = Stream.of(split).collect(Collectors.toList());
        Long l = solution(collect);
        System.out.println(l);
    }


    static Map<String, Long> map = new HashMap<>();

    public static Long solution(List<String> list) {
        Long res = 0L;
        for (String s : list) {
            res += dfs(s, 0);
        }
        return res;
    }

    static int allTimes = 75;

    public static Long dfs(String s, int cur) {
        if (cur == allTimes) {
            return 1L;
        }


        String key = s.concat("_").concat(String.valueOf(cur));
        if (map.containsKey(key)) {
            return map.get(key);
        }

        if (s.equals("0")) {

            s = "1";
            Long dfs = dfs(s, ++cur);
            map.put(key, dfs);
            return dfs;
        }
        int length = s.length();
        if (length % 2 == 0) {
            String s1 = s.substring(0, length / 2);
            String s2 = Long.valueOf(s.substring(length / 2)).toString();

            ++cur;
            Long a = dfs(s1, cur);
            Long b = dfs(s2, cur);
            map.put(key, a + b);
            return a + b;
        }
        long i = Long.parseLong(s) * 2024;
        String s1 = Long.toString(i);
        Long dfs = dfs(s1, ++cur);
        map.put(key, dfs);
        return dfs;
    }
}

