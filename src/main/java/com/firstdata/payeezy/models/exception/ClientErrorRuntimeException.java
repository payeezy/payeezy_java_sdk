package com.firstdata.payeezy.models.exception;


public class ClientErrorRuntimeException extends ApplicationRuntimeException {
    
    public ClientErrorRuntimeException(String msg) {
        super(msg);
    }
    
    public ClientErrorRuntimeException(Throwable e) {
        super(e);
    }
    public ClientErrorRuntimeException(String msg, Throwable e) {
        super(msg,e);
    }
}
