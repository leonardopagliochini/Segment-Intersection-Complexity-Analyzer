public class ComputationalGeometryUtils {

    private static double crossProduct(Point p1, Point p2)
    {

        /*System.out.println(p1.getX()*p2.getY() - p2.getX()*p1.getY());*/
        return p1.getX()*p2.getY() - p2.getX()*p1.getY();
    }

    private static Point difference(Point p1, Point p2)
    {
        Point d = new Point(p1.getX() - p2.getX(), p1.getY() - p2.getY());
        /*System.out.println(p1.getX());
        System.out.println(p1.getY());
        System.out.println(p2.getX());
        System.out.println(p2.getY());
        System.out.println(d.getX());
        System.out.println(d.getY());*/

        return d;
    }

    public static double direction(Point px, Point py , Point pz)
    {
        /*System.out.println(px.getX());
        System.out.println(px.getY());
        System.out.println(py.getX());
        System.out.println(py.getY());
        System.out.println(pz.getX());
        System.out.println(pz.getY());*/
        return crossProduct(difference(pz,px),difference(py,px));
    }

    public static boolean onSegment(Point px, Point py , Point pz)
    {
        return(Math.min(px.getX(), py.getX())<=pz.getX() && pz.getX()<=Math.max(px.getX(), py.getX()) &&
                Math.min(px.getY(), py.getY())<=pz.getY() && pz.getY()<=Math.max(px.getY(), py.getY()));
    }
}

