# Shortest-distance-from-top-left-to-given-point-in-2D-grid
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
```
input:
[1,0,0]
[1,0,0]
[1,9,1]

output:
3
```
explanation:
starting from the left corner the truck traversed cells (0,0) -> (1,0) -> (2,0) -> (2,1). The truck covered total
distance of 3
