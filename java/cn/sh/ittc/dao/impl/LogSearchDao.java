/**
 * <p>Title: LogSearchDao.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author 焦冬冬
 * @date 2014年6月11日
 * @version 1.0.0
 */
package cn.sh.ittc.dao.impl;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import cn.sh.ittc.dao.ILogSearchDao;
import cn.sh.ittc.model.SysLogModel;
import cn.sh.ittc.model.WarningLogModel;

/**
 * <p>Title: LogSearchDao</p>
 * <p>Description: </p>
 * @author 焦冬冬
 * @date 2014年6月11日
 */
public class LogSearchDao extends SqlMapClientDaoSupport implements
		ILogSearchDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<SysLogModel> getSysLog(SysLogModel sysLogModel) {
		try {
			List<SysLogModel> list=getSqlMapClientTemplate().queryForList("logSql.getSysLog", sysLogModel);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public int getSysCount(SysLogModel sysLogModel) {
		try {
			int count=(int) getSqlMapClientTemplate().queryForObject("logSql.getSysCount",sysLogModel);
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}


	@Override
	public void addOperateLog(SysLogModel sysLogModel) {
		try {
			getSqlMapClientTemplate().insert("logSql.addOperateLog", sysLogModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<WarningLogModel> getWarningLog(WarningLogModel warningLogModel) {
		try {
			List<WarningLogModel> list=getSqlMapClientTemplate().queryForList("logSql.getWarnLog", warningLogModel);
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}


	@Override
	public int getWarningCount(WarningLogModel warningLogModel) {
		try {
			int i=(int) getSqlMapClientTemplate().queryForObject("logSql.getWarnCount", warningLogModel);
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}

}
