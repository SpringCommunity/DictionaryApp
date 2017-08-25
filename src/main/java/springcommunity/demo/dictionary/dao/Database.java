package springcommunity.demo.dictionary.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import springcommunity.demo.dictionary.domain.Category;
import springcommunity.demo.dictionary.domain.Type;
import springcommunity.demo.dictionary.domain.Word;
import springcommunity.demo.dictionary.service.DatabaseService;

@Repository
public class Database implements DatabaseService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Word> findAllWord() {
		String sql = "SELECT * FROM word";
	    RowMapper<Word> rm = new WordRowMapper();
		try {
			List<Word> list = jdbcTemplate.query(sql, rm);
			return list;
		} catch (DataAccessException e) {
			System.out.println("Cannot show list cause "+e);
			return null;
		}
		
	}

	@Override
	public List<Word> findWordsByCate(int cateId) {
		String sql = "SELECT * FROM word WHERE categoryID_FK = ?";
		RowMapper<Word> rm = new WordRowMapper();
		Object[] ob = new Object[]{cateId};
		try {
			List<Word> list = jdbcTemplate.query(sql, ob, rm);
			return list;
		} catch (DataAccessException e) {
			System.out.println("Cannot show list cause "+e);
			return null;
		}
	}

	@Override
	public List<Word> findWordsByType(int typeId) {
		String sql = "SELECT * FROM word WHERE typeID_FK = ?";
		RowMapper<Word> rm = new WordRowMapper();
		Object[] ob = new Object[]{typeId};
		try {
			List<Word> list = jdbcTemplate.query(sql, ob, rm);
			return list;
		} catch (DataAccessException e) {
			System.out.println("Cannot show list cause "+e);
			return null;
		}
	}

	@Override
	public List<Type> findAllType() {
		String sql = "SELECT * FROM type";
		RowMapper<Type> rm = new TypeRowMapper();
		try {
			List<Type> list = jdbcTemplate.query(sql, rm);
			return list;
		} catch (DataAccessException e) {
			System.out.println("Cannot show list cause "+e);
			return null;
		}
	}

	@Override
	public List<Category> findAllCategory() {
		String sql = "SELECT * FROM category";
		RowMapper<Category> rm = new CategoryRowMapper();
		try {
			List<Category> list = jdbcTemplate.query(sql, rm);
			return list;
		} catch (DataAccessException e) {
			System.out.println("Cannot show list cause "+e);
			return null;
		}
	}

	@Override
	public int createNewWord(Word word) {
		String sql = "INSERT INTO word(name, mean, categoryID_FK, typeID_FK) VALUES (?,?,?,?)";
		Object[] ob = new Object[]{word.getName(), word.getMean(), word.getCategoryId(), word.getTypeId()};
		try {
			return jdbcTemplate.update(sql, ob);
		} catch (DataAccessException e) {
			System.out.println("Cannot insert new word cause "+e);
			return 0;
		}
	}

	@Override
	public int updateAWord(Word word) {
		String sql = "UPDATE word SET name = ? , mean =?, categoryID_FK =?, typeID_FK=? WHERE wordID = ?";
		Object[] ob = new Object[]{word.getName(), word.getMean(), word.getCategoryId(), word.getTypeId(), word.getId()};
		try {
			System.out.println("row"+word.getCategoryId());
			System.out.println("row"+jdbcTemplate.update(sql, ob));
			return jdbcTemplate.update(sql, ob);
		} catch (DataAccessException e) {
			System.out.println("Cannot edit word cause "+e);
			return 0;
		}
	}

	@Override
	public int deleteAWord(int id) {
		String sql = "DELETE FROM word WHERE wordID=?";
		Object[] ob = new Object[]{id};
		try {
			return jdbcTemplate.update(sql, ob);
		} catch (DataAccessException e) {
			System.out.println("Cannot delete word cause "+e);
			return 0;
		}
	}

	@Override
	public List<Word> findWordsByCateAndType(int categoryId, int typeId) {
		String sql = "SELECT * FROM word WHERE categoryID_FK =? AND typeID_FK=?";
		RowMapper<Word> rm = new WordRowMapper();
		Object[] ob = new Object[]{categoryId, typeId};
		try {
			return jdbcTemplate.query(sql, ob, rm);
		} catch (DataAccessException e) {
			System.out.println("No word found cause "+e);
			return null;
		}
	}

	@Override
	public List<Word> findByKeyword(String keyword) {
		String sql = "SELECT * FROM word WHERE name LIKE ?";
		RowMapper<Word> rm = new WordRowMapper();
		Object[] ob = new Object[]{"%"+keyword+"%"};
		try {
			return jdbcTemplate.query(sql, ob, rm);
		} catch (DataAccessException e) {
			System.out.println("No word found cause "+e);
			return null;
		}
	}

	@Override
	public Word findWordById(int id) {
		String sql = "SELECT * FROM word WHERE wordID = ?";
		RowMapper<Word> rm = new WordRowMapper();
		Object[] ob = new Object[]{id};
		try {
			return jdbcTemplate.queryForObject(sql, rm, ob);
		} catch (DataAccessException e) {
			System.out.println("No word found with this id cause "+e);
			return null;
		}
	}

	
     
}
