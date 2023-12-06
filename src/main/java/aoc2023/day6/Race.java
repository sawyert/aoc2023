package aoc2023.day6;

public class Race {

    private long time;
    private long recordDistance;

    public Race(long time, long distance) {
        this.time = time;
        this.recordDistance = distance;
    }

    public long countWaysToWin() {
        long waysToWin = 0;
        for (long button=0; button < time; button++) {
            long totalDistance = this.calculateDistanceTravelled(button, this.time);
            if (totalDistance > this.recordDistance) {
                waysToWin++;
            }
        }
        return waysToWin;
    }

    private long calculateDistanceTravelled(long buttonLength, long timeForRace) {
        if (buttonLength == 0) {
            return 0;
        }
        long timeMoving = timeForRace - buttonLength;
        return timeMoving * buttonLength;
    }
}
