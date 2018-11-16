package com.music.sharespace.service.user;

import com.music.sharespace.common.Authorities;
import com.music.sharespace.common.QueryConstants;
import com.music.sharespace.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserCreateService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Boolean createUser(User user){
        try {
            //jdbcTemplate.update(QueryConstants.createNewUser, user.getUsername(), new BCryptPasswordEncoder().encode(user.getPassword()), 1, user.getFirstname(), user.getLastname());
            //jdbcTemplate.update(QueryConstants.createNewAuthority, user.getUsername(), Authorities.ROLE_USER.toString());
        }catch(DataAccessException d){
            System.out.println(d);
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

}
