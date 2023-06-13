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
    @NotBlank(groups = {AddRecipe.class})
    @NullOrNotBlank(groups = {AddRecipe.class, UpdateRecipe.class})
    @Size(min =2, max = 30, groups = {AddRecipe.class, UpdateRecipe.class})
    private String name;

    @NotBlank(groups = {AddRecipe.class})
    @NullOrNotBlank(groups = {AddRecipe.class, UpdateRecipe.class})
    @Size(min = 10, max = 100, groups = {AddRecipe.class, UpdateRecipe.class})
    private String description;

    @NotNull(groups = AddRecipe.class)
    @Min(value = 1, groups = {AddRecipe.class, UpdateRecipe.class})
    private Integer duration;

    @Max(value = 20, groups = {AddRecipe.class, UpdateRecipe.class})
    @Min(value = 1, groups = {AddRecipe.class, UpdateRecipe.class})
    private Integer numberOfPeople;
    private String ingredients;

    @NotNull(groups = AddRecipe.class)
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

interface AddRecipe {}

interface UpdateRecipe {}