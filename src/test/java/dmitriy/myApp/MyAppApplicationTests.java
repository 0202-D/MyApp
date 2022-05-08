package dmitriy.myApp;

import static org.junit.jupiter.api.Assertions.*;

import com.yourCodeReview.Dmitriy.Task1.Cache;
import com.yourCodeReview.Dmitriy.Task1.MyAppApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = MyAppApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MyAppApplicationTests {
    private Cache cache;

    @Test
    public void testCache() {
        Cache cache = new Cache();
        cache.put("1", "one");
        cache.put("2", "two");
        cache.put("3", "three");
        cache.put("4", "four");
        assertEquals("two", cache.get("2"));
        assertNotEquals("five", cache.get("4"));
        cache.delete("3");
        try {
            cache.get("3");
            fail();
        } catch (Exception ignored) {
        }
        cache.put(null, "six");
        try {
            cache.get(null);
            fail();
        } catch (Exception ignored) {
        }
        cache.put("8", "");
        try {
            cache.get("8");
            fail();
        } catch (Exception ignored) {
        }
    }
}
