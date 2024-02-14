package guru.qa.tests;

import com.github.javafaker.Faker;

import java.util.HashMap;

public class TestData {
    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress(firstName.toLowerCase() + "." + lastName.toLowerCase());
    String gender = getGender();
    String userNumber = faker.phoneNumber().subscriberNumber(10);
    String calendarDay = String.format("%02d", faker.number().numberBetween(1, 29));
    String calendarMonth = getCalendarMonth();
    String calendarYear = String.valueOf(faker.number().numberBetween(1950, 2024));
    String subjects = getSubjects();
    String hobbies = getHobbies();
    String imgName = "Anime.png";
    String address = faker.address().fullAddress();
    String city = getCity();
    String state = getStateByCity(city);



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