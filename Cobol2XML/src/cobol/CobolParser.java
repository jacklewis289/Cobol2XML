/*
 * @(#)CobolParser.java	 0.1.0
 *
 * Copyright (c) 2019 Julian M. Bass
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 *
 */
package cobol;

import parse.Alternation;
import parse.Repetition;
import parse.Empty;
import parse.Parser;
import parse.Sequence;
import parse.tokens.*;

public class CobolParser {
	/**
	 * Return a parser that will recognize the selected COBOL source code constructs:
	 *
	 *
	 * This parser creates a <code>COBOL</code> object
	 * as an assembly'sequence target.
	 *
	 * @return a parser that will recognize and build a
	 *         <object>COBOL</object> from a source code file.
	 */
	public Parser cobol() {
		Alternation alternation = new Alternation();

		Symbol fullstop = new Symbol('.');
		fullstop.discard();

		alternation.add( ProgramID() );

		alternation.add( DivisionName() );

		alternation.add( SectionName() );

		alternation.add( DateWritten() );

		alternation.add( constantValue() );

		alternation.add( commentLine() );

		alternation.add( remarks() );

		alternation.add( variable() );

		alternation.add( string() );

		alternation.add(new Empty());
		return alternation;
	}

	private Parser string() {
		Sequence sequence = new Sequence();
		sequence.add(new Num());
		sequence.add(new Word());
		sequence.add(new CaselessLiteral("pic"));
		sequence.add(new Word());
		sequence.add(new Symbol('('));
		sequence.add(new Num());
		sequence.setAssembler(new StringAssembler());
		return sequence;
	}

	private Parser variable() {
		Sequence sequence = new Sequence();
		sequence.add(new Num());
		sequence.add(new Word());
		sequence.add(new CaselessLiteral("pic"));
		sequence.add(new Num());
		sequence.add(new Symbol('('));
		sequence.add(new Num());
		sequence.setAssembler(new VariableAssembler());
		return sequence;
	}

	private Parser remarks() {
		Sequence sequence = new Sequence();
		sequence.add(new CaselessLiteral("remarks"));
		sequence.add(new Symbol('.').discard());
		sequence.add(new Word().setAssembler(new RemarksValueAssembler()) );
		return sequence;
	}

	/*
	 * Return a parser that will recognize the grammar:
	 *
	 * value
	 *
	 */
	private Parser constantValue() {
		//System.out.println("constantValue()");
		Sequence sequence = new Sequence();
		sequence.add(new Num() );
		sequence.add(new Word() );
		sequence.add(new CaselessLiteral("value") );
		sequence.add(new Num() );
		sequence.setAssembler(new ConstantValueAssembler());
		return sequence;
	}

	/*
	 * Return a parser that will recognize the grammar:
	 *
	 * ***--- comment text
	 *
	 */
	private Parser commentLine() {
		//System.out.println("commentLine()");
		Sequence sequence = new Sequence();
		sequence.add(new Symbol("*"));
		sequence.add(new Symbol("*"));
		sequence.add(new Symbol("*"));
		sequence.add(new Symbol("-"));
		sequence.add(new Symbol("-"));
		sequence.add(new Symbol("-"));
		sequence.add(new Word().setAssembler(new CommentLineAssembler()) );
		//sequence.setAssembler(new CommentLineAssembler());
		return sequence;
	}

	/*
	 * Return a parser that will recognize the grammar:
	 *
	 *    Program Identifier = Word;
	 *
	 */
	protected Parser ProgramID() {
		Sequence sequence = new Sequence();
		sequence.add(new CaselessLiteral("program-id") );
		sequence.add(new Symbol('.').discard());
		sequence.add(new Word().setAssembler(new Program_idAssembler()));
		return sequence;
	}

	/*
	 * Return a parser that will recognise the grammar:
	 *
	 *    <divisionName> division;
	 *
	 */
	protected Parser DivisionName() {
		Sequence sequence = new Sequence();
		sequence.add(new Word().setAssembler(new DivisionAssembler()));
		sequence.add(new CaselessLiteral("division") );
		sequence.add(new Symbol('.').discard());
		return sequence;
	}

	/*
	 * Return a parser that will recognize the grammar:
	 *
	 *    Program Identifier = Word;
	 *
	 */
	protected Parser SectionName() {
		Sequence sequence = new Sequence();
		sequence.add(new Word().setAssembler(new SectionNameAssembler()));
		sequence.add(new CaselessLiteral("section") );
		sequence.add(new Symbol('.').discard());

		return sequence;
	}

	/*
	 * Return a parser that will recognise the grammar:
	 *
	 *    working-storage section;
	 *
	 */
	protected Parser DateWritten() {
		Sequence sequence = new Sequence();
		sequence.add(new CaselessLiteral("date-written") );
		sequence.add(new Symbol('.').discard());
		sequence.add(new Num());
		sequence.add(new Symbol('-').discard());

		//This next Word actually contains month and year (which are extracted in DateAssembler
		sequence.add(new Word());
		sequence.add(new Symbol('-').discard());
		sequence.add(new Word().discard());
		sequence.add(new Symbol('.').discard());
		sequence.setAssembler(new DateAssembler());
		return sequence;
	}


	/**
	 * Return the primary parser for this class -- cobol().
	 *
	 * @return the primary parser for this class -- cobol()
	 */
	public static Parser start() {
		return new CobolParser().cobol();
	}

	/**
	 * Returns a tokenizer that does not allow spaces to appear inside
	 * the "words" that identify cobol'sequence grammar.
	 *
	 * @return a tokenizer that does not allow spaces to appear inside
	 * the "words" that identify cobol grammar.
	 */
	public static Tokenizer tokenizer() {
		Tokenizer tokenizer = new Tokenizer();
		tokenizer.wordState().setWordChars(' ', ' ', false);
		return tokenizer;
	}

}
