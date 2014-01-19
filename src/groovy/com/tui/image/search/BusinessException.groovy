package com.tui.image.search

/**
 * Created with IntelliJ IDEA.
 * User: thandomafela
 * Date: 19/01/2014
 * Time: 12:53
 * To change this template use File | Settings | File Templates.
 */
class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        this(message, new Throwable())
    }

    public BusinessException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
