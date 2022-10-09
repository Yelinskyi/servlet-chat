package yelinskyi.vitalii.service;

import yelinskyi.vitalii.dao.UserDao;
import yelinskyi.vitalii.dao.UserDaoImpl;
import yelinskyi.vitalii.model.User;

public class UserServiceImpl implements UserService {

    private final UserDao userDao = new UserDaoImpl();

    @Override
    public User add(User user) {
        return userDao.add(user);
    }

}
