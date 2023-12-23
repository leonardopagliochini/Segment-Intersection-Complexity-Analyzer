public class SweepLine {

    public static boolean intersection(String filename,int num)
    {
        double[] eventPoints = new double[2*num];
        Double[][] seq = FileUtils.readSequences(filename,num);
        Segment[] sa = Segment.segmentArrayFromSequence(seq);
        QuickSorter quickSorter = new QuickSorter();

        int x = 0;
        for (int i = 0 ; i < num ; i++)
        {
            for (int j = 0 ; j < 3;j = j+2)
            {
                eventPoints[x] = seq[i][j];
                x++;
            }
        }
        quickSorter.sort(eventPoints);

        RBTree T = new RBTree();

        for (int i = 0 ; i < eventPoints.length ; i++)
        {
            if (isLeftEndpoint(eventPoints[i], sa))
            {
                Segment s = findSegmentFromLeftEndpoint(eventPoints[i], sa);
                RBTree.RBTElement w = new RBTree.RBTElement(s);
                T.insert(w , eventPoints[i]);
                if ((T.above(w).getKey() != null && Segment.segmentIntersect(T.above(w).getKey(),s)) ||
                        (T.below(w).getKey() != null && Segment.segmentIntersect(T.below(w).getKey(),s)))
                    return true;

            }
            if (isRightEndpoint(eventPoints[i], sa))
            {
                Segment z = findSegmentFromRightEndpoint(eventPoints[i], sa);
                RBTree.RBTElement w = T.search(z,eventPoints[i]);
                if (T.above(w).getKey() != null && T.below(w).getKey() != null && Segment.segmentIntersect(T.above(w).getKey(),T.below(w).getKey()))
                    return true;
                T.delete(w);
            }
        }
        return false;
    }

    private static boolean isLeftEndpoint(double x1, Segment[] sa)
    {
        for (int i = 0 ; i < sa.length ; i++)
            if (x1 == sa[i].getX1())
                return true;
        return false;
    }

    private static boolean isRightEndpoint(double x2, Segment[] sa)
    {
        for (int i = 0 ; i < sa.length ; i++)
            if (x2 == sa[i].getX2())
                return true;
        return false;
    }

    private static Segment findSegmentFromLeftEndpoint(double x1, Segment[] sa)
    {
        for (int i = 0 ; i < sa.length ; i++)
        {
            if (x1 == sa[i].getX1())
                return sa[i];
        }
        return null;
    }

    private static Segment findSegmentFromRightEndpoint(double x2, Segment[] sa)
    {
        for (int i = 0 ; i < sa.length ; i++)
        {
            if (x2 == sa[i].getX1())
                return sa[i];
        }
        return null;
    }
}

