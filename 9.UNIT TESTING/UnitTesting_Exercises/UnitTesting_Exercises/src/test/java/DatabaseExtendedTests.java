import org.junit.Before;
import org.junit.Test;
import p02_ExtendedDatabase.Database;
import p02_ExtendedDatabase.Person;

import javax.naming.OperationNotSupportedException;

public class DatabaseExtendedTests {
    private static final Person[] INITIAL_PERSONS = new Person[]{
            new Person(1, "Maria"),
            new Person(2, "Gosho"),
            new Person(3, "Stefan")};
    private Database db;

    @Before
    public void beforeEach() throws OperationNotSupportedException {
        db = new Database(INITIAL_PERSONS);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameShouldThrowWithNullParam() throws OperationNotSupportedException {
        db.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameShouldThrowIfDublicateName() throws OperationNotSupportedException {
        db.add(new Person(1, "Maria"));
        db.findByUsername("Maria");
    }
}
