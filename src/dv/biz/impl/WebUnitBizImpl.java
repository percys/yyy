package dv.biz.impl;

import java.util.List;

import dv.biz.WebUnitBiz;
import dv.sys.dao.WebUnitDao;
import dv.sys.entity.WebUnit;
import dv.sys.queryProperties.QueryWebUnit;

public class WebUnitBizImpl implements WebUnitBiz {
	private WebUnitDao webUnitDao;
	public WebUnitDao getWebUnitDao() {
		return webUnitDao;
	}

	public void setWebUnitDao(WebUnitDao webUnitDao) {
		this.webUnitDao = webUnitDao;
	}

	/**
	 * 获取所有部门信息
	 */
	public List<WebUnit> getAllUnit(String id) {
		return webUnitDao.getAllUnit(id);
	}
	/**
	 * 分页排序查询
	 */
	public List<WebUnit> doSplitPage(int page, int rows, String sort,
			String order, QueryWebUnit queryWebUnit) {
		return webUnitDao.doSplitPage(page, rows, sort, order, queryWebUnit);
	}
	/**
	 * 获得记录总条数
	 */
	public Long getUnitsTotal(QueryWebUnit queryWebUnit) {
		return webUnitDao.getUnitsTotal(queryWebUnit);
	}

	/**
	 * 删除部门信息
	 */
	public void delUnit(String ids) {
		webUnitDao.delUnit(ids);
	}

	/**
	 * 获得单个部门信息
	 */
	public WebUnit getUnit(String unitid) {
		return webUnitDao.getUnit(unitid);
	}

	/**
	 * 更新部门信息
	 */
	public WebUnit updateUnit(WebUnit unit) {
		return webUnitDao.updateUnit(unit);
	}

	public WebUnit addUnit(WebUnit webUnit) {
		return webUnitDao.addUnit(webUnit);
	}
}
