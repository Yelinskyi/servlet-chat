package yelinskyi.vitalii.dao;

import yelinskyi.vitalii.model.Message;
import yelinskyi.vitalii.model.User;
import yelinskyi.vitalii.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageDaoImpl implements MessageDao {

    @Override
    public List<Message> add(Message message) {
        String query = "INSERT INTO messages (message, user_id, datetime) VALUES (?, ?, ?)";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, message.getText());
            preparedStatement.setLong(2, message.getUser().getId());
            preparedStatement.setString(3, message.getDateTime());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't create message. " + message, e);
        }
        return getAll();
    }

    @Override
    public List<Message> getAll() {
        String query = "SELECT * FROM messages "
                + "JOIN users ON users.id = user_id "
                + "ORDER BY messages.id DESC LIMIT 50 ;";

        List<Message> messages = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String datetime = resultSet.getString("datetime");
                String nickname = resultSet.getString("users.nickname");
                String message = resultSet.getString("message");
                messages.add(new Message(datetime, new User(nickname), message));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't get a list of messages. ", e);
        }
        return messages;
    }

}
