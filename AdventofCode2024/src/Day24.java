import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: wangshengbin
 * @Date: 2024/12/24 16:12
 * @Description:
 */
public class Day24 {
    public static void main(String[] args) {
        String input = "x00: 1\n" +
                "x01: 0\n" +
                "x02: 0\n" +
                "x03: 1\n" +
                "x04: 1\n" +
                "x05: 1\n" +
                "x06: 0\n" +
                "x07: 0\n" +
                "x08: 1\n" +
                "x09: 1\n" +
                "x10: 0\n" +
                "x11: 1\n" +
                "x12: 0\n" +
                "x13: 0\n" +
                "x14: 1\n" +
                "x15: 1\n" +
                "x16: 1\n" +
                "x17: 1\n" +
                "x18: 0\n" +
                "x19: 0\n" +
                "x20: 0\n" +
                "x21: 0\n" +
                "x22: 1\n" +
                "x23: 1\n" +
                "x24: 1\n" +
                "x25: 1\n" +
                "x26: 1\n" +
                "x27: 1\n" +
                "x28: 0\n" +
                "x29: 1\n" +
                "x30: 1\n" +
                "x31: 0\n" +
                "x32: 1\n" +
                "x33: 0\n" +
                "x34: 0\n" +
                "x35: 0\n" +
                "x36: 0\n" +
                "x37: 1\n" +
                "x38: 1\n" +
                "x39: 0\n" +
                "x40: 0\n" +
                "x41: 0\n" +
                "x42: 0\n" +
                "x43: 1\n" +
                "x44: 1\n" +
                "y00: 1\n" +
                "y01: 1\n" +
                "y02: 1\n" +
                "y03: 1\n" +
                "y04: 0\n" +
                "y05: 0\n" +
                "y06: 0\n" +
                "y07: 0\n" +
                "y08: 0\n" +
                "y09: 1\n" +
                "y10: 0\n" +
                "y11: 1\n" +
                "y12: 0\n" +
                "y13: 0\n" +
                "y14: 1\n" +
                "y15: 0\n" +
                "y16: 0\n" +
                "y17: 0\n" +
                "y18: 0\n" +
                "y19: 1\n" +
                "y20: 0\n" +
                "y21: 0\n" +
                "y22: 0\n" +
                "y23: 0\n" +
                "y24: 0\n" +
                "y25: 1\n" +
                "y26: 1\n" +
                "y27: 0\n" +
                "y28: 1\n" +
                "y29: 0\n" +
                "y30: 1\n" +
                "y31: 0\n" +
                "y32: 1\n" +
                "y33: 1\n" +
                "y34: 0\n" +
                "y35: 1\n" +
                "y36: 1\n" +
                "y37: 1\n" +
                "y38: 0\n" +
                "y39: 1\n" +
                "y40: 0\n" +
                "y41: 1\n" +
                "y42: 1\n" +
                "y43: 0\n" +
                "y44: 1\n" +
                "\n" +
                "x07 AND y07 -> ncs\n" +
                "y24 AND x24 -> wrf\n" +
                "x19 XOR y19 -> tsm\n" +
                "x40 XOR y40 -> svt\n" +
                "rjf OR src -> dfv\n" +
                "fsf XOR fgs -> z44\n" +
                "mhc AND jqd -> qgn\n" +
                "nrr XOR sms -> kpp\n" +
                "y20 AND x20 -> ngc\n" +
                "y21 AND x21 -> hbc\n" +
                "sgj OR ptb -> rqf\n" +
                "hbc OR wdr -> gjn\n" +
                "tks XOR sbg -> z23\n" +
                "ddh AND tnm -> hgg\n" +
                "hsf OR bjw -> vbb\n" +
                "x15 XOR y15 -> vqs\n" +
                "x10 AND y10 -> dtm\n" +
                "vqs XOR vss -> z15\n" +
                "x29 XOR y29 -> mgd\n" +
                "srg OR cwb -> qtn\n" +
                "nmb OR mbk -> z45\n" +
                "dhs OR njq -> tng\n" +
                "jfw OR jrf -> vpd\n" +
                "x07 XOR y07 -> gck\n" +
                "tdw XOR vrk -> z03\n" +
                "y11 AND x11 -> ffw\n" +
                "x16 XOR y16 -> bth\n" +
                "x39 XOR y39 -> tnm\n" +
                "cfg AND ngh -> jrq\n" +
                "vpd AND mvn -> hbj\n" +
                "rgp XOR bth -> z16\n" +
                "qtn AND cjd -> vrv\n" +
                "x14 AND y14 -> cgt\n" +
                "dwh XOR hsk -> z24\n" +
                "tgp XOR dkh -> z13\n" +
                "y26 XOR x26 -> cfg\n" +
                "cpc XOR nbm -> z42\n" +
                "y42 XOR x42 -> cpc\n" +
                "x17 XOR y17 -> cjd\n" +
                "rqf XOR pqn -> z36\n" +
                "x27 AND y27 -> nwg\n" +
                "bcq AND hnk -> vjp\n" +
                "tks AND sbg -> wqr\n" +
                "wvr OR skq -> gmw\n" +
                "cwm AND tpv -> pqw\n" +
                "x41 AND y41 -> tqh\n" +
                "jcw AND wpk -> sbr\n" +
                "tgp AND dkh -> tbh\n" +
                "wrg XOR nwq -> z38\n" +
                "y32 XOR x32 -> gds\n" +
                "bmn OR hbj -> msb\n" +
                "wps XOR mtn -> z33\n" +
                "ncs OR pjf -> sws\n" +
                "wqr OR tqk -> dwh\n" +
                "x31 AND y31 -> pwg\n" +
                "y12 XOR x12 -> jcw\n" +
                "nrr AND sms -> z31\n" +
                "x38 AND y38 -> npd\n" +
                "y02 AND x02 -> fwt\n" +
                "y37 AND x37 -> rnc\n" +
                "fwt OR vtm -> tdw\n" +
                "x38 XOR y38 -> nwq\n" +
                "gds AND ghr -> ckd\n" +
                "ffw OR nfb -> wpk\n" +
                "ctv XOR wht -> z05\n" +
                "y11 XOR x11 -> cmg\n" +
                "y05 XOR x05 -> ctv\n" +
                "jhw XOR tcv -> z18\n" +
                "wrf OR gnt -> rmw\n" +
                "y01 AND x01 -> tnr\n" +
                "x36 XOR y36 -> pqn\n" +
                "gjq OR dfg -> skp\n" +
                "x40 AND y40 -> ptg\n" +
                "y39 AND x39 -> dqn\n" +
                "bjb OR hjf -> sbg\n" +
                "rrn OR rpt -> qfs\n" +
                "ctv AND wht -> dhs\n" +
                "sgs AND rsb -> ccw\n" +
                "rmw XOR psg -> z25\n" +
                "y24 XOR x24 -> hsk\n" +
                "bgd XOR msb -> z10\n" +
                "y17 AND x17 -> fvv\n" +
                "y22 AND x22 -> kdh\n" +
                "qfs AND rfv -> fgp\n" +
                "wds AND fps -> rhr\n" +
                "y18 XOR x18 -> tcv\n" +
                "ttd AND nhg -> tfw\n" +
                "bbc AND jkb -> ptb\n" +
                "djn OR tnr -> cpb\n" +
                "y35 XOR x35 -> bbc\n" +
                "tfw OR cgt -> z14\n" +
                "rgp AND bth -> srg\n" +
                "dwh AND hsk -> gnt\n" +
                "pqw OR ngc -> frt\n" +
                "y25 XOR x25 -> psg\n" +
                "y13 XOR x13 -> tgp\n" +
                "x30 XOR y30 -> rbw\n" +
                "vrv OR fvv -> jhw\n" +
                "skp XOR mgd -> z29\n" +
                "cmg XOR ntv -> z11\n" +
                "vjr XOR vbb -> z04\n" +
                "gkj XOR sws -> z08\n" +
                "x20 XOR y20 -> tpv\n" +
                "ntv AND cmg -> nfb\n" +
                "x32 AND y32 -> tdk\n" +
                "wmr AND cpb -> vtm\n" +
                "x19 AND y19 -> jps\n" +
                "jhw AND tcv -> rqv\n" +
                "y27 XOR x27 -> bcq\n" +
                "x34 AND y34 -> hdk\n" +
                "wqc XOR qtf -> z01\n" +
                "wgk OR sbr -> dkh\n" +
                "x43 AND y43 -> kdb\n" +
                "y04 XOR x04 -> vjr\n" +
                "rmw AND psg -> fgg\n" +
                "gkj AND sws -> jfw\n" +
                "cwm XOR tpv -> z20\n" +
                "cjd XOR qtn -> z17\n" +
                "fsf AND fgs -> nmb\n" +
                "wps AND mtn -> rpt\n" +
                "x33 XOR y33 -> mtn\n" +
                "bcq XOR hnk -> z27\n" +
                "tbh OR wwk -> nhg\n" +
                "twb XOR tsm -> z19\n" +
                "frt AND mhw -> wdr\n" +
                "y15 AND x15 -> pwr\n" +
                "rbw XOR dfv -> z30\n" +
                "vss AND vqs -> ctt\n" +
                "x28 AND y28 -> gjq\n" +
                "y28 XOR x28 -> dvf\n" +
                "bbc XOR jkb -> sgj\n" +
                "x43 XOR y43 -> fps\n" +
                "y04 AND x04 -> khw\n" +
                "pwg OR kpp -> ghr\n" +
                "x31 XOR y31 -> nrr\n" +
                "gmw XOR gck -> z07\n" +
                "frt XOR mhw -> z21\n" +
                "spb AND tng -> skq\n" +
                "svt AND hkg -> knf\n" +
                "gjn AND kdh -> bjb\n" +
                "qfs XOR rfv -> z34\n" +
                "cpc AND nbm -> jtt\n" +
                "tqh OR ccw -> nbm\n" +
                "jtt OR qkv -> wds\n" +
                "gds XOR ghr -> z32\n" +
                "rbw AND dfv -> qnv\n" +
                "msb AND bgd -> gjr\n" +
                "qnv OR bjd -> sms\n" +
                "y18 AND x18 -> pns\n" +
                "x41 XOR y41 -> rsb\n" +
                "x26 AND y26 -> srh\n" +
                "nvc OR npd -> ddh\n" +
                "dtm OR gjr -> ntv\n" +
                "x08 AND y08 -> jrf\n" +
                "y14 XOR x14 -> ttd\n" +
                "y06 AND x06 -> wvr\n" +
                "y16 AND x16 -> cwb\n" +
                "rnc OR qgn -> wrg\n" +
                "y30 AND x30 -> bjd\n" +
                "jqd XOR mhc -> z37\n" +
                "ddh XOR tnm -> z39\n" +
                "x12 AND y12 -> wgk\n" +
                "cqh OR fgg -> ngh\n" +
                "kdh XOR gjn -> z22\n" +
                "x01 XOR y01 -> wqc\n" +
                "khw OR djm -> wht\n" +
                "ctt OR pwr -> rgp\n" +
                "y21 XOR x21 -> mhw\n" +
                "vjp OR nwg -> dhh\n" +
                "x02 XOR y02 -> wmr\n" +
                "gck AND gmw -> pjf\n" +
                "rqv OR pns -> twb\n" +
                "y00 AND x00 -> qtf\n" +
                "y05 AND x05 -> njq\n" +
                "y29 AND x29 -> rjf\n" +
                "vrk AND tdw -> hsf\n" +
                "y42 AND x42 -> qkv\n" +
                "y10 XOR x10 -> bgd\n" +
                "cfg XOR ngh -> z26\n" +
                "tng XOR spb -> z06\n" +
                "y00 XOR x00 -> z00\n" +
                "cpb XOR wmr -> z02\n" +
                "ckd OR tdk -> wps\n" +
                "jrq OR srh -> hnk\n" +
                "y22 XOR x22 -> hjf\n" +
                "x03 AND y03 -> bjw\n" +
                "nhg XOR ttd -> vss\n" +
                "tsm AND twb -> rwg\n" +
                "dqn OR hgg -> hkg\n" +
                "y34 XOR x34 -> rfv\n" +
                "y35 AND x35 -> z35\n" +
                "x25 AND y25 -> cqh\n" +
                "y33 AND x33 -> rrn\n" +
                "wqc AND qtf -> djn\n" +
                "sgs XOR rsb -> z41\n" +
                "x08 XOR y08 -> gkj\n" +
                "rwg OR jps -> cwm\n" +
                "rqf AND pqn -> wbv\n" +
                "x37 XOR y37 -> mhc\n" +
                "dvf XOR dhh -> z28\n" +
                "kdb OR rhr -> fgs\n" +
                "knf OR ptg -> sgs\n" +
                "svt XOR hkg -> z40\n" +
                "y13 AND x13 -> wwk\n" +
                "y23 AND x23 -> tqk\n" +
                "fgp OR hdk -> jkb\n" +
                "jcw XOR wpk -> z12\n" +
                "y06 XOR x06 -> spb\n" +
                "x23 XOR y23 -> tks\n" +
                "y09 AND x09 -> bmn\n" +
                "wds XOR fps -> z43\n" +
                "dhh AND dvf -> dfg\n" +
                "mgd AND skp -> src\n" +
                "wrg AND nwq -> nvc\n" +
                "y03 XOR x03 -> vrk\n" +
                "y36 AND x36 -> kqk\n" +
                "vjr AND vbb -> djm\n" +
                "x44 XOR y44 -> fsf\n" +
                "x44 AND y44 -> mbk\n" +
                "kqk OR wbv -> jqd\n" +
                "vpd XOR mvn -> z09\n" +
                "y09 XOR x09 -> mvn";

        String[] split = input.split("\n\n");

        String[] split1 = split[0].split("\\n");
        Map<String, Integer> map = new HashMap<>();
        for (String s : split1) {
            String[] split2 = s.split(": ");
            map.put(split2[0], Integer.parseInt(split2[1]));
        }
        String[] split2 = split[1].split("\\n");

        Map<String, String> map1 = new HashMap<>();

        for (String s : split2) {
            String[] split3 = s.split(" -> ");
            String c = split3[1];
            map1.put(c, split3[0]);
        }

        long answer1 = solutionForPartOne(map, map1);
        System.out.println(answer1);

    }

    static Map<String, Integer> MAP;
    static Map<String, String> WiredGates;

    public static long solutionForPartOne(Map<String, Integer> map, Map<String, String> wiredGates) {
        MAP = new HashMap<>(map);
        WiredGates = new HashMap<>(wiredGates);
        String resStr = "";

        wiredGates.forEach((c, v) -> {
            String[] split = v.split(" ");
            String a = split[0];
            String m = split[1];
            String b = split[2];
            MAP.put(c, cal(a, b, m));
        });

        List<String> list = new ArrayList<>();
        List<String> finalList = list;
        MAP.forEach((k, v) -> {
            if (k.startsWith("z")) {
                finalList.add(k);
            }
        });
        list = list.stream().sorted().collect(Collectors.toList());

        for (int i = list.size() - 1; i >= 0; i--) {
            resStr = resStr.concat(String.valueOf(MAP.get(list.get(i))));
        }

        return Long.parseLong(resStr, 2);
    }

    public static int cal(String a, String b, String m) {
        int aV;
        if (MAP.containsKey(a)) {
            aV = MAP.get(a);
        } else {
            aV = dfs(a);
        }

        int bV;
        if (MAP.containsKey(b)) {
            bV = MAP.get(b);
        } else {
            bV = dfs(b);
        }

        if (Objects.equals(m, "AND")) {
            if (Objects.equals(aV, 1) && Objects.equals(bV, 1)) {
                return 1;
            }
        }
        if (Objects.equals(m, "OR")) {
            if (Objects.equals(aV, 1) || Objects.equals(bV, 1)) {
                return 1;
            }
        }
        if (Objects.equals(m, "XOR")) {
            if (!Objects.equals(aV, bV)) {
                return 1;
            }
        }
        return 0;
    }

    public static int dfs(String val) {
        String input = WiredGates.get(val);
        String[] split = input.split(" ");
        String a = split[0];
        String m = split[1];
        String b = split[2];
        return cal(a, b, m);
    }


}
