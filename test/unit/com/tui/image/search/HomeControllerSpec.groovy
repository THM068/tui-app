package com.tui.image.search

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * Created with IntelliJ IDEA.
 * User: thandomafela
 * Date: 19/01/2014
 * Time: 22:57
 * To change this template use File | Settings | File Templates.
 */
@TestFor(HomeController)
class HomeControllerSpec extends Specification {
    def imageSearchService

    def setup() {
        imageSearchService = Mock(ImageSearchService)
        controller.imageSearchService = imageSearchService
    }

    def 'index returns home page images'() {
        when:
            def model = controller.index()
        then:
            1 * imageSearchService.homeImages >> [ [farm: '23'], [farm: '34'] ]
        and:
            model.imageList.size() == 2
        and:
            model.imageList[0].farm == '23'
            model.imageList[1].farm == '34'
    }

    def 'An error message is returned if an exception is throw in home index'() {
        when:
            def model = controller.index()
        then:
            1 * imageSearchService.homeImages >> { throw new ImageSearchException(error)}
        then:
            flash.errors == error
        and:
            model.imageList == null
        where:
            error = 'some error'
    }


}
