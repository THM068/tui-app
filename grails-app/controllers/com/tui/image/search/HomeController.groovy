package com.tui.image.search

import grails.converters.JSON

/**
 * Created with IntelliJ IDEA.
 * User: thandomafela
 * Date: 19/01/2014
 * Time: 10:58
 * To change this template use File | Settings | File Templates.
 */
class HomeController {

    def imageSearchService

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

    }
}
