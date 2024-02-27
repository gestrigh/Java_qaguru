package guru.qa.utils;

import com.github.javafaker.Faker;

import java.util.HashMap;

public class RandomUtil {
    Faker faker = new Faker();
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmail = faker.internet().emailAddress(firstName.toLowerCase() + "." + lastName.toLowerCase());
    public String gender = getGender();
    public String userNumber = faker.phoneNumber().subscriberNumber(10);
    public String calendarDay = String.format("%02d", faker.number().numberBetween(1, 29));
    public String calendarMonth = getCalendarMonth();
    public String calendarYear = String.valueOf(faker.number().numberBetween(1950, 2024));
    public String subjects = getSubjects();
    public String hobbies = getHobbies();
    public String imgName = "Anime.png";
    public String address = faker.address().fullAddress();
    public String city = getCity();
    public String state = getStateByCity(city);


    public String getGender() {

        return faker.options().option("Male", "Female", "Other");
    }

    public String getCalendarMonth() {
        return faker.options().option("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");
    }

    public String getSubjects() {
        return faker.options().option("Hindi", "English", "Maths", "Physics", "Chemistry", "Biology",
                "Computer Science", "Commerce", "Accounting", "Economics", "Arts", "Social Studies", "History", "Civics");
    }

    public String getHobbies() {

        return faker.options().option("Sports", "Reading", "Music");
    }

    public String getCity() {
        return faker.options().option("Delhi", "Agra", "Karnal", "Gurgaon", "Lucknow", "Panipat", "Jaipur", "Jaiselmer");
    }

    public String getStateByCity(String value) {
        HashMap<String, String> cityAndState = new HashMap<>();
        cityAndState.put("Delhi", "NCR");
        cityAndState.put("Gurgaon", "NCR");
        cityAndState.put("Agra", "Uttar Pradesh");
        cityAndState.put("Lucknow", "Uttar Pradesh");
        cityAndState.put("Karnal", "Haryana");
        cityAndState.put("Panipat", "Haryana");
        cityAndState.put("Jaipur", "Rajasthan");
        cityAndState.put("Jaiselmer", "Rajasthan");
        return cityAndState.get(value);
    }
}