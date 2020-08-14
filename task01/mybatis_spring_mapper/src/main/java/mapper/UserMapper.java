package mapper;

import po.User;

import java.util.List;


public interface UserMapper {
    public void insertUser(User user) throws Exception;
    public void deleteById(int id);
    public void updateById(User user) throws Exception;

    public User findUserById(int id);
    public User findUserByUsername(String username);
    public List<User> findUserListByUsername(String username);
    public List<User> findUserAll();
}