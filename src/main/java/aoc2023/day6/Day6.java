package aoc2023.day6;

import java.util.ArrayList;
import java.util.List;

public class Day6 {

    private List<Race> races = new ArrayList<>();
    private String part2Time = "";
    private String part2Distance = "";

    public Day6(String[] testInput) {

        List<Integer> times = new ArrayList<>();
        List<Integer> distance = new ArrayList<>();

        String[] line1 = testInput[0].substring("Time:".length()).split(" ");
        for (String eachTime : line1) {
            if (eachTime.trim().length() > 0) {
                this.part2Time += eachTime;
                times.add(Integer.parseInt(eachTime));
            }
        }

        String[] line2 = testInput[1].substring("Distance:".length()).split(" ");
        for (String eachDistance : line2) {
            if (eachDistance.trim().length() > 0) {
                this.part2Distance += eachDistance;
                distance.add(Integer.parseInt(eachDistance));
            }
        }

        for (int i=0; i<times.size(); i++) {
            Race race = new Race(times.get(i), distance.get(i));
            this.races.add(race);
        }
    }

    public long execute1() {
        long total = 1;
        for (Race race : this.races) {
            long waysToWin = race.countWaysToWin();
            total *= waysToWin;
        }
        return total;
    }

    public long execute2() {
        Race race = new Race(Long.parseLong(this.part2Time), Long.parseLong(this.part2Distance));
        return race.countWaysToWin();
    }
}
