package com.example.transline;

class UserDetails {
    String username,section;

    public UserDetails(String username, String section) {
        this.username = username;
        this.section = section;
    }

    public UserDetails() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
