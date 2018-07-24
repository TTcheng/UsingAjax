import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wangchuncheng.beans.User;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wangchuncheng on 2018/7/24 9:03
 *
 * note:Jackson使用getter方法来选择属性
 *      可使用@JsonIgnore注解来忽略某个getter方法
 */
public class TestJackson {
    @Test
    public void testJacksonObject() {
        ObjectMapper mapper = new ObjectMapper();
        String result = null;
        try {
            result = mapper.writeValueAsString(new User("Jesse", "jesse123", "Jesse@163.com"));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println("result = " + result);
    }

    @Test
    public void testJacksonMap() {
        ObjectMapper mapper = new ObjectMapper();
        Map map = new HashMap<String, String>();
        map.put("name", "Jackson");
        map.put("gender", "Male");
        map.put("email", "jackson@163.com");
        String resultJson = null;
        try {
            resultJson = mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println("resultJson = " + resultJson);
    }
}
