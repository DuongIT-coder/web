package com.example.web.enity;

import java.util.List;

public class Bill {
    private int id;
    private List<Item> list;
    private Client client;
    private int total;
    private String description;

    public Bill() {
    }

    public Bill(int id, List<Item> list, Client client, int total, String description) {
        this.id = id;
        this.list = list;
        this.client = client;
        this.total = total;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Item> getList() {
        return list;
    }

    public void setList(List<Item> list) {
        this.list = list;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}