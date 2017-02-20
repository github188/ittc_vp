/**
 * <p>Title: CameraService.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author 焦冬冬
 * @date 2014年4月3日
 * @version 1.0.0
 */
package cn.sh.ittc.service.impl;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import cn.sh.ittc.dao.ICameraDao;
import cn.sh.ittc.model.CameraGrpModel;
import cn.sh.ittc.model.CameraModel;
import cn.sh.ittc.model.NvrModel;
import cn.sh.ittc.service.ICameraService;

/**
 * <p>Title: CameraService</p>
 * <p>Description: </p>
 * @author 焦冬冬
 * @date 2014年4月3日
 */
public class CameraService implements ICameraService {

	private ICameraDao cameraDao;
	
	
	public void setCameraDao(ICameraDao cameraDao) {
		this.cameraDao = cameraDao;
	}

	@Override
	public List<CameraGrpModel> getAllCameraGrp() {
		
		return cameraDao.getAllCameraGrp();
	}


	@Override
	public List<CameraModel> getCameraByGrp(int grpId) {
		
		return cameraDao.getCameraByGrp(grpId);
	}

	
	@Override
	public String getCameraInfo() {

		List<CameraGrpModel> list=cameraDao.getAllCameraGrp();
		
		JSONArray jsonArray=new JSONArray();
		int index=0;
		for (CameraGrpModel cameraGrpModel : list) {
			JSONObject jsonObject=new JSONObject();
			jsonObject.element("grpId", cameraGrpModel.getGrpId());
			jsonObject.element("grpName", cameraGrpModel.getGrpName());
			jsonObject.element("id", cameraGrpModel.getGrpId());
			jsonObject.element("open", true);
			jsonObject.element("name", cameraGrpModel.getGrpName());
			jsonObject.element("children", cameraDao.getCameraByGrp(cameraGrpModel.getGrpId()));
			jsonArray.add(index, jsonObject);
			index++;
		}
		JSONObject json=new JSONObject();
		json.element("data", jsonArray);
		//System.out.println(json.toString());
		return json.toString();
	}

	/* （no Javadoc）
	 * <p>Title: loadCameraGrp</p>
	 * <p>Description: </p>
	 * @return
	 * @see cn.sh.ittc.service.ICameraService#loadCameraGrp()
	 * @author 焦冬冬
	 * @date 2014年4月17日
	 */
	@Override
	public String loadCameraGrp() {
		List<CameraGrpModel> list=cameraDao.getAllCameraGrp();
		JSONObject jsonObject=new JSONObject();
		return jsonObject.element("data", list).toString();
		
	}

	/* （no Javadoc）
	 * <p>Title: getCameraByGrp</p>
	 * <p>Description: </p>
	 * @param cameraGrpModel
	 * @return
	 * @see cn.sh.ittc.service.ICameraService#getCameraByGrp(cn.sh.ittc.model.CameraGrpModel)
	 * @author 焦冬冬
	 * @date 2014年4月17日
	 */
	@Override
	public String getCameraByGrp(CameraGrpModel cameraGrpModel) {
		List<CameraModel> list=cameraDao.getCameraByGrp(cameraGrpModel.getGrpId());
		JSONObject jsonObject=new JSONObject();
		return jsonObject.element("data", list).toString();
		//return null;
	}

	/* （no Javadoc）
	 * <p>Title: delGrpCamera</p>
	 * <p>Description: </p>
	 * @param cameraGrpModel
	 * @return
	 * @see cn.sh.ittc.service.ICameraService#delGrpCamera(cn.sh.ittc.model.CameraGrpModel)
	 * @author 焦冬冬
	 * @date 2014年4月21日
	 */
	@Override
	public boolean delGrpCamera(CameraGrpModel cameraGrpModel) {
		
		return cameraDao.delGrpCameraById(cameraGrpModel.getId());
	}

	/* （no Javadoc）
	 * <p>Title: cutCamera2Grp</p>
	 * <p>Description: </p>
	 * @param id
	 * @param grpId
	 * @return
	 * @see cn.sh.ittc.service.ICameraService#cutCamera2Grp(int, int)
	 * @author 焦冬冬
	 * @date 2014年4月22日
	 */
	@Override
	public boolean cutCamera2Grp(int id, int grpId) {
	
		return cameraDao.cutCameraGrp(id, grpId);
	}

	/* （no Javadoc）
	 * <p>Title: copyCameraGrp</p>
	 * <p>Description: </p>
	 * @param cameraId
	 * @param grpIds
	 * @return
	 * @see cn.sh.ittc.service.ICameraService#copyCameraGrp(int, int[])
	 * @author 焦冬冬
	 * @date 2014年4月23日
	 */
	@Override
	public boolean copyCameraGrp(int cameraId, int[] grpIds) {
		
		return cameraDao.copyCameraGrp(cameraId, grpIds);
	}

	/* （no Javadoc）
	 * <p>Title: getAllNvrInfo</p>
	 * <p>Description: </p>
	 * @return
	 * @see cn.sh.ittc.service.ICameraService#getAllNvrInfo()
	 * @author 焦冬冬
	 * @date 2014年5月28日
	 */
	@Override
	public String getAllNvrInfo() {
		List<NvrModel> list=cameraDao.getAllNvrInfo();
		JSONObject jsonObject=new JSONObject();
		jsonObject.element("data", list);
		return jsonObject.toString();
	}

	/* （no Javadoc）
	 * <p>Title: getAllCamera</p>
	 * <p>Description: </p>
	 * @return
	 * @see cn.sh.ittc.service.ICameraService#getAllCamera()
	 * @author 焦冬冬
	 * @date 2014年5月28日
	 */
	@Override
	public String getAllCamera() {
		
		List<CameraModel> list=cameraDao.getAllCamera();
		JSONObject jsonObject=new JSONObject();
		jsonObject.element("data", list);
		return jsonObject.toString();
	}

	/* （no Javadoc）
	 * <p>Title: addCamera</p>
	 * <p>Description: </p>
	 * @return
	 * @see cn.sh.ittc.service.ICameraService#addCamera()
	 * @author 焦冬冬
	 * @date 2014年5月28日
	 */
	@Override
	public boolean addCamera(CameraModel cameraMode) {
		int cameraId=cameraDao.addCamera(cameraMode);
		cameraMode.setCameraId(cameraId);
		cameraDao.addCamera_grp(cameraMode);
		cameraDao.addCamera2Nvr(cameraMode);
		return false;
	}

	/* （no Javadoc）
	 * <p>Title: addCamera2Grp</p>
	 * <p>Description: </p>
	 * @param cameras
	 * @param grpId
	 * @return
	 * @see cn.sh.ittc.service.ICameraService#addCamera2Grp(int[], int)
	 * @author 焦冬冬
	 * @date 2014年5月29日
	 */
	@Override
	public boolean addCamera2Grp(int[] cameras, int grpId) {
		for (int c : cameras) {
			CameraModel cameraModel=new CameraModel();
			cameraModel.setCameraId(c);
			cameraModel.setGrpId(grpId);
			if(!cameraDao.queryCamera_Grp(cameraModel)){
				cameraDao.addCamera_grp(cameraModel);
			}
		}
		return true;
	}

	@Override
	public boolean delCameraGrpByGrpId(CameraModel cameraModel) {
		if (cameraModel.getGrpId()==1) {//未分组不作为
			return false;
		}
		cameraDao.delCamera_GrpByGrpId(cameraModel);
		cameraDao.delCameraGrpByGrpId(cameraModel);
		return false;
	}


	@Override
	public boolean addCameraGrp(CameraGrpModel cameraGrpModel) {
		
		return cameraDao.addCameraGrp(cameraGrpModel);
	}

	/* （no Javadoc）
	 * <p>Title: renameCamera</p>
	 * <p>Description: </p>
	 * @param cameraModel
	 * @return
	 * @see cn.sh.ittc.service.ICameraService#renameCamera(cn.sh.ittc.model.CameraModel)
	 * @author 焦冬冬
	 * @date 2014年7月11日
	 */
	@Override
	public boolean renameCamera(CameraModel cameraModel) {
		
		return cameraDao.renameCamera(cameraModel);
	}

}
