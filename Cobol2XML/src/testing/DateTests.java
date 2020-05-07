package testing;

import cobol.Cobol;
import cobol.CobolParser;
import org.junit.Test;
import parse.Assembly;
import parse.Parser;
import parse.tokens.TokenAssembly;
import parse.tokens.Tokenizer;
import static org.junit.Assert.assertEquals;

public class DateTests {

    @Test
    public void testDate() {
        Tokenizer tokenizer = CobolParser.tokenizer();
        Parser parser = CobolParser.start();
        tokenizer.setString("date-written.  07-mar-1995 - mb.");
        Assembly in = new TokenAssembly(tokenizer);
        Assembly out = parser.bestMatch(in);
        Cobol cobol = new Cobol();
        cobol = (Cobol) out.getTarget();
        assertEquals(cobol.getMonthDateWritten(), "mar");
    }


}
