package me.sungbin.blog;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : rovert
 * @packageName : me.sungbin.blog
 * @fileName : App
 * @date : 2/21/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/21/24       rovert         최초 생성
 */
public class App {
    public static void main(String[] args) {
        List<Blog> developBlogs = new ArrayList<>();
        developBlogs.add(new Blog(1L, "자바", "스트림 API", true));
        developBlogs.add(new Blog(1L, "mysql", "롤백", true));
        developBlogs.add(new Blog(1L, "spring boot", "DI", false));
        developBlogs.add(new Blog(1L, "spring data jpa", "트랜잭션", false));
        developBlogs.add(new Blog(1L, "spring security", "cors", false));

        System.out.println("spring 으로 시작하는 블로그");
        List<Blog> blogsByTitleIsSpringStartWith =
                developBlogs.stream()
                        .filter(x -> x.getTitle().startsWith("spring"))
                        .collect(Collectors.toList());

        blogsByTitleIsSpringStartWith.forEach(x -> System.out.println("   > " + x.getTitle()));

        System.out.println("공개 블로그");
        List<Blog> notSecretBlog =
                developBlogs.stream()
                        .filter(x -> !x.isSecret())
                        .collect(Collectors.toList());

        notSecretBlog.forEach(x -> System.out.println("   > " + x.getTitle()));

        System.out.println("블로그 이름만 만들어서 스트림 만들기");
        List<String> blogsByTitle =
                developBlogs.stream()
                        .map(Blog::getTitle)
                        .collect(Collectors.toList());

        blogsByTitle.forEach(x -> System.out.println("    > " + x));

    }
}
