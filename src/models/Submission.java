package models;

public class Submission {
    private int Id;
    private int TaskId;
    private String Verdict;
    private int Runtime;
    private int UNixTime;
    private String Language;
    private int Rank;

    public Submission(int id, int taskId, String verdict, int runtime, int UNixTime, String language, int rank) {
        Id = id;
        TaskId = taskId;
        Verdict = verdict;
        Runtime = runtime;
        this.UNixTime = UNixTime;
        Language = language;
        Rank = rank;
    }

    @Override
    public String toString() {
        return "Submission{" +
                "Id=" + Id +
                ", TaskId=" + TaskId +
                ", Verdict='" + Verdict + '\'' +
                ", Runtime=" + Runtime +
                ", UNixTime=" + UNixTime +
                ", Language='" + Language + '\'' +
                ", Rank=" + Rank +
                '}';
    }
}
