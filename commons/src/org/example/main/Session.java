package org.example.main;

import java.io.Serializable;

public class Session implements Serializable {
    private final String name;
    private final String password;
    private TypeOfSession session;

/**Class for generating status in requests**/
    public Session(String nameNew, String passwordNew, TypeOfSession sessionNew) {
        name = nameNew;
        password = (passwordNew.trim().equals("")) ? null : passwordNew;
        session = sessionNew;
    }

    public String getName(){
        return name;
    }

    public String getPassword(){
        return password;
    }

    public TypeOfSession getSession(){
        return session;
    }

    @Override
    public String toString(){
        return "username: " + name;
    }

    public void setTypeofSession(TypeOfSession login) {
        session = login;
    }

    public Object getTypeOfSession() {
        return session;
    }
}
