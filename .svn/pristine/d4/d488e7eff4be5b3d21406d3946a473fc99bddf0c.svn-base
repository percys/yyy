package dv.sys.dao.impl;

import java.util.List;
import java.util.Map;

import dv.sys.dao.WebDictionaryDao;
import dv.sys.entity.WebDictionary;

public class WebDictionaryDaoImpl implements WebDictionaryDao {

	public List<WebDictionary> getAllDictionary() {
		return null;
	}

	public List<WebDictionary> doSplitPage(int page, int rows, String sort,
			String order, WebDictionary webDictionary) {
		return null;
	}

	public Long getWebDictionaryTotal(WebDictionary webDictionary) {
		return null;
	}

	public String jointHQL(String hql,WebDictionary webDictionary,Map<String, Object> map,String sort,String order) {
		if (sort!=null&&!sort.trim().equals("")&&order!=null&&!order.trim().equals("")) {
			hql=hql+" order by "+sort+" "+order;
			map.put(sort, sort);
			map.put(order, order);
		}
		return hql;
	}
}
