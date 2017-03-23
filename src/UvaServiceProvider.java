import models.Submission;
import models.Task;
import models.User;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UvaServiceProvider {

    final String Api = "http://uhunt.felix-halim.net/api";
    private String ApiBuilder;
    private HashMap<Integer,String> languages;

    public UvaServiceProvider(){
        this.languages = new HashMap<>();
        languages.put(1,"ANSI,C");
        languages.put(2,"JAVA");
        languages.put(3,"C++");
        languages.put(4,"PASCAL");
        languages.put(5,"C++11");
    }

    public User getUser(String username){
        ApiBuilder = new StringBuilder(Api)
                            .append("/uname2uid/")
                            .append(username)
                            .toString();
        User user = new User();
        try {
            InputStream input = new URL(ApiBuilder).openStream();
            Scanner sc = new Scanner(input);
            int Id = sc.nextInt();
            if(Id == 0) throw new Exception("Wrong username");
            user.setId(Id);
            user.setUsername(username);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return user;
    }

    public double getUserScore(String username,ArrayList<Integer> tasksId,double score){
        double total = 0;
        Task task;
        User user = this.getUser(username);
        for(int taskId : tasksId){
            task = getTask(taskId);
            total += (this.Solved(task.getPId(),user.getId())) ? score : 0;
        }
        return total;
    }

    public Task getTask(int num) {
        ApiBuilder = new StringBuilder(Api)
                            .append("/p/")
                            .append("num/")
                            .append(num)
                            .toString();
        Task task = new Task();
        JSONObject json = null;

        try {
            json = readJsonFromUrl(ApiBuilder);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        try {
            task.setTitle((String)json.get("title"));
            task.setPId((Integer)json.get("pid"));
            task.setNum((Integer)json.get("num"));
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        return task;
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    /*check if user solved the problem by id*/
    public boolean Solved(int Id,int UserId){
        ApiBuilder = new StringBuilder(Api)
                .append("/subs-user/")
                .append(UserId)
                .toString();

        JSONObject json = null;
        JSONArray subsArray = null;

        try {
            json = readJsonFromUrl(ApiBuilder);
            subsArray = json.getJSONArray("subs");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        for(int i = 0 ; i < subsArray.length() ; i++){
            try {
                JSONArray item = (JSONArray) subsArray.get(i);
                if(item.get(2).equals(90) && item.get(1).equals(Id)){
                    return true;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    public void Submissions(int UserId){
        ApiBuilder = new StringBuilder(Api)
                .append("/subs-user/")
                .append(UserId)
                .toString();

        JSONObject json = null;
        JSONArray subsArray = null;

        try {
            json = readJsonFromUrl(ApiBuilder);
            subsArray = json.getJSONArray("subs");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

        for(int i = 0 ; i < subsArray.length() ; i++){
            try {
                JSONArray item = (JSONArray) subsArray.get(i);
                Submission submission = new Submission(
                        item.getInt(0),item.getInt(1),"",
                        item.getInt(3),item.getInt(4),languages.get(item.getInt(5)),
                        item.getInt(6));
                System.out.println(submission);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
