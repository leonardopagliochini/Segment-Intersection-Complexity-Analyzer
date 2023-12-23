public class CoupleIntersection {
    public static boolean intersection(String fileName, int num)
    {
        Double[][] seq = FileUtils.readSequences(fileName,num);
        Segment[] sa = Segment.segmentArrayFromSequence(seq);

        for(int i = 0; i < num; i++)
        {
            for (int j = i+1 ; j < num; j++)
            {
                if (Segment.segmentIntersect(sa[i] ,sa[j])) {
                    return true;
                }
            }
        }
        return false;
    }
}
