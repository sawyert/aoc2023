package aoc2023.day11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Day11 {

    private char[][] grid;
    private List<Integer> noGalaxyColumns = new ArrayList<>();
    private List<Integer> noGalaxyLines = new ArrayList<>();

    private List<Galaxy> galaxies = new ArrayList<>();
    private List<GalaxyPair> pairs = new ArrayList<>();

    public Day11(char[][] testInput) {
        this.grid = testInput;

        for (int line=0; line<this.grid.length;line++) {
            boolean lineBlank = true;
            for (int column=0; column<this.grid[0].length;column++){
                if (this.grid[line][column] != '.') {
                    lineBlank = false;
                    break;
                }
            }
            if (lineBlank) {
                this.noGalaxyLines.add(line);
            }
        }

        for (int column=0; column<this.grid[0].length; column++) {
            boolean columnBlank = true;
            for (int line=0; line<this.grid.length; line++){
                if (this.grid[line][column] != '.') {
                    columnBlank = false;
                    break;
                }
            }
            if (columnBlank) {
                this.noGalaxyColumns.add(column);
            }
        }

        int galaxyCount = 1;
        for (int line=0; line<this.grid.length; line++) {
            for (int column=0; column<this.grid[0].length; column++){
                if (this.grid[line][column] == '#') {
                    Galaxy galaxy = new Galaxy(line, column, galaxyCount);
                    this.galaxies.add(galaxy);
                    galaxyCount++;
                }
            }
        }

        Set<String> uniqueLinks = new HashSet<>();
        for(int i=0; i<this.galaxies.size()-1; i++){
            for(int j=i+1; j<galaxies.size(); j++){
                Galaxy galaxy1 = this.galaxies.get(i);
                Galaxy galaxy2 = this.galaxies.get(j);

                if (galaxy1.number > galaxy2.number) {
                    Galaxy temp = galaxy1;
                    galaxy1 = galaxy2;
                    galaxy2 = temp;
                }
                uniqueLinks.add(galaxy1.number + ":" + galaxy2.number);
            }
        }

        for (String eachLink : uniqueLinks) {
            String[] link = eachLink.split(":");
            Galaxy leftGalaxy = this.fetchGalaxy(Integer.parseInt(link[0]));
            Galaxy rightGalaxy = this.fetchGalaxy(Integer.parseInt(link[1]));
            this.pairs.add(new GalaxyPair(leftGalaxy, rightGalaxy));
        }
    }

    private Galaxy fetchGalaxy(int number) {
        for (Galaxy eachGalaxy: this.galaxies) {
            if (eachGalaxy.number == number) {
                return eachGalaxy;
            }
        }
        throw new UnsupportedOperationException();
    }

    public long execute1() {
        long total = 0;
        for (GalaxyPair pair: this.pairs) {
            total += this.findDistance(pair, 1);
        }
        return total;
    }

    private long findDistance(GalaxyPair pair, int expansion) {
        int leftLine = pair.leftGalaxy.line;
        int rightLine = pair.rightGalaxy.line;

        int startLine = leftLine;
        int endLine = rightLine;
        if (startLine > endLine) {
            int temp = endLine;
            endLine = startLine;
            startLine = temp;
        }
        long lineDistance = 0 ;
        for (int i=startLine; i<endLine; i++) {
            if (this.noGalaxyLines.contains(i)) {
                lineDistance+=(expansion-1);
            }
            lineDistance++;
        }

        int leftColumn = pair.leftGalaxy.column;
        int rightColumn = pair.rightGalaxy.column;

        int startColumn = leftColumn;
        int endColumn = rightColumn;
        if (startColumn > endColumn) {
            int temp = endColumn;
            endColumn = startColumn;
            startColumn = temp;
        }
        long columnDistance = 0 ;
        for (int i=startColumn; i<endColumn; i++) {
            if (this.noGalaxyColumns.contains(i)) {
                columnDistance+=(expansion-1);
            }
            columnDistance++;
        }

        return lineDistance + columnDistance;
    }

    public long execute2(int expansion) {
        long total = 0;
        for (GalaxyPair pair: this.pairs) {
            total += this.findDistance(pair, expansion);
        }
        return total;
    }
}
