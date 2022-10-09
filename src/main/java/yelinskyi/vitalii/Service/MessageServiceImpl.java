package yelinskyi.vitalii.Service;

import yelinskyi.vitalii.dao.MessageDao;
import yelinskyi.vitalii.dao.MessageDaoImpl;
import yelinskyi.vitalii.model.Message;

import java.util.List;

public class MessageServiceImpl implements MessageService {

    private final MessageDao messageDao = new MessageDaoImpl();

    @Override
    public List<Message> add(Message message) {
        return messageDao.add(message);
    }

    @Override
    public List<Message> getAll() {
        return messageDao.getAll();
    }

}
