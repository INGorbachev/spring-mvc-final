package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
@Transactional(readOnly = false)
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Override
   public void remove(Long id) {
      userDao.remove(id);
   }

   @Override
   public void update(User user) {
      userDao.update(user);
   }

   @Override
   public User getUserById(Long id) {
      return userDao.getUserById(id);
   }
}
