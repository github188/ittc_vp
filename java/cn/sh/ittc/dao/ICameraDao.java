/**
 * <p>Title: ICameraDao.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author 焦冬冬
 * @date 2014年4月3日
 * @version 1.0.0
 */
package cn.sh.ittc.dao;

import java.util.List;

import cn.sh.ittc.model.CameraGrpModel;
import cn.sh.ittc.model.CameraModel;
import cn.sh.ittc.model.NvrModel;

/**
 * <p>Title: ICameraDao</p>
 * <p>Description: </p>
 * @author 焦冬冬
 * @date 2014年4月3日
 */
public interface ICameraDao {
	/**
	 * 
	 * <p>Title: getAllCameraGrp</p>
	 * <p>Description:查询所有的摄像机组 </p>
	 * @return
	 * @author 焦冬冬
	 * @date 2014年4月3日
	 */
	public List<CameraGrpModel> getAllCameraGrp();
	/**
	 * 
	 * <p>Title: getCameraByGrp</p>
	 * <p>Description: 根据摄像机组id查询该组的摄像机</p>
	 * @param grpId
	 * @return
	 * @author 焦冬冬
	 * @date 2014年4月3日
	 */
	public List<CameraModel> getCameraByGrp(int grpId);
	
	/**
	 * 
	 * <p>Title: delGrpCamera</p>
	 * <p>Description:根据 </p>
	 * @param id
	 * @return
	 * @author 焦冬冬
	 * @date 2014年4月21日
	 */
	public boolean delGrpCameraById(int id);
	/**
	 * 
	 * <p>Title: cutCameraGrp</p>
	 * <p>Description: 剪切摄像机</p>
	 * @param id
	 * @param grpId
	 * @return
	 * @author 焦冬冬
	 * @date 2014年4月22日
	 */
	public boolean cutCameraGrp(int id,int grpId);
	/**
	 * 
	 * <p>Title: copyCameraGrp</p>
	 * <p>Description: </p>
	 * @param cameraId
	 * @param grpIds
	 * @return
	 * @author 焦冬冬
	 * @date 2014年4月23日
	 */
	public boolean copyCameraGrp(int cameraId,int[] grpIds);
	/**
	 * 
	 * <p>Title: getAllNvrInfo</p>
	 * <p>Description: 获取nvr信息</p>
	 * @return
	 * @author 焦冬冬
	 * @date 2014年5月28日
	 */
	public List<NvrModel> getAllNvrInfo();
	/**
	 * 
	 * <p>Title: getAllCamera</p>
	 * <p>Description: 获取所有的摄像机</p>
	 * @return
	 * @author 焦冬冬
	 * @date 2014年5月28日
	 */
	public List<CameraModel> getAllCamera();
	/**
	 * 
	 * <p>Title: addCamera</p>
	 * <p>Description: </p>
	 * @param cameraModel
	 * @return
	 * @author 焦冬冬
	 * @date 2014年5月28日
	 */
	public int addCamera(CameraModel cameraModel);
	/**
	 * 
	 * <p>Title: addCamera_grp</p>
	 * <p>Description: </p>
	 * @param cameraMode
	 * @return
	 * @author 焦冬冬
	 * @date 2014年5月28日
	 */
	public boolean addCamera_grp(CameraModel cameraMode);
	/**
	 * 
	 * <p>Title: addCamera2Nvr</p>
	 * <p>Description: </p>
	 * @param cameraModel
	 * @return
	 * @author 焦冬冬
	 * @date 2014年5月29日
	 */
	public boolean addCamera2Nvr(CameraModel cameraModel);
	/**
	 * 
	 * <p>Title: queryCamera_Grp</p>
	 * <p>Description: </p>
	 * @param cameraModel
	 * @return
	 * @author 焦冬冬
	 * @date 2014年5月29日
	 */
	public boolean queryCamera_Grp(CameraModel cameraModel);
	
	/**
	 * 
	 * <p>Title: delCamera_GrpByGrpId</p>
	 * <p>Description: 根据组ID删除该组下的所有摄像机</p>
	 * @param cameraModel
	 * @return
	 * @author 焦冬冬
	 * @date 2014年5月29日
	 */
	public boolean delCamera_GrpByGrpId(CameraModel cameraModel);
	/**
	 * 
	 * <p>Title: delCameraGrpByGrpId</p>
	 * <p>Description:根据组ID删除该组 </p>
	 * @param cameraModel
	 * @return
	 * @author 焦冬冬
	 * @date 2014年5月29日
	 */
	public boolean delCameraGrpByGrpId(CameraModel cameraModel);
	/**
	 * 
	 * <p>Title: addCameraGrp</p>
	 * <p>Description: </p>
	 * @param cameraGrpModel
	 * @return
	 * @author 焦冬冬
	 * @date 2014年5月29日
	 */
	public boolean addCameraGrp(CameraGrpModel cameraGrpModel);
	/**
	 * 
	 * <p>Title: renameCamera</p>
	 * <p>Description: </p>
	 * @param cameraModel
	 * @return
	 * @author 焦冬冬
	 * @date 2014年7月11日
	 */
	public boolean renameCamera(CameraModel cameraModel);

}
