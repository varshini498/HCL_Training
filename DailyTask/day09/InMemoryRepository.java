
import java.util.*;
import java.util.function.Function;

public class InMemoryRepository<T, ID>
        implements CrudRepository<T, ID> {

    private final Map<ID, T> data = new LinkedHashMap<>();
    private final Function<T, ID> idExtractor;

    public InMemoryRepository(Function<T, ID> idExtractor) {
        this.idExtractor = Objects.requireNonNull(idExtractor);
    }

    @Override
    public T save(T entity) {
        Objects.requireNonNull(entity);
        ID id = Objects.requireNonNull(idExtractor.apply(entity));
        data.put(id, entity);
        return entity;
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(data.get(id));
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(data.values());
    }

    @Override
    public boolean deleteById(ID id) {
        return data.remove(id) != null;
    }
}
