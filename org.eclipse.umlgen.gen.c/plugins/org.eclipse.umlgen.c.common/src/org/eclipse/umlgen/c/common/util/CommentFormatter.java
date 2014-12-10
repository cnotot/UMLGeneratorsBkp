/*******************************************************************************
 * Copyright (c) 2010, 2014 CS Systèmes d'Information (CS-SI).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sebastien Gabel (CS-SI) - initial API and implementation
 *******************************************************************************/
package org.eclipse.umlgen.c.common.util;

/**
 * Utility class allowing to wrap/unwrap C comments.<br>
 * Creation : 26 november 2010<br>
 *
 * @author <a href="mailto:sebastien.gabel@c-s.fr">Sebastien GABEL</a>
 */
public final class CommentFormatter {

    /** Constant for space. */
    private static final String SPACE = " ";

    /** Regular expression for removing comments marks when UNWARP. */
    private static final String REGEXP_STRIP_COMMENT_MARKS = "^/\\*+\\n|/? ?\\*+ ?/?"; //$NON-NLS-1$

    /** Content replacement for comment UNWARP process. */
    private static final String REPLACEMENT_STRING = ""; //$NON-NLS-1$

    /** Constant for WRAPING comments. */
    private static final int MAX_CHAR_PER_LINE = 78; // assuming a formatting on 80 chars

    /** First line for a Javadoc comment. */
    private static final String BEGIN_COMMENT_LINE = "/**\n"; //$NON-NLS-1$

    /** Last line for a Javadoc comment. */
    private static final String END_COMMENT_LINE = " */\n"; //$NON-NLS-1$

    /** Intermediate line for Javadoc comment. */
    private static final String INTERMEDIATE_COMMENT_LINE = " * "; //$NON-NLS-1$

    /** Default constructor. */
    private CommentFormatter() {
    }

    /**
     * This method should be called ONLY by the generator for inline comments.
     *
     * @param string
     *            The string to format
     * @return the formatted comment.
     */
    public static String wrapInLine(final String string) {
        return String.format("/** %s */", string.trim()); //$NON-NLS-1$
    }

    /**
     * Wrap a text to transform it into valid comment. This method is intended to be called from the UML2C
     * generator templates.
     *
     * @param string
     *            The string to format
     * @return the formatted comment.
     */
    public static String wrap(final String string) {
        StringBuilder result = new StringBuilder(BEGIN_COMMENT_LINE);

        if (string.length() <= MAX_CHAR_PER_LINE) {
            addLine(result, string.replaceAll("[\\n\\r]", SPACE).trim()); //$NON-NLS-1$
        } else {
            String[] commentArray = string.split("\\r?\\n"); //$NON-NLS-1$
            for (String line : commentArray) {
                if (line.length() > MAX_CHAR_PER_LINE) {
                    String[] tokensArray = line.split(SPACE);
                    StringBuilder tmpLine = new StringBuilder();
                    for (String token : tokensArray) {
                        if (tmpLine.length() + token.length() > MAX_CHAR_PER_LINE) {
                            addLine(result, tmpLine.toString());
                            tmpLine = new StringBuilder();
                        }
                        tmpLine.append(token);
                        tmpLine.append(SPACE);
                    }

                    // add the last part of this line to the result
                    addLine(result, tmpLine.toString());
                } else {
                    addLine(result, line);
                }
            }
        }
        result.append(END_COMMENT_LINE);

        return result.toString().trim();
    }

    /**
     * Add a new line to the formatted result.
     *
     * @param builder
     *            The string builder
     * @param content
     *            The line content on <b>MAX_CHAR_PER_LINE</b> characters
     */
    private static void addLine(StringBuilder builder, String content) {
        builder.append(INTERMEDIATE_COMMENT_LINE);
        builder.append(content);
        builder.append("\n"); //$NON-NLS-1$
    }

    /**
     * Unwraps comments contained into source code. All characters related to comments are removed from the
     * string.
     *
     * @param comment
     *            The comment presented into a string.
     * @return The same string without any slash or star characters.
     */
    public static String unwrap(String comment) {
        return comment.replaceAll(REGEXP_STRIP_COMMENT_MARKS, REPLACEMENT_STRING);
    }
}
