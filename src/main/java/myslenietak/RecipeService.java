package myslenietak;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    List<Recipe> getRecipes(String ingredients, Complexity complexity, Integer duration) {
        if (ingredients != null) {
            return recipeRepository.findAllByIngredientsContains(ingredients);
        } else if (complexity != null) {
            return recipeRepository.findAllByComplexity(complexity);
        } else if (duration != null) {
            return recipeRepository.findAllByDuration(duration);
        }
        return recipeRepository.findAll();
    }

    Recipe getRecipesById(Long id) {
        return recipeRepository.findById(id)
                .orElseThrow();
    }


    Recipe addRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    Recipe deleteRecipe(Long id) {
        Recipe recipeFromDb = recipeRepository
                .findById(id)
                .orElseThrow();
        recipeRepository.delete(recipeFromDb);
        return recipeFromDb;
    }

    Recipe updateRecipe(Long id, Recipe recipe) {
        Recipe recipeToUpdate = recipeRepository.findById(id)
                .orElseThrow();
        if (recipe.getName() != null) {
            recipeToUpdate.setName(recipe.getName());
        }
        if (recipe.getDescription() != null) {
            recipeToUpdate.setDescription(recipe.getDescription());
        }
        if (recipe.getDuration() != null) {
            recipeToUpdate.setDuration(recipe.getDuration());
        }
        if (recipe.getNumberOfPeople() != null) {
            recipeToUpdate.setNumberOfPeople(recipe.getNumberOfPeople());
        }
        if (recipe.getIngredients() != null) {
            recipeToUpdate.setIngredients(recipe.getIngredients());
        }
        return recipeRepository.save(recipeToUpdate);
    }

}
