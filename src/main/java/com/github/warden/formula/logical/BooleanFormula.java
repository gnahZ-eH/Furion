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

package com.github.warden.formula.logical;

import com.github.warden.enums.FormulaType;
import com.github.warden.exception.FormulaException;
import com.github.warden.formula.Formula;
import com.github.warden.formula.number.NumberFormula;

public class BooleanFormula extends NumberFormula {

    public static final BooleanFormula TRUE = new BooleanFormula(true);
    public static final BooleanFormula FALSE = new BooleanFormula(false);


    private final boolean boolValue;

    public BooleanFormula(boolean boolValue) {
        super(FormulaType.BOOLEAN);
        this.boolValue = boolValue;
    }

    @Override
    public double getValue() {
        return boolValue ? 1 : 0;
    }

    @Override
    public Formula calculate() throws FormulaException {
        return this;
    }

    @Override
    public void verify() throws FormulaException {

    }

    public boolean boolValue() {
        return boolValue;
    }

    public static BooleanFormula getInstance(boolean boolValue) {
        return boolValue ? TRUE : FALSE;
    }
}
