package models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Submission {
    private int Id;
    private int TaskId;
    private String Verdict;
    private int Runtime;
    private Date SubmissionDate;
    private String Language;
    private int Rank;


    public Submission(int id, int taskId, String verdict, int runtime, Date submissionDate, String language, int rank) {
        Id = id;
        TaskId = taskId;
        Verdict = verdict;
        Runtime = runtime;
        SubmissionDate = submissionDate;
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
                ", SubmissionDate=" + new SimpleDateFormat("MM-dd-yyyy").format(SubmissionDate) +
                ", Language='" + Language + '\'' +
                ", Rank=" + Rank +
                '}';
    }
}
