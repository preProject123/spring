package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.User;
import web.dao.UserDao;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class UserServicesImpl implements web.service.UserServices {

    @Autowired
    private final UserDao userDao;


    public UserServicesImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUsers();
    }

    @Override
    public User readUser(Long id) {
        return userDao.readUser(id);
    }

    @Override
    public void createOrUpdateUser(User user) {
        if (user.getId()!=null){
            userDao.updateUser(user);
        }else {
            userDao.createUser(user);
        }

    }

    @Override
    public void deleteUser(Long id) {
        try {
            userDao.deleteUser(id);
        } catch (NullPointerException exception){
            exception.printStackTrace();
        }
    }
    public void updateUser(User user){
        userDao.updateUser(user);

    }
}