package webspace.demo.user;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table
public class User {


    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )

    private Long id;
    private String name;
    private String email;
    private String password;

    //@OneToOne(cascade=CascadeType.PERSIST) <or> @OneToOne(cascade=CascadeType.ALL) <-- for all operation
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "Playlist", referencedColumnName = "id")
    public List<Playlist> playlists = new ArrayList<Playlist>();

    private String preferedStyle;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ClickedStuff", referencedColumnName = "id")
    private LastVideo lastClickedVideo;


    public User(
            Long id,
            String name,
            String email,
            String password,
            String preferedStyle
            //Playlist[] source
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.preferedStyle = preferedStyle;
        //this.sources = source;
    }

    public User( 
            String name,
            String email,
            String password,
            String preferedStyle,
            List<Playlist> playlist
    ) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.preferedStyle = preferedStyle;
        this.playlists = playlist;
    }

    public User(
            String name,
            String email,
            String password,
            String preferedStyle
    ) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.preferedStyle = preferedStyle;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPreferredStyle() {return preferedStyle;}

    public void setPreferredStyle(String preferredStyle){
        this.preferedStyle = preferredStyle;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public LastVideo getLastClickedVideo() {
        return lastClickedVideo;
    }

    public void setLastClickedVideo(LastVideo video) {
        this.lastClickedVideo = video;
    }

}
