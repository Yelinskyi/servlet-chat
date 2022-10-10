package yelinskyi.vitalii.controller;

import lombok.extern.slf4j.Slf4j;
import yelinskyi.vitalii.model.User;
import yelinskyi.vitalii.service.UserService;
import yelinskyi.vitalii.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
@WebServlet("/login")
public class LoginController extends HttpServlet {

    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nickName = request.getParameter(SessionAttribute.NICKNAME);
        log.info("User {} logged in.", nickName);
        User user = userService.add(new User(nickName));

        HttpSession session = request.getSession();
        session.setAttribute(SessionAttribute.NICKNAME, user.getNickname());
        session.setAttribute(SessionAttribute.ID, user.getId());
        response.sendRedirect("/chat");
    }

}
