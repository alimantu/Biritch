package spring.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.database.dao.UserDao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

		spring.database.model.User user = userDao.findByUserName(username);
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		setAuths.add(new SimpleGrantedAuthority(user.getRole()));
		List<GrantedAuthority> authorities = new ArrayList<>(setAuths);
		return buildUserForAuthentication(user, authorities);
	}

	private User buildUserForAuthentication(spring.database.model.User user,
				List<GrantedAuthority> authorities) throws BadCredentialsException {

		return new User(user.getUsername(), user.getPassword(), user.isEnabled(),
				true, true, true, authorities);
	}

}