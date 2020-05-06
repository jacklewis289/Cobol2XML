package testing;

import cobol.Cobol;
import cobol.CobolParser;
import org.junit.Test;
import parse.Assembly;
import parse.Parser;
import parse.tokens.TokenAssembly;
import parse.tokens.Tokenizer;
import static org.junit.Assert.assertEquals;

public class ProgramIdTests {

    @Test
    public void testProgramId() {
        Tokenizer t = CobolParser.tokenizer();
        Parser p = CobolParser.start();
        t.setString("program-id.  base.");
        Assembly in = new TokenAssembly(t);
        Assembly out = p.bestMatch(in);
        Cobol c = new Cobol();
        c = (Cobol) out.getTarget();
        assertEquals(c.getProgram_id(), "base");
    }


}
