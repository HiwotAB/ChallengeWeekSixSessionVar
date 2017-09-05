package com.hiwotab.roboresumeapplication.model;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;


@Component
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value="session")
public class SessionVar implements Serializable {

    private long personId;

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }
}
//@Component
//@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value="session")
//public class SessionVar implements Serializable {
//
//    private ArrayList<String> things = new ArrayList<String>();
//
//    public void addThings(String thing){
//        things.add(thing);
//    }
//
//    public String getThings(){
//        StringBuilder response= new StringBuilder();
//        for(String thing : things){
//            response.append(thing);
//            response.append(", ");
//        }
//        return response.toString();
//    }
//}
