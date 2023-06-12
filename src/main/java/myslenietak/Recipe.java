package myslenietak;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class Recipe {
    @Id
    @GeneratedValue
    Long id;

    public Recipe(String name, String description, Integer duration, Integer numberOfPeople, String ingredients, Complexity complexity) {
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.numberOfPeople = numberOfPeople;
        this.ingredients = ingredients;
        this.complexity = complexity;
    }
    @NotBlank
    @NotNull
    @Size(min =2, max = 30)
    private String name;

    @NotBlank
    @NotNull
    @Size(min =10, max = 100)
    private String description;

    @NotNull
    @Min(1)
    private Integer duration;

    @Max(20)
    @Min(1)
    private Integer numberOfPeople;
    private String ingredients;

    @NotNull
    private Complexity complexity;

    public Recipe() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(Integer numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public Complexity getComplexity() {
        return complexity;
    }

    public void setComplexity(Complexity complexity) {
        this.complexity = complexity;
    }
}
enum Complexity {
    EASY, STANDARD, HARD
}