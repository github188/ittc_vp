/**
 * <p>Title: GoAction.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author ������
 * @date 2014��3��24��
 * @version 1.0.0
 */
package cn.sh.ittc.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * <p>Title: GoAction</p>
 * <p>Description: </p>
 * @author ������
 * @date 2014��3��24��
 */
public class GoAction extends ActionSupport{

	
	/** serialVersionUID */
	private static final long serialVersionUID = 8612034366725786491L;

	public String preview(){
		return SUCCESS;
	}
	public String logsearch() {
		return SUCCESS;
	}
	
	public String home() {
		return SUCCESS;
	}
	
	public String devmgr(){
		
		return SUCCESS;
	}
	
	public String devcfg(){
		return SUCCESS;
	}
	
	public String usermgr(){
		
		return SUCCESS;
	}
}
