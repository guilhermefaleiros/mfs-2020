import java.io.File;

public class DiretorioListarDirs {
    public static void main(String[] args) {
        File dir = new File("/home/guilherme/workspace/UFG/mfs-2020/aula-4/dir");
        listDir(dir);
    }

    private static void listDir(File dir) {
        if(dir.isDirectory()){
            File[] files = dir.listFiles();
            if(files != null) {
                for(File file : files) {
                    listDir(file);
                }
            }
        }
    }
}
