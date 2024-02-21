package me.sungbin.blog;

/**
 * @author : rovert
 * @packageName : me.sungbin.blog
 * @fileName : Blog
 * @date : 2/21/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/21/24       rovert         최초 생성
 */
public class Blog {

    private Long id;

    private String title;

    private String contents;

    private boolean isSecret;

    public Blog(Long id, String title, String contents, boolean isSecret) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.isSecret = isSecret;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public boolean isSecret() {
        return isSecret;
    }

    public void setSecret(boolean secret) {
        isSecret = secret;
    }
}
