public class Runner {
    public static String run(int num, int i )
    {
        String s = new String();
        long t0, t1, t2, t3;

        t0=System.nanoTime();
        CoupleIntersection.intersection("src/Input/"+ num+"Segments" + i + ".txt",num);
        t1=System.nanoTime();

        t2=System.nanoTime();
        SweepLine.intersection("src/Input/"+ num+"Segments" + i + ".txt",num);
        t3=System.nanoTime();

        s = (t1-t0)/1E6+"\t"+(t3-t2)/1E6+"\n";
        return s;
    }
}
