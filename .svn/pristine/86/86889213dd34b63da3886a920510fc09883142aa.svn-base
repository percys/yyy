package dv.sys.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dv.sys.dao.WebUnitDao;
import dv.sys.entity.WebUnit;
import dv.sys.queryProperties.QueryWebUnit;

@SuppressWarnings("unchecked")
public class WebUnitDaoImpl extends BaseDaoImpl implements WebUnitDao {

	/**
	 * 获取所有部门列表
	 * @param id 部门编号
	 */
	public List<WebUnit> getAllUnit(String id) {
		String hql="from WebUnit where 1=1";
		if (id!=null) {
			hql+=" and webUnit.unitid=?";
			return getHibernateTemplate().find(hql,id);
		}else{
			hql+=" and webUnit.unitid is null";
			return getHibernateTemplate().find(hql);
		}
	}
	
	/**
	 * @param page当前页
	 * @param rows每页显示大小
	 * @param sort排序字段
	 * @param order排序方式
	 * @return 部门列表
	 */
	public List<WebUnit> doSplitPage(final int page,final int rows,final String sort,final String order,final QueryWebUnit queryWebUnit){
		StringBuilder hql=new StringBuilder("from WebUnit where 1=1");
		Map<String, Object> map=new HashMap<String,Object>();
		hql=jointHQL(hql, queryWebUnit,map, sort, order);
		return (List<WebUnit>) super.doSplitPage(hql.toString(), page, rows, map);
	}

	/**
	 * 获得部门的总数量
	 * @param queryWebUnit	部门对象
	 * @return	部门数量
	 */
	public Long getUnitsTotal(final QueryWebUnit queryWebUnit) {
		StringBuilder hql=new StringBuilder("select count(*) from WebUnit where 1=1");
		Map<String, Object> map=new HashMap<String,Object>();
		hql=jointHQL(hql, queryWebUnit, map, null, null);
		return getTotal(hql.toString(), map);
	}
	/**
	 * 拼接hql
	 * @param hql 要拼接的hql
	 * @param queryWebUnit 要注入的查询属性
	 * @param map 存放属性的集合
	 * @param sort 排序字段
	 * @param order 排序方式
	 * @return 拼接好的hql
	 */
	private StringBuilder jointHQL(StringBuilder hql,QueryWebUnit queryWebUnit,Map<String, Object> map,String sort,String order) {
		if (queryWebUnit!=null) {
			if (queryWebUnit.getUnitid()!=null&&!queryWebUnit.getUnitid().trim().equals("")) {
				hql.append(" and unitid like :unitid");
				map.put("unitid", "%"+queryWebUnit.getUnitid()+"%");
			}
			if (queryWebUnit.getName()!=null&&!queryWebUnit.getName().trim().equals("")) {
				hql.append(" and name like :name");
				map.put("name", "%"+queryWebUnit.getName()+"%");
			}
			if (queryWebUnit.getAreano()!=null&&!queryWebUnit.getAreano().trim().equals("")) {
				hql.append(" and areano like :areano");
				map.put("areano", "%"+queryWebUnit.getAreano()+"%");
			}
			if (queryWebUnit.getFatherName()!=null&&!queryWebUnit.getFatherName().trim().equals("")) {
				hql.append(" and webUnit.name like :fatherName");
				map.put("fatherName", "%"+queryWebUnit.getFatherName()+"%");
			}
		}
		if (sort!=null&&!sort.trim().equals("")&&order!=null&&!order.trim().equals("")) {
			hql.append(" order by :sort :order");
			map.put("sort", sort);
			map.put("order", order);
		}
		return hql;
	}

	/**
	 * 
	 * 删除部门信息
	 */
	public void delUnit(String ids) {
		String[] delIds=ids.split(",");//分割字符串,批量删除
		for (String id : delIds) {
			this.getHibernateTemplate().delete(getUnit(id));
		}
	}

	/**
	 * 查找单个部门信息
	 */
	public WebUnit getUnit(String unitid) {
		return getHibernateTemplate().get(WebUnit.class, unitid);
	}

	/**
	 * 修改部门
	 */
	public WebUnit updateUnit(WebUnit unit) {
		this.getHibernateTemplate().update(unit);
		return unit;
	}

	public WebUnit addUnit(WebUnit webUnit) {
		this.getHibernateTemplate().save(webUnit);
		return webUnit;
	}
}
