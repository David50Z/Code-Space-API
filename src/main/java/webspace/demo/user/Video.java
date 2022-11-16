package webspace.demo.user;

import javax.annotation.PostConstruct;
import javax.persistence.*;

@Entity
@Table
public class Video {

    @Id
    @SequenceGenerator(
            name = "video_sequence",
            sequenceName = "video_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "video_sequence"
    )

    private Long id;

    private String url;

    private String videoId;

    private String title;


    Video(
            String url,
            String videoId

    ) {
        this.url = url;
        this.videoId = videoId;
        /*String id = "";
        for(int i = url.length() - 1; i > -1; i--) {
            if(url.charAt(i) == '=') {
                this.videoId = id;
                break;
            } else {
                id = url.charAt(i) + id;
            }

            if(i == 0) {
                this.videoId = "GIVE A YOUTUBE LINK DAMN IT";
            }

        }*/
    }

    Video(
            String url,
            String videoId,
            String videoTitle

    ) {
        this.url = url;
        this.videoId = videoId;
        this.title = videoTitle;
        /*String id = "";
        for(int i = url.length() - 1; i > -1; i--) {
            if(url.charAt(i) == '=') {
                this.videoId = id;
                break;
            } else {
                id = url.charAt(i) + id;
            }

            if(i == 0) {
                this.videoId = "GIVE A YOUTUBE LINK DAMN IT";
            }

        }*/
    }

    Video() {

    }


    public Long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getVideoId() {
        return videoId;
    }


    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
