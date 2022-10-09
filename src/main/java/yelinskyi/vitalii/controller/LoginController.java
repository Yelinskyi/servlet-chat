package yelinskyi.vitalii.controller;

import yelinskyi.vitalii.service.UserService;
import yelinskyi.vitalii.service.UserServiceImpl;
import yelinskyi.vitalii.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nickName = request.getParameter("nickname");
        User user = userService.add(new User(nickName));

        HttpSession session = request.getSession();
        session.setAttribute("nickname", user.getNickname());
        session.setAttribute("id", user.getId());
        response.sendRedirect("/chat");
    }

}
