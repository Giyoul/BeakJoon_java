
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;

class Solution {
    private class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    boolean[][] visited;
    Map<Integer, Integer> roomSize;
    int width;
    int height;

    public int solution(int[][] land) {
        width = land[0].length;
        height = land.length;

        visited = new boolean[height][width];
        roomSize = new HashMap<>();

        for(int row = 0; row < height; row++) {
            for(int column = 0; column < width; column++) {
                if(visited[row][column] || land[row][column] == 0)
                    continue;

                calculateRoomSize(row, column, land);
            }
        }

        int max = 0;

        for(int value : roomSize.values()) {
            max = Math.max(max, value);
        }

        return max;
    }

    private void calculateRoomSize(int row, int column, int[][] land) {
        final int[] directionX = {-1, 1, 0, 0};
        final int[] directionY = {0, 0, -1, 1};

        Deque<Position> dfsDeque = new ArrayDeque<>();
        Set<Integer> visitedColumns = new HashSet<>();

        dfsDeque.addLast(new Position(column, row));
        visited[row][column] = true;

        int count = 0;

        while(!dfsDeque.isEmpty()) {
            Position currentPosition = dfsDeque.removeLast();

            visitedColumns.add(currentPosition.x);
            count++;

            for(int index = 0; index < 4; index++) {
                int newPositionX =
                    currentPosition.x + directionX[index];
                int newPositionY =
                    currentPosition.y + directionY[index];

                if(newPositionX < 0 || newPositionX >= width ||
                   newPositionY < 0 || newPositionY >= height ||
                   land[newPositionY][newPositionX] == 0 ||
                   visited[newPositionY][newPositionX]) {
                    continue;
                }

                visited[newPositionY][newPositionX] = true;
                dfsDeque.addLast(
                    new Position(newPositionX, newPositionY)
                );
            }
        }

        for(int columnIndex : visitedColumns) {
            roomSize.put(
                columnIndex,
                roomSize.getOrDefault(columnIndex, 0) + count
            );
        }
    }
}
