import java.util.Random;

public class GenerationRandomFiles {

    public static void generate(int index) {
        Random generator = new Random();
        String s = new String();
        int num = 20;
        for (int i = 0; i < index; i++) {
            for (int x = 0; x < num; x++) {
                for (int y = 0; y < 4; y++)
                    s = s + generator.nextDouble()*Math.sqrt(num) + "\t";
                if (x != num - 1)
                    s = s + "\n";
            }
            FileUtils.writeFile("src/Input/" + num + "Segments" + i + ".txt", s);
            s = "";
        }
        num = 50;
        for (int i = 0; i < index; i++) {
            for (int x = 0; x < num; x++) {
                for (int y = 0; y < 4; y++)
                    s = s + generator.nextDouble()*Math.sqrt(num) + "\t";
                if (x != num - 1)
                    s = s + "\n";
            }
            FileUtils.writeFile("src/Input/" + num + "Segments" + i + ".txt", s);
            s = "";
        }
        num = 100;
        for (int i = 0; i < index; i++) {
            for (int x = 0; x < num; x++) {
                for (int y = 0; y < 4; y++)
                    s = s + generator.nextDouble()*Math.sqrt(num) + "\t";
                if (x != num - 1)
                    s = s + "\n";
            }
            FileUtils.writeFile("src/Input/" + num + "Segments" + i + ".txt", s);
            s = "";
        }
        num = 200;
        for (int i = 0; i < index; i++) {
            for (int x = 0; x < num; x++) {
                for (int y = 0; y < 4; y++)
                    s = s + generator.nextDouble()*Math.sqrt(num) + "\t";
                if (x != num - 1)
                    s = s + "\n";
            }
            FileUtils.writeFile("src/Input/" + num + "Segments" + i + ".txt", s);
            s = "";
        }
        num = 500;
        for (int i = 0; i < index; i++) {
            for (int x = 0; x < num; x++) {
                for (int y = 0; y < 4; y++)
                    s = s + generator.nextDouble()*Math.sqrt(num) + "\t";
                if (x != num - 1)
                    s = s + "\n";
            }
            FileUtils.writeFile("src/Input/" + num + "Segments" + i + ".txt", s);
            s = "";
        }
        num = 1000;
        for (int i = 0; i < index; i++) {
            for (int x = 0; x < num; x++) {
                for (int y = 0; y < 4; y++)
                    s = s + generator.nextDouble()*Math.sqrt(num) + "\t";
                if (x != num - 1)
                    s = s + "\n";
            }
            FileUtils.writeFile("src/Input/" + num + "Segments" + i + ".txt", s);
            s = "";
        }
    }
}

    /*public static void main(String[] args) {
        Random generator = new Random();
        String s = new String();
        int num = 20;
        for (int i = 0; i < 10; i++)
        {
            for (int x = 0 ; x < num ; x++)
            {
                for (int y = 0 ; y < 4 ; y++)
                    s = s + generator.nextDouble(0,num*num) + "\t";
                if (x != num-1)
                    s = s + "\n";
            }
            FileUtils.writeFile("src/Input/" + num + "Segments" + i + ".txt", s);
            s = "";
        }
        num = 50;
        for (int i = 0; i < 10; i++)
        {
            for (int x = 0 ; x < num ; x++)
            {
                for (int y = 0 ; y < 4 ; y++)
                    s = s + generator.nextDouble(0,num*num) + "\t";
                if (x != num-1)
                    s = s + "\n";
            }
            FileUtils.writeFile("src/Input/" + num + "Segments" + i + ".txt", s);
            s = "";
        }
        num = 100;
        for (int i = 0; i < 10; i++)
        {
            for (int x = 0 ; x < num ; x++)
            {
                for (int y = 0 ; y < 4 ; y++)
                    s = s + generator.nextDouble(0,num*num) + "\t";
                if (x != num-1)
                    s = s + "\n";
            }
            FileUtils.writeFile("src/Input/" + num + "Segments" + i + ".txt", s);
            s = "";
        }
        num = 200;
        for (int i = 0; i < 10; i++)
        {
            for (int x = 0 ; x < num ; x++)
            {
                for (int y = 0 ; y < 4 ; y++)
                    s = s + generator.nextDouble(0,num*num) + "\t";
                if (x != num-1)
                    s = s + "\n";
            }
            FileUtils.writeFile("src/Input/" + num + "Segments" + i + ".txt", s);
            s = "";
        }
        num = 500;
        for (int i = 0; i < 10; i++)
        {
            for (int x = 0 ; x < num ; x++)
            {
                for (int y = 0 ; y < 4 ; y++)
                    s = s + generator.nextDouble(0,num*num) + "\t";
                if (x != num-1)
                    s = s + "\n";
            }
            FileUtils.writeFile("src/Input/" + num + "Segments" + i + ".txt", s);
            s = "";
        }
        num = 1000;
        for (int i = 0; i < 10; i++)
        {
            for (int x = 0 ; x < num ; x++)
            {
                for (int y = 0 ; y < 4 ; y++)
                    s = s + generator.nextDouble(0,num*num) + "\t";
                if (x != num-1)
                    s = s + "\n";
            }
            FileUtils.writeFile("src/Input/" + num + "Segments" + i + ".txt", s);
            s = "";
        }
    }
*/





