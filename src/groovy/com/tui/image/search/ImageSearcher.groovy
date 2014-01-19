package com.tui.image.search

import groovyx.net.http.HTTPBuilder
import net.sf.json.JSON
import org.apache.commons.io.IOUtils
import groovy.json.JsonSlurper

/**
 * Created with IntelliJ IDEA.
 * User: thandomafela
 * Date: 19/01/2014
 * Time: 12:18
 * To change this template use File | Settings | File Templates.
 */
public class ImageSearcher {

    int imagesPerPage  = 20
    String apiKey
    String searchTerm =  initTerm()
    String searchMethod = "flickr.photos.search"
    String baseUrl
    String path

    boolean safeSearch = true


    public int safeSearchVal() {
        return safeSearch ? 1 : 0
    }

    public List<Map> doSearch(boolean isGetPersonInfo = true) throws  ImageSearchException {

        if(!apiKey || "".equals(apiKey)) {
            throw new ImageSearchException("Api Key not specified")
        }

        if(!searchMethod || "".equals(searchMethod)) {
            throw new ImageSearchException("search method not specified")
        }

        if(!baseUrl || "".equals(baseUrl)) {
            throw new ImageSearchException("Enter flickr base url")
        }

        if(!path || "".equals(path)) {
            throw new ImageSearchException("Enter flickr path")
        }

        List<Map> images = null
        String responseData =  getResponseData()
        if(responseData){
            responseData =  responseData - "jsonFlickrApi(" - ")"
            images = getImageSearchList(responseData)

            if(isGetPersonInfo)  {
                if(images) {
                    images.each { map ->
                        addPersonInfoToImage(map)
                    }
                }
            }
        }
        return images
    }

    /*
    return infor such as id, serverId secret owner infor in a list of maps
     */
    public List<Map> getImageSearchList(String responseData)throws  ImageSearchException {
        List<Map> list = new ArrayList<Map>()
        def jsonSlurper = new JsonSlurper()
        try {
            def result = jsonSlurper.parseText(responseData)
            result?.photos?.photo?.each {
                list << [ id: it.id, title: it.title, server:it.server, secret: it.secret, owner: it.owner, farm: it.farm ]
            }
        }
        catch (Exception e) {
            e.printStackTrace()
            throw new ImageSearchException(e.getMessage())
        }
        return list
    }

    public void addPersonInfoToImage(Map map) {
        def http = new HTTPBuilder( baseUrl )
        String responseInfo = null
        searchMethod = 'flickr.people.getInfo'
        try {
            http.get(path: path, contentType : JSON, query: [
                    method: searchMethod,
                    api_key: apiKey,
                    user_id: map?.owner,
                    format:"json"
            ]) { response, json ->
                responseInfo = IOUtils?.toString(json, "UTF-8");
                if (responseInfo) {
                    responseInfo = responseInfo - "jsonFlickrApi(" - ")"

                    def jsonSlurper = new JsonSlurper()
                    try {
                        def result = jsonSlurper.parseText(responseInfo)
                        map.author = result?.person?.username?._content
                        map.description = result?.person?.description?._content
                        map.source = result?.person?.location?._content ?: ''
                    }
                    catch(Exception e) {
                        e.printStackTrace()
                    }
                }
            }
        }
        catch(Exception e) {
            throw new ImageSearchException(e.getMessage())
        }
    }

    public String getResponseData() {
        def http = new HTTPBuilder( baseUrl )
        String responseInfo = null
        try {
            http.get(path: path, contentType : JSON, query: [
                    method: searchMethod,
                    text : searchTerm,
                    api_key: apiKey,
                    safe_search: "1",
                    per_page: imagesPerPage ,
                    format:"json"
            ]) { response, json ->
                responseInfo = IOUtils?.toString(json, "UTF-8");
            }
        }
        catch(Exception e) {
            throw new ImageSearchException(e.getMessage())
        }

        if(!responseInfo) {
            throw new ImageSearchException('Error: null returned for response')
        }

        return responseInfo
    }


    private String initTerm() {
        def list = ['obama', 'spock', 'garnerstyle', 'manchester united']
        int pos = Math.random() * list.size()
        return list.get(pos)
    }


}