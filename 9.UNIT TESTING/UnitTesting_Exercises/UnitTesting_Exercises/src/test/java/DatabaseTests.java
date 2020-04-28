import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p01_Database.Database;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;

public class DatabaseTests {

    private static final Integer[] INITIAL_ELEMENTS = new Integer[]{1,2,3};
    private Database db;

    @Before
    public void beforeEach() throws OperationNotSupportedException {
        db = new Database(INITIAL_ELEMENTS);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void constructorShouldThrowWithLessThanOneElement() throws OperationNotSupportedException {
        Database db = new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void constructorShouldThrowWithMoreThan16Elements() throws OperationNotSupportedException {
        Database db = new Database(new Integer[17]);
    }

    @Test
    public void constructorShouldIncreaceElementsCount() throws OperationNotSupportedException, NoSuchFieldException, IllegalAccessException {
        Field elementsCount = db.getClass().getDeclaredField("elementsCount");
        elementsCount.setAccessible(true);
        assertEquals(INITIAL_ELEMENTS.length,elementsCount.getInt(db));
    }

    @Test
    public void addOperationMustAddElementAtTheLastAvailableIndex() throws OperationNotSupportedException, NoSuchFieldException, IllegalAccessException {
        db.add(8);
        Field index = db.getClass().getDeclaredField("index");
        index.setAccessible(true);
        assertEquals(index.getInt(db),db.getElements().length-1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addOperationShouldThrowIfPassedNull() throws OperationNotSupportedException {
        db.add(null);
    }

    @Test
    public void getElementsOperationMustReturnArray(){
        assertEquals(db.getElements(),INITIAL_ELEMENTS);
    }

    @Test
    public void removeOperationShouldRemoveFromLastIndex() throws OperationNotSupportedException {
        db.remove();
        assertEquals(db.getElements().length, INITIAL_ELEMENTS.length-1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeOperationShouldThrowIfArrayIsEmpty() throws OperationNotSupportedException {
        db.remove();
        db.remove();
        db.remove();
        db.remove();
    }
}
