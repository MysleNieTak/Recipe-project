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
        recipeRepository.saveAll(Arrays.asList(new Recipe("Łosoś pieczony 1", "Pieczony łosoś w sosie koperkowym 1", 120, 2, "Łosoś, śmietanka, koperek, masło, cytryna, sól, pieprz, ziemniaki, brokuł", EASY)));
        recipeRepository.saveAll(Arrays.asList(new Recipe("Pad Thai 1", "Klasyczny pad thai 1", 60, 2, "Kurczak/krewetki, makaron ryżowy, sos sojowy, sos rybny, limonka, orzechy ziemne, cukier trzcinowy", Complexity.STANDARD)));
        recipeRepository.saveAll(Arrays.asList(new Recipe("Łosoś pieczony 2", "Pieczony łosoś w sosie koperkowym 2", 120, 2, "Łosoś, śmietanka, koperek, masło, cytryna, sól, pieprz, ziemniaki, brokuł", EASY)));
        recipeRepository.saveAll(Arrays.asList(new Recipe("Pad Thai 2", "Klasyczny pad thai 2", 60, 2, "Kurczak/krewetki, makaron ryżowy, sos sojowy, sos rybny, limonka, orzechy ziemne, cukier trzcinowy", Complexity.STANDARD)));

    }
}
