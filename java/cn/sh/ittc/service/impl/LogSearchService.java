/**
 * <p>Title: LogSearchService.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author 焦冬冬
 * @date 2014年6月11日
 * @version 1.0.0
 */
package cn.sh.ittc.service.impl;

import java.util.List;

import net.sf.json.JSONObject;
import cn.sh.ittc.dao.ILogSearchDao;
import cn.sh.ittc.model.SysLogModel;
import cn.sh.ittc.model.WarningLogModel;
import cn.sh.ittc.service.ILogSearchService;

/**
 * <p>Title: LogSearchService</p>
 * <p>Description: </p>
 * @author 焦冬冬
 * @date 2014年6月11日
 */
public class LogSearchService implements ILogSearchService {

	public ILogSearchDao logSearchDao;

	@Override
	public String getSysLog(SysLogModel sysLogModel) {
//		System.out.println(sysLogModel);
		List<SysLogModel> list=logSearchDao.getSysLog(sysLogModel);
		JSONObject jsonObject=new JSONObject();
		if(list==null){
			jsonObject.element("success", "error");
		} else if(list.size()==0){
			jsonObject.element("success", "0");
		}else{
			int count=logSearchDao.getSysCount(sysLogModel);
			jsonObject.element("success", "success");
			jsonObject.element("data", list);
			jsonObject.element("count", ((count-1)/sysLogModel.getShowNum())+1);
			
		}
		System.out.println(jsonObject);
		return jsonObject.toString();
	}

	@Override
	public String getWarnLog(WarningLogModel warningLogModel) {
		List<WarningLogModel> list=logSearchDao.getWarningLog(warningLogModel);
		JSONObject jsonObject=new JSONObject();
		if(list==null){
			jsonObject.element("success", "error");
		} else if(list.size()==0){
			jsonObject.element("success", "0");
		}else{
			int count=logSearchDao.getWarningCount(warningLogModel);
			jsonObject.element("success", "success");
			jsonObject.element("data", list);
			jsonObject.element("count", ((count-1)/warningLogModel.getShowNum())+1);
			
		}
		System.out.println(jsonObject);
		return jsonObject.toString();
	}
	
	/**
	 * @param logSearchDao the logSearchDao to set
	 */
	public void setLogSearchDao(ILogSearchDao logSearchDao) {
		this.logSearchDao = logSearchDao;
	}



	
	

}
