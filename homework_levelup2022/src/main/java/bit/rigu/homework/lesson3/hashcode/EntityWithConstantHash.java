package bit.rigu.homework.lesson3.hashcode;

public class EntityWithConstantHash extends EntityWithChangeHash
            implements Entity {

    public EntityWithConstantHash(String name, int number, int number2) {
        super(name, number, number2);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
