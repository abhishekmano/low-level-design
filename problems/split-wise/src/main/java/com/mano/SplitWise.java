package com.mano;

import com.mano.Service.GroupManager;
import com.mano.Service.UserManager;

public class SplitWise {
    UserManager userManager;
    GroupManager groupManager;
    static SplitWise instance = null;
    private SplitWise(){
        userManager = new UserManager();
        groupManager = new GroupManager();
    }
    public static SplitWise getInstance(){
        if(instance == null){
            synchronized(SplitWise.class){
                if(instance == null){
                    instance = new SplitWise();
                }
            }
        }
        return instance;
    }
}
