package com.music.sharespace.service.user;

import com.music.sharespace.common.QueryConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserSearchService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<String> fetchUsers(){
        return jdbcTemplate.query(QueryConstants.fetchUserList, new RowMapper<String>() {
            @Nullable
            @Override
            public String mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getString(1);
            }
        });
    }

}
