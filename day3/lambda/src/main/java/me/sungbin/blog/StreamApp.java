package me.sungbin.blog;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : rovert
 * @packageName : me.sungbin.blog
 * @fileName : StreamApp
 * @date : 2/21/24
 * @description :
 * ===========================================================
 * DATE 			AUTHOR			 NOTE
 * -----------------------------------------------------------
 * 2/21/24       rovert         최초 생성
 */
public class StreamApp {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));


        List<List<OnlineClass>> ssonEvents = new ArrayList<>();
        ssonEvents.add(springClasses);
        ssonEvents.add(javaClasses);

        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
        ssonEvents.stream().flatMap(Collection::stream)
                .forEach(oc -> System.out.println(oc.getId()));

        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만");
        Stream.iterate(10, i -> i + 1)
                .skip(10)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인");
        boolean isTestClasses = javaClasses.stream().anyMatch(x -> x.getTitle().contains("Test"));
        System.out.println("isTestClasses : " + isTestClasses);

        System.out.println("스프링 수업 중에 제목에 spring이 들어간 제목만 모아서 List로 만들기");
        List<String> springTitleClasses =
                springClasses.stream()
                        .filter(x -> x.getTitle().contains("spring"))
                        .map(OnlineClass::getTitle)
                        .collect(Collectors.toList());

        springTitleClasses.forEach(x -> System.out.println("    > " + x));
    }
}
