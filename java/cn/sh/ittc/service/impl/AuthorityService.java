/**
 * <p>Title: AuthorityService.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author 焦冬冬
 * @date 2014年5月30日
 * @version 1.0.0
 */
package cn.sh.ittc.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import cn.sh.ittc.dao.IAuthorityDao;
import cn.sh.ittc.model.AuthorityModel;
import cn.sh.ittc.model.UserAuthorityModel;
import cn.sh.ittc.service.IAuthorityService;

/**
 * <p>Title: AuthorityService</p>
 * <p>Description: </p>
 * @author 焦冬冬
 * @date 2014年5月30日
 */
public class AuthorityService implements IAuthorityService {

	private IAuthorityDao authorityDao;
	@Override
	public boolean saveOrUpdateUserAuthority(UserAuthorityModel userAuthorityModel,String json) {
		authorityDao.deleteUserAuthorityByUserId(userAuthorityModel.getUserId());
		try {
			JSONArray jsonArray=JSONArray.fromObject(json);
			StringBuffer unGrpCamera=new StringBuffer();
			for (int i=0;i<jsonArray.size(); i++) {
				JSONObject jsonObject=(JSONObject)jsonArray.get(i);
				
				/** 如果没有父节点 **/
				if (!jsonObject.getBoolean("isParent")) {
					unGrpCamera.append(jsonObject.getString("id")).append(",");
					continue;
				}
				
				JSONArray jsonArrayChildren=JSONArray.fromObject(jsonObject.get("children"));
				/**如果没有孩子节点**/
				if(jsonArrayChildren.toString().equals("[null]")){
					continue;
				}
				
				
				StringBuffer cameraIds=new StringBuffer();
				for (int j=0;j<jsonArrayChildren.size(); j++) {
					JSONObject childrenObject=(JSONObject) jsonArrayChildren.get(j);
					cameraIds.append(childrenObject.get("id")).append(",");
				}
				
				UserAuthorityModel authorityModel=new UserAuthorityModel();
				authorityModel.setUserId(userAuthorityModel.getUserId());
				authorityModel.setAuthorityIds(userAuthorityModel.getAuthorityIds());
				authorityModel.setGrpName(jsonObject.getString("name"));
				authorityModel.setCameraId(cameraIds.substring(0, cameraIds.length()-1).toString());
				
				
				authorityDao.addUserAuthority(authorityModel);

			}
			if(unGrpCamera.length()>0){
				UserAuthorityModel unGrpAuthorityModel = new UserAuthorityModel();
				unGrpAuthorityModel.setGrpName("未分组");
				unGrpAuthorityModel.setUserId(userAuthorityModel.getUserId());
				unGrpAuthorityModel.setAuthorityIds(userAuthorityModel
						.getAuthorityIds());
				unGrpAuthorityModel.setCameraId(unGrpCamera.substring(0,
						unGrpCamera.length() - 1).toString());
//				System.out.println(unGrpAuthorityModel);
				authorityDao.addUserAuthority(unGrpAuthorityModel);
			}
		
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	
		
	}
	
	
	public String copyAuthority(int userId, String copyUserIdstr) {
		String[] copyUserIds = copyUserIdstr.split(",");
		for (String copyUserId : copyUserIds) {
			authorityDao.deleteUserAuthorityByUserId(Integer.parseInt(copyUserId));
			Map<String, Integer> map=new HashMap<String, Integer>();
			map.put("userId", userId);
			map.put("copyUserId", Integer.parseInt(copyUserId));
			authorityDao.copyAuthority(map);
		}
		return "";
	}
	
	/**
	 * @param authorityDao the authorityDao to set
	 */
	public void setAuthorityDao(IAuthorityDao authorityDao) {
		this.authorityDao = authorityDao;
	}

	@Override
	public String getAllAuthority() {
		List<AuthorityModel> list=authorityDao.getAllAuthority();
		JSONObject jsonObject=new JSONObject();
		jsonObject.element("data", list);
		System.out.println(jsonObject);
		return jsonObject.toString();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String getCameraByUserId(int userId) {
		JSONObject jsonObject=new JSONObject();
		
		List<Map> list = authorityDao.getUsedCameraByUserId(userId, false);
		jsonObject.element("unused", list);
		list = authorityDao.getUsedCameraByUserId(userId, true);
		jsonObject.element("used", list);

		String authorityIdstr=authorityDao.getAuthorityByUserId(userId);
		
		if(authorityIdstr==null||"".equals(authorityIdstr)){
			jsonObject.element("authority", "");
		}else{
			List<Map<String, String>> listAuthority=new ArrayList<Map<String,String>>();
			String[] authorityIds=authorityIdstr.split(",");
			for (String authorityId : authorityIds) {
				Map<String, String> map=new HashMap<String, String>();
//				System.out.println(authorityId.split("-").length);
				if(authorityId.split("-").length>1){
					map.put("authorityId", authorityId.split("-")[0]);
					map.put("level", authorityId.split("-")[1]);
				}else {
					map.put("authorityId", authorityId.split("-")[0]);
					map.put("level", "0");
				}
				listAuthority.add(map);
			}
			jsonObject.element("authority", listAuthority);		
		}
		
		
		
		
//		System.out.println(jsonObject);
		return jsonObject.toString();
	}

	
	
}
