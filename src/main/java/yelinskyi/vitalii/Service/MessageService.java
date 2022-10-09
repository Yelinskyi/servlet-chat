package yelinskyi.vitalii.Service;

import yelinskyi.vitalii.model.Message;

import java.util.List;

public interface MessageService {

    List<Message> add(Message message);

    List<Message> getAll();

}
