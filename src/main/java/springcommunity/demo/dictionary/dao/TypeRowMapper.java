package springcommunity.demo.dictionary.dao;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import springcommunity.demo.dictionary.domain.*;

public class TypeRowMapper implements RowMapper<Type> {

	@Override
	public Type mapRow(ResultSet rs, int row) throws SQLException {
		Type type = new Type();
		type.setId(rs.getInt("typeID"));
		type.setType(rs.getString("name"));
		return type;
	}

}
