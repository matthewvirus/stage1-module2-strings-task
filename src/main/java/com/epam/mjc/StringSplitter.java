package com.epam.mjc;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class StringSplitter {

    /**
     * Splits given string applying all delimiters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        for (String delimiter: delimiters) {
            source = source.replace(delimiter, " ").trim();
        }
        String[] trimmedSource = source.split(" +");
        return Arrays.asList(trimmedSource);
    }
}