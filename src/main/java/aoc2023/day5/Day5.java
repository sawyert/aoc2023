package aoc2023.day5;

import java.util.ArrayList;
import java.util.List;

public class Day5 {

    List<Long> seeds = new ArrayList<>();
    List<SourceDestMap> maps = new ArrayList<>();

    public Day5(String[] testInput) {
        String[] seedsString = testInput[0].substring("seeds:".length()).trim().split(" ");
        for (String eachSeed : seedsString) {
            this.seeds.add(Long.parseLong(eachSeed));
        }

        SourceDestMap currentMap = null;
        for (int i=1; i<testInput.length; i++) {
            String line = testInput[i].trim();
            if (line.length() == 0) {
                continue;
            }
            if (line.contains("map:")) {
                currentMap = new SourceDestMap(line.split(" ")[0]);
                this.maps.add(currentMap);
                continue;
            }

            currentMap.addLine(line);
        }
    }

    public long execute1() {
        long lowestLocation = 999999999999999999L;
        for (Long seed : this.seeds) {
            long soil = this.map("seed", "soil", seed);
            long fertilizer = this.map("soil", "fertilizer", soil);
            long water = this.map("fertilizer", "water", fertilizer);
            long light = this.map("water", "light", water);
            long temperature = this.map("light", "temperature", light);
            long humidity = this.map("temperature", "humidity", temperature);
            long location = this.map("humidity", "location", humidity);

            if (location < lowestLocation) {
                lowestLocation = location;
            }
        }
        return lowestLocation;
    }

    private long map(String from, String to, Long value) {
        SourceDestMap mapToUse = this.fetchMap(from, to);
        long returnValue = mapToUse.execute(value);

        // System.out.println(from + ":" + value + " -> " + to + ":" + returnValue);

        return returnValue;
    }

    private SourceDestMap fetchMap(String from, String to) {
        for (SourceDestMap eachMap : this.maps) {
            if (eachMap.from.equals(from) && eachMap.to.equals(to)) {
                return eachMap;
            }
        }
        throw new UnsupportedOperationException("Map not found");
    }

    public long execute2() {
        return 0;
    }
}
