import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class AStarTestcase {

    private enum GridValues { OBSTACLE, BACKGROUND, GOAL };

    /*
     * EXAMPLE TEST CASE
     * Writing a test case to check if there is no part existing from source to destination
     */
    @Test
    public void testAStarWithNoPathToDestination(){

        // Create test map
        GridValues[][] grid = {
                { GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND},
                { GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND},
                { GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND},
                { GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.OBSTACLE, GridValues.OBSTACLE},
                { GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.OBSTACLE, GridValues.BACKGROUND}
        };

        // Define starting and ending points
        Point start = new Point(0, 0);
        Point end = new Point(4, 4);

        // Define canPassThrough function (nodes are passable if they are not obstacles)
        Predicate<Point> canPassThrough = (Point p) -> withinBounds(p, grid) && grid[p.x][p.y]!= GridValues.OBSTACLE;

        // Define withinReach function (if you are just 1 step away from goal; you reach the goal)
        BiPredicate<Point, Point> withinReach = (Point p1, Point p2) -> p1.adjacent(p2);

        // Call A* search algorithm
        List<Point> path = new AStarPathingStrategy().computePath(
                start,
                end,
                canPassThrough,
                withinReach,
                PathingStrategy.CARDINAL_NEIGHBORS
        );

        // Check that path is correct
        List<Point> expectedPath = Arrays.asList();

        assertEquals(expectedPath, path);
    }


    /*
     * COMPLETE THIS TEST CASE
     * Write a test case to verify if there is a path from source to destination with no obstacles
     */
    @Test
    public void testAStarNoObstacle(){

        // Create test map
        GridValues[][] grid = {
                { GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND},
                { GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND},
                { GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND},
                { GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND},
                { GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.GOAL}
        };

        // Define starting and ending points
        Point start = new Point(0, 0);
        Point end = new Point(4, 4);
        // Define canPassThrough function (nodes are passable if they are not obstacles)
        Predicate<Point> canPassThrough = (Point p) -> withinBounds(p, grid) && grid[p.x][p.y]!= GridValues.OBSTACLE;

        // Define withinReach function (if you are just 1 step away from goal; you reach the goal)
        BiPredicate<Point, Point> withinReach = (Point p1, Point p2) -> p1.adjacent(p2);

        // Call A* search algorithm
        List<Point> path = new AStarPathingStrategy().computePath(
                start,
                end,
                canPassThrough,
                withinReach,
                PathingStrategy.CARDINAL_NEIGHBORS
        );


        // change 'true' and 'false' with your actual values ; see example test case ( first testcase) for reference
        assertEquals(8, path.toArray().length);
    }

    /*
     * COMPLETE THIS TEST CASE
     * Write a test case to verify the path if the destination itself is an obstacle.
     */
    @Test
    public void testAStarWithObstacleAsAEnd(){
       // Create test map
        GridValues[][] grid = {
                { GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND},
                { GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND},
                { GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND},
                { GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND},
                { GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.OBSTACLE}
        };

        // Define starting and ending points
        Point start = new Point(0, 0);
        Point end = new Point(4, 4);
        // Define canPassThrough function (nodes are passable if they are not obstacles)
        Predicate<Point> canPassThrough = (Point p) -> withinBounds(p, grid) && grid[p.x][p.y]!= GridValues.OBSTACLE;

        // Define withinReach function (if you are just 1 step away from goal; you reach the goal)
        BiPredicate<Point, Point> withinReach = (Point p1, Point p2) -> p1.adjacent(p2);

        // Call A* search algorithm
        List<Point> path = new AStarPathingStrategy().computePath(
                start,
                end,
                canPassThrough,
                withinReach,
                PathingStrategy.CARDINAL_NEIGHBORS
        );

        List<Point> expectedPath = Arrays.asList();
        // change 'true' and 'false' with your actual values ; see example test case ( first testcase) for reference
        assertEquals(expectedPath,path );
    }

    /*
     * COMPLETE THIS TEST CASE
     * Write a test case to verify the path if the source itself is an obstacle.
     */
    @Test
    public void testAStarWithObstacleAsAStart(){
        // Create test map
        GridValues[][] grid = {
                { GridValues.OBSTACLE, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND},
                { GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND},
                { GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND},
                { GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND},
                { GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND}
        };

        // Define starting and ending points
        Point start = new Point(0, 0);
        Point end = new Point(4, 4);

        // Define canPassThrough function (nodes are passable if they are not obstacles)
        Predicate<Point> canPassThrough = (Point p) -> withinBounds(p, grid) && grid[p.x][p.y]!= GridValues.OBSTACLE;

        // Define withinReach function (if you are just 1 step away from goal; you reach the goal)
        BiPredicate<Point, Point> withinReach = (Point p1, Point p2) -> p1.adjacent(p2);

        // Call A* search algorithm
        List<Point> path = new AStarPathingStrategy().computePath(
                start,
                end,
                canPassThrough,
                withinReach,
                PathingStrategy.CARDINAL_NEIGHBORS
        );

        List<Point> expectedPath = Arrays.asList();
        // change 'true' and 'false' with your actual values ; see example test case ( first testcase) for reference
        assertEquals(expectedPath,path );
    }

    /*
     * COMPLETE THIS TEST CASE
     * Write a test case to verify the path if source and destination are at the same place.
     */
    @Test
    public void testAStarWithSameStartAndEndPoints(){
        // Create test map
        GridValues[][] grid = {
                { GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND},
                { GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND},
                { GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND},
                { GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND},
                { GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND}
        };

        // Define starting and ending points
        Point start = new Point(0, 0);
        Point end = new Point(0, 0);

        // Define canPassThrough function (nodes are passable if they are not obstacles)
        Predicate<Point> canPassThrough = (Point p) -> withinBounds(p, grid) && grid[p.x][p.y]!= GridValues.OBSTACLE;

        // Define withinReach function (if you are just 1 step away from goal; you reach the goal)
        BiPredicate<Point, Point> withinReach = (Point p1, Point p2) -> p1.adjacent(p2);

        // Call A* search algorithm
        List<Point> path = new AStarPathingStrategy().computePath(
                start,
                end,
                canPassThrough,
                withinReach,
                PathingStrategy.CARDINAL_NEIGHBORS
        );

        List<Point> expectedPath = Arrays.asList();
        // change 'true' and 'false' with your actual values ; see example test case ( first testcase) for reference
        assertEquals(expectedPath,path );
    }

    /*
     * COMPLETE THIS TEST CASE
     * Write a test case to verify the path if the source and destination are off the map.
     */
    @Test
    public void testAStarWithStartOrEndOutOfBound(){
        // Create test map
        GridValues[][] grid = {
                { GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND},
                { GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND},
                { GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND},
                { GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND},
                { GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND, GridValues.BACKGROUND}
        };

        // Define starting and ending points
        Point start = new Point(10, 10);
        Point end = new Point(30, 40);

        // Define canPassThrough function (nodes are passable if they are not obstacles)
        Predicate<Point> canPassThrough = (Point p) -> withinBounds(p, grid) && grid[p.x][p.y]!= GridValues.OBSTACLE;

        // Define withinReach function (if you are just 1 step away from goal; you reach the goal)
        BiPredicate<Point, Point> withinReach = (Point p1, Point p2) -> p1.adjacent(p2);

        // Call A* search algorithm
        List<Point> path = new AStarPathingStrategy().computePath(
                start,
                end,
                canPassThrough,
                withinReach,
                PathingStrategy.CARDINAL_NEIGHBORS
        );

        List<Point> expectedPath = Arrays.asList();
        // change 'true' and 'false' with your actual values ; see example test case ( first testcase) for reference
        assertEquals(expectedPath,path );
    }

    /*
     * COMPLETE THIS TEST CASE
     * Write a test case to verify the heuristic method that you used in the AStarPathing Strategy class
     */
    @Test
    public void testAStarHeuristicMethod(){
        // Define starting and ending points
        Point start = new Point(0, 0);
        Point end = new Point(4, 4);

        // Call Heuristic Method; for that you have to define a public static heuristic (Manhattan formula) method in AStarPathingStrategy class
        double distance = AStarPathingStrategy.getManhattanDistance(
                start,
                end
        );

        // Check that value is correct
        double expectedDistance = 8.0;

        assertEquals(expectedDistance, distance);
    }

    private static boolean withinBounds(Point p, GridValues[][] grid) {
        return p.y >= 0 && p.y < grid.length &&
                p.x >= 0 && p.x < grid[0].length;
    }
}
