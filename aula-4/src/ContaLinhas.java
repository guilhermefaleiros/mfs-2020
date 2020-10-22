import java.io.*;

public class ContaLinhas {

    public static int ACCUMULATOR = 0;

    public static void main(String[] args) throws IOException {
        if(args.length == 2) {
            File dir = new File(args[0]);
            countLines(dir, args[1]);
            System.out.println("Total de linhas: " + ACCUMULATOR);
        }
        else if(args.length != 2 && args.length != 0) {
            File dir = new File("/home/guilherme/workspace/UFG/mfs-2020/aula-4/codigo");
            countLines(dir, args[0]);
            System.out.println("Total de linhas: " + ACCUMULATOR);
        }
    }

    private static void countLines(File dir, String pattern) throws IOException {
        if(dir.isDirectory()){
            File[] files = dir.listFiles();
            if(files != null) {
                for(File file : files) {
                    if(file.isFile()) {
                        if(file.getName().endsWith(pattern)) {
                            LineNumberReader lnr = new LineNumberReader(new FileReader(file));
                            String nextLine;
                            while ((nextLine = lnr.readLine()) != null) {
                                if (nextLine == null)
                                    break;
                            }
                            System.out.println("Quantidade de Linhas: " + lnr.getLineNumber() + "  Caminho do arquivo: " + file.getAbsolutePath());
                            ACCUMULATOR += lnr.getLineNumber();
                        }
                    } else if(file.isDirectory()) {
                        countLines(file, pattern);
                    }
                }
            }
        } else {
            System.out.println("O caminho informado não é um diretório!");
        }
    }
}
