package yelinskyi.vitalii.service;

import yelinskyi.vitalii.dao.MessageDao;
import yelinskyi.vitalii.dao.MessageDaoImpl;
import yelinskyi.vitalii.model.Message;
import yelinskyi.vitalii.model.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MessageServiceImpl implements MessageService {

    private final MessageDao messageDao = new MessageDaoImpl();

    @Override
    public List<Message> add(Long id, String nickname, String message) {
        User user = new User(id, nickname);
        String data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return messageDao.add(new Message(data, user, message));
    }

    @Override
    public List<Message> getAll() {
        return messageDao.getAll();
    }

}
