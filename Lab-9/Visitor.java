/**
 * Visitor provides a way for code to be executed for each element of
 * a {@code Visitable} collection. The {@code Visitable} collection's 
 * {@code visitAll()} method {@code show()}s the Visitor the contents of
 * its elements and through this, a visitor can process its data.
 */
public interface Visitor<T>{
    /**
     * A method that should be called for each individual member of a
     * visitable collection, receiving the data contained in this element.
     * @param data Contents of such a visitable collection.
     */
    public void show( final T data );
}