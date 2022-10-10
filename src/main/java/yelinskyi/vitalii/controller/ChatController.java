package yelinskyi.vitalii.controller;

import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@WebServlet("/chat")
public class ChatController extends HttpServlet {
    private final MessageService messageService = new MessageServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Message> messages = messageService.getAll();
        request.setAttribute(SessionAttribute.MESSAGES, messages);
        request.getRequestDispatcher("/WEB-INF/views/chat.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = request.getParameter(SessionAttribute.MESSAGE);
        HttpSession session = request.getSession();
        Long id = (Long) session.getAttribute((SessionAttribute.ID));
        String nickname = (String) session.getAttribute((SessionAttribute.NICKNAME));
        List<Message> messages = messageService.add(id, nickname, message);

        request.setAttribute(SessionAttribute.MESSAGES, messages);
        request.getRequestDispatcher("/WEB-INF/views/chat.jsp").forward(request, response);
    }

}
