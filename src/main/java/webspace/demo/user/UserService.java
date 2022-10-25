package webspace.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    //private final SourceRepository sourceRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public List<User> getUsers()
    {
        User user = userRepository.findById(1L).orElseThrow(() ->
                new IllegalStateException("No user found")
                );
        /*user.sources.add(new Source(
                1L,
                "url",
                "img",
                "high",
                5
        ));
        userRepository.save(user);*/
        return userRepository.findAll();
    }

    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository.
                findUserByEmail(user.getEmail());
        if(userOptional.isPresent()) {
            throw new IllegalStateException("Email taken");
        }

       /* User user2 = userRepository.findById(1L).orElseThrow(() ->
                new IllegalStateException("No user found")
        );
        user2.sources.add(new Source(
                1L,
                "url",
                "img",
                "high",
                5
        ));*/

        userRepository.save(user);

    }

    @Transactional
    public void changeResource(String priority, String priorityLevel, Long id, int index) {
        User user = userRepository.findById(id).orElseThrow(() ->
                    new IllegalStateException("No user found")
                );

        try {
            if(priority != null) {
                user.sources.get(index).setPriority(priority);
            }

            if(priorityLevel != null) {

                int convPriorityLevel = Integer.parseInt(priorityLevel);

                user.sources.get(index).setPriorityLevel(convPriorityLevel);
            }

        }catch(ArithmeticException e) {
            System.out.println("Path got a String and not an int");
        } catch(Exception e) {
            System.out.println("Index probably went out of bounds.");
        }

    }

    public void addSource(Long id, Source source) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("No user found")
        );

        user.sources.add(source);
        userRepository.save(user);
    }
}
