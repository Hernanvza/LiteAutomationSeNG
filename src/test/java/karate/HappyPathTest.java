package karate;

import com.intuit.karate.junit5.Karate;

public class HappyPathTest {

    @Karate.Test
    Karate testHappyPath() {
        return Karate.run("happyPath").relativeTo(getClass());
    }
}
