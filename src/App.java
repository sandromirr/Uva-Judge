import models.Task;
import models.User;
import providers.UvaServiceProvider;

public class App {

    public static void main(String[]args){
        UvaServiceProvider uvaServiceProvider = new UvaServiceProvider();
        Task task = uvaServiceProvider.getTask(10954);
        User user = uvaServiceProvider.getUser("mirianashvili");
        //System.out.println(task);
        //System.out.println(uvaServiceProvider.Solved(task.getPId(),user.getId()));
        uvaServiceProvider.Submissions(user.getId());

        /*ArrayList<Integer> taskIds = new ArrayList<>();
        taskIds.add(10954);
        taskIds.add(11926);
        taskIds.add(11933);
        taskIds.add(11286);
        System.out.println(uvaServiceProvider.getUserScore("mirianashvili",taskIds,2.5));*/
    }
}
