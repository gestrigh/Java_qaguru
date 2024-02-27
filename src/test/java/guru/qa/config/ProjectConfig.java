package guru.qa.config;

import org.aeonbits.owner.Config;
@Config.Sources({"classpath:config/${env}.properties",
        "classpath:config/test.properties"})
public interface ProjectConfig extends Config   {
    @Key("student.name")
    String studentName();
    @Key("student.last.name")
    String studentLastName();
        @Key("student.email")
    String studentEmail();
        @Key("student.number")
    String studentNumber();

}
