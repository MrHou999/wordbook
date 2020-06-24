package databaseDao;

import java.util.List;
import java.util.Map;


import bean.WordDTO;

public class BackgroundDao extends FactoryDao {
	
	/**
	 * @discription 添加单词
	 */
	public boolean addWord(WordDTO wd) {
		
		String sql = "insert into wordbook(word, meaning) values(?, ?)";
		Object[] param = {

				wd.getWord(),
				wd.getMeaning()
				
		};
		
		return upadateByParams(sql, param);
		
	}
	
	
	/**
	 * @discription 修改单词
	 */
	public boolean updateWord(WordDTO wd) {
		
		String sql = "update wordbook set meaning=?, word=? where wordId=?";
		Object[] param = {
				
				wd.getMeaning(),
				wd.getWord(),
				wd.getWordId()
				
		};
		
		return upadateByParams(sql, param);
		
	}
	

	/**
	 * @discription 删除单词
	 */
	public boolean deleteAWord(Integer wordId) {
		
		String sql = "delete from wordbook where wordId=?";
		
		Object[] param = {
				
				wordId
			
		};
		
		return upadateByParams(sql, param);
		
	}
	
	
	/**
	 *  @discription 查询一个单词
	 */
	public List<Map<String, Object>> selectAWord(Integer wordId) {
		
		String sql = "select wordId, word, meaning from wordbook where wordId=?";
		Object[] param = {

				wordId

			};
		
		return select(sql, param);
		
	}
	
	
	/**
	 * @discription 查询所有单词
	 */
	public List<Map<String, Object>> selectWords() {
		
		String sql = "select wordId, word, meaning from wordbook";
		Object[] param = null;
		
		return select(sql, param);
		
	}
	
	
	/**
	 * 查找单词
	 * @param keyword
	 * @return
	 */
    public List<Map<String, Object>> searchWord(String keyword) {
		
		String sql = "select * from wordbook where word like ? ";
		Object[] param = {"%" + keyword + "%"};
		
		return select(sql, param);
		
	}
	
}

