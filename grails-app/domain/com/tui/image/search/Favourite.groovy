package com.tui.image.search

/**
 * Created with IntelliJ IDEA.
 * User: thandomafela
 * Date: 21/01/2014
 * Time: 20:38
 * To change this template use File | Settings | File Templates.
 */
class Favourite {

    String url
    String title
    String author
    String source

    static belongsTo = [ user: User]

    static constraints = {
        url(nullable: false, unique: 'user')   //url is unique per person
        user(nullable: false)
        title(nullable: true, blank: true)
        author(nullable: true, blank: true)
        source(nullable: true, blank: true, maxSize: 500)
    }

    public String toString() {
        return "$user to $url"
    }

}
