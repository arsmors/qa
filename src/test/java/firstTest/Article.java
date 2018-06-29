package firstTest;

public class Article {

    public String title;
    public String text;
    public Integer commentCound;

    public Integer getCommentCound() {
        return commentCound;
    }

    public void setCommentCound(Integer commentCound) {
        this.commentCound = commentCound;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
