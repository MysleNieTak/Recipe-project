package myslenietak;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.Arrays;

import static myslenietak.Complexity.EASY;
import static myslenietak.Complexity.HARD;

@Component
public class RecipeDataSetInitializer {
    private final RecipeRepository recipeRepository;


    public RecipeDataSetInitializer(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @PostConstruct
    void init(){
        recipeRepository.saveAll(Arrays.asList(new Recipe("Łosoś pieczony", "Pieczony łosoś w sosie koperkowym", 120, 2, "Łosoś, śmietanka, koperek, masło, cytryna, sól, pieprz, ziemniaki, brokuł", EASY)));
        recipeRepository.saveAll(Arrays.asList(new Recipe("Pad Thai", "Klasyczny pad thai", 60, 2, "Kurczak/krewetki, makaron ryżowy, sos sojowy, sos rybny, limonka, orzechy ziemne, cukier trzcinowy", Complexity.STANDARD)));

    }
}
