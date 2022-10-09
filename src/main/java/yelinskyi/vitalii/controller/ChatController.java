package yelinskyi.vitalii.controller;

import yelinskyi.vitalii.model.Message;
import yelinskyi.vitalii.service.MessageService;
import yelinskyi.vitalii.service.MessageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/chat")
public class ChatController extends HttpServlet {
    private final MessageService messageService = new MessageServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Message> messages = messageService.getAll();
        request.setAttribute("messages", messages);
        request.getRequestDispatcher("/WEB-INF/views/chat.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = request.getParameter("message");
        HttpSession session = request.getSession();
        Long id = (Long) session.getAttribute(("id"));
        String nickname = (String) session.getAttribute(("nickname"));
        List<Message> messages = messageService.add(id, nickname, message);

        request.setAttribute("messages", messages);
        request.getRequestDispatcher("/WEB-INF/views/chat.jsp").forward(request, response);
    }

}
