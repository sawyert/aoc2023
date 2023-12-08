package aoc2023.day8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day8 {
    List<Character> directions = new ArrayList<>();
    Map<String, Element> elements = new HashMap<>();

    private Element findElement(String currentNode) {
        return this.elements.get(currentNode);
    }

    public Day8(String[] testInput) {
        for (Character eachChar : testInput[0].toCharArray()) {
            directions.add(eachChar);
        }

        for (int i=2; i<testInput.length; i++) {
            String[] parts = testInput[i].split("=");
            String source = parts[0].trim();

            String rhs = parts[1].trim();
            rhs = rhs.substring(1, rhs.length() - 1);

            String[] rhsSplit = rhs.split(",");
            String leftDestination = rhsSplit[0].trim();
            String rightDestination = rhsSplit[1].trim();
            elements.put(source, new Element(source, leftDestination, rightDestination));
        }
    }

    public long execute1() {
        String start = "AAA";
        String end = "ZZZ";

        String currentNode = start;
        long stepCount = 0;
        int instruction = 0;
        while (currentNode.equals(end) == false) {
            Character direction = this.directions.get(instruction);

            Element matchingElement = this.findElement(currentNode);
            if (direction == 'L') {
                currentNode = matchingElement.getLeft();
            } else if (direction == 'R') {
                currentNode = matchingElement.getRight();
            } else {
                throw new UnsupportedOperationException();
            }

            instruction++;
            if (instruction > this.directions.size() -1) {
                instruction = 0;
            }

            stepCount++;
         }

        return stepCount;
    }

    public long execute2() {
        List<String> elementsStartingWithA = new ArrayList<>();
        for (String eachKey : this.elements.keySet()) {
            if (eachKey.endsWith("A")) {
                elementsStartingWithA.add(eachKey);
            }
        }

        Map<String, Long> distanceCounts = new HashMap<>();

        for (String start: elementsStartingWithA) {
            String currentNode = start;
            long stepCount = 0;
            int instruction = 0;
            while (currentNode.endsWith("Z") == false) {
                Character direction = this.directions.get(instruction);

                Element matchingElement = this.findElement(currentNode);
                if (direction == 'L') {
                    currentNode = matchingElement.getLeft();
                } else if (direction == 'R') {
                    currentNode = matchingElement.getRight();
                } else {
                    throw new UnsupportedOperationException();
                }

                instruction++;
                if (instruction > this.directions.size() - 1) {
                    instruction = 0;
                }
                stepCount++;
            }
            distanceCounts.put(start, stepCount);
        }



        System.out.println(distanceCounts);

        return 0;

    }
}
