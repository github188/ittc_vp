/**
 * <p>Title: ILogSearchService.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author ������
 * @date 2014��6��11��
 * @version 1.0.0
 */
package cn.sh.ittc.service;

import cn.sh.ittc.model.SysLogModel;
import cn.sh.ittc.model.WarningLogModel;

/**
 * <p>Title: ILogSearchService</p>
 * <p>Description: </p>
 * @author ������
 * @date 2014��6��11��
 */
public interface ILogSearchService {
	
	public String getSysLog(SysLogModel sysLogModel);
	/**
	 * 
	 * <p>Title: getWarnLog</p>
	 * <p>Description: </p>
	 * @param warningLogModel
	 * @return
	 * @author ������
	 * @date 2014��7��11��
	 */
	public String getWarnLog(WarningLogModel warningLogModel);

}
