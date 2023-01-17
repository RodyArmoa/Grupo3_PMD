package com.example.grupo3_app.Opinions;

import java.io.Serializable;

public class ListOpinions implements Serializable {

    public String idTEACHER;
    public String idStudents;
    public String assessment;
    public String opinion;
    public String date;

    public ListOpinions() {
    }

    public ListOpinions(String idTEACHER, String idStudents, String assessment, String opinion, String date) {
        this.idTEACHER = idTEACHER;
        this.idStudents = idStudents;
        this.assessment = assessment;
        this.opinion = opinion;
        this.date = date;
    }

    public String getIdTEACHER() {
        return idTEACHER;
    }

    public void setIdTEACHER(String idTEACHER) {
        this.idTEACHER = idTEACHER;
    }

    public String getIdStudents() {
        return idStudents;
    }

    public void setIdStudents(String idStudents) {
        this.idStudents = idStudents;
    }

    public String getAssessment() {
        return assessment;
    }

    public void setAssessment(String assessment) {
        this.assessment = assessment;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
