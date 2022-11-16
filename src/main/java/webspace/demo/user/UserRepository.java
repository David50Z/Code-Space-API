package webspace.demo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository
        extends JpaRepository<User, Long> {

    //WE REFFER USER AS U BECAUSE IT IS THE FIRST LETTER OF USER
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    Optional<User> findUserByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.name = ?1 AND u.password = ?2")
    Optional<User> findUserByNameAndPassword(String name, String password);
}
