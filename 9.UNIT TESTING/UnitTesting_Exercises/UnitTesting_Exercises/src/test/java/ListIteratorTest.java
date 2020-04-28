import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p03_IteratorTest.ListIterator;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {

    private static final String[] INITIAL_DATA = new String[]{"One","Two","Three"};
    private ListIterator li;

    @Before
    public void beforeEach() throws OperationNotSupportedException {
        this.li = new ListIterator(INITIAL_DATA);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void constructorShouldThrowIfPassedNull() throws OperationNotSupportedException {
        ListIterator li = new ListIterator(null);
    }

    @Test
    public void constructorShouldSetElementsCorrectly(){
        String lastElement = li.print();
        Assert.assertEquals(INITIAL_DATA[0],lastElement);
    }

}
