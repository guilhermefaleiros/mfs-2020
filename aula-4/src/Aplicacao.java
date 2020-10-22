import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Aplicacao {



    public static void main(String[] args) throws IOException {
        String siglasEstados[] = {"AC","AL","AP","AM","BA","CE","DF","ES","GO","MA","MT","MS","MG","PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR","SC","SP","SE","TO"};
        List<State> states = new ArrayList<>();
        for(String sigla : siglasEstados) {
            states.add(new State(sigla));
        }
        if(args.length != 0) {
            countStateByCSVUrl(args[0], states);
        } else {
            countStateByCSVUrl("http://repositorio.dados.gov.br/educacao/CADASTRO%20DAS%20IES_2011.csv", states);
        }

    }

    public static void countStateByCSVUrl(String url, List<State> states) throws IOException {
        BufferedReader reader;
        URL javaUrl = new URL(url);
        reader = new BufferedReader(new InputStreamReader(javaUrl.openStream()));
        String line = null;
        int lineCount = 0;
        while ((line = reader.readLine()) != null) {
            lineCount++;
            String[] dadosUsuario = line.split(";");
            if(lineCount > 12) {
                if(dadosUsuario.length > 9) {
                    for(State state : states) {
                        if(state.name.equals(dadosUsuario[9])) {
                            state.count++;
                        }
                    }
                }
            }
        }
        for (State state : states) {
            System.out.println(state.name + ": " + state.count);
        }
        reader.close();
    }

    public static class State {
        public String name;
        public Integer count;

        public State(String name) {
            this.name = name;
            this.count = 0;
        }

        public void incrementCount() {
            this.count++;
        }
    }
}
