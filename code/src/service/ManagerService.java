package service;

import java.util.List;
import java.util.Map;

import bean.WordDTO;
import databaseDao.BackgroundDao;

public class ManagerService {
	
	BackgroundDao bd = new BackgroundDao();
	
	/**
	 * 添加单词
	 * @param wd
	 * @return
	 */
	public boolean addWord(WordDTO wd) {
	
		return bd.addWord(wd);
		
	}
	
	/**
	 * 更新单词
	 * @param wd
	 * @return
	 */
	public boolean updateWord(WordDTO wd) {
		
		return bd.updateWord(wd);
		
	}
	
	
	/**
	 * 删除单词
	 * @param wordId
	 * @return
	 */
	public boolean deleteAWord(Integer wordId) {
	
		return bd.deleteAWord(wordId);
		
	}
	
	
	/**
	 * 同时删除多个单词
	 * @param wordIds
	 * @return
	 */
	public boolean deleteWords(Integer wordIds[]) {
		
		if (wordIds.length == 0) {
			
			return false;
			
		} else {
			
			for (int i = 0; i < wordIds.length; i++) {
				
				bd.deleteAWord(wordIds[i]);
				
			}
			
			return true;
			
		}
		
	}
	
	
	/**
	 * 查询单词
	 * @param wordId
	 * @return
	 */
	public List<Map<String, Object>> selectAWord(Integer wordId) {
	
		return bd.selectAWord(wordId);
		
	}
	
	
	/**
	 * 列出所有单词
	 * @return
	 */
	public List<Map<String, Object>> selectWords() {
		
		return bd.selectWords();
		
	}
	
	
	/**
	 * 查询单词
	 * @param keyword
	 * @return
	 */
    public List<Map<String, Object>> searchWord(String keyword) {
		
		return bd.searchWord(keyword);
		
	}
	
}
