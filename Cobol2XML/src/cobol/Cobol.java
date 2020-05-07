/*
 * @(#)Cobol.java	 0.0.1
 *
 * Copyright (cobol) 2019 Julian M. Bass
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

import utensil.*;

public class Cobol implements PubliclyCloneable {
	protected String commentLine;
	protected String program_id;
	protected String sectionName;
	protected String divisionName;
	protected int dayDateWritten = 0;
	protected String monthDateWritten;
	protected int yearDateWritten = 0;
	protected String constantName;
	protected double constantValue;
	protected int lineNumber = 0;
	protected String remarks;
	protected String variableName;
	protected String variableValue;
	protected String variableType;
	protected int variableLength;
	protected String stringName;
	protected String stringValue;
	protected String stringType;
	protected int stringLength;


	/**
	 * Return a copy of this object.
	 *
	 * @return a copy of this object
	 */
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// this shouldn't happen, since we are Cloneable
			throw new InternalError();
		}
	}
	/**
	 * Compares two objects for equality, treating nulls carefullly,
	 * and relying on the first object's implementation of <code>
	 * equals()</code>.
	 *
	 * @param   object1   one object
	 *
	 * @param   object2   the other
	 *
	 * @return  <code>true</code> if the objects are equal and
	 *          <code>false</code> otherwise.
	 */
	public static boolean equal(Object object1, Object object2) {
		if (object1 == null || object2 == null) {
			return object1 == null && object2 == null;
		}
		return object1.equals(object2);
	}
	/**
	 * Compares this object against the specified object. The
	 * result is <code>true</code> if and only if the argument is
	 * not <code>null</code> and is a <code>Coffee</code> object
	 * whose attributes all equal this object's attributes.
	 *
	 * @param   object   the object to compare with.
	 *
	 * @return  <code>true</code> if the objects are equal and
	 *          <code>false</code> otherwise.
	 */
	public boolean equals(Object object) {
		if (!(object instanceof Cobol)) {
			return false;
		}
		Cobol cobol = (Cobol) object;


		if (!equal(program_id, cobol.program_id)) {
			return false;
		}

		if (!equal(sectionName, cobol.sectionName)) {
			return false;
		}


		return true;
	}

	/**
	 * Return line of commented text from the COBOL program.
	 *
	 * @return line of commented text from the COBOL program
	 */
	public String getCommentLine() {
		//System.out.println("getComment()");
		return commentLine;
	}

	/**
	 * Return the variable name from this COBOL program.
	 *
	 * @return the variable name from this COBOL program
	 */
	public String getVariableName() {
		return variableName;
	}

	/**
	 * Return the variable value from this COBOL program.
	 *
	 * @return the variable value from this COBOL program
	 */
	public String getVariableValue() {
		return variableValue;
	}

	/**
	 * Return the variable type from this COBOL program.
	 *
	 * @return the variable type from this COBOL program
	 */
	public String getVariableType() {
		return variableType;
	}

	/**
	 * Return the variable length from this COBOL program.
	 *
	 * @return the variable length from this COBOL program
	 */
	public int getVariableLength() {
		return variableLength;
	}

	/**
	 * Return the string name from this COBOL program.
	 *
	 * @return the string name from this COBOL program
	 */
	public String getStringName() {
		return stringName;
	}

	/**
	 * Return the string value from this COBOL program.
	 *
	 * @return the string value from this COBOL program
	 */
	public String getStringValue() {
		return stringValue;
	}

	/**
	 * Return the string type from this COBOL program.
	 *
	 * @return the string type from this COBOL program
	 */
	public String getStringType() {
		return stringType;
	}

	/**
	 * Return the string length from this COBOL program.
	 *
	 * @return the string length from this COBOL program
	 */
	public int getStringLength() {
		return stringLength;
	}


	/**
	 * Return the name of this COBOL program.
	 *
	 * @return the name of this COBOL program
	 */
	public String getProgram_ID() {
		return program_id;
	}

	/**
	 * Return the section name.
	 *
	 * @return the section name
	 */
	public String getSectionName() {
		return sectionName;
	}

	/**
	 * Return the division name.
	 *
	 * @return the division name
	 */
	public String getDivisionName() {
		return divisionName;
	}

	/**
	 * Return the dayDateWritten of this COBOL program.
	 *
	 * @return the dayDateWritten of this COBOL program
	 */
	public int getDayDateWritten() {
		return dayDateWritten;
	}


	/**
	 * Return the monthWritten of this COBOL program.
	 *
	 * @return the monthWritten of this COBOL program
	 */
	public String getMonthDateWritten() {
		return monthDateWritten;
	}

	/**
	 * Return the dayDateWritten of this COBOL program.
	 *
	 * @return the dayDateWritten of this COBOL program
	 */
	public int getYearDateWritten() {
		return yearDateWritten;
	}

	/**
	 * Set a line of commented text from the COBOL program.
	 *
	 * @return line of commented text from the COBOL program
	 */
	public void setCommentLine(String commentLine) {
		//System.out.println("setComment(): " + commentLine);
		this.commentLine = commentLine;
	}

	/**
	 * Set a variable name from the COBOL program.
	 *
	 * @param String variableName
	 */
	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}

	/**
	 * Set a variable value from the COBOL program.
	 *
	 * @param String variableValue
	 */
	public void setVariableValue(String variableValue) {
		this.variableValue = variableValue;
	}

	/**
	 * Set a variable type from the COBOL program.
	 *
	 * @param String variableType
	 */
	public void setVariableType(String variableType) {
		this.variableType = variableType;
	}

	/**
	 * Set a variable length from the COBOL program.
	 *
	 * @param int variableLength
	 */
	public void setVariableLength(int variableLength) {
		this.variableLength = variableLength;
	}

	/**
	 * Set a string name from the COBOL program.
	 *
	 * @param String stringName
	 */
	public void setStringName(String stringName) {
		this.stringName = stringName;
	}

	/**
	 * Set a string value from the COBOL program.
	 *
	 * @param String stringValue
	 */
	public void setStringValue(String stringValue) {
		this.stringValue = stringValue;
	}

	/**
	 * Set a string type from the COBOL program.
	 *
	 * @param String stringType
	 */
	public void setStringType(String stringType) {
		this.stringType = stringType;
	}

	/**
	 * Set a string length from the COBOL program.
	 *
	 * @param int stringLength
	 */
	public void setStringLength(int stringLength) {
		this.stringLength = stringLength;
	}

	/**
	 * Set the name of this cobol file.
	 *
	 * @param   String   the name
	 */
	public void setProgram_ID(String program_idString) {
		this.program_id = program_idString;
	}

	/**
	 * Set the dayDateWritten of this COBOL program.
	 *
	 * @param the dayDateWritten of this COBOL program
	 */
	public void setDayDateWritten(int dayDateWritten) {
		this.dayDateWritten = dayDateWritten;
	}

	/**
	 * Return the monthWritten of this COBOL program.
	 *
	 * @return the monthWritten of this COBOL program
	 */
	public void setMonthDateWritten(String monthDateWritten) {
		this.monthDateWritten = monthDateWritten;
	}

	/**
	 * Set the yearDateWritten of this COBOL program.
	 *
	 * @param the yearDateWritten of this COBOL program
	 */
	public void setYearDateWritten(int yearDateWritten) {
		this.yearDateWritten = yearDateWritten;
	}


	/**
	 * Set the section name
	 *
	 * @param  String sectionName
	 */
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	/**
	 * Set the division name
	 *
	 * @param  String divisionName
	 */
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public String getProgram_id() {
		return program_id;
	}

	public void setProgram_id(String program_id) {
		this.program_id = program_id;
	}

	public String getConstantName() {
		return constantName;
	}

	public void setConstantName(String constantName) {
		this.constantName = constantName;
	}

	public double getConstantValue() {
		return constantValue;
	}

	public void setConstantValue(double constantValue) {
		this.constantValue = constantValue;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * Return a textual description of this cobol type.
	 *
	 * @return a textual description of this cobol type
	 */



	public String toString() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(program_id);
		stringBuffer.append(", ");
		stringBuffer.append(divisionName);
		stringBuffer.append(", ");
		stringBuffer.append(sectionName);

		return stringBuffer.toString();
	}
}
