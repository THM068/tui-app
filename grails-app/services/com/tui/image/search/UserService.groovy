package com.tui.image.search

/**
 * Created with IntelliJ IDEA.
 * User: thandomafela
 * Date: 21/01/2014
 * Time: 21:39
 * To change this template use File | Settings | File Templates.
 */
class UserService {

    def springSecurityService

    public User getLoggedUser(){
        def user=null

        def principal = springSecurityService?.principal
        if(principal) {
            if(principal instanceof String){
                user = null
            }else {
                user = User.get(principal.id)
            }
        }
        return user
    }
}
