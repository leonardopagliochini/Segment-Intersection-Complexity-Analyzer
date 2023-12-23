public class Segment {
    private Point p1;
    private Point p2;


    public Segment(Point p1,Point p2)
    {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Point getP1()
    {
        return this.p1;
    }

    public Point getP2()
    {
        return this.p2;
    }

    public double getX1()
    {
        return this.p1.getX();
    }

    public void setX1(double x1) { this.p1.setX(x1);}

    public double getX2()
    {
        return this.p2.getX();
    }

    public void setX2(double x2) { this.p2.setX(x2);}

    public double getY1()
    {
        return this.p1.getY();
    }

    public void setY1(double y1) { this.p1.setX(y1);}

    public double getY2()
    {
        return this.p2.getY();
    }

    public void setY2(double y2) { this.p2.setX(y2);}

    public static boolean segmentIntersect(Segment s1 , Segment s2)
    {
        Point p1 = s1.getP1();
        Point p2 = s1.getP2();
        Point p3 = s2.getP1();
        Point p4 = s2.getP2();

       double d1 = ComputationalGeometryUtils.direction(p3,p4,p1);
       double d2 = ComputationalGeometryUtils.direction(p3,p4,p2);
       double d3 = ComputationalGeometryUtils.direction(p1,p2,p3);
       double d4 = ComputationalGeometryUtils.direction(p1,p2,p4);

       if((d1>0 && d2<0 || d1<0 && d2>0) && (d3>0 && d4<0 || d3<0 && d4>0))
            return true;
       if (d1 == 0 && ComputationalGeometryUtils.onSegment(s2.getP1(),s2.getP2(),s1.getP1()))
           return true;
       if (d2 == 0 && ComputationalGeometryUtils.onSegment(s2.getP1(),s2.getP2(),s1.getP2()))
           return true;
       if (d3 == 0 && ComputationalGeometryUtils.onSegment(s1.getP1(),s1.getP2(),s2.getP1()))
           return true;
       if (d4 == 0 && ComputationalGeometryUtils.onSegment(s1.getP1(),s1.getP2(),s2.getP2()))
           return true;
       return false;
    }

    public double lineIntersection(double x)
    {
        double y = ((x-this.getX1())*(this.getY2()-this.getY1()))/(this.getX2()-this.getX1())+this.getY1();
        return y;
    }

    public static Segment[] segmentArrayFromSequence(Double[][] seq)
    {
        Segment[] sa = new Segment[seq.length];
        for (int i = 0 ; i < seq.length ; i++)
        {
            Point p1 = new Point(0,0);
            Point p2 = new Point(0,0);
            sa[i] = new Segment(p1,p2);
            if (seq[i][0]<seq[i][2])
            {
                sa[i].setX1(seq[i][0]);
                sa[i].setY1(seq[i][1]);
                sa[i].setX2(seq[i][2]);
                sa[i].setY2(seq[i][3]);
            }else {
                sa[i].setX2(seq[i][0]);
                sa[i].setY2(seq[i][1]);
                sa[i].setX1(seq[i][2]);
                sa[i].setY1(seq[i][3]);
            }
        }
        return sa;
    }
}
