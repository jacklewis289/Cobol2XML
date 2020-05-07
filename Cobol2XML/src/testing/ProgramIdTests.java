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
        Tokenizer tokenizer = CobolParser.tokenizer();
        Parser parser = CobolParser.start();
        tokenizer.setString("program-id.  base.");
        Assembly in = new TokenAssembly(tokenizer);
        Assembly out = parser.bestMatch(in);
        Cobol cobol = new Cobol();
        cobol = (Cobol) out.getTarget();
        assertEquals(cobol.getProgram_id(), "base");
    }


}
