package reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @author HP
 * @date 2022/3/30
 * 获取泛型信息
 */
public class Test05 {
    public void test01(Map<String,User> map, List<User> list){
        System.out.println("test01");
    }

    public Map<String,User> test02(){
        System.out.println("test02");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = Test05.class.getMethod("test01", Map.class, List.class);

        //获得泛型的参数类型
        Type[] genericParameterTypes = method.getGenericParameterTypes();

        for(Type g : genericParameterTypes){
            System.out.println("#"+g);
            if(g instanceof ParameterizedType){
                Type[] actualTypeArguments = ((ParameterizedType) g).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println(actualTypeArgument);
                }
            }
        }
    }
}
