package data;
import org.apache.commons.lang3.RandomStringUtils;
import page.User;
public class UserRandomizer {
    public static User getNewRandomUser() {
        return new User(RandomStringUtils.randomAlphanumeric(6),
                RandomStringUtils.randomAlphanumeric(8) + "@stellarburgers.ru",
                RandomStringUtils.randomAlphanumeric(6));
    }
}