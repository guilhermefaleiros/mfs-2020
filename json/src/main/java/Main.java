import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        String response = HttpRequest("GET", "https://jsonplaceholder.typicode.com/users");
        List<User> users = Arrays.asList(new Gson().fromJson(response, User[].class));
        System.out.println("-------------------- USUÁRIOS --------------------");
        for(User user : users){
            System.out.println("Id: " + user.getId() + ", Email: " + user.getEmail() + ", Nome: " + user.getName());
            String postJson = HttpRequest("GET", "https://jsonplaceholder.typicode.com/users/" + user.getId() + "/posts");
            List<Post> posts = Arrays.asList(new Gson().fromJson(postJson, Post[].class));
        }

        System.out.println("-------------------- SALVANDO ARQUIVO JSON --------------------");
        String json = new Gson().toJson(users);
        FileWriter fileWriter = new FileWriter("result.json");
        fileWriter.write(json.toString());
        fileWriter.flush();
        fileWriter.close();

    }

    public static String HttpRequest(String method, String urlRequest) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        URL url = new URL(urlRequest);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod(method);
        conn.setRequestProperty("Accept", "application/json");
        InputStreamReader in = new InputStreamReader(conn.getInputStream());
        BufferedReader br = new BufferedReader(in);
        String output;

        while ((output = br.readLine()) != null) {
            stringBuilder.append(output);
        }

        return stringBuilder.toString();
    }

}
