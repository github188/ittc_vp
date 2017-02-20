/**
 * <p>Title: ILogSearchDao.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author 焦冬冬
 * @date 2014年6月11日
 * @version 1.0.0
 */
package cn.sh.ittc.dao;

import java.util.List;

import cn.sh.ittc.model.SysLogModel;
import cn.sh.ittc.model.WarningLogModel;

/**
 * <p>Title: ILogSearchDao</p>
 * <p>Description: </p>
 * @author 焦冬冬
 * @date 2014年6月11日
 */
public interface ILogSearchDao {
	/**
	 * 
	 * <p>Title: getSysLog</p>
	 * <p>Description: </p>
	 * @param sysLogModel
	 * @return
	 * @author 焦冬冬
	 * @date 2014年6月11日
	 */
	public List<SysLogModel> getSysLog(SysLogModel sysLogModel);
	/**
	 * 
	 * <p>Title: getSysCount</p>
	 * <p>Description: </p>
	 * @param sysLogModel
	 * @return
	 * @author 焦冬冬
	 * @date 2014年6月12日
	 */
	public int getSysCount(SysLogModel sysLogModel);
	
	/**
	 * 
	 * <p>Title: addOperateLog</p>
	 * <p>Description: 添加操作日志</p>
	 * @param sysLogModel
	 * @author 焦冬冬
	 * @date 2014年7月7日
	 */
	public void addOperateLog(SysLogModel sysLogModel);
	
	/**
	 * 
	 * <p>Title: getWarningLog</p>
	 * <p>Description: </p>
	 * @param warningLogModel
	 * @return
	 * @author 焦冬冬
	 * @date 2014年7月11日
	 */
	public List<WarningLogModel> getWarningLog(WarningLogModel warningLogModel);
	/**
	 * 
	 * <p>Title: getWarningCount</p>
	 * <p>Description: </p>
	 * @param warningLogModel
	 * @return
	 * @author 焦冬冬
	 * @date 2014年7月11日
	 */
	public int getWarningCount(WarningLogModel warningLogModel);

}
