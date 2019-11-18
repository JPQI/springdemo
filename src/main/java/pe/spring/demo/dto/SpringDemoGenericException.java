package pe.spring.demo.dto;

public class SpringDemoGenericException extends Exception {

	private String errCode;
	private String errMsg;
	private String vista;
	
	public SpringDemoGenericException(String errCode, String errMsg, String vista) {
		this.errCode = errCode;
		this.errMsg = errMsg;
		this.vista = vista;
	}	
	
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public String getVista() {
		return vista;
	}
	public void setVista(String vista) {
		this.vista = vista;
	}
}
