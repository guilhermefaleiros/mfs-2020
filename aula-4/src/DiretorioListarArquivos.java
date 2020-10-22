import java.io.File;

public class DiretorioListarArquivos {

    public static void main(String[] args) {
        File dir = new File("/home/guilherme/workspace/UFG/mfs-2020/aula-4/dir");
        listFiles(dir);
    }

    private static void listFiles(File dir) {
        if(dir.isDirectory()){
            File[] files = dir.listFiles();
            if(files != null) {
                for(File file : files) {
                    if(file.isFile()) {
                        System.out.println(file.getAbsolutePath());
                    } else if(file.isDirectory()) {
                        listFiles(file);
                    }
                }
            }
        }
    }


}
