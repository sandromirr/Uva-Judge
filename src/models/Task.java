package models;

public class Task {
    private int PId;
    private int Num;
    private String title;

    public Task(int PId, int num, String title) {
        this.PId = PId;
        Num = num;
        this.title = title;
    }

    public Task() {
    }

    public int getPId() {
        return PId;
    }

    public void setPId(int PId) {
        this.PId = PId;
    }

    public int getNum() {
        return Num;
    }

    public void setNum(int num) {
        Num = num;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Task{" +
                "PId=" + PId +
                ", Num=" + Num +
                ", title='" + title + '\'' +
                '}';
    }
}
