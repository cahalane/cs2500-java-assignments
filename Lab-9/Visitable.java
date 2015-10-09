/**
 * Visitable is an interface that allows a collection to be "visited"
 * by {@code Visitor{} objects.
 */
public interface Visitable<T>{
    /**
     * A method that should visit every object in a collection and
     * call {@code visitor.show()} on that object.
     * @param visitor An object implementing the {@code Visitor} interface
     *                which visits the elements in the visitable collection.
     */
    public void visitAll( Visitor<T> visitor );
}