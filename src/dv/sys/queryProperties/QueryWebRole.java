package dv.sys.queryProperties;

import java.io.Serializable;

public class QueryWebRole implements Serializable {
	
	private static final long serialVersionUID = 6730561889853961387L;
	private String name;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
