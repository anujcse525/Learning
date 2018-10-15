package Singleton.singleton;

public class MyException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MyException() {
	
	}
	
	public String getMessage(){
		return super.getMessage();
	}
	
	public MyException(String msg){
		super(msg);
	}
}
