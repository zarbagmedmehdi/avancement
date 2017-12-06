/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.User;

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
        if(loadedUser !=null){
            return -1;
        } else if(!loadedUser.getPassword().equals(user.getPassword())){
           return -2;
    } else {
    return 1;
}
}
}