package com.mano;

import com.mano.domain.Expense;
import com.mano.domain.Group;
import com.mano.domain.User;
import com.mano.domain.Split.EqualSplitStrategy;
import com.mano.domain.Split.PercentageSplitStrategy;
import com.mano.domain.Split.Split;

public class Main {
    public static void main(String[] args) {
        try{
            SplitWise instance = SplitWise.getInstance();
        //Creating users
        User abhishek = new User(1,  "abhishek", "abhishek@gmail.com");
        User karthik = new User(2, "karthik" , "karthik@gmail.com");
        User kishore = new User(3, "kishore", "kishore@gamil.com");
        //Creating group and adding users
        Group fortuneNest = new Group(1, "Fortune Nest", "Handle Fortune Nest Deals");
        fortuneNest.addUser(karthik);
        fortuneNest.addUser(abhishek);
        fortuneNest.addUser(kishore);
        //adding group and users to the instance
        instance.userManager.addUser(karthik);
        instance.userManager.addUser(abhishek);
        instance.userManager.addUser(kishore);
        instance.groupManager.addGroup(fortuneNest);

        Expense masalaDosa = new Expense(new EqualSplitStrategy());
        masalaDosa.setValue(120);
        masalaDosa.setPaidBy(abhishek);
        masalaDosa.addSplit(new Split(1, kishore));
        masalaDosa.addSplit(new Split(2, abhishek));
        masalaDosa.addSplit(new Split(3, karthik));
        fortuneNest.addExpense(masalaDosa);
        masalaDosa.calculateSplit();
        
         Expense waterbill = new Expense(new PercentageSplitStrategy());
        
         waterbill.setPaidBy(karthik);
         waterbill.setValue(300);
         waterbill.addSplit(new Split(4,karthik,30));
         waterbill.addSplit(new Split(5,abhishek,35));
         waterbill.addSplit(new Split(6,kishore,45));
         fortuneNest.addExpense(waterbill);
         waterbill.calculateSplit();

        instance.userManager.display();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        

    }
}