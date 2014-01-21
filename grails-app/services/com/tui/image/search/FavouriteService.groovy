package com.tui.image.search

/**
 * Created with IntelliJ IDEA.
 * User: thandomafela
 * Date: 21/01/2014
 * Time: 22:08
 * To change this template use File | Settings | File Templates.
 */
class FavouriteService {

    public void addToFavourites(Map map) {
        User user = map.user
        Favourite favourite = new Favourite(user:user, title:  map.title, author: map.author, source: map.source, url: map.url)
        user.addToFavourites(favourite).save()
    }
}
