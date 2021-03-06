
public class Page {
	
	private int degree;
	private Data keys[];
	private Page children[];
	private int nKeys;
	private Boolean leaf;
	
	public Page(int degree, Boolean leaf) {
		this.degree = degree;
		this.leaf = leaf;
		this.keys = new Data[degree];
		this.children = new Page[degree+1];
		this.nKeys = 0;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	public Data getKey(int pos) {
		return keys[pos];
	}

	public void addKey(Data key, int pos) {
		this.keys[pos] = key;
	}
	
	public int addKey(Data key) {
		if(nKeys == degree)
			return -1;
		int i = nKeys;
		while(i>0 && key.getId() < keys[i-1].getId()) {
			keys[i] = keys[i-1];
			children[i+1] = children[i];
			i--;
		}
		keys[i] = key;
		nKeys++;
		return i;
	}

	public Page getChild(int pos) {
		return children[pos];
	}

	public void addChild(Page page, int pos) {
		this.children[pos] = page;
	}
	
	public int getnKeys() {
		return nKeys;
	}

	public void setnKeys(int nKeys) {
		this.nKeys = nKeys;
	}
	
	public Boolean isLeaf() {
		return leaf;
	}
	
	public void setLeaf(Boolean leaf) {
		this.leaf = leaf;
	}
	
	public void incrementNKeys() {
		this.nKeys++;
	}
	
	public void decrementNKeys() {
		this.nKeys--;
	}

}
