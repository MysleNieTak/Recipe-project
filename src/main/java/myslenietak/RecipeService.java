package myslenietak;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

     RecipeService(RecipeRepository recipeRepository){
        this.recipeRepository = recipeRepository;
    }

    List<Recipe> getRecipes(){
         return  recipeRepository.findAll();
    }

    Recipe getRecipesById(Long id){
        return recipeRepository.findById(id)
                .orElseThrow();
    }



    Recipe addRecipe(Recipe recipe){
         return recipeRepository.save(recipe);
    }

    Recipe deleteRecipe(Long id){
         Recipe recipeFromDb = recipeRepository
                 .findById(id)
                 .orElseThrow();
         recipeRepository.delete(recipeFromDb);
         return recipeFromDb;
    }

}
