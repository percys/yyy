import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import dv.sys.entity.WebResource;
import dv.util.HibernateSessionFactory;
import dv.util.Tree;

@SuppressWarnings("unchecked")
public class Test {
	public static void main(String[] args) {
		Session session=HibernateSessionFactory.getSession();
//		from WebRole r inner join fetch r.webUsers u where u.userid=?",webUser.getUserid());mb.md_id='1' 
		String hql="from Mailbox mb inner join fetch mb.mailboxDetails md where md.mdId=mb.mbId and md.mdId='1' and mb.sendname='admin'";
		List<WebResource> list=session.createQuery(hql).list();
		System.out.println(list.size()+"安第斯山");
		session.close();
//		List<Tree> trees=getAll("0");
//		System.out.println(JSONArray.fromObject(trees));
		//换瓶子 30元
		//30+15+7+1+4+2+1;
		//什么时候不可以继续换瓶子，我没有瓶子的时候或者说只剩下了1瓶
//		int count=130;
//		count=getCount(count);
//		System.out.println(count);
	}
	
	public static int getCount(int count) {
		if (count<=1) {
			return 0;
		}
		if (count%2==0) {
			return count+getCount(count/2);
		}else{
			return count+getCount(count/2+1);
		}
	}
	
	/**
	 * 递归调用 means 自己调用自己，前提是有退出条件，不能无限循环下去，否则就是内存堆栈溢出
	 * @param id
	 * @return
	 */
	public static List<Tree> getAll(String id){
		List<Tree> trees=new ArrayList<Tree>();
		Session session=HibernateSessionFactory.getSession();
		String hql="from WebResource where webResource.resid=?";
		List<WebResource> list=session.createQuery(hql).setString(0, id).list();
		for (WebResource webResource : list) {
			Tree tree=new Tree();
			tree.setId(webResource.getResid());
			tree.setText(webResource.getName());
			tree.setChildren(getAll(webResource.getResid()));//递归调用
			trees.add(tree);
		}
		return trees;
	}
}
