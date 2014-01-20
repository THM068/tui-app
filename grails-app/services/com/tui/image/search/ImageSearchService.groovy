package com.tui.image.search
import groovy.xml.MarkupBuilder
/**
 * Created with IntelliJ IDEA.
 * User: thandomafela
 * Date: 19/01/2014
 * Time: 18:08
 * To change this template use File | Settings | File Templates.
 */
class ImageSearchService {
    def grailsApplication

    def List<Map> getHomeImages() throws  ImageSearchException {
        String apikey = grailsApplication.config.grails.flikr.apiKey
        String path = grailsApplication.config.grails.flikr.path
        String baseUrl = grailsApplication.config.grails.flikr.baseUrl

        ImageSearcher searcher = new ImageSearcher()
        searcher.apiKey = apikey
        searcher.baseUrl  = baseUrl
        searcher.path = path

        List<Map> list = searcher.doSearch(false)
        return list
    }

    public List<Map> searchImages(Map searchMap) throws  ImageSearchException {
        String apikey = grailsApplication.config.grails.flikr.apiKey
        String path = grailsApplication.config.grails.flikr.path
        String baseUrl = grailsApplication.config.grails.flikr.baseUrl

        ImageSearcher searcher = new ImageSearcher()
        searcher.apiKey = apikey
        searcher.baseUrl  = baseUrl
        searcher.path = path
        searcher.searchTerm = searchMap.search
        searcher.imagesPerPage =  searchMap.numPerPage

        List<Map> list = searcher.doSearch(true)
        return list

    }

    public String exportSearchResults(List<Map> searchResults) {
        StringWriter writer = new StringWriter()
        def xml = new MarkupBuilder(writer)

        xml.getMkp().xmlDeclaration(version:'1.0', encoding: 'UTF-8')
        xml.content {
            images {
                searchResults?.each { imageRef ->
                    image {
                          mimetype('jpg')
                          url("http://farm${imageRef.farm}.staticflickr.com/${imageRef.server}/${imageRef.id}_${imageRef.secret}_q.jpg")
                          title(imageRef?.title)
                          description(imageRef?.description)
                          author(imageRef?.author)
                          source(imageRef?.source)
                    }
                }
            }
        }

        return writer.toString()
    }
}
