package yelinskyi.vitalii.dao;

import yelinskyi.vitalii.model.Message;

import java.util.List;

public interface MessageDao {
    List<Message> add(Message message);

    List<Message> getAll();

}
