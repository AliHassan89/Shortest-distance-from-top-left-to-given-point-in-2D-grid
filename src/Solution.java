/*
Amazon Fresh is a grocery delivery services that offers consumers the option of purchasing their groceries online and
having them delivered on schedule.  The Amazon Fresh team is planning a route for a delivery truck to deliver customer
orders in the city of Techlandia.  The planner will create a delivery area for each order to effectively plan the route.
The area is abstracted as a grid. Not all locations are accessible by road. The truck only needs to make a single
delivery.

Assumptions:
Some places in the delivery area cannot be accessed by the driver, as there are no roads into those locations.
The delivery area can be represented as a two-dimensional grid of integers, where each integer represents one cell.
The truck must start from the top-left corner of the area, which is always accessible, and can move one cell up, down,
left, or right at a time.
The truck must navigate around the areas without roads and cannot leave the area.
The accessible areas are represented as 1, areas with without roads are represented by 0 and the order destination is
represented by 9.

input:
[1,0,0]
[1,0,0]
[1,9,1]

output:
3

explanation:
starting from the left corner the truck traversed cells (0,0) -> (1,0) -> (2,0) -> (2,1). The truck covered total
distance of 3
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution
{

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>(Arrays.asList(1,0,0));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(1,1,1));
        List<Integer> l3 = new ArrayList<>(Arrays.asList(0,0,1));
        List<Integer> l4 = new ArrayList<>(Arrays.asList(0,0,9));
        List<List<Integer>> area = new ArrayList<>();
        area.add(l1);
        area.add(l2);
        area.add(l3);
        area.add(l4);

        Solution sol = new Solution();
        System.out.println(sol.minimumDistance(4, 3, area));
    }


    private int[] x = {-1, 0, 0, 1};
    private int[] y = {0, -1, 1, 0};
    private boolean[][] visited;

    public int minimumDistance(int numRows, int numColumns, List<List<Integer>> area)
    {
        visited = new boolean[numRows][numColumns];
        return minimumDistance(0, 0, area, 0);
    }

    private int minimumDistance(int i, int j, List<List<Integer>> area, int minDistance) {
        if (visited[i][j] || area.get(i).get(j) == 9) {
            return minDistance;
        }

        visited[i][j] = true;

        for (int k =0; k<x.length; k++) {
            if (isSafe(i+x[k], j+y[k], area)) {
                minDistance++;
                minDistance = minimumDistance(i+x[k], j+y[k], area, minDistance);
            }
        }

        return minDistance;
    }

    private boolean isSafe(int i, int j, List<List<Integer>> area) {
        int rows = area.size();
        int cols = area.get(0).size();

        if (i >= rows || i < 0 || j >= cols || j < 0 || visited[i][j] || area.get(i).get(j) == 0) {
            return false;
        }

        return true;
    }
}
