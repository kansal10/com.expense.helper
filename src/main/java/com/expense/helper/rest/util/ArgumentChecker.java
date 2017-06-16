package com.expense.helper.rest.util;

import java.util.Collection;

public class ArgumentChecker
{
    /**
     * Rejects a string if it is {@code null} or empty by throwing an {@link IllegalArgumentException}, otherwise
     * returns the argument.
     * 
     * @param argument
     *            the string on which to perform a {@code null} and empty check
     * @param name
     *            the name of the string to be checked, used for traceability in the error message
     * 
     * @return {@code argument} if it is not {@code null} or empty
     * 
     * @throws IllegalArgumentException
     *             if the specified {@code argument} is {@code null} or empty
     */
    public static String rejectIfNullOrEmpty(String argument, String name)
    {
        rejectIfNull(argument, name);

        if (argument.length() == 0)
        {
            throw new IllegalArgumentException(name);
        }

        return argument;
    }

    /**
     * Rejects a collection if it is {@code null} or empty by throwing an {@link IllegalArgumentException}, otherwise
     * returns that object.
     * 
     * @param collection
     *            the collection on which to perform a {@code null} and empty check
     * @param name
     *            the name of the argument to be checked, used for traceability in the error message
     * 
     * @return {@code argument} if it is not {@code null} or empty
     * 
     * @throws IllegalArgumentException
     *             if the specified {@code argument} is {@code null} or empty
     */
    public static <T> Collection<T> rejectIfNullOrEmpty(Collection<T> collection, String name)
    {
        rejectIfNull(collection, name);

        if (collection.isEmpty())
        {
            throw new IllegalArgumentException(name);
        }

        return collection;
    }

    /**
     * Returns an empty string if the provided string is {@code null}. If the original string is not {@code null}, then
     * the string is returned.
     * 
     * @param argument
     *            the argument on which to perform a {@code null} check
     * 
     * @return {@code argument} if it is not {@code null}, otherwise an empty string
     */
    public static String emptyIfNull(String argument)
    {
        if (argument == null)
        {
            return "";
        }
        return argument;
    }

    /**
     * Rejects an argument if it is {@code null} by throwing an {@link IllegalArgumentException}, otherwise returns that
     * object.
     * 
     * @param argument
     *            the object on which to perform a {@code null}
     * @param name
     *            the name of the argument to be checked, used for traceability in the error message
     * 
     * @return {@code argument} if it is not {@code null}
     * 
     * @throws IllegalArgumentException
     *             if the specified {@code argument} is {@code null}
     */
    public static <T> T rejectIfNull(T argument, String name)
    {
        if (argument == null)
        {
            throw new IllegalArgumentException(name + " cannot be null");
        }

        return argument;
    }

    public static double rejectIfLessThanOrEqualToZero(float argument, String name)
    {
        if (argument <= 0L)
        {
            throw new IllegalArgumentException(name + " must be greater than 0");
        }

        return argument;
    }
}
