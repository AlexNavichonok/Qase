package tests;

import com.google.gson.annotations.Expose;
import lombok.Data;

import java.util.List;

@Data
public class HHResponse {
    List<Vacancy> items;
    @Expose
    int found;

}
