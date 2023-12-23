public class Launcher {

    public static void launch(int index) {
        String s = new String("\tCoupleIntersection\tSweepLine\n");
        int num = 20;
        for (int i = 0; i < index; i++) {
            s = s + num + "\t" + Runner.run(num, i);
        }
        s = s + "\n";
        num = 50;
        for (int i = 0; i < index; i++) {
            s = s + num + "\t" + Runner.run(num, i);
        }
        s = s + "\n";
        num = 100;
        for (int i = 0; i < index; i++) {
            s = s + num + "\t" + Runner.run(num, i);
        }
        s = s + "\n";
        num = 200;
        for (int i = 0; i < index; i++) {
            s = s + num + "\t" + Runner.run(num, i);
        }
        s = s + "\n";
        num = 500;
        for (int i = 0; i < index; i++) {
            s = s + num + "\t" + Runner.run(num, i);
        }
        s = s + "\n";
        num = 1000;
        for (int i = 0; i < index; i++) {
            s = s + num + "\t" + Runner.run(num, i);
        }
        s = s + "\n";

        FileUtils.writeFile("src/Output/output.txt", s);
    }
}

    /*public static void main(String[] args) {
        String s = new String("\tCoupleIntersection\tSweepLine\n");
        int num = 20;
         index = 100;
        for (int i = 0 ; i < 100 ; i++)
        {
            s = s + num +"\t" + Runner.run(num, i);
        }
        s= s + "\n";
        num = 50;
        for (int i = 0 ; i < 100 ; i++)
        {
            s = s + num +"\t" + Runner.run(num, i);
        }
        s= s + "\n";
        num = 100;
        for (int i = 0 ; i < 100 ; i++)
        {
            s = s + num +"\t" + Runner.run(num, i);
        }
        s= s + "\n";
        num = 200;
        for (int i = 0 ; i < 100 ; i++)
        {
            s = s + num +"\t" + Runner.run(num, i);
        }
        s= s + "\n";
        num = 500;
        for (int i = 0 ; i < 100 ; i++)
        {
            s = s + num +"\t" + Runner.run(num, i);
        }
        s= s + "\n";
        num = 1000;
        for (int i = 0 ; i < 100 ; i++)
        {
            s = s + num +"\t" + Runner.run(num, i);
        }
        s= s + "\n";

        FileUtils.writeFile("src/Output/output.txt",s);
    }*/

