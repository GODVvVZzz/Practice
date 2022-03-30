package reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * @author HP
 * @date 2022/3/30
 * 练习反射操作注解
 */
public class Test06 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("reflection.Student2");

        //通过反射获得注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        //获得注解的value的值
        TableV tablev = (TableV)c1.getAnnotation(TableV.class);
        String value = tablev.value();
        System.out.println(value);

        //获得类指定的注解
        Field f = c1.getDeclaredField("name");
        FieldV annotation = f.getAnnotation(FieldV.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());
    }
}

@TableV("db_student")
class Student2{

    @FieldV(columnName = "db_id",type = "int",length = 10)
    private int id;

    @FieldV(columnName = "db_age",type = "int",length = 10)
    private int age;

    @FieldV(columnName = "db_name",type = "varchar",length = 10)
    private String name;

    public Student2() {
    }

    public Student2(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

//类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableV{
    String value();
}

//属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldV{
    String columnName();
    String type();
    int length();
}
