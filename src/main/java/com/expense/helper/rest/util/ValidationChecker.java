package com.expense.helper.rest.util;

public class ValidationChecker
{
    /**
     * Private constructor to prevent class instantiation.
     */
    private ValidationChecker()
    {
    }

    /**
     * Validates that the given argument is not {@code null}. If it is {@code null}, an {@link IllegalStateException} is
     * thrown.
     * 
     * @param argument
     *            the object on which to perform the {@code null} check
     * @param argumentName
     *            the name of the argument. This is for traceability in the error message.
     * @throws IllegalStateException
     *             <ul>
     *             <li>if {@code argument} is {@code null}</li>
     *             </ul>
     */
    public static <T> void validateNotNull(T argument, String argumentName)
    {
        if (argument == null)
        {
            throw new IllegalStateException(argumentName + "cannot be null");
        }
    }
}
