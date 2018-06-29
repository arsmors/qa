package firstTest;

import org.junit.Test;

public class ForTest {

    @Test
    public void tests() {
        Article article = new Article();
        article.setTitle("Article1");
        article.setText("Text123");
        article.setCommentCound(15);

        System.out.println(article.getTitle());
        System.out.println(article.getText());
        System.out.println(article.getCommentCound());
    }
}
