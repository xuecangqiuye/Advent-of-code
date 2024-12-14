import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @Author: wangshengbin
 * @Date: 2024/12/14 09:41
 * @Description:
 */
public class Day13 {

    public static void main(String[] args) {
        String input = "Button A: X+29, Y+71\n" +
                "Button B: X+52, Y+31\n" +
                "Prize: X=5388, Y=4716\n" +
                "\n" +
                "Button A: X+47, Y+16\n" +
                "Button B: X+14, Y+21\n" +
                "Prize: X=4795, Y=2996\n" +
                "\n" +
                "Button A: X+21, Y+11\n" +
                "Button B: X+12, Y+60\n" +
                "Prize: X=741, Y=2859\n" +
                "\n" +
                "Button A: X+61, Y+34\n" +
                "Button B: X+17, Y+50\n" +
                "Prize: X=2223, Y=12510\n" +
                "\n" +
                "Button A: X+49, Y+84\n" +
                "Button B: X+71, Y+22\n" +
                "Prize: X=6954, Y=8830\n" +
                "\n" +
                "Button A: X+63, Y+94\n" +
                "Button B: X+79, Y+28\n" +
                "Prize: X=3313, Y=2966\n" +
                "\n" +
                "Button A: X+63, Y+34\n" +
                "Button B: X+16, Y+47\n" +
                "Prize: X=2601, Y=19683\n" +
                "\n" +
                "Button A: X+58, Y+16\n" +
                "Button B: X+34, Y+69\n" +
                "Prize: X=1538, Y=782\n" +
                "\n" +
                "Button A: X+32, Y+13\n" +
                "Button B: X+33, Y+65\n" +
                "Prize: X=14263, Y=17657\n" +
                "\n" +
                "Button A: X+61, Y+12\n" +
                "Button B: X+28, Y+67\n" +
                "Prize: X=11219, Y=19511\n" +
                "\n" +
                "Button A: X+31, Y+67\n" +
                "Button B: X+63, Y+23\n" +
                "Prize: X=12991, Y=911\n" +
                "\n" +
                "Button A: X+13, Y+29\n" +
                "Button B: X+55, Y+38\n" +
                "Prize: X=2352, Y=12511\n" +
                "\n" +
                "Button A: X+55, Y+31\n" +
                "Button B: X+26, Y+45\n" +
                "Prize: X=8031, Y=11372\n" +
                "\n" +
                "Button A: X+27, Y+17\n" +
                "Button B: X+21, Y+46\n" +
                "Prize: X=13241, Y=17761\n" +
                "\n" +
                "Button A: X+17, Y+36\n" +
                "Button B: X+57, Y+29\n" +
                "Prize: X=9818, Y=2628\n" +
                "\n" +
                "Button A: X+26, Y+43\n" +
                "Button B: X+53, Y+23\n" +
                "Prize: X=9328, Y=13971\n" +
                "\n" +
                "Button A: X+22, Y+80\n" +
                "Button B: X+80, Y+64\n" +
                "Prize: X=5684, Y=5920\n" +
                "\n" +
                "Button A: X+45, Y+98\n" +
                "Button B: X+94, Y+37\n" +
                "Prize: X=9896, Y=6625\n" +
                "\n" +
                "Button A: X+13, Y+67\n" +
                "Button B: X+67, Y+15\n" +
                "Prize: X=4487, Y=19239\n" +
                "\n" +
                "Button A: X+49, Y+13\n" +
                "Button B: X+22, Y+44\n" +
                "Prize: X=8574, Y=8268\n" +
                "\n" +
                "Button A: X+46, Y+16\n" +
                "Button B: X+17, Y+69\n" +
                "Prize: X=15584, Y=17398\n" +
                "\n" +
                "Button A: X+71, Y+85\n" +
                "Button B: X+90, Y+31\n" +
                "Prize: X=12308, Y=7751\n" +
                "\n" +
                "Button A: X+55, Y+26\n" +
                "Button B: X+33, Y+59\n" +
                "Prize: X=3036, Y=5211\n" +
                "\n" +
                "Button A: X+33, Y+71\n" +
                "Button B: X+85, Y+43\n" +
                "Prize: X=5600, Y=3376\n" +
                "\n" +
                "Button A: X+47, Y+65\n" +
                "Button B: X+83, Y+24\n" +
                "Prize: X=4787, Y=4623\n" +
                "\n" +
                "Button A: X+64, Y+69\n" +
                "Button B: X+87, Y+13\n" +
                "Prize: X=6933, Y=3354\n" +
                "\n" +
                "Button A: X+86, Y+11\n" +
                "Button B: X+19, Y+62\n" +
                "Prize: X=3043, Y=3189\n" +
                "\n" +
                "Button A: X+88, Y+21\n" +
                "Button B: X+19, Y+36\n" +
                "Prize: X=3247, Y=2946\n" +
                "\n" +
                "Button A: X+12, Y+31\n" +
                "Button B: X+62, Y+21\n" +
                "Prize: X=10044, Y=15067\n" +
                "\n" +
                "Button A: X+13, Y+34\n" +
                "Button B: X+65, Y+15\n" +
                "Prize: X=14563, Y=2264\n" +
                "\n" +
                "Button A: X+82, Y+26\n" +
                "Button B: X+37, Y+69\n" +
                "Prize: X=7403, Y=3779\n" +
                "\n" +
                "Button A: X+48, Y+76\n" +
                "Button B: X+44, Y+19\n" +
                "Prize: X=10552, Y=14750\n" +
                "\n" +
                "Button A: X+20, Y+72\n" +
                "Button B: X+42, Y+14\n" +
                "Prize: X=5892, Y=2256\n" +
                "\n" +
                "Button A: X+21, Y+67\n" +
                "Button B: X+60, Y+15\n" +
                "Prize: X=3891, Y=5357\n" +
                "\n" +
                "Button A: X+26, Y+56\n" +
                "Button B: X+64, Y+32\n" +
                "Prize: X=1574, Y=18312\n" +
                "\n" +
                "Button A: X+75, Y+34\n" +
                "Button B: X+14, Y+40\n" +
                "Prize: X=2859, Y=4022\n" +
                "\n" +
                "Button A: X+58, Y+51\n" +
                "Button B: X+31, Y+99\n" +
                "Prize: X=4132, Y=6216\n" +
                "\n" +
                "Button A: X+35, Y+61\n" +
                "Button B: X+62, Y+34\n" +
                "Prize: X=17642, Y=17366\n" +
                "\n" +
                "Button A: X+66, Y+23\n" +
                "Button B: X+15, Y+57\n" +
                "Prize: X=7568, Y=2293\n" +
                "\n" +
                "Button A: X+23, Y+68\n" +
                "Button B: X+47, Y+17\n" +
                "Prize: X=5337, Y=7242\n" +
                "\n" +
                "Button A: X+11, Y+59\n" +
                "Button B: X+73, Y+31\n" +
                "Prize: X=1976, Y=19532\n" +
                "\n" +
                "Button A: X+35, Y+89\n" +
                "Button B: X+43, Y+12\n" +
                "Prize: X=5090, Y=4669\n" +
                "\n" +
                "Button A: X+48, Y+70\n" +
                "Button B: X+57, Y+25\n" +
                "Prize: X=9210, Y=8200\n" +
                "\n" +
                "Button A: X+44, Y+80\n" +
                "Button B: X+95, Y+30\n" +
                "Prize: X=7211, Y=7830\n" +
                "\n" +
                "Button A: X+28, Y+17\n" +
                "Button B: X+30, Y+57\n" +
                "Prize: X=17276, Y=14123\n" +
                "\n" +
                "Button A: X+24, Y+99\n" +
                "Button B: X+74, Y+69\n" +
                "Prize: X=4472, Y=8997\n" +
                "\n" +
                "Button A: X+44, Y+79\n" +
                "Button B: X+83, Y+21\n" +
                "Prize: X=8621, Y=6389\n" +
                "\n" +
                "Button A: X+50, Y+29\n" +
                "Button B: X+18, Y+51\n" +
                "Prize: X=5272, Y=6262\n" +
                "\n" +
                "Button A: X+55, Y+22\n" +
                "Button B: X+27, Y+66\n" +
                "Prize: X=6449, Y=9098\n" +
                "\n" +
                "Button A: X+67, Y+48\n" +
                "Button B: X+29, Y+77\n" +
                "Prize: X=4049, Y=6724\n" +
                "\n" +
                "Button A: X+73, Y+12\n" +
                "Button B: X+22, Y+76\n" +
                "Prize: X=17384, Y=3832\n" +
                "\n" +
                "Button A: X+57, Y+24\n" +
                "Button B: X+13, Y+30\n" +
                "Prize: X=11289, Y=2744\n" +
                "\n" +
                "Button A: X+58, Y+83\n" +
                "Button B: X+97, Y+44\n" +
                "Prize: X=7205, Y=6613\n" +
                "\n" +
                "Button A: X+58, Y+23\n" +
                "Button B: X+14, Y+95\n" +
                "Prize: X=4604, Y=8266\n" +
                "\n" +
                "Button A: X+47, Y+78\n" +
                "Button B: X+29, Y+12\n" +
                "Prize: X=18393, Y=15038\n" +
                "\n" +
                "Button A: X+32, Y+24\n" +
                "Button B: X+12, Y+63\n" +
                "Prize: X=3716, Y=6405\n" +
                "\n" +
                "Button A: X+60, Y+82\n" +
                "Button B: X+89, Y+39\n" +
                "Prize: X=10051, Y=8861\n" +
                "\n" +
                "Button A: X+34, Y+69\n" +
                "Button B: X+77, Y+42\n" +
                "Prize: X=9646, Y=10206\n" +
                "\n" +
                "Button A: X+34, Y+48\n" +
                "Button B: X+91, Y+28\n" +
                "Prize: X=7490, Y=4144\n" +
                "\n" +
                "Button A: X+21, Y+93\n" +
                "Button B: X+38, Y+25\n" +
                "Prize: X=1912, Y=1733\n" +
                "\n" +
                "Button A: X+16, Y+71\n" +
                "Button B: X+64, Y+41\n" +
                "Prize: X=5872, Y=5888\n" +
                "\n" +
                "Button A: X+95, Y+83\n" +
                "Button B: X+22, Y+82\n" +
                "Prize: X=8676, Y=9024\n" +
                "\n" +
                "Button A: X+76, Y+34\n" +
                "Button B: X+14, Y+57\n" +
                "Prize: X=7858, Y=6103\n" +
                "\n" +
                "Button A: X+18, Y+48\n" +
                "Button B: X+49, Y+26\n" +
                "Prize: X=7233, Y=6394\n" +
                "\n" +
                "Button A: X+60, Y+22\n" +
                "Button B: X+12, Y+37\n" +
                "Prize: X=3816, Y=4594\n" +
                "\n" +
                "Button A: X+37, Y+81\n" +
                "Button B: X+65, Y+19\n" +
                "Prize: X=3109, Y=1751\n" +
                "\n" +
                "Button A: X+57, Y+63\n" +
                "Button B: X+11, Y+90\n" +
                "Prize: X=4465, Y=12330\n" +
                "\n" +
                "Button A: X+55, Y+22\n" +
                "Button B: X+32, Y+58\n" +
                "Prize: X=18992, Y=3264\n" +
                "\n" +
                "Button A: X+27, Y+90\n" +
                "Button B: X+85, Y+36\n" +
                "Prize: X=5030, Y=9594\n" +
                "\n" +
                "Button A: X+89, Y+39\n" +
                "Button B: X+16, Y+94\n" +
                "Prize: X=2210, Y=4274\n" +
                "\n" +
                "Button A: X+70, Y+42\n" +
                "Button B: X+18, Y+45\n" +
                "Prize: X=7150, Y=7368\n" +
                "\n" +
                "Button A: X+55, Y+35\n" +
                "Button B: X+14, Y+45\n" +
                "Prize: X=13106, Y=9340\n" +
                "\n" +
                "Button A: X+23, Y+56\n" +
                "Button B: X+69, Y+34\n" +
                "Prize: X=8219, Y=8774\n" +
                "\n" +
                "Button A: X+66, Y+20\n" +
                "Button B: X+24, Y+92\n" +
                "Prize: X=2736, Y=3032\n" +
                "\n" +
                "Button A: X+75, Y+24\n" +
                "Button B: X+23, Y+27\n" +
                "Prize: X=6819, Y=3714\n" +
                "\n" +
                "Button A: X+54, Y+76\n" +
                "Button B: X+79, Y+14\n" +
                "Prize: X=6844, Y=6328\n" +
                "\n" +
                "Button A: X+36, Y+63\n" +
                "Button B: X+49, Y+27\n" +
                "Prize: X=7784, Y=13157\n" +
                "\n" +
                "Button A: X+67, Y+18\n" +
                "Button B: X+15, Y+66\n" +
                "Prize: X=1604, Y=15416\n" +
                "\n" +
                "Button A: X+58, Y+28\n" +
                "Button B: X+12, Y+41\n" +
                "Prize: X=3908, Y=2802\n" +
                "\n" +
                "Button A: X+16, Y+85\n" +
                "Button B: X+32, Y+14\n" +
                "Prize: X=2400, Y=3546\n" +
                "\n" +
                "Button A: X+40, Y+23\n" +
                "Button B: X+35, Y+61\n" +
                "Prize: X=9350, Y=1199\n" +
                "\n" +
                "Button A: X+18, Y+36\n" +
                "Button B: X+40, Y+11\n" +
                "Prize: X=11872, Y=621\n" +
                "\n" +
                "Button A: X+79, Y+55\n" +
                "Button B: X+32, Y+88\n" +
                "Prize: X=7757, Y=10461\n" +
                "\n" +
                "Button A: X+87, Y+23\n" +
                "Button B: X+12, Y+79\n" +
                "Prize: X=2631, Y=3577\n" +
                "\n" +
                "Button A: X+11, Y+49\n" +
                "Button B: X+68, Y+30\n" +
                "Prize: X=15642, Y=2000\n" +
                "\n" +
                "Button A: X+47, Y+19\n" +
                "Button B: X+37, Y+64\n" +
                "Prize: X=12590, Y=18040\n" +
                "\n" +
                "Button A: X+91, Y+21\n" +
                "Button B: X+22, Y+53\n" +
                "Prize: X=2355, Y=2700\n" +
                "\n" +
                "Button A: X+11, Y+81\n" +
                "Button B: X+25, Y+29\n" +
                "Prize: X=867, Y=2507\n" +
                "\n" +
                "Button A: X+45, Y+34\n" +
                "Button B: X+13, Y+34\n" +
                "Prize: X=3230, Y=8812\n" +
                "\n" +
                "Button A: X+13, Y+29\n" +
                "Button B: X+86, Y+19\n" +
                "Prize: X=7194, Y=2739\n" +
                "\n" +
                "Button A: X+29, Y+12\n" +
                "Button B: X+42, Y+58\n" +
                "Prize: X=9035, Y=938\n" +
                "\n" +
                "Button A: X+18, Y+79\n" +
                "Button B: X+99, Y+75\n" +
                "Prize: X=8559, Y=7007\n" +
                "\n" +
                "Button A: X+39, Y+12\n" +
                "Button B: X+30, Y+73\n" +
                "Prize: X=18224, Y=4138\n" +
                "\n" +
                "Button A: X+47, Y+15\n" +
                "Button B: X+39, Y+46\n" +
                "Prize: X=5397, Y=3333\n" +
                "\n" +
                "Button A: X+11, Y+44\n" +
                "Button B: X+71, Y+22\n" +
                "Prize: X=626, Y=14004\n" +
                "\n" +
                "Button A: X+31, Y+70\n" +
                "Button B: X+38, Y+20\n" +
                "Prize: X=5135, Y=5870\n" +
                "\n" +
                "Button A: X+31, Y+64\n" +
                "Button B: X+46, Y+15\n" +
                "Prize: X=4718, Y=5317\n" +
                "\n" +
                "Button A: X+52, Y+15\n" +
                "Button B: X+34, Y+61\n" +
                "Prize: X=19776, Y=4845\n" +
                "\n" +
                "Button A: X+63, Y+21\n" +
                "Button B: X+18, Y+68\n" +
                "Prize: X=12698, Y=734\n" +
                "\n" +
                "Button A: X+11, Y+58\n" +
                "Button B: X+64, Y+24\n" +
                "Prize: X=19282, Y=4620\n" +
                "\n" +
                "Button A: X+11, Y+49\n" +
                "Button B: X+84, Y+30\n" +
                "Prize: X=8877, Y=7387\n" +
                "\n" +
                "Button A: X+16, Y+98\n" +
                "Button B: X+29, Y+27\n" +
                "Prize: X=1699, Y=8147\n" +
                "\n" +
                "Button A: X+68, Y+85\n" +
                "Button B: X+84, Y+17\n" +
                "Prize: X=1320, Y=1122\n" +
                "\n" +
                "Button A: X+47, Y+18\n" +
                "Button B: X+12, Y+19\n" +
                "Prize: X=9197, Y=14349\n" +
                "\n" +
                "Button A: X+18, Y+82\n" +
                "Button B: X+57, Y+57\n" +
                "Prize: X=4212, Y=8244\n" +
                "\n" +
                "Button A: X+21, Y+50\n" +
                "Button B: X+48, Y+21\n" +
                "Prize: X=19220, Y=13256\n" +
                "\n" +
                "Button A: X+15, Y+97\n" +
                "Button B: X+79, Y+42\n" +
                "Prize: X=4719, Y=6604\n" +
                "\n" +
                "Button A: X+37, Y+71\n" +
                "Button B: X+92, Y+58\n" +
                "Prize: X=4093, Y=4535\n" +
                "\n" +
                "Button A: X+16, Y+66\n" +
                "Button B: X+80, Y+21\n" +
                "Prize: X=17136, Y=1205\n" +
                "\n" +
                "Button A: X+40, Y+30\n" +
                "Button B: X+16, Y+55\n" +
                "Prize: X=1392, Y=2635\n" +
                "\n" +
                "Button A: X+38, Y+14\n" +
                "Button B: X+21, Y+41\n" +
                "Prize: X=17360, Y=12000\n" +
                "\n" +
                "Button A: X+22, Y+95\n" +
                "Button B: X+72, Y+21\n" +
                "Prize: X=2082, Y=7251\n" +
                "\n" +
                "Button A: X+64, Y+18\n" +
                "Button B: X+61, Y+89\n" +
                "Prize: X=4725, Y=3125\n" +
                "\n" +
                "Button A: X+18, Y+89\n" +
                "Button B: X+96, Y+50\n" +
                "Prize: X=7764, Y=9936\n" +
                "\n" +
                "Button A: X+64, Y+20\n" +
                "Button B: X+16, Y+87\n" +
                "Prize: X=6624, Y=7810\n" +
                "\n" +
                "Button A: X+49, Y+24\n" +
                "Button B: X+11, Y+56\n" +
                "Prize: X=7663, Y=19448\n" +
                "\n" +
                "Button A: X+80, Y+14\n" +
                "Button B: X+59, Y+64\n" +
                "Prize: X=6788, Y=6126\n" +
                "\n" +
                "Button A: X+90, Y+39\n" +
                "Button B: X+56, Y+90\n" +
                "Prize: X=13578, Y=11997\n" +
                "\n" +
                "Button A: X+17, Y+44\n" +
                "Button B: X+44, Y+21\n" +
                "Prize: X=16409, Y=13862\n" +
                "\n" +
                "Button A: X+30, Y+25\n" +
                "Button B: X+27, Y+81\n" +
                "Prize: X=4479, Y=8237\n" +
                "\n" +
                "Button A: X+34, Y+72\n" +
                "Button B: X+32, Y+11\n" +
                "Prize: X=17594, Y=6142\n" +
                "\n" +
                "Button A: X+22, Y+70\n" +
                "Button B: X+69, Y+12\n" +
                "Prize: X=4853, Y=1628\n" +
                "\n" +
                "Button A: X+44, Y+79\n" +
                "Button B: X+43, Y+13\n" +
                "Prize: X=5208, Y=13828\n" +
                "\n" +
                "Button A: X+29, Y+46\n" +
                "Button B: X+44, Y+21\n" +
                "Prize: X=16486, Y=17474\n" +
                "\n" +
                "Button A: X+91, Y+37\n" +
                "Button B: X+34, Y+98\n" +
                "Prize: X=7377, Y=6619\n" +
                "\n" +
                "Button A: X+19, Y+94\n" +
                "Button B: X+66, Y+63\n" +
                "Prize: X=4170, Y=10353\n" +
                "\n" +
                "Button A: X+93, Y+87\n" +
                "Button B: X+89, Y+17\n" +
                "Prize: X=6270, Y=1890\n" +
                "\n" +
                "Button A: X+37, Y+18\n" +
                "Button B: X+15, Y+48\n" +
                "Prize: X=11639, Y=11552\n" +
                "\n" +
                "Button A: X+31, Y+14\n" +
                "Button B: X+38, Y+67\n" +
                "Prize: X=2853, Y=13372\n" +
                "\n" +
                "Button A: X+42, Y+12\n" +
                "Button B: X+32, Y+58\n" +
                "Prize: X=11178, Y=16954\n" +
                "\n" +
                "Button A: X+49, Y+99\n" +
                "Button B: X+53, Y+12\n" +
                "Prize: X=7435, Y=9507\n" +
                "\n" +
                "Button A: X+43, Y+29\n" +
                "Button B: X+11, Y+39\n" +
                "Prize: X=14616, Y=1736\n" +
                "\n" +
                "Button A: X+39, Y+11\n" +
                "Button B: X+59, Y+79\n" +
                "Prize: X=6578, Y=7530\n" +
                "\n" +
                "Button A: X+73, Y+16\n" +
                "Button B: X+11, Y+62\n" +
                "Prize: X=4992, Y=7314\n" +
                "\n" +
                "Button A: X+78, Y+13\n" +
                "Button B: X+30, Y+51\n" +
                "Prize: X=5592, Y=4842\n" +
                "\n" +
                "Button A: X+74, Y+24\n" +
                "Button B: X+14, Y+94\n" +
                "Prize: X=1686, Y=8956\n" +
                "\n" +
                "Button A: X+31, Y+56\n" +
                "Button B: X+44, Y+20\n" +
                "Prize: X=19755, Y=17496\n" +
                "\n" +
                "Button A: X+39, Y+22\n" +
                "Button B: X+24, Y+58\n" +
                "Prize: X=2379, Y=1920\n" +
                "\n" +
                "Button A: X+28, Y+48\n" +
                "Button B: X+41, Y+23\n" +
                "Prize: X=17638, Y=290\n" +
                "\n" +
                "Button A: X+21, Y+44\n" +
                "Button B: X+43, Y+14\n" +
                "Prize: X=12687, Y=15890\n" +
                "\n" +
                "Button A: X+22, Y+13\n" +
                "Button B: X+20, Y+99\n" +
                "Prize: X=2730, Y=10157\n" +
                "\n" +
                "Button A: X+66, Y+17\n" +
                "Button B: X+77, Y+85\n" +
                "Prize: X=7447, Y=3417\n" +
                "\n" +
                "Button A: X+31, Y+15\n" +
                "Button B: X+28, Y+46\n" +
                "Prize: X=9921, Y=6127\n" +
                "\n" +
                "Button A: X+15, Y+53\n" +
                "Button B: X+64, Y+19\n" +
                "Prize: X=11172, Y=1343\n" +
                "\n" +
                "Button A: X+18, Y+75\n" +
                "Button B: X+66, Y+18\n" +
                "Prize: X=14042, Y=16058\n" +
                "\n" +
                "Button A: X+19, Y+90\n" +
                "Button B: X+66, Y+11\n" +
                "Prize: X=6241, Y=6337\n" +
                "\n" +
                "Button A: X+96, Y+80\n" +
                "Button B: X+17, Y+83\n" +
                "Prize: X=8419, Y=12729\n" +
                "\n" +
                "Button A: X+39, Y+48\n" +
                "Button B: X+51, Y+17\n" +
                "Prize: X=6522, Y=4869\n" +
                "\n" +
                "Button A: X+29, Y+15\n" +
                "Button B: X+16, Y+46\n" +
                "Prize: X=8057, Y=12355\n" +
                "\n" +
                "Button A: X+17, Y+44\n" +
                "Button B: X+44, Y+24\n" +
                "Prize: X=1866, Y=12616\n" +
                "\n" +
                "Button A: X+21, Y+44\n" +
                "Button B: X+66, Y+30\n" +
                "Prize: X=9695, Y=1532\n" +
                "\n" +
                "Button A: X+54, Y+21\n" +
                "Button B: X+20, Y+49\n" +
                "Prize: X=2434, Y=6402\n" +
                "\n" +
                "Button A: X+55, Y+66\n" +
                "Button B: X+55, Y+18\n" +
                "Prize: X=5060, Y=2568\n" +
                "\n" +
                "Button A: X+70, Y+11\n" +
                "Button B: X+14, Y+57\n" +
                "Prize: X=9832, Y=524\n" +
                "\n" +
                "Button A: X+18, Y+73\n" +
                "Button B: X+65, Y+17\n" +
                "Prize: X=13511, Y=4266\n" +
                "\n" +
                "Button A: X+14, Y+69\n" +
                "Button B: X+62, Y+33\n" +
                "Prize: X=3316, Y=6258\n" +
                "\n" +
                "Button A: X+71, Y+16\n" +
                "Button B: X+31, Y+37\n" +
                "Prize: X=6052, Y=1724\n" +
                "\n" +
                "Button A: X+41, Y+63\n" +
                "Button B: X+50, Y+14\n" +
                "Prize: X=6977, Y=6951\n" +
                "\n" +
                "Button A: X+44, Y+21\n" +
                "Button B: X+16, Y+38\n" +
                "Prize: X=15596, Y=7785\n" +
                "\n" +
                "Button A: X+44, Y+80\n" +
                "Button B: X+45, Y+14\n" +
                "Prize: X=18455, Y=16762\n" +
                "\n" +
                "Button A: X+64, Y+28\n" +
                "Button B: X+11, Y+29\n" +
                "Prize: X=5092, Y=18412\n" +
                "\n" +
                "Button A: X+49, Y+30\n" +
                "Button B: X+18, Y+61\n" +
                "Prize: X=2349, Y=4287\n" +
                "\n" +
                "Button A: X+78, Y+39\n" +
                "Button B: X+16, Y+55\n" +
                "Prize: X=18792, Y=11304\n" +
                "\n" +
                "Button A: X+70, Y+15\n" +
                "Button B: X+85, Y+84\n" +
                "Prize: X=4365, Y=1659\n" +
                "\n" +
                "Button A: X+83, Y+99\n" +
                "Button B: X+73, Y+26\n" +
                "Prize: X=9696, Y=8939\n" +
                "\n" +
                "Button A: X+19, Y+64\n" +
                "Button B: X+51, Y+18\n" +
                "Prize: X=12732, Y=18462\n" +
                "\n" +
                "Button A: X+12, Y+85\n" +
                "Button B: X+56, Y+34\n" +
                "Prize: X=600, Y=986\n" +
                "\n" +
                "Button A: X+56, Y+32\n" +
                "Button B: X+11, Y+61\n" +
                "Prize: X=380, Y=436\n" +
                "\n" +
                "Button A: X+46, Y+98\n" +
                "Button B: X+71, Y+11\n" +
                "Prize: X=2140, Y=2876\n" +
                "\n" +
                "Button A: X+60, Y+19\n" +
                "Button B: X+19, Y+62\n" +
                "Prize: X=18888, Y=13062\n" +
                "\n" +
                "Button A: X+45, Y+68\n" +
                "Button B: X+37, Y+11\n" +
                "Prize: X=12993, Y=9189\n" +
                "\n" +
                "Button A: X+38, Y+80\n" +
                "Button B: X+60, Y+18\n" +
                "Prize: X=9222, Y=2250\n" +
                "\n" +
                "Button A: X+34, Y+23\n" +
                "Button B: X+48, Y+99\n" +
                "Prize: X=1970, Y=3262\n" +
                "\n" +
                "Button A: X+25, Y+48\n" +
                "Button B: X+98, Y+38\n" +
                "Prize: X=5093, Y=3622\n" +
                "\n" +
                "Button A: X+15, Y+55\n" +
                "Button B: X+54, Y+32\n" +
                "Prize: X=3627, Y=4501\n" +
                "\n" +
                "Button A: X+14, Y+55\n" +
                "Button B: X+87, Y+34\n" +
                "Prize: X=6042, Y=7116\n" +
                "\n" +
                "Button A: X+97, Y+11\n" +
                "Button B: X+75, Y+98\n" +
                "Prize: X=10393, Y=2700\n" +
                "\n" +
                "Button A: X+48, Y+16\n" +
                "Button B: X+12, Y+49\n" +
                "Prize: X=5664, Y=6028\n" +
                "\n" +
                "Button A: X+55, Y+85\n" +
                "Button B: X+88, Y+18\n" +
                "Prize: X=3861, Y=3961\n" +
                "\n" +
                "Button A: X+69, Y+27\n" +
                "Button B: X+50, Y+77\n" +
                "Prize: X=7731, Y=4059\n" +
                "\n" +
                "Button A: X+41, Y+11\n" +
                "Button B: X+24, Y+45\n" +
                "Prize: X=18974, Y=2387\n" +
                "\n" +
                "Button A: X+18, Y+48\n" +
                "Button B: X+64, Y+22\n" +
                "Prize: X=19244, Y=14654\n" +
                "\n" +
                "Button A: X+24, Y+40\n" +
                "Button B: X+87, Y+36\n" +
                "Prize: X=3177, Y=1916\n" +
                "\n" +
                "Button A: X+11, Y+52\n" +
                "Button B: X+42, Y+20\n" +
                "Prize: X=10250, Y=12128\n" +
                "\n" +
                "Button A: X+26, Y+22\n" +
                "Button B: X+16, Y+66\n" +
                "Prize: X=3032, Y=5346\n" +
                "\n" +
                "Button A: X+81, Y+27\n" +
                "Button B: X+52, Y+98\n" +
                "Prize: X=10266, Y=7536\n" +
                "\n" +
                "Button A: X+37, Y+20\n" +
                "Button B: X+18, Y+48\n" +
                "Prize: X=16841, Y=16484\n" +
                "\n" +
                "Button A: X+62, Y+19\n" +
                "Button B: X+15, Y+52\n" +
                "Prize: X=3367, Y=8360\n" +
                "\n" +
                "Button A: X+49, Y+22\n" +
                "Button B: X+19, Y+30\n" +
                "Prize: X=4357, Y=766\n" +
                "\n" +
                "Button A: X+41, Y+17\n" +
                "Button B: X+17, Y+33\n" +
                "Prize: X=10150, Y=13358\n" +
                "\n" +
                "Button A: X+94, Y+38\n" +
                "Button B: X+56, Y+84\n" +
                "Prize: X=11506, Y=10358\n" +
                "\n" +
                "Button A: X+20, Y+41\n" +
                "Button B: X+51, Y+31\n" +
                "Prize: X=8049, Y=8659\n" +
                "\n" +
                "Button A: X+38, Y+76\n" +
                "Button B: X+59, Y+38\n" +
                "Prize: X=4712, Y=3344\n" +
                "\n" +
                "Button A: X+59, Y+23\n" +
                "Button B: X+11, Y+23\n" +
                "Prize: X=19102, Y=5206\n" +
                "\n" +
                "Button A: X+30, Y+78\n" +
                "Button B: X+67, Y+19\n" +
                "Prize: X=1112, Y=5864\n" +
                "\n" +
                "Button A: X+52, Y+18\n" +
                "Button B: X+15, Y+24\n" +
                "Prize: X=5023, Y=2886\n" +
                "\n" +
                "Button A: X+41, Y+18\n" +
                "Button B: X+40, Y+67\n" +
                "Prize: X=12191, Y=18022\n" +
                "\n" +
                "Button A: X+34, Y+12\n" +
                "Button B: X+53, Y+78\n" +
                "Prize: X=19655, Y=10970\n" +
                "\n" +
                "Button A: X+62, Y+97\n" +
                "Button B: X+62, Y+23\n" +
                "Prize: X=5642, Y=2833\n" +
                "\n" +
                "Button A: X+54, Y+28\n" +
                "Button B: X+27, Y+46\n" +
                "Prize: X=17432, Y=5168\n" +
                "\n" +
                "Button A: X+12, Y+31\n" +
                "Button B: X+84, Y+60\n" +
                "Prize: X=16064, Y=15470\n" +
                "\n" +
                "Button A: X+52, Y+14\n" +
                "Button B: X+23, Y+69\n" +
                "Prize: X=7657, Y=12397\n" +
                "\n" +
                "Button A: X+35, Y+13\n" +
                "Button B: X+13, Y+42\n" +
                "Prize: X=2589, Y=3861\n" +
                "\n" +
                "Button A: X+15, Y+33\n" +
                "Button B: X+22, Y+13\n" +
                "Prize: X=11329, Y=14497\n" +
                "\n" +
                "Button A: X+63, Y+71\n" +
                "Button B: X+71, Y+20\n" +
                "Prize: X=10736, Y=7178\n" +
                "\n" +
                "Button A: X+15, Y+37\n" +
                "Button B: X+94, Y+35\n" +
                "Prize: X=2897, Y=2618\n" +
                "\n" +
                "Button A: X+22, Y+79\n" +
                "Button B: X+57, Y+44\n" +
                "Prize: X=4278, Y=5721\n" +
                "\n" +
                "Button A: X+62, Y+76\n" +
                "Button B: X+80, Y+13\n" +
                "Prize: X=13004, Y=7519\n" +
                "\n" +
                "Button A: X+25, Y+13\n" +
                "Button B: X+18, Y+46\n" +
                "Prize: X=10630, Y=18270\n" +
                "\n" +
                "Button A: X+51, Y+16\n" +
                "Button B: X+37, Y+73\n" +
                "Prize: X=3377, Y=6155\n" +
                "\n" +
                "Button A: X+15, Y+35\n" +
                "Button B: X+66, Y+35\n" +
                "Prize: X=10817, Y=12170\n" +
                "\n" +
                "Button A: X+32, Y+55\n" +
                "Button B: X+51, Y+17\n" +
                "Prize: X=10777, Y=9727\n" +
                "\n" +
                "Button A: X+13, Y+60\n" +
                "Button B: X+73, Y+33\n" +
                "Prize: X=367, Y=11945\n" +
                "\n" +
                "Button A: X+17, Y+68\n" +
                "Button B: X+70, Y+19\n" +
                "Prize: X=7935, Y=18594\n" +
                "\n" +
                "Button A: X+28, Y+54\n" +
                "Button B: X+66, Y+40\n" +
                "Prize: X=16520, Y=9812\n" +
                "\n" +
                "Button A: X+23, Y+72\n" +
                "Button B: X+74, Y+25\n" +
                "Prize: X=14040, Y=4926\n" +
                "\n" +
                "Button A: X+78, Y+73\n" +
                "Button B: X+83, Y+12\n" +
                "Prize: X=9936, Y=3782\n" +
                "\n" +
                "Button A: X+27, Y+41\n" +
                "Button B: X+82, Y+35\n" +
                "Prize: X=4765, Y=3655\n" +
                "\n" +
                "Button A: X+51, Y+25\n" +
                "Button B: X+17, Y+49\n" +
                "Prize: X=1230, Y=18502\n" +
                "\n" +
                "Button A: X+58, Y+40\n" +
                "Button B: X+40, Y+95\n" +
                "Prize: X=9102, Y=11940\n" +
                "\n" +
                "Button A: X+75, Y+34\n" +
                "Button B: X+20, Y+57\n" +
                "Prize: X=2100, Y=14380\n" +
                "\n" +
                "Button A: X+89, Y+30\n" +
                "Button B: X+56, Y+73\n" +
                "Prize: X=8039, Y=3684\n" +
                "\n" +
                "Button A: X+64, Y+13\n" +
                "Button B: X+13, Y+80\n" +
                "Prize: X=15579, Y=5585\n" +
                "\n" +
                "Button A: X+70, Y+13\n" +
                "Button B: X+68, Y+99\n" +
                "Prize: X=4644, Y=2849\n" +
                "\n" +
                "Button A: X+53, Y+19\n" +
                "Button B: X+32, Y+70\n" +
                "Prize: X=1587, Y=1951\n" +
                "\n" +
                "Button A: X+71, Y+19\n" +
                "Button B: X+13, Y+55\n" +
                "Prize: X=18219, Y=10159\n" +
                "\n" +
                "Button A: X+88, Y+24\n" +
                "Button B: X+63, Y+94\n" +
                "Prize: X=12746, Y=9468\n" +
                "\n" +
                "Button A: X+18, Y+54\n" +
                "Button B: X+49, Y+18\n" +
                "Prize: X=13757, Y=18944\n" +
                "\n" +
                "Button A: X+62, Y+19\n" +
                "Button B: X+11, Y+51\n" +
                "Prize: X=11171, Y=10870\n" +
                "\n" +
                "Button A: X+85, Y+98\n" +
                "Button B: X+79, Y+18\n" +
                "Prize: X=1932, Y=912\n" +
                "\n" +
                "Button A: X+36, Y+13\n" +
                "Button B: X+14, Y+49\n" +
                "Prize: X=2160, Y=3944\n" +
                "\n" +
                "Button A: X+19, Y+61\n" +
                "Button B: X+87, Y+47\n" +
                "Prize: X=9370, Y=7548\n" +
                "\n" +
                "Button A: X+96, Y+11\n" +
                "Button B: X+42, Y+71\n" +
                "Prize: X=3900, Y=6139\n" +
                "\n" +
                "Button A: X+85, Y+91\n" +
                "Button B: X+68, Y+20\n" +
                "Prize: X=10098, Y=6534\n" +
                "\n" +
                "Button A: X+16, Y+19\n" +
                "Button B: X+92, Y+12\n" +
                "Prize: X=2304, Y=791\n" +
                "\n" +
                "Button A: X+12, Y+96\n" +
                "Button B: X+78, Y+20\n" +
                "Prize: X=1686, Y=3220\n" +
                "\n" +
                "Button A: X+22, Y+42\n" +
                "Button B: X+39, Y+11\n" +
                "Prize: X=1749, Y=5985\n" +
                "\n" +
                "Button A: X+42, Y+16\n" +
                "Button B: X+23, Y+48\n" +
                "Prize: X=8578, Y=4160\n" +
                "\n" +
                "Button A: X+20, Y+49\n" +
                "Button B: X+78, Y+26\n" +
                "Prize: X=2818, Y=1786\n" +
                "\n" +
                "Button A: X+21, Y+53\n" +
                "Button B: X+50, Y+18\n" +
                "Prize: X=11452, Y=12732\n" +
                "\n" +
                "Button A: X+37, Y+18\n" +
                "Button B: X+25, Y+39\n" +
                "Prize: X=13915, Y=6356\n" +
                "\n" +
                "Button A: X+21, Y+98\n" +
                "Button B: X+21, Y+18\n" +
                "Prize: X=1743, Y=7414\n" +
                "\n" +
                "Button A: X+84, Y+79\n" +
                "Button B: X+15, Y+86\n" +
                "Prize: X=2124, Y=3723\n" +
                "\n" +
                "Button A: X+41, Y+54\n" +
                "Button B: X+55, Y+18\n" +
                "Prize: X=8532, Y=6120\n" +
                "\n" +
                "Button A: X+38, Y+64\n" +
                "Button B: X+30, Y+15\n" +
                "Prize: X=1248, Y=1569\n" +
                "\n" +
                "Button A: X+68, Y+33\n" +
                "Button B: X+26, Y+57\n" +
                "Prize: X=15350, Y=19079\n" +
                "\n" +
                "Button A: X+12, Y+61\n" +
                "Button B: X+90, Y+78\n" +
                "Prize: X=7584, Y=9710\n" +
                "\n" +
                "Button A: X+69, Y+14\n" +
                "Button B: X+14, Y+90\n" +
                "Prize: X=3911, Y=3234\n" +
                "\n" +
                "Button A: X+59, Y+35\n" +
                "Button B: X+13, Y+34\n" +
                "Prize: X=9247, Y=16339\n" +
                "\n" +
                "Button A: X+40, Y+11\n" +
                "Button B: X+11, Y+66\n" +
                "Prize: X=11174, Y=1255\n" +
                "\n" +
                "Button A: X+87, Y+99\n" +
                "Button B: X+54, Y+11\n" +
                "Prize: X=5433, Y=4114\n" +
                "\n" +
                "Button A: X+17, Y+78\n" +
                "Button B: X+57, Y+49\n" +
                "Prize: X=1895, Y=3594\n" +
                "\n" +
                "Button A: X+81, Y+65\n" +
                "Button B: X+22, Y+63\n" +
                "Prize: X=3521, Y=5909\n" +
                "\n" +
                "Button A: X+58, Y+99\n" +
                "Button B: X+66, Y+35\n" +
                "Prize: X=5042, Y=3015\n" +
                "\n" +
                "Button A: X+19, Y+50\n" +
                "Button B: X+49, Y+22\n" +
                "Prize: X=12558, Y=2900\n" +
                "\n" +
                "Button A: X+57, Y+29\n" +
                "Button B: X+17, Y+44\n" +
                "Prize: X=13239, Y=1533\n" +
                "\n" +
                "Button A: X+31, Y+69\n" +
                "Button B: X+49, Y+16\n" +
                "Prize: X=3513, Y=17917\n" +
                "\n" +
                "Button A: X+70, Y+38\n" +
                "Button B: X+17, Y+51\n" +
                "Prize: X=3714, Y=9326\n" +
                "\n" +
                "Button A: X+47, Y+14\n" +
                "Button B: X+36, Y+75\n" +
                "Prize: X=1969, Y=6868\n" +
                "\n" +
                "Button A: X+12, Y+49\n" +
                "Button B: X+66, Y+35\n" +
                "Prize: X=18962, Y=15964\n" +
                "\n" +
                "Button A: X+46, Y+61\n" +
                "Button B: X+74, Y+21\n" +
                "Prize: X=10072, Y=6646\n" +
                "\n" +
                "Button A: X+68, Y+19\n" +
                "Button B: X+75, Y+90\n" +
                "Prize: X=4839, Y=2802\n" +
                "\n" +
                "Button A: X+39, Y+13\n" +
                "Button B: X+28, Y+38\n" +
                "Prize: X=3130, Y=1932\n" +
                "\n" +
                "Button A: X+60, Y+20\n" +
                "Button B: X+22, Y+56\n" +
                "Prize: X=11652, Y=10996\n" +
                "\n" +
                "Button A: X+21, Y+47\n" +
                "Button B: X+76, Y+50\n" +
                "Prize: X=16051, Y=14205\n" +
                "\n" +
                "Button A: X+24, Y+92\n" +
                "Button B: X+85, Y+69\n" +
                "Prize: X=7673, Y=9637\n" +
                "\n" +
                "Button A: X+72, Y+16\n" +
                "Button B: X+69, Y+73\n" +
                "Prize: X=2067, Y=863\n" +
                "\n" +
                "Button A: X+85, Y+31\n" +
                "Button B: X+47, Y+59\n" +
                "Prize: X=4672, Y=4048\n" +
                "\n" +
                "Button A: X+79, Y+62\n" +
                "Button B: X+35, Y+89\n" +
                "Prize: X=7740, Y=7182\n" +
                "\n" +
                "Button A: X+20, Y+84\n" +
                "Button B: X+66, Y+43\n" +
                "Prize: X=6530, Y=5177\n" +
                "\n" +
                "Button A: X+60, Y+18\n" +
                "Button B: X+62, Y+99\n" +
                "Prize: X=3418, Y=3357\n" +
                "\n" +
                "Button A: X+67, Y+11\n" +
                "Button B: X+18, Y+61\n" +
                "Prize: X=15779, Y=4864\n" +
                "\n" +
                "Button A: X+72, Y+29\n" +
                "Button B: X+38, Y+65\n" +
                "Prize: X=6958, Y=4840\n" +
                "\n" +
                "Button A: X+41, Y+64\n" +
                "Button B: X+72, Y+17\n" +
                "Prize: X=1910, Y=1646\n" +
                "\n" +
                "Button A: X+17, Y+59\n" +
                "Button B: X+32, Y+15\n" +
                "Prize: X=13963, Y=3310\n" +
                "\n" +
                "Button A: X+13, Y+34\n" +
                "Button B: X+54, Y+39\n" +
                "Prize: X=17275, Y=10735\n" +
                "\n" +
                "Button A: X+68, Y+22\n" +
                "Button B: X+11, Y+43\n" +
                "Prize: X=4043, Y=14171\n" +
                "\n" +
                "Button A: X+49, Y+41\n" +
                "Button B: X+69, Y+11\n" +
                "Prize: X=5997, Y=3943\n" +
                "\n" +
                "Button A: X+13, Y+67\n" +
                "Button B: X+54, Y+15\n" +
                "Prize: X=18389, Y=14300\n" +
                "\n" +
                "Button A: X+35, Y+12\n" +
                "Button B: X+25, Y+39\n" +
                "Prize: X=8260, Y=16295\n" +
                "\n" +
                "Button A: X+11, Y+82\n" +
                "Button B: X+80, Y+12\n" +
                "Prize: X=8144, Y=6364\n" +
                "\n" +
                "Button A: X+80, Y+23\n" +
                "Button B: X+50, Y+60\n" +
                "Prize: X=5060, Y=1911\n" +
                "\n" +
                "Button A: X+39, Y+22\n" +
                "Button B: X+15, Y+89\n" +
                "Prize: X=807, Y=1019\n" +
                "\n" +
                "Button A: X+19, Y+47\n" +
                "Button B: X+17, Y+11\n" +
                "Prize: X=19529, Y=7457\n" +
                "\n" +
                "Button A: X+88, Y+33\n" +
                "Button B: X+13, Y+21\n" +
                "Prize: X=1447, Y=591\n" +
                "\n" +
                "Button A: X+28, Y+80\n" +
                "Button B: X+70, Y+16\n" +
                "Prize: X=3980, Y=11856\n" +
                "\n" +
                "Button A: X+51, Y+27\n" +
                "Button B: X+31, Y+54\n" +
                "Prize: X=8544, Y=12140\n" +
                "\n" +
                "Button A: X+28, Y+64\n" +
                "Button B: X+59, Y+21\n" +
                "Prize: X=18595, Y=9393\n" +
                "\n" +
                "Button A: X+26, Y+80\n" +
                "Button B: X+60, Y+34\n" +
                "Prize: X=6396, Y=5974\n" +
                "\n" +
                "Button A: X+43, Y+25\n" +
                "Button B: X+24, Y+85\n" +
                "Prize: X=3675, Y=2705\n" +
                "\n" +
                "Button A: X+49, Y+15\n" +
                "Button B: X+39, Y+70\n" +
                "Prize: X=1505, Y=13780\n" +
                "\n" +
                "Button A: X+65, Y+11\n" +
                "Button B: X+40, Y+51\n" +
                "Prize: X=3450, Y=805\n" +
                "\n" +
                "Button A: X+26, Y+71\n" +
                "Button B: X+77, Y+52\n" +
                "Prize: X=6108, Y=8133\n" +
                "\n" +
                "Button A: X+71, Y+31\n" +
                "Button B: X+15, Y+61\n" +
                "Prize: X=1068, Y=3570\n" +
                "\n" +
                "Button A: X+16, Y+77\n" +
                "Button B: X+94, Y+54\n" +
                "Prize: X=9970, Y=10135\n" +
                "\n" +
                "Button A: X+44, Y+15\n" +
                "Button B: X+20, Y+54\n" +
                "Prize: X=16592, Y=14516\n" +
                "\n" +
                "Button A: X+12, Y+22\n" +
                "Button B: X+38, Y+17\n" +
                "Prize: X=5624, Y=2372\n" +
                "\n" +
                "Button A: X+28, Y+56\n" +
                "Button B: X+63, Y+32\n" +
                "Prize: X=5499, Y=1824\n" +
                "\n" +
                "Button A: X+11, Y+68\n" +
                "Button B: X+36, Y+17\n" +
                "Prize: X=1596, Y=2261\n" +
                "\n" +
                "Button A: X+35, Y+16\n" +
                "Button B: X+12, Y+42\n" +
                "Prize: X=18101, Y=16340\n" +
                "\n" +
                "Button A: X+86, Y+86\n" +
                "Button B: X+50, Y+12\n" +
                "Prize: X=2780, Y=2628\n" +
                "\n" +
                "Button A: X+74, Y+50\n" +
                "Button B: X+11, Y+63\n" +
                "Prize: X=1900, Y=6396\n" +
                "\n" +
                "Button A: X+52, Y+67\n" +
                "Button B: X+97, Y+29\n" +
                "Prize: X=12679, Y=8370\n" +
                "\n" +
                "Button A: X+24, Y+91\n" +
                "Button B: X+85, Y+46\n" +
                "Prize: X=4074, Y=3843\n" +
                "\n" +
                "Button A: X+29, Y+68\n" +
                "Button B: X+35, Y+13\n" +
                "Prize: X=12015, Y=1641\n" +
                "\n" +
                "Button A: X+56, Y+18\n" +
                "Button B: X+21, Y+68\n" +
                "Prize: X=9601, Y=18358\n" +
                "\n" +
                "Button A: X+84, Y+40\n" +
                "Button B: X+32, Y+59\n" +
                "Prize: X=3612, Y=5396\n" +
                "\n" +
                "Button A: X+77, Y+19\n" +
                "Button B: X+11, Y+92\n" +
                "Prize: X=3663, Y=8136\n" +
                "\n" +
                "Button A: X+25, Y+38\n" +
                "Button B: X+38, Y+13\n" +
                "Prize: X=1657, Y=8142\n" +
                "\n" +
                "Button A: X+13, Y+29\n" +
                "Button B: X+63, Y+35\n" +
                "Prize: X=15775, Y=16167\n" +
                "\n" +
                "Button A: X+14, Y+44\n" +
                "Button B: X+80, Y+24\n" +
                "Prize: X=7254, Y=4604\n" +
                "\n" +
                "Button A: X+51, Y+34\n" +
                "Button B: X+26, Y+94\n" +
                "Prize: X=4065, Y=8230\n" +
                "\n" +
                "Button A: X+14, Y+81\n" +
                "Button B: X+94, Y+31\n" +
                "Prize: X=7968, Y=5072\n" +
                "\n" +
                "Button A: X+50, Y+78\n" +
                "Button B: X+80, Y+26\n" +
                "Prize: X=5740, Y=3718\n" +
                "\n" +
                "Button A: X+96, Y+73\n" +
                "Button B: X+18, Y+78\n" +
                "Prize: X=1728, Y=4401\n" +
                "\n" +
                "Button A: X+19, Y+57\n" +
                "Button B: X+58, Y+12\n" +
                "Prize: X=13020, Y=11432\n" +
                "\n" +
                "Button A: X+75, Y+15\n" +
                "Button B: X+64, Y+86\n" +
                "Prize: X=11389, Y=7841\n" +
                "\n" +
                "Button A: X+16, Y+50\n" +
                "Button B: X+33, Y+19\n" +
                "Prize: X=960, Y=1654\n" +
                "\n" +
                "Button A: X+11, Y+67\n" +
                "Button B: X+64, Y+12\n" +
                "Prize: X=7909, Y=5285\n" +
                "\n" +
                "Button A: X+67, Y+89\n" +
                "Button B: X+90, Y+27\n" +
                "Prize: X=9541, Y=5825";


//        String input = "Button A: X+94, Y+34\n" +
//                "Button B: X+22, Y+67\n" +
//                "Prize: X=8400, Y=5400\n" +
//                "\n" +
//                "Button A: X+26, Y+66\n" +
//                "Button B: X+67, Y+21\n" +
//                "Prize: X=12748, Y=12176\n" +
//                "\n" +
//                "Button A: X+17, Y+86\n" +
//                "Button B: X+84, Y+37\n" +
//                "Prize: X=7870, Y=6450\n" +
//                "\n" +
//                "Button A: X+69, Y+23\n" +
//                "Button B: X+27, Y+71\n" +
//                "Prize: X=18641, Y=10279";

        String[] split = input.split("\n\n");

        List<String> strings = new ArrayList<>();
        for (String s : split) {
            strings.addAll(Arrays.stream(s.split("\\n")).collect(Collectors.toList()));
        }

        List<Equation> list = new ArrayList<>();
        for (int i = 0; i < strings.size(); i += 3) {
            Pattern pattern = Pattern.compile("\\d+");

            String s1 = strings.get(i);
            String s2 = strings.get(i + 1);
            String s3 = strings.get(i + 2);
            int a = 0, b = 0;

            Matcher matcher1 = pattern.matcher(s1);
            if (matcher1.find()) {
                a = Integer.parseInt(matcher1.group()); // 匹配到的第一个数字
            }
            if (matcher1.find()) {
                b = Integer.parseInt(matcher1.group()); // 匹配到的第二个数字
            }
            Button buttonA = new Button(a, b);
            Matcher matcher2 = pattern.matcher(s2);
            if (matcher2.find()) {
                a = Integer.parseInt(matcher2.group()); // 匹配到的第一个数字
            }
            if (matcher2.find()) {
                b = Integer.parseInt(matcher2.group()); // 匹配到的第二个数字
            }
            Button buttonB = new Button(a, b);

            Matcher matcher3 = pattern.matcher(s3);
            if (matcher3.find()) {
                a = Integer.parseInt(matcher3.group()); // 匹配到的第一个数字
            }
            if (matcher3.find()) {
                b = Integer.parseInt(matcher3.group()); // 匹配到的第二个数字
            }
            Equation equation = new Equation(buttonA, buttonB, a, b);
            list.add(equation);
        }

        int answer1 = solutionForPartOne(list);
        System.out.println(answer1);

        long answer2 = solutionForPartTwo(list);
        System.out.println(answer2);
    }

    public static int solutionForPartOne(List<Equation> list) {
        int res = 0;
        for (Equation equation : list) {
            Button a = equation.getA();
            Button b = equation.getB();
            long c1 = equation.getPx();
            long c2 = equation.getPy();

            int a1 = a.getX();
            int a2 = a.getY();
            int b1 = b.getX();
            int b2 = b.getY();

            long ex = (c2 * b1 - c1 * b2) / (a2 * b1 - a1 * b2);
            long ey = (a1 * c2 - a2 * c1) / (b2 * a1 - a2 * b1);

            long remainderX = (c2 * b1 - c1 * b2) % (a2 * b1 - a1 * b2);
            long remainderY = (a1 * c2 - a2 * c1) % (b2 * a1 - a2 * b1);

            if (remainderX == 0 && remainderY == 0) {
                res += 3 * ex + ey;
            }
        }
        return res;
    }

    public static long solutionForPartTwo(List<Equation> list) {
        long res = 0l;
        for (Equation equation : list) {
            Button a = equation.getA();
            Button b = equation.getB();
            int a1 = a.getX();
            int a2 = a.getY();
            int b1 = b.getX();
            int b2 = b.getY();
            long c1 = equation.getPx() + 10000000000000L;
            long c2 = equation.getPy() + 10000000000000L;

            long ex = (c2 * b1 - c1 * b2) / (a2 * b1 - a1 * b2);
            long ey = (a1 * c2 - a2 * c1) / (b2 * a1 - a2 * b1);

            long remainderX = (c2 * b1 - c1 * b2) % (a2 * b1 - a1 * b2);
            long remainderY = (a1 * c2 - a2 * c1) % (b2 * a1 - a2 * b1);

            if (remainderX == 0 && remainderY == 0) {
                res += 3 * ex + ey;
            }


        }
        return res;
    }


    static class Equation {
        private Button a;
        private Button b;
        private int px;
        private int py;

        public Equation(Button a, Button b, int px, int py) {
            this.a = a;
            this.b = b;
            this.px = px;
            this.py = py;
        }

        public Button getA() {
            return a;
        }

        public void setA(Button a) {
            this.a = a;
        }

        public Button getB() {
            return b;
        }

        public void setB(Button b) {
            this.b = b;
        }

        public int getPx() {
            return px;
        }

        public void setPx(int px) {
            this.px = px;
        }

        public int getPy() {
            return py;
        }

        public void setPy(int py) {
            this.py = py;
        }
    }

    static class Button {
        private int x;
        private int y;

        public Button(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

}
