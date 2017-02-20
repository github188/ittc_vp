/**
 * <p>Title: ILogSearchDao.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author ������
 * @date 2014��6��11��
 * @version 1.0.0
 */
package cn.sh.ittc.dao;

import java.util.List;

import cn.sh.ittc.model.SysLogModel;
import cn.sh.ittc.model.WarningLogModel;

/**
 * <p>Title: ILogSearchDao</p>
 * <p>Description: </p>
 * @author ������
 * @date 2014��6��11��
 */
public interface ILogSearchDao {
	/**
	 * 
	 * <p>Title: getSysLog</p>
	 * <p>Description: </p>
	 * @param sysLogModel
	 * @return
	 * @author ������
	 * @date 2014��6��11��
	 */
	public List<SysLogModel> getSysLog(SysLogModel sysLogModel);
	/**
	 * 
	 * <p>Title: getSysCount</p>
	 * <p>Description: </p>
	 * @param sysLogModel
	 * @return
	 * @author ������
	 * @date 2014��6��12��
	 */
	public int getSysCount(SysLogModel sysLogModel);
	
	/**
	 * 
	 * <p>Title: addOperateLog</p>
	 * <p>Description: ��Ӳ�����־</p>
	 * @param sysLogModel
	 * @author ������
	 * @date 2014��7��7��
	 */
	public void addOperateLog(SysLogModel sysLogModel);
	
	/**
	 * 
	 * <p>Title: getWarningLog</p>
	 * <p>Description: </p>
	 * @param warningLogModel
	 * @return
	 * @author ������
	 * @date 2014��7��11��
	 */
	public List<WarningLogModel> getWarningLog(WarningLogModel warningLogModel);
	/**
	 * 
	 * <p>Title: getWarningCount</p>
	 * <p>Description: </p>
	 * @param warningLogModel
	 * @return
	 * @author ������
	 * @date 2014��7��11��
	 */
	public int getWarningCount(WarningLogModel warningLogModel);

}
