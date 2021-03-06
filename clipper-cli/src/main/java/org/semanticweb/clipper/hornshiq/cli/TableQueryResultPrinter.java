package org.semanticweb.clipper.hornshiq.cli;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.semanticweb.clipper.hornshiq.rule.Atom;
import org.semanticweb.clipper.hornshiq.rule.Term;
import org.semanticweb.clipper.hornshiq.rule.Variable;

import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;

public class TableQueryResultPrinter extends QueryResultPrinter {

	private ArrayList<Integer> widths;
	private int linewidth;
	private String format;

	@Override
	void init(List<Term> answerVars, List<List<String>> answers) {

		int size = answerVars.size();

		widths = Lists.newArrayListWithCapacity(size);
		for (int i = 0; i < size; i++) {
			widths.add(answerVars.get(i).toString().length());
		}

		for (List<String> answer : answers) {
			for (int i = 0; i < size; i++) {
				widths.set(i, Math.max(widths.get(i), answer.get(i).length()));
			}
		}

		linewidth = 1;
		StringBuilder formatBuilder = new StringBuilder();
		formatBuilder.append("|");
		for (Integer width : widths) {
			// "-" : left alignment
			formatBuilder.append(" %-").append(width).append("s |");
			linewidth += width + 3;
		}

		formatBuilder.append("\n");
		format = formatBuilder.toString();
	}

	@Override
	void printHead(List<Term> answerVars) {
		System.out.println(Strings.repeat("-", linewidth));

		// FIXME: output variable name
		System.out.format(format, answerVars.toArray());

		System.out.println(Strings.repeat("=", linewidth));

	}

	@Override
	void printFoot() {
		System.out.println(Strings.repeat("-", linewidth));
	}

	@Override
	void printAnswer(List<String> answer) {
		System.out.format(format, answer.toArray());

	}

}