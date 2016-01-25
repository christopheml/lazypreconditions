/*
 * Copyright 2016 Christophe Michel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package fr.christopheml.preconditions;

import java.util.function.Supplier;

/**
 * Provides methods that enforce preconditions in your code, with lazy evaluation of error messages.
  */
public final class LazyPreconditions {

    private LazyPreconditions() {
    }

    /**
     * Enforces the truthness of an expression that is a method argument.
     * @param expression a boolean expression
     * @throws IllegalArgumentException if {@code expression} is false
     */
    public static void checkArgument(boolean expression) {
        if (!expression) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Enforces the truthness of an expression that is a method argument.
     * @param expression a boolean expression
     * @param messageSupplier Supplier that provides the exception message if needed
     * @throws IllegalArgumentException if {@code expression} is false
     */
    public static void checkArgument(boolean expression, Supplier<Object> messageSupplier) {
        if (!expression) {
            throw new IllegalArgumentException(String.valueOf(messageSupplier.get()));
        }
    }

    /**
     * Enforces the truthness of an expression that represents the current state of an object.
     * @param expression a boolean expression
     * @throws IllegalStateException if {@code expression} is false
     */
    public static void checkState(boolean expression) {
        if (!expression) {
            throw new IllegalStateException();
        }
    }

    /**
     * Enforces the truthness of an expression that represents the current state of an object.
     * @param expression a boolean expression
     * @param messageSupplier Supplier that provides the exception message if needed
     * @throws IllegalStateException if {@code expression} is false
     */
    public static void checkState(boolean expression, Supplier<Object> messageSupplier) {
        if (!expression) {
            throw new IllegalStateException(String.valueOf(messageSupplier.get()));
        }
    }

    /**
     * Enforces the non-nullness of a reference.
     * @param reference a reference that may be {@code null}
     * @throws NullPointerException if {@code reference} is false
     */
    public static <T> T checkNotNull(T reference) {
        if (reference == null) {
            throw new NullPointerException();
        }
        return reference;
    }

    /**
     * Enforces the non-nullness of a reference.
     * @param reference a reference that may be {@code null}
     * @param messageSupplier Supplier that provides the exception message if needed
     * @throws NullPointerException if {@code reference} is false
     */
    public static <T> T checkNotNull(T reference, Supplier<Object> messageSupplier) {
        if (reference == null) {
            throw new NullPointerException(String.valueOf(messageSupplier.get()));
        }
        return reference;
    }

}
