package com.tui.image.search

import grails.converters.JSON
import grails.plugins.springsecurity.Secured

/**
 * Created with IntelliJ IDEA.
 * User: thandomafela
 * Date: 19/01/2014
 * Time: 10:58
 * To change this template use File | Settings | File Templates.
 */
class HomeController {

    def imageSearchService
    def favouriteService
    def userService

    def exportResults() {
        String content= imageSearchService.exportSearchResults(session.imageSearchList)
        byte [] byteArr = content.getBytes()
        String filename = 'searchResults.xml'

        response.setHeader("Content-disposition", "attachment; filename=${filename}")
        response.setHeader("Content-Length", "${byteArr.length}")
        response.contentType = "text/xml"
        response.outputStream << byteArr
    }

    def index() {
        def List<Map> imageList = null
        try{
           imageList = imageSearchService.homeImages
        }
        catch (ImageSearchException e) {
            flash.errors = e.getMessage()
        }
        [ imageList: imageList ]
    }

    def search() {
        String search = params.q
        int numPerPage = params.int('numPerPage')
        def map = [:]
        def searchParams = [ search: search, numPerPage: numPerPage]
        List<Map> imageList = null

        if (!search) {
            map = [success: false, message: 'Please specify a search term']
            render map as JSON
            return
        }
        if (search) {
            try {
                imageList = imageSearchService.searchImages(searchParams)
                session.imageSearchList = imageList
            }
            catch(ImageSearchException ex) {
                map = [success: false, message: ex.getMessage()]
                render map as JSON
                return
            }

        }
        render imageList as JSON
    }

    def favourites() {
         User user = userService.getLoggedUser()
         def map = [:]
         if (!user) {
             map = [error: 'login', success: false]
             render map as JSON
             return
         }
         else {
             String url = params.url
             String title = params.title
             String source = params.source
             String author = params.author

             println url

             def favMap = [ user: user, url: url, title: title, source: source, author: author ]
             favouriteService.addToFavourites(favMap)
             map.success = true
             render map as JSON
             return
         }
    }

    def myFavourites() {
       def user = userService.loggedUser
       def imageList = Favourite.findAllWhere(user: user)
       [imageList: imageList]
    }
}
