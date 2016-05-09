package com.firstdata.payeezy.models.exception;



@SuppressWarnings("serial")
public class ApplicationRuntimeException extends RuntimeException {
	
	private Error errorCode;
    private String msg;
    
    public ApplicationRuntimeException(String msg){
    	super(msg);
        this.msg=msg;
    }
    
    public ApplicationRuntimeException(Throwable e){
        super(e);
    }
    public ApplicationRuntimeException(String msg, Throwable e){
        super(msg,e);
    }
    
    public ApplicationRuntimeException(Error errCode){
        super();
        this.errorCode=errCode;
    }
	
	public ApplicationRuntimeException(String message, Error errCode){
        super(message);
        this.errorCode=errCode;
    }
	
   public ApplicationRuntimeException(Throwable t, Error errCode){
        super(t);
        this.errorCode=errCode;
    }
    public ApplicationRuntimeException(String message, Throwable t, Error errCode){
        super(message,t);
        this.errorCode=errCode;
    }

    public Error getErrorCode() {
        return errorCode;
    }
    
    public void setErrorCode(Error errorCode) {
        this.errorCode = errorCode;
    }
}
