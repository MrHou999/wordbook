package bean;


public class WordDTO {
	
	private Integer wordId;  // ����ID
	private String word;   // ����
	private String meaning;  // ����
	
	public Integer getWordId() {
		
		return wordId;
		
	}


	public void setWordId(Integer wordId) {
		
		this.wordId = wordId;
		
	}

	
	public String getWord() {
		
		return word;
		
	}
	
	public void setWord(String word) {
		
		this.word = word;
		
	}
	
	public String getMeaning() {
		
		return meaning;
		
	}
	
	public void setMeaning(String meaning) {
		
		this.meaning = meaning;
		
	}
	
}
