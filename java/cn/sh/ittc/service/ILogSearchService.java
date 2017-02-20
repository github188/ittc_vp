/**
 * <p>Title: ILogSearchService.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author 焦冬冬
 * @date 2014年6月11日
 * @version 1.0.0
 */
package cn.sh.ittc.service;

import cn.sh.ittc.model.SysLogModel;
import cn.sh.ittc.model.WarningLogModel;

/**
 * <p>Title: ILogSearchService</p>
 * <p>Description: </p>
 * @author 焦冬冬
 * @date 2014年6月11日
 */
public interface ILogSearchService {
	
	public String getSysLog(SysLogModel sysLogModel);
	/**
	 * 
	 * <p>Title: getWarnLog</p>
	 * <p>Description: </p>
	 * @param warningLogModel
	 * @return
	 * @author 焦冬冬
	 * @date 2014年7月11日
	 */
	public String getWarnLog(WarningLogModel warningLogModel);

}
