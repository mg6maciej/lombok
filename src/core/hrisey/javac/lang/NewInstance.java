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

import static hrisey.javac.lang.EmptyList.*;

import java.util.List;

import lombok.javac.JavacNode;
import lombok.javac.JavacTreeMaker;

import com.sun.tools.javac.tree.JCTree.JCClassDecl;
import com.sun.tools.javac.tree.JCTree.JCExpression;
import com.sun.tools.javac.util.ListBuffer;

public class NewInstance extends Expression {
	
	private TypeExpression type;
	private List<Expression> arguments;
	private boolean anonymous;

	public NewInstance(TypeExpression type, List<Expression> arguments, boolean anonymous) {
		this.type = type;
		this.arguments = arguments;
		this.anonymous = anonymous;
	}

	@Override
	public JCExpression create(JavacNode node) {
		JavacTreeMaker maker = node.getTreeMaker();
		ListBuffer<JCExpression> list = new ListBuffer<JCExpression>();
		for (Expression argument : arguments) {
			list.add(argument.create(node));
		}
		JCClassDecl classDecl = null;
		if (anonymous) {
			classDecl = maker.AnonymousClassDef(maker.Modifiers(0), emptyTrees());
		}
		return maker.NewClass(null, emptyExpressions(), type.create(node), list.toList(), classDecl);
	}
}