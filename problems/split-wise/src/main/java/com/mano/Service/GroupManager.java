package com.mano.Service;

import java.util.HashSet;

import com.mano.domain.Group;

public class GroupManager {
    HashSet<Group> groups ;
    public GroupManager(){
        groups = new HashSet<>();
    }
    public void addGroup(Group group){
        groups.add(group);
    }
    public void removeUser(Group group){
        if(groups.contains(group)){
            groups.remove(group);
        }
    }

}
