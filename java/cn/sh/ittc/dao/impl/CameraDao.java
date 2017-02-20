/**
 * <p>Title: CameraDao.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: Consmation</p>
 * @author 焦冬冬
 * @date 2014年4月3日
 * @version 1.0.0
 */
package cn.sh.ittc.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import cn.sh.ittc.dao.ICameraDao;
import cn.sh.ittc.model.CameraGrpModel;
import cn.sh.ittc.model.CameraModel;
import cn.sh.ittc.model.NvrModel;

import com.ibatis.sqlmap.client.SqlMapExecutor;

/**
 * <p>Title: CameraDao</p>
 * <p>Description: </p>
 * @author 焦冬冬
 * @date 2014年4月3日
 */
public class CameraDao extends SqlMapClientDaoSupport implements ICameraDao {

	/* （no Javadoc）
	 * <p>Title: getAllCameraGrp</p>
	 * <p>Description: </p>
	 * @return
	 * @see cn.sh.ittc.dao.ICameraDao#getAllCameraGrp()
	 * @author 焦冬冬
	 * @date 2014年4月3日
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CameraGrpModel> getAllCameraGrp() {
		
		List<CameraGrpModel> list=getSqlMapClientTemplate().queryForList("cameraSql.getAllCameraGrp");
		return list;
	}

	/* （no Javadoc）
	 * <p>Title: getCameraByGrp</p>
	 * <p>Description: </p>
	 * @param grpId
	 * @return
	 * @see cn.sh.ittc.dao.ICameraDao#getCameraByGrp(int)
	 * @author 焦冬冬
	 * @date 2014年4月3日
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CameraModel> getCameraByGrp(int grpId) {
		List<CameraModel> list=getSqlMapClientTemplate().queryForList("cameraSql.getCameraByGrp", grpId);
		return list;
	}

	/* （no Javadoc）
	 * <p>Title: delGrpCamera</p>
	 * <p>Description: </p>
	 * @param id
	 * @return
	 * @see cn.sh.ittc.dao.ICameraDao#delGrpCamera(int)
	 * @author 焦冬冬
	 * @date 2014年4月21日
	 */
	@Override
	public boolean delGrpCameraById(int id) {
		try {
			getSqlMapClientTemplate().delete("cameraSql.delGrpCameraById", id);
			return true;
		} catch (Exception e) {
			return false;
		}
		
		
	}

	@Override
	public boolean cutCameraGrp(int id, int grpId) {
		Map<String, Integer> map=new HashMap<String, Integer>();
		map.put("id", id);
		map.put("grpId", grpId);
		try {
			getSqlMapClientTemplate().update("cameraSql.cutCamera",map);
			return true;
		} catch (Exception e) {
			return false;
		}
		
		
	}


	@Override
	public boolean copyCameraGrp(final int cameraId, final int[] grpIds) {
		
		getSqlMapClientTemplate().execute(new SqlMapClientCallback<Object>() {
			public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
				executor.startBatch();
				for (int grpId : grpIds) {
					Map<String, Integer> map=new HashMap<String, Integer>();
					map.put("cameraId", cameraId);
					map.put("grpId", grpId);
					getSqlMapClientTemplate().insert("cameraSql.copyCamera", map);
				}
				 executor.executeBatch();
				return null;
			}
		});
		return false;
	
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NvrModel> getAllNvrInfo() {
		List<NvrModel> list=getSqlMapClientTemplate().queryForList("cameraSql.queryAllNvr");
		return list;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<CameraModel> getAllCamera() {
		List<CameraModel> list=getSqlMapClientTemplate().queryForList("cameraSql.queryAllCamera");
		return list;
	}


	@Override
	public int addCamera(CameraModel cameraModel) {
		int cameraId=(int) getSqlMapClientTemplate().insert("cameraSql.addCamera",cameraModel);
		
		return cameraId;
	}


	@Override
	public boolean addCamera_grp(CameraModel cameraModel) {
		getSqlMapClientTemplate().insert("cameraSql.addCamera_grp", cameraModel);
		return true;
	}


	@Override
	public boolean addCamera2Nvr(CameraModel cameraModel) {
		getSqlMapClientTemplate().insert("cameraSql.addCmaera2Nvr", cameraModel);
		return false;
	}


	@Override
	public boolean queryCamera_Grp(CameraModel cameraModel) {
//		int i = (int) getSqlMapClientTemplate().queryForObject(
//				"cameraSql.queryCamera_grp", cameraModel);
		Object object=getSqlMapClientTemplate().queryForObject(
				"cameraSql.queryCamera_grp", cameraModel);
		if(object!=null){
			return true;
		}
		return false;
	}

	@Override
	public boolean delCamera_GrpByGrpId(CameraModel cameraModel) {
		try {
			getSqlMapClientTemplate().delete("cameraSql.delCamera_grpByGrpId", cameraModel);
			return true;
		} catch (Exception e) {
			return false;
		}
		
		
	}

	@Override
	public boolean delCameraGrpByGrpId(CameraModel cameraModel) {
		try {
			getSqlMapClientTemplate().delete("cameraSql.delCameraGrpById", cameraModel);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean addCameraGrp(CameraGrpModel cameraGrpModel) {
		try {
			getSqlMapClientTemplate().insert("cameraSql.addCameraGrp", cameraGrpModel);
			return true;
		} catch (Exception e) {
		
			return false;
		}
		
	}

	/* （no Javadoc）
	 * <p>Title: renameCamera</p>
	 * <p>Description: </p>
	 * @param cameraModel
	 * @return
	 * @see cn.sh.ittc.dao.ICameraDao#renameCamera(cn.sh.ittc.model.CameraModel)
	 * @author 焦冬冬
	 * @date 2014年7月11日
	 */
	@Override
	public boolean renameCamera(CameraModel cameraModel) {
		try {
			getSqlMapClientTemplate().update("cameraSql.renameCamera", cameraModel);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	

}
