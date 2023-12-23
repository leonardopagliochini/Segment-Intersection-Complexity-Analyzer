import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        String s = JOptionPane.showInputDialog("Inserire Numero Di tentativi");
        int index = Integer.parseInt(s);
        GenerationRandomFiles.generate(index);
        Launcher.launch(index);
    }
}
