package myslenietak;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.NoSuchElementException;

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
                            @RequestParam(required = false) Integer duration,
                            @RequestParam(required = false) SortType sortType,
                            @RequestParam(required = false) Integer page,
                            @RequestParam(required = false) Integer size)
       {
        return recipeService.getRecipes(
                ingredients,
                complexity,
                duration,
                sortType,
                page,
                size);
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

    @PatchMapping("/{id}")
    Recipe updateRecipe(@PathVariable Long id, @RequestBody Recipe recipe){
         return recipeService.updateRecipe(id, recipe);
    }

    @ExceptionHandler(NoRecipeFoundException.class)
    private ResponseEntity<Error> mapNoRecipeFoundException(NoRecipeFoundException ex){
         return new ResponseEntity<>(new Error(HttpStatus.NOT_FOUND.value(),
                 ex.getMessage()
         ), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RecipeAlreadyExistsException.class)
    private ResponseEntity<Error> mapRecipeAlreadyExistsException(RecipeAlreadyExistsException ex){
         return new ResponseEntity<>(
                 new Error(HttpStatus.BAD_REQUEST.value(), ex.getMessage()),
                 HttpStatus.BAD_REQUEST
         );

    }

}
