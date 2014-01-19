package com.tui.image.search

import spock.lang.Specification

/**
 * Created with IntelliJ IDEA.
 * User: thandomafela
 * Date: 19/01/2014
 * Time: 12:45
 * To change this template use File | Settings | File Templates.
 */
class ImageSearcherSpec extends Specification {

    def 'A dosearch test'() {
        given:
            ImageSearcher searcher = new ImageSearcher()
            searcher.apiKey = apiKey
            searcher.baseUrl = baseUrl
            searcher.path = path
            searcher.searchTerm = 'obama'
        when:
            def map = searcher.doSearch()
        then:
            println map
        where:
            apiKey = "18ca527064d2a55e4f09f655efcac8f3"
            baseUrl = "http://api.flickr.com/"
            path = "services/rest/"
    }

    def 'A string response is returned'() {
        given:
            ImageSearcher searcher = new ImageSearcher()
            searcher.apiKey = apiKey
            searcher.baseUrl = baseUrl
            searcher.path = path
            searcher.searchTerm = 'obama'
        expect:
            searcher.getResponseData() instanceof String
        where:
            apiKey = "18ca527064d2a55e4f09f655efcac8f3"
            baseUrl = "http://api.flickr.com/"
            path = "services/rest/"
    }

    def 'A list of maps is returned from the response data'() {
        given:
            ImageSearcher searcher = new ImageSearcher()
        when:
            def list = searcher.getImageSearchList(responseData)
        then:
            list.size() == 20
        where:
            responseData = '{"photos":{"page":1, "pages":41244, "perpage":20, "total":"824866", "photo":[{"id":"12031577104", "owner":"94195711@N02", "secret":"6b9d62515c", "server":"3771", "farm":4, "title":"#lilwayne #obama #eminem #truestory", "ispublic":1, "isfriend":0, "isfamily":0}, {"id":"12028227514", "owner":"99048570@N04", "secret":"bd6ea5b84c", "server":"5514", "farm":6, "title":"Obama\'s Full 2013 State of the Union Address-- SOTU 2013", "ispublic":1, "isfriend":0, "isfamily":0}, {"id":"12026215254", "owner":"95162959@N07", "secret":"d4e0b56cb2", "server":"3758", "farm":4, "title":"140117225638_obama_nsa_304x171_ap_nocredit-300x168", "ispublic":1, "isfriend":0, "isfamily":0}, {"id":"12026213984", "owner":"95162959@N07", "secret":"93f4bae732", "server":"3758", "farm":4, "title":"140117225638_obama_nsa_304x171_ap_nocredit", "ispublic":1, "isfriend":0, "isfamily":0}, {"id":"12026698436", "owner":"95162959@N07", "secret":"c06a8497b6", "server":"3698", "farm":4, "title":"140117225638_obama_nsa_304x171_ap_nocredit-150x150", "ispublic":1, "isfriend":0, "isfamily":0}, {"id":"12026214324", "owner":"95162959@N07", "secret":"06037d447f", "server":"2824", "farm":3, "title":"140117225638_obama_nsa_304x171_ap_nocredit", "ispublic":1, "isfriend":0, "isfamily":0}, {"id":"12025560285", "owner":"45664609@N02", "secret":"6264a54357", "server":"5492", "farm":6, "title":"#Wisconsin #Ohio #florida #Mexico #party #washitgon #DC #Obama #carnival #icecream #muchies #rich #California #logic  #hollywood #china #paris #girls #french #florida #amaze #louisvuitton #hottie #beach #Hawaii #paradise #celebrity #nickelodeon #zoey #101", "ispublic":1, "isfriend":0, "isfamily":0}, {"id":"12024756165", "owner":"45664609@N02", "secret":"ca902d37aa", "server":"7424", "farm":8, "title":"#Wisconsin #Ohio #florida #Mexico #party #washitgon #DC #Obama #carnival #icecream #muchies #rich #California #logic  #hollywood #china #paris #girls #french #florida #amaze #louisvuitton #hottie #beach #Hawaii #paradise #celebrity #nickelodeon #zoey #101", "ispublic":1, "isfriend":0, "isfamily":0}, {"id":"12024152565", "owner":"9844565@N04", "secret":"5ea5218569", "server":"3787", "farm":4, "title":"Rattle and Hum", "ispublic":1, "isfriend":0, "isfamily":0}, {"id":"12024326453", "owner":"17510449@N07", "secret":"124f5e8d0e", "server":"7318", "farm":8, "title":"Buhler High School students in Buhler, Kansas", "ispublic":1, "isfriend":0, "isfamily":0}, {"id":"12024874326", "owner":"17510449@N07", "secret":"6e282f8397", "server":"5504", "farm":6, "title":"Buhler High School students in Buhler, Kansas", "ispublic":1, "isfriend":0, "isfamily":0}, {"id":"12024035715", "owner":"17510449@N07", "secret":"8da94f0d5a", "server":"3667", "farm":4, "title":"Buhler High School students in Buhler, Kansas", "ispublic":1, "isfriend":0, "isfamily":0}, {"id":"12024326333", "owner":"17510449@N07", "secret":"20c31863a9", "server":"3673", "farm":4, "title":"Buhler High School students in Buhler, Kansas", "ispublic":1, "isfriend":0, "isfamily":0}, {"id":"12024677696", "owner":"17510449@N07", "secret":"8433c062c8", "server":"2884", "farm":3, "title":"Buhler High School students in Buhler, Kansas", "ispublic":1, "isfriend":0, "isfamily":0}, {"id":"12024129553", "owner":"17510449@N07", "secret":"ff6491c85d", "server":"5534", "farm":6, "title":"Buhler High School students in Buhler, Kansas", "ispublic":1, "isfriend":0, "isfamily":0}, {"id":"12024677506", "owner":"17510449@N07", "secret":"064e882217", "server":"2889", "farm":3, "title":"Created by Allen at Buhler High School in Buhler, Kansas", "ispublic":1, "isfriend":0, "isfamily":0}, {"id":"12024677556", "owner":"17510449@N07", "secret":"2c144c2e64", "server":"7335", "farm":8, "title":"Buhler High School students in Buhler, Kansas", "ispublic":1, "isfriend":0, "isfamily":0}, {"id":"12021374435", "owner":"97019847@N00", "secret":"6354950cde", "server":"7367", "farm":8, "title":"IMG_7518", "ispublic":1, "isfriend":0, "isfamily":0}, {"id":"12021724274", "owner":"97019847@N00", "secret":"a7cf068320", "server":"5495", "farm":6, "title":"IMG_7516", "ispublic":1, "isfriend":0, "isfamily":0}, {"id":"12021724694", "owner":"97019847@N00", "secret":"c5abf9bd58", "server":"5493", "farm":6, "title":"IMG_7515", "ispublic":1, "isfriend":0, "isfamily":0}]}, "stat":"ok"}'
    }

    def 'An exception is thrown if resource is not found'() {
        given:
            ImageSearcher searcher = new ImageSearcher()
            searcher.apiKey = apiKey
            searcher.baseUrl = baseUrl
            searcher.path = path
            searcher.searchMethod = 'ddd'
            searcher.searchTerm = 'obama'
        when:
            searcher.getResponseData() instanceof String
        then:
            thrown(ImageSearchException)
        where:
            apiKey = "18ca527064d2a55e4f09f655efcac8f3"
            baseUrl = "http://api.flickr.com/"
            path = "srvices/rest/"  //wrong url
    }
}
//http://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=18ca527064d2a55e4f09f655efcac8f3&search=obama&safe_search=1&per_page=20&format=json&&jsoncallback=?
// http://farm4.staticflickr.com/3771/12031577104_6b9d62515c.jpg