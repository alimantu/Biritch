package spring.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;
import spring.database.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Service("customSuccessHandler")
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserDao userDao;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
               HttpServletResponse httpServletResponse, Authentication authentication)
               throws IOException, ServletException {

        HttpSession session = httpServletRequest.getSession();
        User userAuth = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        spring.database.model.User user = userDao.findByUserName(userAuth.getUsername());

        session.setAttribute("username", user.getUsername());
        session.setAttribute("password", user.getPassword());
        session.setAttribute("id", user.getId());
        session.setAttribute("role", user.getRole());
        session.setAttribute("email", user.getEmail());
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);

        if (user.getRole().equals("ROLE_ADMIN")) {
            httpServletResponse.sendRedirect("admin");
        } else {
            httpServletResponse.sendRedirect("user-profile");
        }
    }
}
