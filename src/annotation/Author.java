package annotation;

/**
 * @author footman77
 * @create 2018-10-29 20:17
 */
public @interface Author {
//
//    String nickName() default "jack";
//
//    String[] address();

    String value();//如果注解的属性名称为value，那么在使用注解的时候可以不写value=
}
