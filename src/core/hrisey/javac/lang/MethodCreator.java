/*
 * Copyright (C) 2014 Maciej Gorski
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package hrisey.javac.lang;

import java.util.Arrays;
import java.util.Collections;

public class MethodCreator {

	public static Method createMethod(Modifier modifier, TypeExpression returnType, String name, Block body) {
		return new Method(Collections.singletonList(modifier), returnType, name, Collections.<Parameter>emptyList(), body);
	}

	public static Method createMethod(Modifier modifier, TypeExpression returnType, String name, Parameter parameter, Block body) {
		return new Method(Collections.singletonList(modifier), returnType, name, Collections.singletonList(parameter), body);
	}

	public static Method createMethod(Modifier modifier1, Modifier modifier2, String returnType, String name, Block body) {
		return new Method(Arrays.asList(modifier1, modifier2), new DottedExpression(returnType), name, Collections.<Parameter>emptyList(), body);
	}

	public static Method createMethod(Modifier modifier, String returnType, String name, Parameter parameter, Block body) {
		return new Method(Collections.singletonList(modifier), new DottedExpression(returnType), name, Collections.singletonList(parameter), body);
	}

	public static Method createMethod(Modifier modifier, String returnType, String name, Block body) {
		return new Method(Collections.singletonList(modifier), new DottedExpression(returnType), name, Collections.<Parameter>emptyList(), body);
	}
}