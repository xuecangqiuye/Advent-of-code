import java.util.Objects;

/**
 * @Author: wangshengbin
 * @Date: 2025/12/2 16:35
 * @Description:
 */
public class Day2 {

    public static void main(String[] args) {
        String input = "2157315-2351307,9277418835-9277548385,4316210399-4316270469,5108-10166,872858020-872881548,537939-575851,712-1001,326613-416466,53866-90153,907856-1011878,145-267,806649-874324,6161532344-6161720341,1-19,543444404-543597493,35316486-35418695,20-38,84775309-84908167,197736-309460,112892-187377,336-552,4789179-4964962,726183-793532,595834-656619,1838-3473,3529-5102,48-84,92914229-92940627,65847714-65945664,64090783-64286175,419838-474093,85-113,34939-52753,14849-30381";

        String input1 = "11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124";


        String[] split = input.split(",");

        long count = partOne(split);
        System.out.println(count);

        long l = partTwo(split);
        System.out.println(l);
    }

    private static long partOne(String[] ranges) {
        long res = 0;
        for (String range : ranges) {
            String[] split = range.split("-");
            long start = Long.parseLong(split[0]);
            long end = Long.parseLong(split[1]);
            for (long i = start; i <= end; i++) {
                if (check(String.valueOf(i))) {
                    res += i;
                }
            }
        }
        return res;
    }


    private static boolean check(String num) {
        if (num.length() % 2 == 1) return false;
        int r = num.length() - 1;
        int l = (num.length() - 1) / 2;
        while (l >= 0) {
            if (Objects.equals(num.charAt(r), num.charAt(l))) {
                r--;
                l--;
            } else {
                return false;
            }
        }
        return true;
    }

    private static long partTwo(String[] ranges) {
        long res = 0;
        for (String range : ranges) {
            String[] split = range.split("-");
            long start = Long.parseLong(split[0]);
            long end = Long.parseLong(split[1]);

            for (long i = start; i <= end; i++) {
                if (validCheck(String.valueOf(i))) {
                    res += i;
                }
            }
        }
        return res;
    }

    private static boolean validCheck(String num) {
        for (int i = 1; i <= num.length() / 2; i++) {
            if (num.length() % i != 0) continue;
            String pattern1 = num.substring(0, i);
            boolean matched = true;
            for (int j = i; j <= num.length() - i; j += i) {
                String pattern2 = num.substring(j, j + i);
                if (!Objects.equals(pattern1, pattern2)) {
                    matched = false;
                    break;
                }
            }
            if (matched) return true;
        }
        return false;
    }

}
