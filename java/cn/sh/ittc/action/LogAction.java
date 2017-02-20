/**
 * <p>Title: LogAction.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author 焦冬冬
 * @date 2014年6月11日
 * @version 1.0.0
 */
package cn.sh.ittc.action;

import cn.sh.ittc.model.SysLogModel;
import cn.sh.ittc.model.WarningLogModel;
import cn.sh.ittc.service.ILogSearchService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * <p>Title: LogAction</p>
 * <p>Description: </p>
 * @author 焦冬冬
 * @date 2014年6月11日
 */
public class LogAction extends ActionSupport{

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	private SysLogModel sysLogModel;
	private WarningLogModel warningLogModel;
	private String jsonData;
	
	private ILogSearchService logSearchService;
	
	public String getSysLog(){
//		System.out.println(sysLogModel);
		sysLogModel.setTableName("ittc_sys_log");
		jsonData=logSearchService.getSysLog(sysLogModel);
		return SUCCESS;
	}

	public String getOperateLog(){
		sysLogModel.setTableName("ittc_operate_log");
		jsonData=logSearchService.getSysLog(sysLogModel);
		return SUCCESS;
	}
	
	/**
	 * 
	 * <p>Title: getWarningLog</p>
	 * <p>Description: </p>
	 * @return
	 * @author 焦冬冬
	 * @date 2014年7月11日
	 */
	public String getWarningLog(){
		
		jsonData=logSearchService.getWarnLog(warningLogModel);
		
		return SUCCESS;
	}
	
	
	
	/**
	 * @return sysLogModel
	 */
	public SysLogModel getSysLogModel() {
		return sysLogModel;
	}

	/**
	 * @param sysLogModel the sysLogModel to set
	 */
	public void setSysLogModel(SysLogModel sysLogModel) {
		this.sysLogModel = sysLogModel;
	}

	
	
	
	/**
	 * @return jsonData
	 */
	public String getJsonData() {
		return jsonData;
	}

	/**
	 * @param jsonData the jsonData to set
	 */
	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}

	/**
	 * @param logSearchService the logSearchService to set
	 */
	public void setLogSearchService(ILogSearchService logSearchService) {
		this.logSearchService = logSearchService;
	}

	/**
	 * @return warningLogModel
	 */
	public WarningLogModel getWarningLogModel() {
		return warningLogModel;
	}

	/**
	 * @param warningLogModel the warningLogModel to set
	 */
	public void setWarningLogModel(WarningLogModel warningLogModel) {
		this.warningLogModel = warningLogModel;
	}
	
	

	
}
