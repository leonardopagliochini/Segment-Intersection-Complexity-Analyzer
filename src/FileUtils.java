import java.io.*;

public class FileUtils {
    public static Double[][] readSequences(String fileName, int num)
    {
        Double[][] seq = new Double[num][4];
        Segment[] segments = new Segment[num];
        try
        {
            BufferedReader in = new BufferedReader (new FileReader(fileName));
            String line = in.readLine ();
            int i = 0;
            for(int x = 0 ; x < num ; x++)
            {
                String[] s = line.split("\t");
                for (int j = 0 ; j < 4 ;j++) {
                    seq[x][j] = Double.parseDouble(s[j]);
                    //System.out.println(seq[i][j]);
                }
                line = in.readLine();
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return seq;
    }

    public static void writeFile(String fileName, String txt)
    {
        try {
            PrintWriter out = new PrintWriter (new FileWriter(fileName));
            out.println(txt);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
