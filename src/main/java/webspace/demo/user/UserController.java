package webspace.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //@CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PutMapping(path = "{id}/{playlistId}/{videoId}")
    public void setLastClickedVideo(
            @PathVariable("id") Long id,
            @PathVariable("playlistId") Long playlistId,
            @PathVariable("videoId") Long videoId

    ) {
        boolean reset = false;
        userService.setLastClickedVideo(id, playlistId, videoId, reset);
    }

    @GetMapping(path = "{name}/{password}")
    public User findUser(
            @PathVariable("name") String name,
            @PathVariable("password") String password
    ) {
        return userService.findUser(name, password);
    }

    @PostMapping 
    public void addUser(@RequestBody User user) {
        userService.addNewUser(user);
    }


    @GetMapping(path = "playlists/{userId}/{playlistId}")
    public void getPlaylist(
            @PathVariable("userId") Long userId,
            @PathVariable("playlistId") Long playlistId
    ) {
        userService.getPlaylist(userId, playlistId);
    }

    @PutMapping(path = "{id}/{playlist}")
    public void changePlaylist(
            @RequestParam(required = false) String name,
            @PathVariable("id") Long id,
            @PathVariable("playList") String playlist
            ) {
        userService.changePlaylist(
                id,
                playlist,
                name
        );
    }

    @PutMapping(path = "/sort/{id}/{playlistId}")
    public void sortPlaylist(
            @PathVariable("id") Long id,
            @PathVariable("playlistId") Long playlistId
    ) {
        userService.sortPlaylist(
                id,
                playlistId
        );
    }

    /*@PutMapping(path = "{id}")
    public void changeResource(
            @RequestParam() String preferredStyle,
            @PathVariable("id") Long id
    ) {
        userService.changeStyling(id, preferredStyle);
    }*/

    @PostMapping(path = "{id}")
    public void addPlaylist(
            @PathVariable("id") Long id,
            @RequestBody Playlist playlist
    ) {
        userService.addPlaylist(id, playlist);
    }

    @PostMapping(path = "{id}/{playlistId}")
    public void addVideo(
            @PathVariable("id") Long id,
            @PathVariable("playlistId") Long playlistId,
            @RequestBody Video video
    ) {
        userService.addVideo(id, playlistId, video);
    }

    @DeleteMapping(path = "{id}")
    public void removeUser(
            @PathVariable("id") Long id
    ) {
        userService.removeUser(id);
    }

    @DeleteMapping(path = "{id}/{playlistId}")
    public void removePlaylist(
            @PathVariable("id") Long id,
            @PathVariable("playlistId") Long playlistId
    ) {
        userService.removePlaylist(id, playlistId);
    }

    @DeleteMapping(path = "{id}/{playlistId}/{videoId}")
    public void removeVideo(
            @PathVariable("id") Long id,
            @PathVariable("playlistId") Long playlistId,
            @PathVariable("videoId") Long videoId
    ) {
        userService.removeVideo(id, playlistId, videoId);
    }

}
