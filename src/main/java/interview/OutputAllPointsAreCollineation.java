package interview;

/**
 * Find each line defined by any pair of points from the input. Keep track
 * of a line by its slope and intercept. Put the lines into a dictionary/hashmap
 * where each unique pair of (slope, intercept) is one unique key in the hashmap.
 * Value is the points grouped into the same (slope, intercept). Finally output all
 * values in the hashmap. Mind when the line is parallel to y-axis, which has infinite
 * slope value. In the solution below the infinite slope is set to 'None'.
 */
public class OutputAllPointsAreCollineation {
//    from collections import defaultdict
//    def groupColinearPoints(points):
//    groups = defaultdict(lambda: set())
//            for i in range(len(points)):
//            for j in range(i + 1, len(points)):
//    slope, intercept = getLine(points[i], points[j])
//            if (slope, intercept) not in groups:
//    groups[(slope, intercept)].add(points[i])
//    groups[(slope, intercept)].add(points[j])
//    return groups.values()
//
//    def getLine(p, q): #Get slope and intercept of the line defined by p and q.
//            if p[0] == q[0]:
//    slope = None
//    else:
//    slope = 1.0 * (p[1] - q[1]) / (p[0] - q[0])
//
//            if not slope:
//    intercept = p[0]
//            else:
//    intercept = p[1] - slope * p[0]
//            return slope, intercept
}
