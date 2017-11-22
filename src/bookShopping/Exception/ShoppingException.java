package bookShopping.Exception;


//自定义异常类
public class ShoppingException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String errorInfo;
	
	
	
	public String getErrorInfo() {
		return errorInfo;
	}



	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}



	public ShoppingException(String errorInfo)
	{
		super(errorInfo);
		this.errorInfo=errorInfo;
	}

}
