package dv.util;

/**
 * JSON模型
 * 后台向前台返回的JSON对象
 */
public class Json implements java.io.Serializable {
	private static final long serialVersionUID = 1494113314158839322L;
	private boolean success = false;
	private String msg = "";
	private Object obj = null;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
}
