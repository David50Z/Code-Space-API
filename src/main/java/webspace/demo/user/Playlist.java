package webspace.demo.user;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Playlist {

    @Id
    @SequenceGenerator(
            name = "playlist_sequence",
            sequenceName = "playlist_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "playlist_sequence"
    )

    private Long id;

    private String name;

    private int timesClicked = 0;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "videos", referencedColumnName = "id")
    public List<Video> videos = new ArrayList<Video>();


    Playlist(
        String name
    ) {
        this.name = name;
    }

    Playlist() {

    }


    public Long getId() {
        return id;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public String getName() {
        return name;
    }


    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimesClicked() {
        return timesClicked;
    }

    public void addTimesClicked() {
        timesClicked++;
    }
}
