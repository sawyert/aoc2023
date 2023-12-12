package aoc2023.day12;

import java.util.ArrayList;
import java.util.List;

public class SpringLine {
    private final String springs;
    private final String regionsString;
    private final List<Integer> regions = new ArrayList<>();

    public SpringLine(String eachLine, boolean unfold) {
        String[] parts = eachLine.split(" ");
        String springsString = parts[0];
        if (unfold) {
            springsString += "?";
            springsString += parts[0];
            springsString += "?";
            springsString += parts[0];
            springsString += "?";
            springsString += parts[0];
            springsString += "?";
            springsString += parts[0];
        }
        this.springs = springsString;

        String regionsString = parts[1];
        if (unfold) {
            regionsString += ",";
            regionsString += parts[1];
            regionsString += ",";
            regionsString += parts[1];
            regionsString += ",";
            regionsString += parts[1];
            regionsString += ",";
            regionsString += parts[1];
        }
        this.regionsString = regionsString;

        String[] regions = regionsString.split(",");
        for (String eachRegion : regions) {
            this.regions.add(Integer.parseInt(eachRegion));
        }
    }

    public long validCombinationCount() {
        long validCombinationCount = 0;

        for (String possibleCombination : this.getPossibleCombinationsList()) {
            if (this.isValid(possibleCombination)) {
                validCombinationCount++;
            }
        }

        return validCombinationCount;
    }

    private boolean isValid(String possibleCombination) {
        String groups = "";
        Character lastChar = ' ';
        int groupCount = 0;
        for (int i=0; i<possibleCombination.length();i++) {
            char eachChar = possibleCombination.toCharArray()[i];
            switch (eachChar) {
                case '.':
                    if (lastChar == '#') {
                        groups += ",";
                        groups += groupCount;
                    }
                    groupCount = 0;
                    break;
                case '#':
                    groupCount++;
                    if (lastChar == '.') {
                       groupCount = 1;
                    }
                    break;
                default:
                    throw new UnsupportedOperationException();
            }
            lastChar = eachChar;

        }
        if (lastChar == '#') {
            groups += ",";
            groups += groupCount;
        }
        if (groups.length() > 0 && groups.startsWith(",")) {
            groups = groups.substring(1);
        }

        if (groups.equals(this.regionsString)) {
            return true;
        }
        return false;
    }

    private List<String> getPossibleCombinationsList() {
        List<String> returnList = new ArrayList<>();

        String binaryMaxString = "";
        for (int i=0; i<this.springs.toCharArray().length;i++) {
            if (this.springs.toCharArray()[i] == '?') {
                binaryMaxString += 1;
            }
        }

        int binaryMax = Integer.parseInt(binaryMaxString, 2);

        for (int i=0; i<=binaryMax;i++) {
            String combination = this.replaceMarkers(i, this.springs, binaryMaxString.length());
            returnList.add(combination);
        }

        return returnList;
    }

    private String replaceMarkers(int binaryNumber, String springs, int bits) {
        String binary = String.format("%"+bits+"s", Integer.toBinaryString(binaryNumber)).replace(' ', '0');
        char[] springsSplit = springs.toCharArray();
        for (int k=0; k<binary.length();k++) {
            char newValue;
            if (binary.charAt(k) == '0') {
                newValue = '.';
            } else {
                newValue = '#';
            }
            springsSplit = this.replaceMarker(springsSplit, newValue);
        }
        String returnString = "";
        for (int j=0; j<springsSplit.length;j++) {
            returnString += springsSplit[j];
        }
        return returnString;
    }

    private char[] replaceMarker(char[] springsSplit, char newValue) {
        for (int i=0; i<springsSplit.length;i++) {
            if (springsSplit[i] == '?') {
                springsSplit[i] = newValue;
                break;
            }
        }
        return springsSplit;
    }
}
