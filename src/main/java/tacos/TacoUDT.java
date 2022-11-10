package tacos;
import java.util.List;
import org.springframework.data.cassandra.core.mapping.UserDefinedType; import lombok.Data;
import tacos.web.IngredientUDT;

@Data @UserDefinedType("taco") public class TacoUDT {
    private final String name;
    private final List<IngredientUDT> ingredients;
}
