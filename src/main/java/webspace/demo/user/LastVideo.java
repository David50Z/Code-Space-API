package webspace.demo.user;

import javax.persistence.*;

@Entity
@Table
public class LastVideo {

    @Id
    @SequenceGenerator(
            name = "clickedStuff_sequence",
            sequenceName = "clickedStuff_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "clickedStuff_sequence"
    )

    private Long id;

    private String url;

    private String videoId;

    private String title;

    private String test = "Yoooo";


    LastVideo(
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

    LastVideo(
            String url,
            String videoId,
            String videoTitle,
            String test

    ) {
        this.url = url;
        this.videoId = videoId;
        this.title = videoTitle;
        this.test = test;
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

    LastVideo() {

    }

    public String getTest() {
        return test;
    }

    public Long getId() {return id;}

    public String getUrl() {
        return url;
    }

    public String getVideoId() {
        return videoId;
    }


    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    //public void setUrl(String url) {
    //    this.url = url;
    //}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
