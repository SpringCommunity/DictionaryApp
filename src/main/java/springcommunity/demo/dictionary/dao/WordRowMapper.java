package springcommunity.demo.dictionary.dao;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import springcommunity.demo.dictionary.domain.*;

public class WordRowMapper implements RowMapper<Word> {

	@Override
	public Word mapRow(ResultSet rs, int row) throws SQLException {
		Word word = new Word();
		word.setId(rs.getInt("wordID"));
		word.setMean(rs.getString("mean"));
		word.setName(rs.getString("name"));
		word.setTypeId(rs.getInt("typeID_FK"));
		word.setCategoryId(rs.getInt("categoryID_FK"));
		return word;
	}

}
