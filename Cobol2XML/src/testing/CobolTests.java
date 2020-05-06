package testing;

import cobol.Cobol;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CobolTests {

    @Test
    public void testCobol() {
        Cobol cobol = new Cobol();
        cobol.setCommentLine("convert from base to dicimal system");
        assertEquals(cobol.getCommentLine(), "convert from base to dicimal system");
    }


}