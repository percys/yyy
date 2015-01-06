package dv.util;

import java.util.List;

/**
 * EasyUI tree模型
 */
public class Tree implements java.io.Serializable {
	private static final long serialVersionUID = 3370617396345475611L;
	private String id;//节点的值
	private String text;//节点显示文本
	private String state = "open";// open,closed，节点状态
	private boolean checked = false;
	private Object attributes;//自定义属性
	private List<Tree> children;//子节点
	private String iconCls;//图标
	private String pid;//父节点id

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public Object getAttributes() {
		return attributes;
	}

	public void setAttributes(Object attributes) {
		this.attributes = attributes;
	}

	public List<Tree> getChildren() {
		return children;
	}

	public void setChildren(List<Tree> children) {
		this.children = children;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	@Override
	public String toString() {
		if (children!=null&&children.size()!=0) {
			return "Tree [id=" + id + ", text=" + text + ", children=" + children + "]";
		}else{
			return "Tree [id=" + id + ", text=" + text + "]";
		}
	}
}
