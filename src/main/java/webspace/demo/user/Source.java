package webspace.demo.user;

public class Source {

    private String url;
    private String img;

    Source(
            String url,
            String img
    ) {
        this.url = url;
        this.img = img;
    }

    public String getUrl() {
        return url;
    }

    public String getImg() {
        return img;
    }

}
