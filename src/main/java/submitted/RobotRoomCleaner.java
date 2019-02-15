package submitted;

import java.util.HashSet;
import java.util.Set;

public class RobotRoomCleaner {
    public void cleanRoom(Robot robot) {
        // A number can be added to each visited cell
        // use string to identify the class
        Set<String> set = new HashSet<>();
        int cur_dir = 0;   // 0: up, 90: right, 180: down, 270: left
        backtrack(robot, set, 0, 0, 0);
    }

    public void backtrack(Robot robot, Set<String> set, int i,
                          int j, int curDir) {
        String tmp = i + "->" + j;
        if (set.contains(tmp)) {
            return;
        }

        robot.clean();
        set.add(tmp);

        for (int n = 0; n < 4; n++) {
            // the robot can to four directions, we use right turn
            if (robot.move()) {
                // can go directly. Find the (x, y) for the next cell based on current direction
                int x = i, y = j;
                switch (curDir) {
                    case 0:
                        // go up, reduce i
                        x = i - 1;
                        break;
                    case 90:
                        // go right
                        y = j + 1;
                        break;
                    case 180:
                        // go down
                        x = i + 1;
                        break;
                    case 270:
                        // go left
                        y = j - 1;
                        break;
                    default:
                        break;
                }

                backtrack(robot, set, x, y, curDir);
                // go back to the starting position
                robot.turnLeft();
                robot.turnLeft();
                robot.move();
                robot.turnRight();
                robot.turnRight();

            }
            // turn to next direction
            robot.turnRight();
            curDir += 90;
            curDir %= 360;
        }

    }
}
class Robot {
    // returns true if next cell is open and robot moves into the cell.
    // returns false if next cell is obstacle and robot stays on the current cell.
    boolean move() {
        return true;
    }

    // Robot will stay on the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    void turnLeft() {}
    void turnRight() {}

    // Clean the current cell.
    void clean() {}
}
