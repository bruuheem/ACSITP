package com.example.acsitp;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Maladie  {

        private long id;
        private String title;
        private String description;
        private String syps;

        public Maladie() {
        }

        public Maladie(String title, String description) {
            this.title = title;
            this.description = description;

        }
        public Maladie(String title, String description,String syps) {
        this.title = title;
        this.description = description;
        this.syps = syps;}

        // Getters and setters

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

    public String getSyps() {
        return syps;
    }

    public void setSyps(String syps) {
        this.syps = syps;
    }
}


