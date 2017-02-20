/**
 * <p>Title: ICameraService.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author 焦冬冬
 * @date 2014年4月3日
 * @version 1.0.0
 */
package cn.sh.ittc.service;

import java.util.List;

import cn.sh.ittc.model.CameraGrpModel;
import cn.sh.ittc.model.CameraModel;

/**
 * <p>Title: ICameraService</p>
 * <p>Description: </p>
 * @author 焦冬冬
 * @date 2014年4月3日
 */
public interface ICameraService {
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
	 * <p>Title: getCameraInfo</p>
	 * <p>Description: </p>
	 * @return
	 * @author 焦冬冬
	 * @date 2014年4月3日
	 */
	public String getCameraInfo();
	/**
	 * 
	 * <p>Title: loadCameraGrp</p>
	 * <p>Description: 加载摄像机组</p>
	 * @return
	 * @author 焦冬冬
	 * @date 2014年4月17日
	 */
	public String loadCameraGrp();
	/**
	 * 
	 * <p>Title: getCameraByGrp</p>
	 * <p>Description: 根据组查询摄像机</p>
	 * @param cameraGrpModel
	 * @return
	 * @author 焦冬冬
	 * @date 2014年4月17日
	 */
	public String getCameraByGrp(CameraGrpModel cameraGrpModel);
	/**
	 * 
	 * <p>Title: delGrpCamera</p>
	 * <p>Description: 根据id删除该组下的某摄像机</p>
	 * @param cameraGrpModel
	 * @return
	 * @author 焦冬冬
	 * @date 2014年4月21日
	 */
	public boolean delGrpCamera(CameraGrpModel cameraGrpModel);
	/**
	 * 
	 * <p>Title: cutCamera2Grp</p>
	 * <p>Description: </p>
	 * @param id
	 * @param grpId
	 * @return
	 * @author 焦冬冬
	 * @date 2014年4月22日
	 */
	public boolean cutCamera2Grp(int id,int grpId);
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
	public boolean copyCameraGrp(int cameraId, int[] grpIds);
	/**
	 * 
	 * <p>Title: getAllNvrInfo</p>
	 * <p>Description: 获取NVR信息</p>
	 * @return
	 * @author 焦冬冬
	 * @date 2014年5月28日
	 */
	public String getAllNvrInfo();
	/**
	 * 
	 * <p>Title: getAllCamera</p>
	 * <p>Description: </p>
	 * @return
	 * @author 焦冬冬
	 * @date 2014年5月28日
	 */
	public String getAllCamera();
	/**
	 * 
	 * <p>Title: addCamera</p>
	 * <p>Description: </p>
	 * @param cameraModel
	 * @return
	 * @author 焦冬冬
	 * @date 2014年5月28日
	 */
	public boolean addCamera(CameraModel cameraModel);
	/**
	 * 
	 * <p>Title: addCamera2Grp</p>
	 * <p>Description: </p>
	 * @param cameras
	 * @param grpId
	 * @return
	 * @author 焦冬冬
	 * @date 2014年5月29日
	 */
	public boolean addCamera2Grp(int[] cameras,int grpId );
	/**
	 * 
	 * <p>Title: delCameraGrpByGrpId</p>
	 * <p>Description: 根据grpId删除该组下的所有摄像机和该组</p>
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
