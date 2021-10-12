package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @PersistenceContext
   private EntityManager entityManager;

   @Override
   public void add(User user) {
      entityManager.persist(user);
      entityManager.flush();
   }

   @Override
   public List<User> listUsers() {
      TypedQuery<User> query =  entityManager.createQuery("select user from User user", User.class);
      return query.getResultList();
   }

   @Override
   public void remove(Long id) {
      User user = getUserById(id);
      entityManager.remove(user);
   }

   @Override
   public void update(User user) {
      entityManager.merge(user);
   }

   @Override
   public User getUserById(Long id) {
      return entityManager.find(User.class, id);
   }

}
