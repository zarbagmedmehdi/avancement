/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Salarie;
import service.*;
import bean.User;
import util.HashageUtil ;

/**
 *
 * @author user
 */
public class UserService extends AbstractFacade<User> {
    
    public UserService() {
        super(User.class);
    }

    public int seConnecter(User user)
    {
        User loadedUser= find(user.getId());
        if(loadedUser ==null){
            return -1;
        } else if(!loadedUser.getPassword().equals(HashageUtil.sha256(user.getPassword()))){
           return -2;
    } else {
    return 1;
}
}
    
    public void creerUser(String id, String password) {
        User user=new User();
        user.setId(id);
        
       
   user.setPassword(HashageUtil.sha256(password));
   super.create(user);

    }

public void initDb(){
 creerUser("U1","123456789");
 creerUser("U2","987654321");


}
}