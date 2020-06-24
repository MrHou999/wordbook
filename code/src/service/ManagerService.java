package service;

import java.util.List;
import java.util.Map;

import bean.WordDTO;
import databaseDao.BackgroundDao;

public class ManagerService {
	
	BackgroundDao bd = new BackgroundDao();
	
	/**
	 * ��ӵ���
	 * @param wd
	 * @return
	 */
	public boolean addWord(WordDTO wd) {
	
		return bd.addWord(wd);
		
	}
	
	/**
	 * ���µ���
	 * @param wd
	 * @return
	 */
	public boolean updateWord(WordDTO wd) {
		
		return bd.updateWord(wd);
		
	}
	
	
	/**
	 * ɾ������
	 * @param wordId
	 * @return
	 */
	public boolean deleteAWord(Integer wordId) {
	
		return bd.deleteAWord(wordId);
		
	}
	
	
	/**
	 * ͬʱɾ���������
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
	 * ��ѯ����
	 * @param wordId
	 * @return
	 */
	public List<Map<String, Object>> selectAWord(Integer wordId) {
	
		return bd.selectAWord(wordId);
		
	}
	
	
	/**
	 * �г����е���
	 * @return
	 */
	public List<Map<String, Object>> selectWords() {
		
		return bd.selectWords();
		
	}
	
	
	/**
	 * ��ѯ����
	 * @param keyword
	 * @return
	 */
    public List<Map<String, Object>> searchWord(String keyword) {
		
		return bd.searchWord(keyword);
		
	}
	
}
