package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import spring.registration.UserDto;
import spring.registration.UserExistsException;
import spring.registration.UserRegistrationService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class Authorization {

    @Autowired
    @Qualifier("userRegistrationService")
    UserRegistrationService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView defaultPage() {

        ModelAndView model = new ModelAndView();
        model.setViewName("news");
        return model;
    }

    @RequestMapping(value = "/user-profile", method = RequestMethod.GET)
    public ModelAndView userPage() {

        ModelAndView model = new ModelAndView();
        model.setViewName("user-profile");
        return model;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {

        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView registerUserAccount
            (@ModelAttribute("user") @Valid UserDto accountDto,
             BindingResult result) {

        if (!result.hasErrors()) {
            createUserAccount(accountDto, result);
        }
        if (result.hasErrors()) {
            return new ModelAndView("registration", "user", accountDto);
        }
        else {
            return new ModelAndView("login", "user", accountDto);
        }
    }

    private void createUserAccount(UserDto accountDto, BindingResult result) {

        try {
            service.registerNewUserAccount(accountDto);
        } catch (UserExistsException e) {
            if (e.getMessage().equals("email")) {
                result.rejectValue("email", "error.email",
                        "Account with these email address already exist");
            } else {
                result.rejectValue("username", "error.username",
                        "Username is not available");
            }
        }
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView adminPage() {

        ModelAndView model = new ModelAndView();
        model.setViewName("admin");
        return model;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            System.out.println(error);
            model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
        }
        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");
        return model;
    }

    // customize the error message
    private String getErrorMessage(HttpServletRequest request, String key) {

        Exception exception = (Exception) request.getSession().getAttribute(key);
        String error = "";
        if (exception instanceof BadCredentialsException) {
            error = "Invalid username or password";
        } else if (exception instanceof LockedException) {
            error = exception.getMessage();
        } else {
            error = "Invalid username or password";
        }
        return error;
    }

    // for 403 access denied page
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied() {

        ModelAndView model = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            model.addObject("username", userDetail.getUsername());
        }
        model.setViewName("403");
        return model;
    }

}
