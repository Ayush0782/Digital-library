package org.library.DigitalLibrary.exception;

public class BookAlreadyPresent extends Exception {
    public BookAlreadyPresent (String msg){
        super(msg);
    }
}
