
public class QueryString {
	private String key = null;
	private String value = null;
	private String query = null;
	private String[][] tabPairs; // An two-dimensional array which elements are an array of key and value
	
	
	public QueryString(String q){
		this.setQuery(q);
		if(this.getQuery().contains("&")){
			this.tabPairs = isolateKeyValue(isolatePairs());
		}
		else{
			this.setKey(getQuery().split("=")[0]);
			this.setValue(getQuery().split("=")[1]);
		}
	}

	private String [] isolatePairs(){
		String[] tab = getQuery().split("&");
		return tab;
		
	}
	
	private String[][] isolateKeyValue(String[] pairs){
		String[][] tabPair = new String[pairs.length][];
		for(int i = 0; i < pairs.length; ++i){
			tabPair[i] = pairs[i].split("=");
		}
		return tabPair;
		
	}
	
	private void accessToKeyValue(String[][] tabPair, int access){
		String[] tmp = null; 
		tmp = tabPair[access];
		for(int i = 0; i < tmp.length; ++i){
			initializeKeyValue(i,tmp);
		}
	}
	
	protected void access(int access){
		if(-1 < access  &&  access < tabPairs.length )
			accessToKeyValue(tabPairs,access);
		else 
			System.out.println("Access Not Authorized");
	}
	private void initializeKeyValue(int keyOrValue, String[] pair){
		switch(keyOrValue){
		case 0:
			this.setKey(pair[keyOrValue]);
			break;
		case 1: 
			this.setValue(pair[keyOrValue]);
		}
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String[][] getTabPairs() {
		return tabPairs;
	}

}
