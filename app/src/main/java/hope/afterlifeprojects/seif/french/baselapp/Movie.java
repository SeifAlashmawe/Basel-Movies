package hope.afterlifeprojects.seif.french.baselapp;

public class Movie {

    private String title ;
    private String description ;
    private int thumbnail ;
    private String studio ;
    private String rating;
    private String streamingLink;
    private int coverPhoto;
    private  String Test1;
    private  String Test2;



    public Movie(String test1, String test2) {
        Test1 = test1;
        Test2 = test2;
    }

    public Movie(String title, int thumbnail, int coverPhoto) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.coverPhoto = coverPhoto;
    }

    public Movie(String title, int thumbnail) {
        this.title = title;
        this.thumbnail = thumbnail;
    }

    public Movie(String title, String description, int thumbnail, String studio, String rating, String streamingLink) {
        this.title = title;
        this.description = description;
        this.thumbnail = thumbnail;
        this.studio = studio;
        this.rating = rating;
        this.streamingLink = streamingLink;
    }
    public String getTest1() {
        return Test1;
    }

    public void setTest1(String test1) {
        Test1 = test1;
    }

    public String getTest2() {
        return Test2;
    }

    public void setTest2(String test2) {
        Test2 = test2;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public String getStudio() {
        return studio;
    }

    public String getRating() {
        return rating;
    }

    public String getStreamingLink() {
        return streamingLink;
    }

    public int getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(int coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setStreamingLink(String streamingLink) {
        this.streamingLink = streamingLink;
    }
}
