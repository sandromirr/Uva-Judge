import models.Task;
import models.User;

import java.util.ArrayList;

public class Main {

    public static void main(String[]args){
        UvaServiceProvider uvaServiceProvider = new UvaServiceProvider();
        //Task task = uvaServiceProvider.getTask(10954);
        //User user = uvaServiceProvider.getUser("mirianashvili");
        //System.out.println(uvaServiceProvider.Solved(task.getPId(),user.getId()));
        //uvaServiceProvider.Submissions(user.getId());

        ArrayList<Integer> taskIds = new ArrayList<>();
        taskIds.add(10954);
        taskIds.add(11926);
        taskIds.add(11933);
        taskIds.add(11286);
        System.out.println(uvaServiceProvider.getUserScore("mirianashvili",taskIds,2.5));
    }
}
