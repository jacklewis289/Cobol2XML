package testing;

import cobol.Cobol;
import cobol.CobolParser;
import org.junit.Test;
import parse.Assembly;
import parse.Parser;
import parse.tokens.TokenAssembly;
import parse.tokens.Tokenizer;
import static org.junit.Assert.assertEquals;

public class SectionTests {

    @Test
    public void testSectionStorage() {
        Tokenizer t = CobolParser.tokenizer();
        Parser p = CobolParser.start();
        t.setString("working-storage section.");
        Assembly in = new TokenAssembly(t);
        Assembly out = p.bestMatch(in);
        Cobol c = new Cobol();
        c = (Cobol) out.getTarget();
        assertEquals(c.getSectionName(), "working-storage");
    }

}
