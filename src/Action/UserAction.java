package Action;

import Bean.User;
import Service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{
    private User user;

    private UserService userService;

    public String login() {
        if (user.getUsername() != null) {
            User existUser = userService.login(user);

            ActionContext.getContext().getSession().put("user", existUser);

            //重定向到首页
            return "toIndex";
        }
        //或者可以采用转发到login页面 ActionContext.getContext().put("msg", "用户名或密码不正确");
        ActionContext.getContext().put("msg", "用户名或密码不正确");
        return "login";
    }



    @Override
    public User getModel() {
        return user;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
