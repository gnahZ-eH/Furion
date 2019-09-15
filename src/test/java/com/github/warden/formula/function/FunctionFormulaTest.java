/*
 * MIT License
 *
 * Copyright (c) [2019] [He Zhang]
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.warden.formula.function;

import com.github.warden.enums.FormulaType;
import com.github.warden.exception.FormulaException;
import com.github.warden.formula.Formula;
import com.github.warden.formula.arithmetic.Addition;
import com.github.warden.formula.function.mathematics.Abs;
import com.github.warden.formula.number.DoubleFormula;
import com.github.warden.formula.number.IntegerFormula;
import com.github.warden.formula.number.NumberFormula;
import com.github.warden.processor.Parser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionFormulaTest {

    @Test
    public void functionFormulaTest() {
        String line = "test(1, 2)";
        try {
            Formula formula = Parser.parse(line);
            assertEquals(formula.getFormulaType(), FormulaType.FUNCTION);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Test of Abs Function calculate()")
    public void absTest() throws FormulaException, IOException {
        double arg = -12;
        String line = "test(" + arg + ")";

        Formula formula = Parser.parse(line);
        assertEquals(formula.getFormulaType(), FormulaType.FUNCTION);
        ((FunctionFormula) formula).setImplementation(new Abs());
        formula = formula.calculate();
        assertEquals(formula.getFormulaType(), FormulaType.NUMBER_DOUBLE);
        assertEquals(((NumberFormula) formula).getValue(), Math.abs(arg));
    }

    @Test
    @DisplayName("Test of normal Function with variable")
    public void normalTest() throws FormulaException, IOException {
        String line = "test(1, 2, x, y)";
        Formula formula = Parser.parse(line);
        assertEquals(formula.getFormulaType(), FormulaType.FUNCTION);
        assertEquals(((FunctionFormula) formula).getFunctionName(), "test");
        assertEquals(((FunctionFormula) formula).getArgs().length, 4);
        Formula[] args = ((FunctionFormula) formula).getArgs();
        assertEquals(args[0].getFormulaType(), FormulaType.NUMBER_INTEGER);
        assertEquals(args[1].getFormulaType(), FormulaType.NUMBER_INTEGER);
        assertEquals(args[2].getFormulaType(), FormulaType.VARIABLE);
        assertEquals(((VariableFormula) args[2]).getVariableName(), "x");
        assertEquals(args[3].getFormulaType(), FormulaType.VARIABLE);
        assertEquals(((VariableFormula) args[3]).getVariableName(), "y");

        Formula arg2 = new Addition(new IntegerFormula(4), new IntegerFormula(5));
        ((VariableFormula) args[2]).setActualValue(arg2);
        args[2] = args[2].calculate();
        assertEquals(args[2].getFormulaType(), FormulaType.NUMBER_DOUBLE);
        assertEquals(((DoubleFormula) args[2]).getValue(), 9);
    }
}
