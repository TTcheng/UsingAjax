
import org.junit.Test;
import java.io.File;
import java.io.IOException;

/**
 * Created by Wangchuncheng on 2018/7/24 11:21
 */
public class TestDao {

    @Test
    public void testpath(){
        //project root path hello.txt
        File file = new File("hello.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testLocationDao(){

    }
}
