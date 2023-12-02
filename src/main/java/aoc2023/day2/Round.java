package aoc2023.day2;

public class Round {
    public int red;
    public int green;
    public int blue;

    public Round(String roundText) {
        String[] balls = roundText.split(",");
        for (String ball : balls) {
            String[] parts = ball.trim().split(" ");
            if (parts[1].equals("red")) {
                this.red = Integer.parseInt(parts[0]);
            } else if (parts[1].equals("green")) {
                this.green = Integer.parseInt(parts[0]);
            } else if (parts[1].equals("blue")) {
                this.blue = Integer.parseInt(parts[0]);
            } else {
                throw new UnsupportedOperationException("**" + ball + "**");
            }
        }
    }

    public boolean possible(int redMax, int greenMax, int blueMax) {
        return this.red <= redMax && this.green <= greenMax && this.blue <= blueMax;
    }
}
