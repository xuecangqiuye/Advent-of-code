import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: wangshengbin
 * @Date: 2024/12/16 09:49
 * @Description:
 */
public class Day15 {

    public static void main(String[] args) {
        String input = "##################################################\n" +
                "#OO...O#.O...#.........O....#.#...O............OO#\n" +
                "#..O.O...O..#.O#.O....O.O.O#.OO.O....O.#O...OO.O.#\n" +
                "#....O.....##.......O.O....#.......OO#O.O.#....O##\n" +
                "#O........O#...O....O...OO.O..OOO.O.OO...#..OO.O.#\n" +
                "#..O...O.OO......#O#.......O.O..#..OOO.OOO..O.#.O#\n" +
                "#....OOO.O..O#..O...........O....O.O.OO.OO.O#O...#\n" +
                "#..O....#O....OO....O#O..........O..OO.O.O.......#\n" +
                "#...O...OO...O....OO...O.O.O.....O.OOO...#...#...#\n" +
                "#....#.#.....O.#O....O..O.....#.O.O.....O..O#..OO#\n" +
                "#..O..O...O.##....O..O#.OO...OO..O...#O#OO.......#\n" +
                "#.....O....O..O###.O.O#.O...#O.OO...O.#.##O.#O...#\n" +
                "#..O.#.....O.#.O..O.O...O...O#.O...O.O..O.O....#O#\n" +
                "#O...OO#O.....O.OO..O##.OO#.O.OO..OO.OOO.O....#O.#\n" +
                "#.O..O....O.O.#OO..#O..OO...O.#O........O....O..O#\n" +
                "#OO#.OOOO.##........O.......#OO.......O.OO......O#\n" +
                "#..O..##.O.O..O...##..O.O....OOOOO.......OO.OOO#.#\n" +
                "#.O.##O..O..O.#.OO..OO.O.....O..O.O#...O........O#\n" +
                "##....O..................O.....O#....O.O.O#.....##\n" +
                "#..O#....#.....O....OO...#.#O.........O...O.O...O#\n" +
                "#.#....OO#...#..##..OO..OO..#....O....O......O.#O#\n" +
                "#....O...O.OO..#O...#.O.O....O##.OO...O.##.#..O..#\n" +
                "#..O.O..O..#O.O......OOOOO.......O.#O.OO.O...O..O#\n" +
                "#.O.O.#..O#OO#OOO.O...O..........O...O..O##O..O..#\n" +
                "#O....O..OO..OOO.O.....O@O..O..OO...............O#\n" +
                "#..O..OO......##........O.OO.......#....O..O.....#\n" +
                "#O.OO.O.O.......#..#....O.O...O.......#.#.O.OO#.O#\n" +
                "#...O#...........#.O..OOOO..O...#.#.O....OO.O.#..#\n" +
                "##....OO..#.O#OO....O...OO#.......O...OOO.O.O.OO.#\n" +
                "##.....O.........##.O....OO..#....##.O..........O#\n" +
                "#O.#..OO.......#O..#...OOO..O.O..OO.O.OOO...O.O..#\n" +
                "#O.OOOO.OO..........O........OO..OO.O#.O.O..O....#\n" +
                "#.##.O.OOO.........O...O...O.OO.O.#..O#.O...O...##\n" +
                "#.OO#O.O..O.O.O..O..#.O.O...O..O..O....#O.#..O...#\n" +
                "#......O.#O.O.O....OO#.......O.O..OO#O..##.......#\n" +
                "#.OO.O.OOO.O.O##...O#.....O..O#...O.O.O..O..O..O.#\n" +
                "#....O........O.##..O..#.....#..OO#....OO#O..O...#\n" +
                "#OO...O...OO.O.....O..O......O.O..O.......O...O..#\n" +
                "#.....O.O.O......O#..O.O.OO...O...OO...O.....OO..#\n" +
                "#.O.O.O....O.O#.O......O...#..O..O#...OO..O#.O...#\n" +
                "##.O....#......#.....OOOO.OOOO.O.OOO.O..O.O..#O..#\n" +
                "#O.#O.O....O.O.O....#...#..OO......O..#O........##\n" +
                "#O...#O..O.O.O.........O#O.OO...O....O...O.O.O.O.#\n" +
                "#.O.#...O#..O......#.....O..OO#...#.#........O.#.#\n" +
                "#O.O..O....O.....O.O.O....OO.......O...O.O.OO....#\n" +
                "#.#O............O.....##OO..OO........OOOO#O.#.O##\n" +
                "#.#.O..OO.......O...O...#..O..O....O.O......OOO..#\n" +
                "#...##.OOOOO.#...O...#....O...O.#......O.O...O.OO#\n" +
                "#....O.O..O.#...OO#..OO.O..................#...#.#\n" +
                "##################################################\n" +
                "\n" +
                ">^v<v<<vvv<>^^>^<>v^^^>vvv><>vvvv^>>v>^v^v>^>v^^v^^v>v<<^<>v>^><<<<v>v<>^^^^>^^v>^^v><^<vv^><>><<v<v>^><^^^>v^^<>^v<<^^v<v<^^^<v<>^<<v^vv^v<><^<^^>^<>>v<<>vv<vv<^^<><v<<^^<^v><v^<<>v><v>><^^vv<v>>^v>>><^<>>vvv<<>^^<<<^>>^>^><^<v>vv><<vv<<vv<v<v<<^^<<^<<^vv^<<<>v>v>^^^>>vv><^>>><<vv>><<<>>^><><v<v>v^^^<^<<><<>v<<^^vvv<v^^^v>^v<v<><>><<><>vv^<<<><>v^^vv<^<><vvv<^^<^>^<vv<^v^>^<^>^<>><<v><^v>><<<<<>><^^>^^v><<<v>v^v>^^<v<^<<>v^v<<>v>v<<>>^v>>vvv>>v^v><^<v^<<<<v<<<^vv^><<>v<^v^v<^^vv^>v^>v^^>v><<^>^<v<<vv>^<>>v>vvv^>v><v>v>^<>^<><^>^^v<<>vv>v>>^^v>>^v^><^v<^><>>^v>v^<^>^v^>^<<>>^^v><>v<>^^>>^>v^<^v<v><<vv<^^^v^vv<^^>^^>v>vvvv><vvvv>v<<>>><v><v^^v>>><v>>^><v>>>>^v>^>^vv^<><>><><^v^v>^>>^>^><vv>^v><v^v^><<><^^v^^<v^vv^^<v<v^vv^^<><v^<<>v<><<^<>>>v>>><<<^^vv^^>^^^^v>^vvv<<<>>^^v^<<v^<><<<>>v>><v<<<>^>v^^v><>^>v<^>><^^vv>^^><>><^<>><^^<v^^><>>^>^^^<<><<vv><><v<^v^>^vv<^>><^^vv><>^>^>><v<>>v<vv><><<vv>>^^vv>^^><v^v^<v<^<<>^v<^^vvv^<>^>v^v^<<v^^v>v^>^<vv>^v>v>>v<>><<v^v>v<><<^^<>^>>v^^vv^vv<^>><\n" +
                ">^><^<vvvvvv^<>>^v>>^<><vv<^v^<<v^^>^>v^>>v^vv>v<v^<>^<>v^v<<^^<v>>v>v>>^^v^^v^>v<^<^<>><^^v^<^<>^<^<v>>vvv^>>^>^>><>^^<v>v<vv><v>^^<<>v^^^><>>^<^>v^^<<>v<<v<>^^<<>^^v^^<<^>>^v<^<><v>>v^vv>^v^><^<<<vv^><>^^<<vv<>v>^>vv^v<^^v^^^<^<vv<^v>^<v><v>^vvv^vv<^v^<><v><>^^v^>><^v^v><v<^v>>>^><>><<<vvv<^<>^^vv>v<vv<vv>><^<<<>>v^<>><><vvvv<^>>v<><<^vv<>^<>^^vv<><^<v>>vvvvvv>>>>>v>^>v^^^<^v<><^<^v>v>>vv<<<^<>vv^<v><>>^<v><<^<<^<^^>^^v^<v<^v><v><v^^^>v>v^><^><^^^v>>^>^><<><><<^<>><<vv^<v^<>^^v^v<><<v<vv^^v<v<>v<^^^<v^<^<vvv^vv<>^>^vv<<<^<<<^>^^vvvvv<<v>>v^>>>v^><vv><><>v>v<><v^vv^<<vv^<>v<^^><v^^<<>>^v<^^>v<vv<<><><^^^v<^<v><v^>>v>v>>v>>>><v>v<v<><>v^<>>><<><<<<>>^^^^>v>v^>><vv^v^><v^>>^^>v<vv^><v^vv^^^^^^v<<^^^^>>>^^^>v^<<><^<<>>>^^<^>^<^><^><>v<<<^^^>^<^<^vv>>^>^>vv^<<^<v<>v><^^<>vvvv>^<>>>^<vvv^v^>v^^^^>v^vv<>>v><^v>>>v>^^vv<^v>^v><>^><v>^<>^^v<^^<>><^^v<^^>^v>>^>>v><><^^>>>^vvv>>^v<>^>>^^><v>>v><<>v<><<v<<v<vv^<>^v<^>^v^vvvvv<>^^v^^vv^^<<v<<^^v^^<<v<^^<^v<v><^v<^><v^>^^^vv>^<^^<>>vvv^>^v^<v^vv<v\n" +
                "<v<v>>v<>>>v><<<^v>>v>>^vv>v^<^^<><v>^^<>vv^>>^>>><v<<>v><<<<^v>v<>>>v>v^v^v>^^<^v<<^v<><<<^vvv>^<>>^>><>>v<v<v<v^><v<<^^^vv<^<>v>v><<v^v>^^^vvv>>vv<<><>^v<<<^^^>>>>>^v>vv<<<^<^<<^v^^><^>^^^^vv<v<<<v>^v^v>>>^^>vv^^<v^^>><^^<v>^><v>^v^v>^<>^<^>>>v>^^v^v^><<<v<>^v<vv^>v><v>>>^<>><<><<^^<<>^^vvv^^<<^><vv<>v<><><^v^<^>v>v<v>>>vvv^v<^<><<v<vv<v>>^^<v^v^^<>><^<<^v>v^^v^v^^>^><>^^^v>vvv>v<>^v><^^<^^><>>vv^>v<^^v<<<v>>v>^<vv^<^^v><v^^^^^<vvvvvv^<>>v>^v^v><v^^><><>>^v>^<<<><<<<^^>^<v^<vv^>^^><v<^^^<^<>>v><>^v>^<<^vvv^^<^^v^vvv^>v<v<>>^^^^>><^>>^^<^<vv>^><<v^<v<>^><<><<>vv<^vvv<^<><<v<v^^<^>v<^<^v<v<^^<^>^<v^>v>>v>vv<<><vv^^v>>v^><^vv<>v<^^<>^v^>>^>v^<vv>><>^^v><v^>v><<^<vv><>><v>^>^^<v^>>><v><>v^^v^>><^v><<>^^^v^vv^>v^^vvvvvv>^>>>^><^>^>vv<v><v^<v<v>^^v<<^<^<v<v>>>>^^^^>^vv<>^vv<><^>^>^^>v<<<v<>^<<v>v^v^>v>>><><^>vv<^<^^>>>>^vv^^v<vvv<>v><v<vv<^^<>v<v^<^<<^^<vv>><<v>><vvv>^^<<^^<^v>^<^^v>^<<^v>><^<v<>v<^v<v<^vv>v^<>>>>>^vv<><<<>^>v>v<><<v^<^v^><>v^<>v<^v><><>v<>>><>^<^v^<v^^<^vv<<v<<<^vv^^<>v>^\n" +
                "<<^<<<<<>^>v^v^vv^>><<vv<<v>^><<vv>>^v<^v^>^^^^v^>v^<v>v<<^^^v<^>><v^vv<vv<>^<>^<^<v<><^^v><<>v<v^>^<vv>v^<^<>^><v>^^^>>^^>^^v<>v<>>v<^v>v<<>^><vv>>>v><vv^vv<^<^<<v^<><v>>v^<<v><<^>>v<<^<^<>><><<^>^>>^<<^^vv^v^>^^<<>^^v^>v>^^<>>^>^>^>^^^^<^vv<^vv^^v^^>^^v^v^^v<^>v>^v<>>><>^>v>>^<^><v<^v<^>^<vvvv><v^<^><<<^v^^^<>v<<>v<<v<<vv<v<<^<vv><^<vv<>^^<><><>>vv^<^>vv<>^<^<vv<^>v>v><^^>>>^<<<^<<<^^v<><vv><v^vv>v>v^><><>v>^><v^^v^>>^>^<<<<<>>>^>><<<<>>v>><^^>>>^v<>vv<^vvv^^<>vv^><v<<<v>>^^>^>>^^>^^v^<vv^v>v>>>v^^<<v><<>><vv>>^>v<^<^vv>v<v<^<^<<<v^<<v^<<>v>>vvv^>>^>vv<^^>v^^>^><v>v^<<v^^>>^v<<v>>>>>^v<<^>>>v^^v^v^>vv^^<><^^>v>>^<v^^v>>^vv<vv^^v<<v<^<><>>v^^v><<<>v<v<>>>>>><^^<vvv<<v^<>v>^v<v^^>vvvv^v^v><<^>v>>v^v>^^^>v^<v<v^<<v<>>v<<^^><>^<<>>><<v^<<^>v>^<><^^>^><v^<v>vv>^>^^^^>>v<v<^><^v<v^^<>v^>v^><^<v>>v^v>v<<<>v><^>v^v<>vv>^<^<<v<<^v><>^vv<>v^v><vv><><<^>^<<^>><>v>^>>v^><<v<>>^^vv<^><^<^v<<v^>><^^^><>v>^<><>^v^<>>v>>^>>>v<^>v>v>v<^>v>^^^<<<>^<>v<^^<<>v>^<<v^<<vv<^<v^>vv^>>>^vv^^>v>>v>^><^v^>v<v>\n" +
                "<<^>v<<^>>><<v<<^^^<>v^<v>><<><>v>v<<vv<>v<>v^^v^^vv<><^v>^>^<<v^^^<<<v^^^><^^<vv>v<^<>^<>>>v^^v><v><<<>^<>>v^v^<<v^<v^^<^^><<<v<>^>>v^^v>><>v^v<><^><v^<v>^vv^><<^^^v>^<^v^>^>v<<^>vv<>vv<v^^>^><^v>>v>^^v><<<^<^<vvvvv^^v<<^^>>^vv<vv^<<<^<<v>^><>>>>vv<<>v>><v^v<v^vv^^^^>vv>^v<>v^^vv^^vv>^<<>^<v>><v<vv>vv^^^<^^vv<^<<<vvv<<^^v<vvv<v^><^<^^vv<<>v^>v^^><vv<>>>>v><^^v>v<v><v<^><<v^v<>><>^>^v<^<^^vv>^v^<v>>>v>^v>^^><^><v>vv<<^<>vv^>^^>vv>^v><v<>v^v^v><<>>^>><<^<<<v^v<<^>vv<v>v>v<^^<>^>>>^^^v<>>^<>^v^<v<><<v<v>vv<<><>v><^^<>vv^><<><>v^v^^v^vv>>>><<<vv<<>>v<^<v>^<^>>v<^v>v^<<>^>>>>><<><^^v>>>>vvv<v^<>>v^<^>^^>v<<><>>v>v^v^<^<>v>vv^v>^<^^<>^vv<><^v<<vvv>>^v<v<^<<>v<^<^<<v^v<^v>^<<>v<>>v><<<>^<vv^v>><^^<^>><>>^^v<<^v^<^<^vv><^<^vv^v<^>^^v<v><^^<vv>v>^>^v>>vv^>^>^<><v<<v<>v^v^^>^^v><^<><v>>>vv<<<>><<v^><^v<v^>v^<>^v^<^v^>^>>^v^<^v<>^<>v<v<v><>>vv<><vvv^^v>>^><vv^>^vv^<>^^v^^>v<<>^vv><<^^<^>vv>v^<>>v>vv^v^<>>>^>v^^<<><v>^>^^^v><v<<<^v>^>v^^>^<<v>^>^<>vv>^>>^<><><v<^^>>vv><^^>^^>^>^>v^^^<<>^>^>v><v^^\n" +
                "v>v^<vv<^>>>v>^^^v>v<><^v^^<<<<v>vv<^^vvvv^<^^<<v>^>>^^<<^vvv<^v>^<v<^^^<v>>>v^^v<v<^v>v><v<>vv><>>^^><v<<>^>^>><><^v^>vvv<><^v^v^><<<>v><vv<v^^v>^^>^<<^<<><>>^>^^<<v<<^>>v<>^<^v>>><^<<>v<vv>vvv>><v>^^v^vv<<<>><><vvv^<^><^^<<>^v><<>>^>^<vv^v<^v<<v^vv<>v<>>>>>^>v^>>v<<><<v>vv>>v^><^vv>vv<><><v>^<^^^>>v<<>><v^>>>v^v<>^v<v<<vvv<>>v<vv^v<v<<^^>^><>^^><^^><^>>^^vv^>v^>^^><v>^v<<>vv><<vvv>vv^v^<vv><>><<>v><vv<>^><vv^>^^^^v<><vv<<^<><<<vvvv^<vv^v^><>><^^^><<^^^^>><v^^v^<^v^v^>>^vv>>^^<<>^^^v<v^vv<<^vv<>v<vvvv>v>>^>v<^<v<vv>v><^>vv<v^<^>>v><<vv>v><><^<^<^v<<^<>>^^>^<^><>>>^^vv^v<v^><>>^v>v>>>>v><>^<^><><^v>><v^vvv>^><^><>>^^<>>^>>><^<>vv<v><v^>v^^^>v<><^<>v^v>>^>>^v>>v<>>>v^^^^^^<v^>vv<<<^><<vv>^>>v>><v>^^v>><^vvv^>v>>v><^^v^^<^><v^<vv><>^v>><v^^v^^^<vvv>^<<^<<>>vv^^^v^<<<^v<vv>v^^>><^<v^>>^<v<>>>^<>>^>vv<>v^^>><>^<v><<v<^<v<>vvv><^<vv>v>^^>^<vvv^^^<>v^<v<><<v>><><vv^v><v>^v<><^<vv><<<vv^>^^<<vv><v>^>^^v<><><>vvv<^^v<<<<<<<<^v<><v<v><<><vv>v>>^<vv^v^>><<v^>^^>v^>><v^>^^v^vv^<vv>^>v>v<v><<><<<<\n" +
                "^<>^^v^^<^^<>v<<<<<^vvvv<>>^vv^><>^vv><>v<^<>>v^v^^<><<v<v>v<<v<>>^<v>>v>v>>v^v<v>vvv>>>^^>><vv>v>v<>><<v>vv><<<v<<>v<><v^vv>^>v>v<^<>v<<>vv^v<>v<v^<<>vvv>v<>v<><<v^>^>v>>>>><>>v>v>^v>^^><v^<^<^v<vv<v^v^>^v^v^<>><v>>>><^^^>>^><<<<<v>^^<^v>^<^<^><^>>^v<>^>>><><<vv<^<<>^><>v<v<><><v>vvv<vvv^><><^><v^>vv^vvv<v>vvv>^><<^^>^>>v<^^<<>>^>><v<v^v^^v<^^^<^vv>^v>>>>><>>><v>>^v>>vv^v<<<v>><v^^<<<>vv<^v^v^><<>v^^v<^vv^v>v^<<v><>^vv^^>>vv<<>^v^^<^<v<>^^v^<^>^^<^<>^^>v>^v>^<>v^^>v<v<^>>v^><v^^v>v<^vv<<^^^v^><><v<vv>v>>>v<^><^>>^<v^<v>>v<^v<>^^^><^v>vvv^^<<>^^<^v>>>>><^^<^>>>v^v^<vv^<vv<<>^v^<<v>v^<^v>vv^^^vv<><^>^^v<>v>v^><<v^>^v<v<>><<^^<vv>>>>v><v^>>v><>>^vvv>vv>><<<v><^>^v<><^v>^>>>>>^v^<^^v^<>v>^<^<>vv<v>^^<v>v>><^vv<vvv>vv<^<>^>v><>v^<><>vv<^^vv<>^v^^>^^^<v>><v>><<>^<<<v>v<<vv<<>v>vv^^v>>^>^><<<^<<^vv<^>^>v^>v^vv^v^^<^vvv<^v^><^^>^^^^>vv^^^>>^v>>vvvv<<^vv^<v<vvv^<^<^v<^^><>v><<<<v>v><>v>vv<v>^v<<^<^>>^v><v>>v<v>v^v<<><^v<^v><^v^>v><><v<^^>^>^>v<>v^>>^^vv><^<>>>vv>v>v^^v^vv^^<v><^<<<><<<<v>><^^v\n" +
                "^^^<<<><v<vvv>v>>vv^>^v<v^^><v><>vvv<>vv<^vv>^><v^>^<>>>v^>v<^><<^v^><^<v<<^<^^>v<<^vvv^^^<<<>>v>^^^<<^>v<vvv<v^^<^v^vv>>>v^^v^^<vv<>><<>v<<>v^>>^>><vv^v<v^>vv^v<v>>^<<v<vv>v<v>^v>^v>^<v^<>vvv>v<<v>v>>^<<v^<<>v^v>>><>vv<<<^^>vv^vv<vv^><v<>><^^^<v^v^<><><^^<^<<>v<<vv>>><<<<^vv<^^v>>v>^vv>^^v^>^^>><^<^v^<<v<><vv>>^^^>>^vvv><^>>v>>vv^<vv^v^<<>^^><<v<^>>^<^><><>^<<<>>vvv<v^v>v>v>v^<<^vv^<^^<<^v>><<<^v><>^>>^v>^>v^>v^>^<>><<<<<^><v<<>><v^vv<><>^^>><^<^^<v^vv>>^vvvvvv^<^<v^<v<>v<<<>>vv<<>>vv<><<<>>v><>v>v^^>>><vv>>v<^><v<<vv><vvv<v<v>v^^>>v>^^>>^^<<v<><v^>v><><^<^^><^^<^^vv^><^>>^>><v^^v>^<v>^^vv<^>>>>>^<vv<>^^^<^<^v>><>v^<<<v^v><<><v<<^>v><<>^<<<vv><>vvv<>v>v<>vv>^>v><v<v^<v>><<vv>v^<^v^^^^^>>vv>v^^v^<>^><v^v^^<>^>^<>v<>>^^>^><<<v>>>v>^^>^>>^<<>^>v>v>v<<<><v><<>^vvv^vv>^><v<<^<<<><<^v<<^^><v<^<>^>>^^v<<v>vv<v<><^^>^^^<>^^^<><v><v>vv<<<><<^<<<v^<<>v<<>^><>>>v>v^v>v<vvvv<v<^<<^>^v<><<v><<>^^<>><>><^<^v>v^^<>>^^><^<vv<<v^^>vv^vv>v<^^><vv<vv^<<>vv^v^^><>>>>>v^<v<^<<<<^<<<><<^^v<^^><<>v^>>v<v>v>\n" +
                "><<<<<<>>vv<>>v>^v>^v>>^><v>^^^>v<>vvvv^v>^^v^^<^v><<<v>>>>>v^>>^v^v^^>>^>^>>>>^>^>^<<>v<>^v^>>v<^^>^><><<^><><<^^<<>>^>>^>vvv<<><<>v<>>>^^^v^^^<>><^v^^>v>v^^><<<>^>vv^<vvv^<>^v<<><<<v<vv<>v>v>^^>v<v^>v>^>>v>>><>v>v^>v^>^>>><>v><^<>v><^v<<v^>v^^^v^^^^^v^v<v^vv^^^^<^^>^>^>>vv><<^^v>^>^>>^<vv<v<<^vv^><<vv^<^><^><^^>><^>v<v<^<v<vv^>v>v<<>^^><><>><vvvv^>>v<<v>v^^^^^^<v<<<v^v^>>>^v>^vv<v^^^>>>v>v>^>v^vvv^v<vv>vvv<>^>>vv>^^v<>^<>v<v>vv>><<>^v^>v<<>^<<^>vv^v^v>>v><vv<v<<<v<^><^<^<>vv>><><^vv<v^>><>v>vv<^^>>v<>>^v^^^<<<>v<^<<^^v><^v>v<<^v^<v><<><>^<<<><>v^>^v^^^vvvv^^v>>vv<vv>><<>>^>v>>^>^><^v<><v<<<<v^v>v>>>>^>^><<<^^v>vv<>^>^<^><<^>>^<vv<>v>^>>^<<^v<><^<>><v>v<>><>v^v>><^^^^^^>^vv>>v^v^^v>>^>>>>v^vv<>vv^>^>><>>>>>v^^<^>>^<>^v^><><><v<<vvv^^<v<^<<^<^<<v<>vv<^<<v^<v><v>^^<v>^><<>>><>>v>>v>vv<>>vv>><<v<<>^<v<v>^v^v^^v<v<<vv<^>>><>>^vv>^<vvv<^<^v<v^<^<vv><>^>>>>>v<v<<>^<<v<<^^^v<<^vv<^<v>^<>^<<<v<vv^<^^v>>^<^^<<v><><v><<vv^^v^^>^<vv<<>>><><>^^vv<vv>v<vv><<<v^>><>^<^vvvvv<><<>vv^<^>><v^>v>>><<<v<\n" +
                "v<>>v>>^^><<<^<vvv^>^<>>v^>^v>><<vv^>>^><^v<><>^^<<<><<^>^vv>v<<^>v<<v<>>v><<<^>><<<v^v<^<<>^>>v<>><>>v^^^>>^>^>^<^v^v>^^^<<>>^>^><^^^>v>^^^^v^>>>^vv^vv^^^^v<>^^<>^^>><>^v>v^v<<><^>>vvv^^><<<v<^<v>^>>v<<v<<v<^>>>>^^^<v>v^<><vv^<^v^v<>^^^^>^^v<>vv<vv>>>vvvv^vv>^>v>^<<<v^>><^^<^^^><><<v<<>>v>^>v^^<<>v^v>^>^v<^^>^>>v<<v>v^<>^v^<<v<v^>>v>v<vv^<^><><<^<><^><^<<^^<><>v<^^^v<^^v<>^^>><v>v^<v<v^>^<v>^v<<>^>^^<^v^>><><>>>>>^<>vvv^<v<v^^v^^^>v^^<>>v>>^><<><^>v^^<<<v<>>v>v^^v^^<<<^^<<v<^<>v>^^<^^vvv^>^><>^<<>>^^<^>v<<<<<^<<>^vv<^<v^<<<<>^^><<^^^<vv<vv<^v<>v<>v<>><><vv^v^>^<vvv>><><<<^<>v>^v<><>>><v<>^v<vv<^^>^<v<v^<v><><^>>^v>>^vv<<^>>vv^<<vv>v>><v<><>>^>v<v<v>v>>>v^<>^<v^<<<><v<><<>v^^<<<vv<<><^v<<><<>>^^<^^<^<><<>vv<<^>>^^>^v^v<^vv^>^v>^vv^<v<>^^<>>v>v<v<<^>^^^^^><><v<><>v<v^>>v<>>^>v^vv^<<<<v>^^>v>v^<^v^v^<<>><v^v^v<<>^>>>>vv<v><<^v^vv<>^>^v^^<vvv>^<^>^<v^>>vv^^>vv^^v<^^<^<>^^<^vv>vv>v>^v><^>v>>v<v<><>>>><v^<v^<<v^^v^^v^<^>v>^vv^^v^>^>>vvv^^<v>^><>vv><>^>>v>v><<^>>^^^vv<vv><<v<<>>vvv<^<<>><^><\n" +
                "^v>vv^^<v<<>^^>^v^<vvvv^v>^^^v^<<^>^^v>>^>^^<<vv>vv^<vv>>vvv>^<v^^vvv^^v<^<^^><<><>^v<<v>v>>^v><v>>^<^<v^v>v^><^<><v^<<><^>vv>v>v<<<<^<v>v<>>^>^>>^<<^<^^^>^vv^<<<<<>^v<<>v^>v<>^<^<v<>^<>^><^^>>^><v^<<^v^v>^<>^^^v<<<<^v>>>v<<<v<<^^<^><v>^^<vv>v><v^v^v<v^v^^v<v><>>vv<<v^^<^^>>^<>>^^^vvv<v>>^>vv<>><^vvv>><vv<v^>^<^<>vvvv^<^^v<><^v^><><<v<>>^^<>><^<<<<<>vvv^<v^^<vvv<<><<^vv<^v<vv^<^<<^><<<^><^<^<vv>vv<<<v^<>^<<>v>>^^>^v^>^>^>>v<>^v^v^v>v>v<>v<v><<v>>v<<<^><v^>>v>^^<<^^<><v>v^<><^v<v<^^v^<>>>>><>^^^>^v>>^^>vvv<>>><>^<v>>>>v<^^<v^>^<>>><<<^v>v^<v^^v^^v<v<<<>vv>>^>>^vv^^>>>^><^^>>>v^^^<v<<^<<^>><>^<^<<v<<<>^^v<^<><>>vv>>^<<v^vv<^^v<v^^>v<^>v^^v>v>v<v>>v<<<^><><><^><<v><v^<<^v<^>^>>^<<^^v^<>^<v<>vv<>>v<^><^^^v<v<<><<vv^<<<>>^v^^^>^vvvvv^<<>v<<<vv<>v<<^<^^^<v^^<>^>^<v>v<vv><^<^^^v^v^<v^<^<v<>^>^^v<<>>^<>^>^v^<>v>v^>v><<><v^vv^<<^>^<vv>><>v^<v<^v^vv^^^><>^^>>v><v>^vv<>v^<<<<>v>v<v>>>^v<>^>^<^>^^<^<^><<<v<><^<v^^<>>^<><v^^^v^<<<<v^^><<^^^v^^^><<v><<>v^^^<v^<>^<<<^^v^^<v>><<<<v<v^v^^<<v>^^v<>><vvv\n" +
                "^v<>><v>>^^^<<^v<v<<^>^<^^<<<v<v^><^^vv^v^v^v^^>>vvv^><vvv>>^^v^^^^>>>>vv>><><v><>vvv^<^v<^v^<^<v<^><v^>^<<v<<v>vv^^^^v^^<v<vv>v>^<vvvvvv^v^><<v<<vvv^^<^>v>v^v<><<v<>vv<^v^v><v>>^><vvv>^><^>^><^>v>^<><v>v<v><^^v>>^^>>>vvv>vv>>v<v<<<>vv<<>^>^><vv<><^<<^vv^vv<<vv^v^vv<v>>v<<^<^<vv^^v<^^v^<^v>^^v>^<>>>vv><^<^<^>>>>><<>^^v<v><>><^^<^v<>v<^<<>v<v>^<v>>v<<>^<v^^<^v^>>v<>^>>^<^>>v>^<v<^<>^<v<^<^^^<<>v<^<<>>vv^<v<<>^<v>vvvv>^<>v>>>v<>v^v>v^<^<^>vvv<><>^>^>^^<v^<<>^<v<vv<^^<<>v<vv^>>^>vv^><<v><<><^><^><<^>v>vv^v^>>>><<vv>>>>v^^v>v<^v>v^<^^^^<<>^<>v>>^>>vvvvv>>^v^^^>^>><>^<<>v>vv<<v>^>>v<v><^v>^>v^<>><>^v^v<^<>^<v>^>v><>^vv^<vv><v^<<v<v>>^>><<><><v<^>>>^vv^<v^<vv<^^>^><>^vvvv>>>v^^>^<<>^<^v^vv>><>>>v^>v<<v>^^v>>>^>v^<vv<<v>^>>>><>^>>^^v^v<>v>vv^^v^v<<v^^v^<^v>^^<v>^<^^<>v>vv>^^<>v>^>>v^v>vvvv>^<vv>><>>v>^<<<>v<<<^vv^<<v>v<vv^^v<v^vv><vvv<<^^^^vv><vv>v^v<vvv><^>^^v^^v^v<<><<^>v<^v^^<v^><v>>><<<v<^<^<>>^^><vv><v>>^<v^^<^><><^^v^<<<v><<<^<v<^^v<^>>^vv^<><^v^^<v<^<v^<>>>>>^v>v^<<<>^^>>>><>><<vv<v>^<\n" +
                "^>>v>^><<^<<v>^^^v^<vv<v><<<^>^vv<>>^><>^>>v^^v>v><>v^v^^<<v<>><v>>v^<<>^^><>><><>vv>^^<^><<^>v^>^>v^^<<^<^<<<>^v<v^<^^v<>^v<>^>>vv>v><>v^<><>v<vv^v<>vv<^>>>^v<><^<^^^<v^><v^v^^<<^^><>v>><^v>v^>^>^v^v<>v^><>><^v>><^v>^<^<^vvvv<<<v^v<<v^>>v<^^>^>^>^<vv^<^<v><<<^v><>>><^^>>><>^^<v<><<<>>v>>><<vv<>^v^><><<<<v^v<>v><<v>>>><v<v><>v^^^^^>>v^^<>>>vv^v<<v^^v^^vv<v^v<^>vv^>v>v>>>^<<^^^<v<v<^^v>^>^<v<>^v^<<<vvvv<v>v>>^<^vvvv^>vv<vvv<^>^v<^^<>^v<^<>^^<v>^^vv>><>^<v>v><>vv>v>><<>v><>>^v>v<^^v^><<v><^v>vv><><<vvv^v>^<<v<^vvvv>^><>v^vv>^^v<v>^>>v>^><<^<v<<>^>v><><^<<<>v^<><>^v<^^v>>^<>>>>^^><v^<><<>v<^>>v^^^<>>^<^^^v^v<>^v^<^v<>vv>>^^v^v<v><^^>><<><vvv^>v<<vv>v>v>vv>^<<v^vv<^<<>^v<v<vv>>>vvvv<^^^v>>>>v^^<v>>vvvv<^^v^<<>>><^<>^v>^<>^v<<<v^<v^<^>>^v^<<v<>v^>>>v<<><^^^>^<v<^>vv^^<<v<>vv<<<^^<<>>^><<<<v^^<^v>v^^^>v>v^^>v>v<v>>^v>>^><<<>^<><>^>>^^^>v><v<>>^<^^^><>^<^v^v^vvv>v>vv>vv>>vv<v<>^>v>><v>><<^vv<<>>v<<<^><v^vv>>>v><<v^>^<v>v><<>><^^v>>^<v^>^<^<^v<<<^^<<v<>vv<vv<<v>^v><vv^vv>>v<>v^vv><<<v><^<v<>v<\n" +
                "<><v>>^<>vv>v><<^v><>vv<<><<<><v^><v^^^>>><v^^<>^^<^>v^^><v^<>>v>^>>>>>^<^^^^<<>^v^>vvvvv^^^<<v<v>><<^>>>vv^v><><<^vv<^^^>^>>v<<^><^><v<^^>v<^^>vv<<<<^v>v>^v^vvv^v<^v<<^>^>^vv^<><<vv>v<v>>v>>v^^^<^^>>v^<^v>^v><^^>^<^<>vv<^>>v^^<vvv<vv^v<vv<vvv^<vv<v<>^v><^>>><^>^^vvvv<<^v^vv<<<>v>v^>^>>^^v^>^>v><v<^v^^<^v<<<v^vv<v^>v<^<^>vvv><>v>><<<^<vv^><v^<<^<><>v^^>^^<vv^vvv><>><>vv<^<>>>v>vv<^v<v>^>^^^<<^>^><^>v^^<>v<^v<v^vv>v<><^><>>v^>v><v>^v<vvv^<>>^<<^<^^vv>>>v<>^v>vvv^vv^^^>^vvv<v^v>^>v^v>^<v<>^>v>v<<<><><>v<^v><vvvv><^>v<><v>vv<<vv<<^^^v<>^^^>>v><><>>v<^^><^^<v>>^^^^>v<^vvv<v^<><<<v^^<<^v>v<^^>v^<>vv^<v><^v>^^v^vv^><>^v^^^^>^^>v^>v^>v>v>^><^><>v^v>>v><>^><v<><v<><<vv^v<v<<<^v<<v>v<^v^<>^^v<<v<^^><>v^>>>vv>v^vvvvv>><v>>v<<<v>>^<<^><>>^>^v>>v><v><^^v^><>>^<v<>^<vv^v>^v<^<v><>v^^^<v^<<v^^<<><<v^v>^<^v>>v<v>vv<v>^^>v^v^>>vv<><>vvv>vv>><^><^>^vv><<^^>>vvvvv<<<v^^<v^^vvv>>>^^^^<^>vv>^vv<>v^>>^<v><<<^^v>^>vv>vv^>vvv^^^^<v>>>>v^vv^^>^>><>>>>><<^vvvv>^vvv<^<^^>v^<vv<v><<<^^>^v>><^^v><^^vv<^v><v>v^vv>\n" +
                "v>^<<>vv^<<<^>vv^<<v>^<^<v<>^<><^^<^^>vv><vvv<<v<v^<>><>^<^><v>><v><>v^^v<>v>v<>>^^><<vv<>>^^<<<<v<^<>vv><<v^vv>vv^v<vv<>v<^<^<^^^^vv<<v^^v^v<v>><><<<v><v>>v><^v^>vvv<><v>>vv^>v^<<<v<>><^<^^v><<^<^<>v^v^^>v^<^>><^>v>v>><<v<<^^>^^>>v>><<<v^v^^>v^v^^v<v><v^<<>>v^<<>vvv<>^<v^><^v>^v<^v><<^<v<<<>v^>>^>v><>v><^^<>>^^<><<<v<v<<>^><>>>>>vv>>>>>v<vv>^^v^>^><vv>vv^><>^^<vv^v^v>v^>vv^<>><>^<<><vv^<><>>>^>vv^<>>vv><<v<<vvv>>v^v><v>><<<>v>v^v<><<<^<^^v>>v<^><v>vv<<vv<v^v><<<vv>v^^<v>v^vvvv^<<><v^v^<<^v<<>>vv<v^v^^>^>v^<>><<<v^^<^^v<<v<>^^>><v<<^v><>v>v<><^>^^^<v<<>>v<^<><>vv^<<>v>v<vv<v>><^>^v^<<>^<><>>v^^<<>>><<v><<v^v>>v<v<<^v^^^v^^v<<<<^v>^^><><<<>^v<><<vv^^><v<<v<^^vv>><v>v^v>><v<v<v^><^^^^<^>^<^>v<^<<v^^^>v<<v><^>><<><^<^>>>><v^^<v>><<^<^<^v>^<<<v>^>v><v>><>^<>^^>>v<<v^^^<>^^>>>>^^^vv>vv^^<v>v<v<^<>v<v^<^>^v><v><<vv<>>>><<>v>>^^<>><>><^v^v>^v^^<<<^>v<><>^>>vvv<^^<>>^>^v<^<<<><<v><<^<<^^^vv>vv<<<>^<vv^vv^<v><>^><<^<v>v<^^^<^>^v^v>^<v<>>v<vv^><>v>>^v<<<^vv>v>>v<<<^<^>vv><>v>>><v>v<>v^><><^v^^^<\n" +
                "<>vv<><^^><<<<>v^v>v<v^v<^<>vv><^>>^^v<vvv>v<v^><v^v>v>vvvv^<^vvv^vv<>v^^>v><>v<v^vv>vv^^vv<<<>vv>vv<<^v<<^><>v^<^<vv^^^^>><<^^v<v^<<>^v<^^^v>>>v<^^^v>^>^<<<<v<v^^>^v<>>^>>>>^<vv^^^^>v>v>v<^<<v<<vv><>>vvv<v^^>^><>^>^v>><^>^<>^v^^>^^<^<^v<<v<><<>^<v^vv>v<v<v<<v>><<<>vvvv^<^vv<v^^>>><v><^<^<^^<^>^<<>>v>>^^>><v>>vv>v^^v^>^<>v><>v^<>^><<^^><>>^><<v^<^^^v>^>v^<^>vv>>vv^>^vv<>>^<<>^>v<^vv<<>>v>v^^^^^v^v^^><vv>^^^v>^vv<><>^>^>v>^v^<v>v<<><^<<^<v^<<^vv^^<>vv><vv^^>^v<<>v^>vv<v><v>v^>^^>^^>v<v^^^<v^>^vv^>^<v^>^>v>v<<^v>^<v<^>^<v>vv^>vv<>^>^<^>vv>vv^v<^<>v><><vv^<^^^^vv^^<<v^v<<^>>><>v<>>^^^>^<vvv><^^v>><><v<<^^<<v>^^<v><^>^><^vv>><^^>^<vv>>v>><^>vv<<v^><^><<>v<>^^<^vv<<>v><>>^vvv>v><>>^vv>>vv<<^^>v>v>>vv^<v><>v^<^>>>vvv><v^^v^^vv<^<v<v^>>^v<^^<>v^><vvv<v>>>>^>^^<><v^^>><<<<v>^v<v^vv<>^vv<>^v>^^^v^>^vv^vv<^><<<<v<<vvv<>^<^^<<^>vv>^>^vv>vv<^^<>>v<v^v>v^^>>vv<^>^<^>v^<v><v>^vv^<^^^<<^^v>>>>>^<^vv>^^>^>^^>>^<<vv<^<<>^<><v>v<>v<<^^>^>^v^<<vv^vvvv<^>>><>>vv<^<v^<>^^v<<^<<<^^^^<><<v><v>><<<v^<<>>v>^><\n" +
                ">><<^<<<<><^>vv^>>vv>^^>>^v^<<^^v>v<>v<v<v^><<^><<>v^><>v^<<<v<<<<<^>^>><>^v>>><<<v<^>^>><<v>^^<^>v>v<<vv><v<^<>^><^^v^^v<><vv^>><^v>^<<v><vvv^<^<<v<>^^vv<>>^>v<>^><^<>vvv<^>vv<v><v^v^^v^>^^>v<^>^^<<v><>v^<^v>^><><<><>><^<v<v<^v<vv><^>^>vv^<v>^><^>vv><><>vv<^^<>v>^<>vv<v^v>>>v>v^><^<><v>^v>v^v<^v^v>>>v^vv>>v>^vv^>^>><>>^^v>^v^^^^<v>><^>vv^<>><<^^v>^v<^<<>^v^<><^>v<<^<^>>^<>><>^^^vv^v>vv<>^>v<>v^v^^^^><^<vv><<^>^><<^v^^^><>^<vv^<^><v<v<v<^>vv<v^<<>^>>><v><>>><>vv>>^><^<>vv>>v^<>v^v^^>^>v<<><^^^v<^^>>^^<v>v>^<vv><v<^>^^^>vvv<>>>v^><v^^vv<<>>>^<>>v>>>><v>v<>v^^^^>v<<<<^^<^^<v<>^>^v>^<<><^>^vv^^<^>v^^vvv<vv^vv<v^v<>>^^>><^v>vvv>^^>^>^>vv^>v^v^vv^^^^v<v^vv>>v<^<><v<<<<<v><>>v^<^^<^<>>^v<^<<v>v^>^<<^<^<^^vv><><^^v<<<<v<<<^<<>^^^<>^v^^><>^>>vv^<<<^>vv<>v><^>>^v<<^>^^><v<^>>>^^>v^<^<<^^v>^v<><^<vv^<vv<^><vvvvv>^><v>v>>v>^^^^><>^>^^<vvv>>>v<v><<><<<<>>><<>^^^vvv^^>^^^<v^v<v<<v<<v^<v>^>>^>v>^v><<>^<v>^<^<^^<v<><^<<^>>vv^><>v<^<^vv><><>>^^^v><<>v>>>><>^><>>>><vv^<>>^v>^<v<^v>v>v><<^^v^<>>^vv<<^<^\n" +
                "<v>vv<^<^<>^>>>><^<>v^<<^v<^^<v<>><v<v^>vvv<<<<<v>^<v^vvv>>vv^>><>v<^^<><><^<^<<v^^>>vv><><^<^v<^<<<^^<>><>>v^v><>>^<^v><^<^^<>v><^v<^<^<<>v<>^<^v<^v^^v>^><v>v^^^v>v^^>>^><^<^<<>^v>v<^vv<v^^<^>><><^v^<>v^<v<v^v^v>^^v<^<^^vv<<>>><>vvv^^<>^^>^<^v^<<>v^<^<^<v^^^>^>^v<v<>vv>>>^<<^v<v>v><>^v>^vv<v<>v^>>^>v>^<^<^>><v>vvv^<>v^^<>v^>><<>^<><>^>^<^^v^<^^<^^^v^<v><v^>>><v^^>>v<v>>><<vv<<><^v<v>>^<v>vvv^>>>>>>>v><>^>>^<<^<>^v^vv^>>v<^^^<vvv^><v<vv>^>v<>^^<vv>v^><<vv><^<vv>v<<^<<v<vv<^>><<^>^v<^v<^><><^<v<v>>^^<^><<<<v>>^v>><^>>^v^<<v<>^<><<>>v>v<^>>>^>>^^<<v<v<<<<^>><vv>>^v<<v<^<^v<<^<>^^v>^v>^^<v<^^>^><<<<^<^<><^><v<>^>vv^>><>>><v><v^><v>vv<<^^^v>^>v<^v>><>^<v>^<^^>v^<>>v<>v<<^^v^^>>vvv<><v<v^<<v<^v^>v^^^v>v>>v<<<<<^>v><<v^>v>>><v^<>>>>v>v^^<vv>><v><v^<^><>v^vv><<>><v<>^^>v<<vv>vv^<v>><<v^^>v<>v^^><>^<^>v><<><v><v^><v^<^<vv>^<<^><<vv<<<vvv^^<^v<v<>v><>><v<><><<v>^<>^v^^<>v<><<<<^<vv<vvvvvvv^>><^>vv^v<^v><>^^><v>>^>v<>><^><><^<>><>>v>>>>vv>^v>v<v>v<>^^<>>^<>>vvv^<vv^v^^^>vv>^vv>v<<>v>>>>v>^^v<>>>\n" +
                "v>v^^<^>v^<v^>>v><^><v>>^^>>v<^<>>^>v^v>>v^v^v<>v<>>^v>><v>>v<^^^<vv>^v^vv>>^^^vvvv^v^vvvv>v>><vv<<^v>^>><vvv^^>^<^^v><^<v^><^<<^>>>v>>><<<><<^>>v>^<^^><><>v^v><^^vv^><<<vvv<^<<>>^^v>>^vvv^>v^>v<<><>v>v>><<^v^>^^^^<<^<><<>^^<^v<>>><^<vv<<>v<v^^>v^>>^<<v>^^vv<<>>^><^<<^<^vvv^>>>v^^^<<<v^^<<vvv>v^v>v>vv><^v^>^^v^v>>v<<^^<^v>^^v><>>^>^^<vvv>vvv<^v^<vv>^^<v>>v^^>vv^<<v^vv^<<v<v>>><>^>^<^^v>v>^v<^^vvv^>^>vvv<^vvv>^>^><^<v^^<vvv><v^^v>><<>>^><v<<<v<<<^>v^><v<<v^v^<^<<>vv><v<^^v^><>>^>>^vv>^<>vv><><<vvv^^<^<^>^><<^v<>><<<^<>v<>^<^v<^v^v<><<><v><v>v^vv<<^^<^>^>^^>>v<<>><<vv^<<>v<<^>^^^v><>>>><>><><^^^>vv^^>v^>><^<>^<^>v<^>>v>v<v^^v^>vv^v<<<><vvvv<^<>^v^v^>vv<>^v>v^>^v<<<^vv^<>>v<^<<^^^<<<>v<v>><<^^^^<>v<>^<<^>>vv^>><v>^<<v<v>><^>^<v>v>v>v>v^^>vv^vvvv^<v>>>><^^<<v>v<^^<^>vvvv<<<vv^<>v^v^<v^>vv>^><<v^><>^^>^<<^vvv^v^><^vv>^<<<v>v><><>>^^>v>^^vv<^^v>>>v><^<^v^<^v>>>^<>^<>^v^^>^^>><^><><^><^v^><<<v^<>^^^<<^^<>><<>v^v^vvv^>v<v<<<^>>>v<>vv>>>v^vv>>^<>>vv^^^^^^vv^v^>>>>>^><v^^>^<>v^^^><><>v^^^^<>vv<<\n" +
                "^^<v>^>>>v<<><^^<^^<^v><><^v><v>>><>>v>><><<v^<v^<<<^<<v^<^^<^v><>v<<v^><^v<vv><^>v><<v^^>>>>^>>^^^v^v>>^vv>v^^<v^<>>^<^^^^v>>^><^v^v^^<^<<^^>^vv^^v^^v^><v^^^>^vv^<^vv<<>^>^^<>>>v^v<>>>^^^^<<^>>v<<<<v<^<>^vv^^>^>^><<<>v<>>><><^>^>^v>>v^v<><<v<^v<v^vv<>v<v>><>>^<v^>^vv>v>^^^>v^<v^v^>v^v^^v^vvvv<^^^^^vv>>v<<><<<>v><<<^^^><^><v<vv>>^><<<>^<^v<><v>>v><v>>^^<>>>^<^v<<^^>><>v<v^<^>^v>^<v>v>>>vv>>^^vv>^^v<>^<v^<vvv^>v^>>^<v^v^^<v><>v>>>^v><^v<>>v><^v>^<>>^<^v^>^<vv>v>^>^>>^>^<^<<^v<>v>>v^v<v>>^<^^<<>^^vv><<<<v>><<<><>^>v<><v^vvvv>vv^<><<^>^vv<<^v<v^<><><<>^>><^^v>v^<v>><<^>v<<v<<>>vvv<vv>^v<>^vv<v<<vvvv<<v^<vv><v^<^>><vvv><><vv><<>><>v^>>v^<<^<<^v^v<<>>><^<v<>^v^<^>v><^<^<^^^<<>^^><vv^>^>^^^^^^><vvvv>^>>^><<>^<<<<>>>>^<<>^vv<>^vv^vv><>v<v>^>^<<>v>v><<<><v<v<>>vv^^<<^>><v^<^>>vv>^>>vvv>^><^v^v<<><^^<>^^>vv<>>>v^>v^^^^>^v<<<^<<^><<^v^^v^<>>v<>v>^>>^^^^v^>v<>>>v^^>^<v>^v><><>><>>>>^^<vvv^<>^<<>v<>v<v<^<>v>^><<^v<v>><v<v^>vv<<<<v^>^v<v<^v><^<>>>^>>>>><v^vv<<>>v<<>><^>vv^><^><vv>^>><v^^^>>^<vv^vv>";

        String input1 = "#######\n" +
                "#...#.#\n" +
                "#.....#\n" +
                "#..OO@#\n" +
                "#..O..#\n" +
                "#.....#\n" +
                "#######\n" +
                "\n" +
                "<vv<<^^<<^^";
        String[] split = input.split("\n\n");
        String[] ss = split[0].split("\\n");

        char[][] map1 = new char[ss.length][ss[0].length()];
        char[][] map2 = new char[ss.length][ss[0].length()];
        for (int i = 0; i < ss.length; i++) {
            map1[i] = ss[i].toCharArray();
            map2[i] = ss[i].toCharArray();
        }

        int answer1 = solutionForPartOne(map1, split[1]);
        System.out.println(answer1);

        int answer2 = solutionForPartTwo(map2, split[1]);
        System.out.println(answer2);
    }

    static char up = '^';
    static char down = 'v';
    static char left = '<';
    static char right = '>';
    static char robot = '@';
    static char goods = 'O';
    static char wall = '#';
    static char empty = '.';
    static int Y = 0;
    static int X = 0;

    public static int solutionForPartOne(char[][] map, String instruction) {
        int res = 0;

        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[i].length; j++) {
                if (map[i][j] == robot) {
                    X = j;
                    Y = i;
                }
            }
        }

        for (char d : instruction.toCharArray()) {
            if (Objects.equals(d, up)) {
                boolean moved = move(map, X, Y, map[Y][X], X, Y - 1);
                if (moved) {
                    map[Y][X] = empty;
                    Y = Y - 1;
                    map[Y][X] = robot;
                }
            }
            if (Objects.equals(d, down)) {
                boolean moved = move(map, X, Y, map[Y][X], X, Y + 1);
                if (moved) {
                    map[Y][X] = empty;
                    Y = Y + 1;
                    map[Y][X] = robot;
                }
            }
            if (Objects.equals(d, left)) {
                boolean moved = move(map, X, Y, map[Y][X], X - 1, Y);
                if (moved) {
                    map[Y][X] = empty;
                    X = X - 1;
                    map[Y][X] = robot;
                }
            }
            if (Objects.equals(d, right)) {
                boolean moved = move(map, X, Y, map[Y][X], X + 1, Y);
                if (moved) {
                    map[Y][X] = empty;
                    X = X + 1;
                    map[Y][X] = robot;
                }
            }
        }

        for (int y = 1; y < map.length; y++) {
            for (int x = 1; x < map[y].length; x++) {
                if (map[y][x] == goods) {
                    res += y * 100 + x;
                }
            }
        }

        return res;
    }

    public static boolean move(char[][] map, int curX, int curY, char curPoint, int nextX, int nextY) {
        int h = map.length;
        int w = map[0].length;

        int diffX = nextX - curX;
        int diffY = nextY - curY;

        if (diffX != 0 && nextX < w || (diffY != 0 && nextY < h)) {
            char nextPoint = map[nextY][nextX];
            if (nextPoint == goods) {
                boolean b = move(map, nextX, nextY, nextPoint, nextX + diffX, nextY + diffY);
                if (b) {
                    map[nextY][nextX] = curPoint;
                }
                return b;
            }
            if (nextPoint == empty) {
                map[nextY][nextX] = curPoint;
                return true;
            }
        }
        return false;
    }

    static char[][] newMap;
    static char leftGoods = '<';
    static char rightGoods = '>';
    static char newEmpty = '_';

    public static int solutionForPartTwo(char[][] map, String instruction) {
        int res = 0;
        newMap = new char[map.length][map[0].length * 2];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == wall) {
                    newMap[i][2 * j] = wall;
                    newMap[i][2 * j + 1] = wall;
                }
                if (map[i][j] == goods) {
                    newMap[i][2 * j] = leftGoods;
                    newMap[i][2 * j + 1] = rightGoods;
                }
                if (map[i][j] == empty) {
                    newMap[i][2 * j] = newEmpty;
                    newMap[i][2 * j + 1] = newEmpty;
                }
                if (map[i][j] == robot) {
                    newMap[i][2 * j] = robot;
                    newMap[i][2 * j + 1] = newEmpty;
                }
            }
        }

        for (int i = 1; i < newMap.length; i++) {
            for (int j = 2; j < newMap[i].length; j++) {
                if (newMap[i][j] == robot) {
                    X = j;
                    Y = i;
                }
            }
        }

        for (char d : instruction.toCharArray()) {
            if (Objects.equals(d, up)) {
                boolean moved = newMove(newMap, X, Y, newMap[Y][X], X, Y - 1);
                if (moved) {
                    newMap[Y][X] = newEmpty;
                    Y = Y - 1;
                    newMap[Y][X] = robot;
                }
            }
            if (Objects.equals(d, down)) {
                boolean moved = newMove(newMap, X, Y, newMap[Y][X], X, Y + 1);
                if (moved) {
                    newMap[Y][X] = newEmpty;
                    Y = Y + 1;
                    newMap[Y][X] = robot;
                }
            }
            if (Objects.equals(d, left)) {
                boolean moved = newMove(newMap, X, Y, newMap[Y][X], X - 1, Y);
                if (moved) {
                    newMap[Y][X] = newEmpty;
                    X = X - 1;
                    newMap[Y][X] = robot;
                }
            }
            if (Objects.equals(d, right)) {
                boolean moved = newMove(newMap, X, Y, newMap[Y][X], X + 1, Y);
                if (moved) {
                    newMap[Y][X] = newEmpty;
                    X = X + 1;
                    newMap[Y][X] = robot;
                }
            }
        }

        for (int y = 1; y < newMap.length; y++) {
            for (int x = 2; x < newMap[y].length; x++) {
                if (newMap[y][x] == leftGoods) {
                    res += y * 100 + x;
                }
            }
        }
        return res;
    }

    static Set<Day12.Point> set;

    public static boolean newMove(char[][] map, int curX, int curY, char curPoint, int nextX, int nextY) {
        int h = map.length;
        int w = map[0].length;
        int diffX = nextX - curX;
        int diffY = nextY - curY;

        if (diffX != 0 && nextX < w) {
            char nextPoint = map[nextY][nextX];
            if (nextPoint == leftGoods || nextPoint == rightGoods) {
                boolean b = newMove(map, nextX, nextY, nextPoint, nextX + diffX, nextY + diffY);
                if (b) {
                    map[nextY][nextX] = curPoint;
                }
                return b;
            }
            if (nextPoint == newEmpty) {
                map[nextY][nextX] = curPoint;
                return true;
            }
        }

        if (diffY != 0 && nextY < h) {
            char nextPoint = map[nextY][nextX];
            if (nextPoint == leftGoods) {
                set = new LinkedHashSet<>();
                boolean b = moveTogether(map, nextX, nextY, nextX + 1, nextY, diffY);
                if (b) {
                    doMove(diffY);
                    map[nextY][nextX + 1] = newEmpty;

                }
                return b;
            }
            if (nextPoint == rightGoods) {
                set = new HashSet<>();
                boolean b = moveTogether(map, nextX - 1, nextY, nextX, nextY, diffY);
                if (b) {
                    doMove(diffY);
                    map[nextY][nextX - 1] = newEmpty;
                }
                return b;
            }
            if (nextPoint == newEmpty) {
                map[nextY][nextX] = curPoint;
                return true;
            }
        }
        return false;
    }

    public static boolean moveTogether(char[][] map, int curLeftGoodX, int curLeftGoodY, int curRightGoodX, int curRightGoodY, int direction) {
        if (set.contains(new Day12.Point(curLeftGoodX, curLeftGoodY))) {
            return true;
        } else {
            set.add(new Day12.Point(curLeftGoodX, curLeftGoodY));
        }

        int h = map.length;
        int nextLeftGoodX = curLeftGoodX;
        int nextLeftGoodY = curLeftGoodY + direction;
        int nextRightGoodX = curRightGoodX;
        int nextRightGoodY = curRightGoodY + direction;

//        char curLeft = map[curLeftGoodY][curLeftGoodX];
//        char curRight = map[curRightGoodY][curRightGoodX];

        if (nextLeftGoodY < h && nextRightGoodY < h) {
            char nextLeftPoint = map[nextLeftGoodY][nextLeftGoodX];
            char nextRightPoint = map[nextRightGoodY][nextRightGoodX];

            boolean m1 = false;
            boolean m2 = false;
            if (nextLeftPoint == leftGoods) {
                m1 = moveTogether(map, nextLeftGoodX, nextLeftGoodY, nextLeftGoodX + 1, nextLeftGoodY, direction);
            } else if (nextLeftPoint == rightGoods) {
                m1 = moveTogether(map, nextLeftGoodX - 1, nextLeftGoodY, nextLeftGoodX, nextLeftGoodY, direction);
            } else if (nextLeftPoint == newEmpty) {
                m1 = true;
            }

            if (nextRightPoint == leftGoods) {
                m2 = moveTogether(map, nextRightGoodX, nextRightGoodY, nextRightGoodX + 1, nextRightGoodY, direction);
            } else if (nextRightPoint == rightGoods) {
                m2 = moveTogether(map, nextRightGoodX - 1, nextRightGoodY, nextRightGoodX, nextRightGoodY, direction);
            } else if (nextRightPoint == newEmpty) {
                m2 = true;
            }

//            if (nextLeftPoint == newEmpty && nextRightPoint == newEmpty) {
//                map[nextLeftGoodY][nextLeftGoodX] = leftGoods;
//                map[nextRightGoodY][nextRightGoodX] = rightGoods;
//                return true;
//            }
            if (m1 && m2) {
//                map[nextLeftGoodY][nextLeftGoodX] = curLeft;
//                map[nextRightGoodY][nextRightGoodX] = curRight;
//                map[curLeftGoodY][curLeftGoodX] = newEmpty;
//                map[curRightGoodY][curRightGoodX] = newEmpty;
                return true;
            }
        }
        return false;
    }

    public static void doMove(int dir) {
        List<Day12.Point> collect;
        if (dir > 0) {
            collect = set.stream().sorted(Comparator.comparing(Day12.Point::getY, Comparator.reverseOrder())).collect(Collectors.toList());
        } else {
            collect = set.stream().sorted(Comparator.comparing(Day12.Point::getY)).collect(Collectors.toList());

        }
        for (Day12.Point point : collect) {
            int rightX = point.getX() + 1;
            int rightY = point.getY();

            int nextLeftX = point.getX();
            int nextLeftY = point.getY() + dir;

            int nextRightX = rightX;
            int nextRightY = rightY + dir;

            newMap[nextLeftY][nextLeftX] = leftGoods;
            newMap[nextRightY][nextRightX] = rightGoods;

            newMap[point.getY()][point.getX()] = newEmpty;
            newMap[rightY][rightX] = newEmpty;
        }


    }
}
