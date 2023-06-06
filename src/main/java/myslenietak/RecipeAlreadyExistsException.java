package myslenietak;

public class RecipeAlreadyExistsException extends RuntimeException{
    public RecipeAlreadyExistsException(String recipeName){
        super(String.format("Recipe %s already exists!", recipeName));
    }
}
