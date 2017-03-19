package springcommunity.demo.dictionary.dao;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import springcommunity.demo.dictionary.domain.*;

public class CategoryRowMapper implements RowMapper<Category> {

	@Override
	public Category mapRow(ResultSet rs, int row) throws SQLException {
		Category category = new Category();
		category.setId(rs.getInt("categoryID"));
		category.setCategory(rs.getString("name").charAt(0));
		return category;
	}

}
