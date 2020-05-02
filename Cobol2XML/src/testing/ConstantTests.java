package testing;

import cobol.Cobol;
import cobol.CobolParser;
import org.junit.Test;
import parse.Assembly;
import parse.Parser;
import parse.tokens.TokenAssembly;
import parse.tokens.Tokenizer;

public class ConstantTests {

    @Test
    public void testConstant() {
        Tokenizer t = CobolParser.tokenizer();
        Parser p = CobolParser.start();
        t.setString("88  base_2                          value 2.");
        Assembly in = new TokenAssembly(t);
        Assembly out = p.bestMatch(in);
        Cobol c = new Cobol();
        c = (Cobol) out.getTarget();
    }


}
