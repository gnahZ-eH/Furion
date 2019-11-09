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

package com.github.furion.exception;

import com.github.furion.utils.ExceptionUtils;

public class FormulaException extends Exception {
    public FormulaException() { super(); }
    public FormulaException(String exceptionMessage, Throwable cause) {
        super(exceptionMessage, cause);
    }
    public FormulaException(String exceptionMessage) { super(exceptionMessage); }
    public FormulaException(Throwable cause) { super(cause); }

    public FormulaException(int exceptionCode) {
        super(ExceptionUtils.exceptionMap.get(exceptionCode));
    }

    public FormulaException(int exceptionCode, String supplement) {
        super(ExceptionUtils.exceptionMap.get(exceptionCode) + ": " + supplement);
    }
}
