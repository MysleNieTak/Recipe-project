package myslenietak;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;

    RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    List<Recipe> getRecipes(String ingredients,
                            Complexity complexity,
                            Integer duration,
                            SortType sortType,
                            Integer page,
                            Integer size) {

        Pageable pageable = providePageable(page, size, sortType);

        if (ingredients != null) {
            return recipeRepository.findAllByIngredientsContains(ingredients, pageable);
        } else if (complexity != null) {
            return recipeRepository.findAllByComplexity(complexity, pageable);
        } else if (duration != null) {
            return recipeRepository.findAllByDuration(duration, pageable);
        }
        return recipeRepository.findAll(pageable).toList();

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

    Pageable providePageable (Integer page, Integer size, SortType sortType) {

        Sort.Direction direction = SortType.DESC == sortType ? Sort.Direction.DESC : Sort.Direction.ASC;
        Sort sort = Sort.by(direction, "name");

        // start range: pages x size, end range: pages x size + size = which elements received
        // if page/sort/page+sort/lack of page&sort service:

        return PageRequest.of(
                page != null && size != null ? page : 0,
                page != null && size != null ? size : (int) recipeRepository.count(), sort);

    }

}
