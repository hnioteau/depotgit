
public class QueryString {
	private String key = null;
	private String value = null;
	private String query = null;
	
	public QueryString(String k, String v){
		this.setKey(k);
		this.setValue(v);
	}
	
	public QueryString(String q){
		this.setQuery(q);
		String[] t = isolatePairs();
		String[][] t2 = isolateKeyValue(t);
		String keyValue = accessToKeyValue(t2,0);	
		System.out.println(keyValue);
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
	
	private String accessToKeyValue(String[][] tabPair, int access){
		String[] tmp = null; 
		tmp = tabPair[access];
		for(int i = 0; i < tmp.length; ++i){
			initializeKeyValue(i,tmp);
		}
		return null;
		
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
}
