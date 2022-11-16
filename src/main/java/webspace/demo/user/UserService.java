package webspace.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
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

    public List<User> getUsers() {
       /* User user = userRepository.findById(1L).orElseThrow(() ->
                new IllegalStateException("No user found")
                );
        user.sources.add(new Source(
                1L,
                "url",
                "img",
                "high",
                5
        ));
        userRepository.save(user);*/
        return userRepository.findAll();
    }

    public User findUser(String name, String password) {
        User user = userRepository.findUserByNameAndPassword(name, password).orElseThrow(() ->
                new IllegalStateException("NO MATCHING NAME OR PASSWORD")
        );

        return user;
    }


    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository.
                findUserByEmail(user.getEmail());
        if(userOptional.isPresent()) {
            throw new IllegalStateException("Email taken");
        }

        Optional<User> userOptional2 = userRepository.
                findUserByNameAndPassword(user.getName(), user.getPassword());
        if(userOptional2.isPresent()) {
            throw new IllegalStateException("Username and password are taken");
        }

        userRepository.save(user);

    }

    @Transactional
    public String changePlaylist(Long id, String playlist, String name) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("No user found")
        );

        boolean nameFound = false;

        for (int i = 0; i < user.playlists.size(); i++) {
            if (user.playlists.get(i).getName() == playlist) {
                user.playlists.get(i).setName(name);
                userRepository.save(user);
                nameFound = true;
            }

        }

        if(nameFound) {
            return "Playlist found!";
        } else {
            return "No playlist by that name";
        }
    }

    public void addPlaylist(Long id, Playlist playlist) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("No user found")
        );

        user.playlists.add(playlist);
        userRepository.save(user);
    }

    public void removeUser(Long id) {
        boolean exists = userRepository.existsById(id);

        if(!exists) {
            throw new IllegalStateException("Student with id " +
                    id + " Does not exist");
        }

        userRepository.deleteById(id);
    }

    public String removePlaylist(Long id, Long playlistId) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("No user found")
        );

        boolean nameFound = false;

        for(int i = 0; i < user.playlists.size(); i++) {
            if(user.playlists.get(i).getId() == playlistId) {
                user.playlists.remove(i);
                userRepository.save(user);
                nameFound = true;
            }
        }

        if(nameFound) {
            return "Playlist found!";
        } else {
            return "No playlist by that name";
        }


    }

    /*public void changeStyling(Long id, String preferedStyle) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("No user found")
        );

        user.setPreferredStyle(preferedStyle);
        userRepository.save(user);
    }*/


    public String removeVideo(Long id, Long playlistId, Long videoId) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("No user found")
        );

        boolean playlistFound = false;
        boolean videoFound = false;

        for (int i = 0; i < user.playlists.size(); i++) {
            if (user.playlists.get(i).getId() == playlistId) {
                playlistFound = true;

                for (int z = 0; z < user.playlists.get(i).videos.size(); z++)
                    if (user.playlists.get(i).videos.get(z).getId() == videoId) {
                        videoFound = true;
                        user.playlists.get(i).videos.remove(z);
                        userRepository.save(user);
                    }
            }
        }

        if (playlistFound && videoFound) {
            return "playlist found, video found, removing video";
        } else if (playlistFound && videoFound == false) {
            return "Playlist found, video not found";
        } else {
            return "nothing found";
        }
    }

        public String addVideo(Long id, Long playlistId, Video video) {
            User user = userRepository.findById(id).orElseThrow(() ->
                    new IllegalStateException("No user found")
            );
            String url = video.getUrl();
            String videoId = "";
            for(int i = url.length() - 1; i > -1; i--) {
                if(url.charAt(i) == '=') {
                    video.setVideoId(videoId);
                    break;
                } else {
                    videoId = url.charAt(i) + videoId;
                }

                if(i == 0) {
                    videoId = "GIVE A YOUTUBE LINK DAMN IT";
                }

            }

            boolean playlistFound = false;

            for(int i = 0; i < user.playlists.size(); i++) {
                if(user.playlists.get(i).getId() == playlistId) {
                    user.playlists.get(i).videos.add(new Video(url, videoId, video.getTitle()));
                    userRepository.save(user);
                    playlistFound = true;
                }
            }

            if(playlistFound) {
                return "playlist found, adding video";
            } else {
                return "Playlist or user not found.";
            }

    }

    public void sortPlaylist(Long id, Long playlistId) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("No user found")
        );

        boolean success = false;

        for(int i = 0; i < user.playlists.size(); i++) {
            if(user.playlists.get(i).getId() == playlistId) {
                Playlist playlist = user.playlists.get(i);
                user.playlists.get(i).addTimesClicked();
                userRepository.save(user);
                success = true;
            }
        }

        if(success == false) {
            throw new IllegalStateException("Something went wrong");
        }
    }

    public Playlist getPlaylist(Long userId, Long playlistId) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new IllegalStateException("No user found")
        );

        Playlist playlist = new Playlist("Playlist not found");

        for(int i = 0; i < user.playlists.size(); i++) {
            if(user.playlists.get(i).getId() == playlistId) {
                playlist = user.playlists.get(i);
            }
        }

        return playlist;
    }

    public void setLastClickedVideo(Long id, Long playlistId, Long videoId, boolean reset) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("No user found")
        );

        boolean playlistFound = false;
        boolean videoFound = false;
        if(reset == false) {
            for (int i = 0; i < user.playlists.size(); i++) {
                if (user.playlists.get(i).getId() == playlistId) {
                    playlistFound = true;

                    for (int z = 0; z < user.playlists.get(i).videos.size(); z++)
                        if (user.playlists.get(i).videos.get(z).getId() == videoId) {
                            videoFound = true;

                            user.setLastClickedVideo(user.playlists.get(i).videos.get(z));
                            userRepository.save(user);
                        }
                }
            }
        } else {
            user.setLastClickedVideo(new Video());
            userRepository.save(user);
        }


    }
}
