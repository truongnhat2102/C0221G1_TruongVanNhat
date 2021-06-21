package nasa_picture.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "picture")
public class Picture implements Cloneable{
    @Id
    private int id;
    private String director;
    private String point;
    private String comment;
    private int likes;

    public Picture(String director, String point, String comment, int likes) {
        this.director = director;
        this.point = point;
        this.comment = comment;
        this.likes = likes;
    }

    public Picture() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
