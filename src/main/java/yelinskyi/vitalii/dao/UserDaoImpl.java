package yelinskyi.vitalii.dao;

import yelinskyi.vitalii.model.User;
import yelinskyi.vitalii.util.ConnectionUtil;

import java.sql.*;

public class UserDaoImpl implements UserDao {

    @Override
    public User add(User user) {
        String query = "INSERT INTO users (nickname) VALUES (?)";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, user.getNickname());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                user.setId(resultSet.getObject(1, Long.class));
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException("Couldn't create user. " + user, e);
        }
    }

}
