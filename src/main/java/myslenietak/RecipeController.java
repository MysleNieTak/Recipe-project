package myslenietak;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequestMapping("/recipes")
@RestController
public class RecipeController {

    private final RecipeService recipeService;

     RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    List<Recipe> getRecipes(@RequestParam(required = false) String ingredients,
                            @RequestParam(required = false) Complexity complexity,
                            @RequestParam(required = false) Integer duration){
        return recipeService.getRecipes(ingredients, complexity, duration);
    }
    @GetMapping("/getById/{id}")
    Recipe getRecipeById(@PathVariable Long id){
         return recipeService.getRecipesById(id);
    }

    @PostMapping
    Recipe addRecipes(@RequestBody Recipe recipe){
        return recipeService.addRecipe(recipe);
    }

    @DeleteMapping("/{id}")
    Recipe deleteRecipes(@PathVariable Long id){
        return recipeService.deleteRecipe(id);
    }

}
