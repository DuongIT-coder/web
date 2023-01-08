package com.example.web.enity;

public class Feedback {
    private int id;
    private String client_name;
    private String feedback;
    private String image;
    private int id_parent;


    public Feedback() {
    }

    public Feedback(int id, String client_name, String feedback, String image, int id_parent) {
        this.id = id;
        this.client_name = client_name;
        this.feedback = feedback;
        this.image = image;
        this.id_parent = id_parent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId_parent() {
        return id_parent;
    }

    public void setId_parent(int id_parent) {
        this.id_parent = id_parent;
    }
}
