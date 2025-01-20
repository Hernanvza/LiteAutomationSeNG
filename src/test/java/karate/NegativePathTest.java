package karate;

import com.intuit.karate.junit5.Karate;

public class NegativePathTest {

    @Karate.Test
    Karate testNegativePath() {
        return Karate.run("negativePath").relativeTo(getClass());
    }
}
