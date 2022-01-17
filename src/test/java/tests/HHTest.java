package tests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class HHTest {

    @Test
    public void getVacancy(){
        String vacancies =
                when().
                        get("https://api.hh.ru/vacancies?text=QA").
                        then().
                        extract().body().asString();
        System.out.println(vacancies);

        HHResponse response = new GsonBuilder().
                excludeFieldsWithoutExposeAnnotation().
                create().
                fromJson(vacancies, HHResponse.class);

        System.out.println(response);

        for(Vacancy vacancy:response.getItems()){
            if(vacancy.getSalary() != null)
                System.out.println(vacancy.getSalary().getAverage());
        }
    }
}
