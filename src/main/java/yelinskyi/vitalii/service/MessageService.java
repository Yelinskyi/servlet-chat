package yelinskyi.vitalii.service;

import yelinskyi.vitalii.model.Message;

import java.util.List;

public interface MessageService {

    List<Message> add(Long id, String nickname, String message);

    List<Message> getAll();

}
