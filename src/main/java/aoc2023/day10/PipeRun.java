package aoc2023.day10;

import java.util.ArrayList;
import java.util.List;

public class PipeRun {
    private List<Node> nodes = new ArrayList<>();

    public PipeRun(Node startNode) {
        this.nodes.add(startNode);
    }

    public long length() {
        return this.nodes.size();
    }

    public boolean hasMetWith(PipeRun other) {
        for (int i=1; i<this.nodes.size(); i++) {
            Node thisNode = this.nodes.get(i);
            for(Node thatNode : other.nodes) {
                if (thisNode.isSameLocationAs(thatNode)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void add(Node node) {
        for (Node eachNode : this.nodes) {
            if (node.isSameLocationAs(eachNode)) {
                throw new UnsupportedOperationException();
            }
        }
        this.nodes.add(node);
    }

    public Node progressA(Node currentNode) {
        Directions possibleExits = currentNode.getDirections();
        Node nextNode = null;

        if (possibleExits.north && !this.isVisited(currentNode.north())) {
            nextNode = currentNode.north();
        }

        if (possibleExits.east && !this.isVisited(currentNode.east())) {
            nextNode = currentNode.east();
        }

        if (possibleExits.south && !this.isVisited(currentNode.south())) {
            nextNode = currentNode.south();
        }

        if (possibleExits.west && !this.isVisited(currentNode.west())) {
            nextNode = currentNode.west();
        }

        if (nextNode == null) {
            throw new UnsupportedOperationException();
        }

        this.add(nextNode);
        return nextNode;
    }

    public Node progressB(Node currentNode) {
        Directions possibleExits = currentNode.getDirections();
        Node nextNode = null;

        if (possibleExits.west && !this.isVisited(currentNode.west())) {
            nextNode = currentNode.west();
        }

        if (possibleExits.south && !this.isVisited(currentNode.south())) {
            nextNode = currentNode.south();
        }

        if (possibleExits.east && !this.isVisited(currentNode.east())) {
            nextNode = currentNode.east();
        }

        if (possibleExits.north && !this.isVisited(currentNode.north())) {
            nextNode = currentNode.north();
        }

        if (nextNode == null) {
            throw new UnsupportedOperationException();
        }

        this.add(nextNode);
        return nextNode;
    }

    private boolean isVisited(Node other) {
        for (Node eachNode : this.nodes) {
            if (other.isSameLocationAs(eachNode) ){
                return true;
            }
        }
        return false;
    }
}
