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

import org.junit.Test;

import static fr.christopheml.preconditions.LazyPreconditions.*;
import static org.junit.Assert.*;

public class LazyPreconditionsTest {

    @Test
    public void checkArgument_should_do_nothing_when_expression_is_true() {
        checkArgument(true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkArgument_should_raise_exception_when_expression_is_false() {
        checkArgument(false);
    }

    @Test
    public void checkArgument_should_not_call_message_supplier_when_expression_is_true() {
        checkArgument(true, () -> {
            fail("Message supplier called.");
            return "";
        });
    }

    @Test
    public void checkArgument_should_use_message_from_message_supplier_when_expression_is_false() {
        try {
            checkArgument(false, () -> "supplied message");
        } catch (IllegalArgumentException e) {
            assertEquals("supplied message", e.getMessage());
        }
    }

    @Test
    public void checkState_should_do_nothing_when_expression_is_true() {
        checkState(true);
    }

    @Test(expected = IllegalStateException.class)
    public void checkState_should_raise_exception_when_expression_is_false() {
        checkState(false);
    }

    @Test
    public void checkState_should_not_call_message_supplier_when_expression_is_true() {
        checkState(true, () -> {
            fail("Message supplier called.");
            return "";
        });
    }

    @Test
    public void checkState_should_use_message_from_message_supplier_when_expression_is_false() {
        try {
            checkState(false, () -> "supplied message");
        } catch (IllegalStateException e) {
            assertEquals("supplied message", e.getMessage());
        }
    }

    @Test
    public void checkNotNull_should_do_nothing_when_reference_is_not_null() {
        checkNotNull("I'm obviously not null");
    }

    @Test(expected = NullPointerException.class)
    public void checkNotNull_should_raise_exception_when_reference_is_null() {
        checkNotNull(null);
    }

    @Test
    public void checkNotNull_should_not_call_message_supplier_when_reference_is_not_null() {
        checkNotNull("Still not null", () -> {
            fail("Message supplier called.");
            return "";
        });
    }

    @Test
    public void checkNotNull_should_use_message_from_message_supplier_when_reference_is_null() {
        try {
            checkNotNull(null, () -> "supplied message");
        } catch (NullPointerException e) {
            assertEquals("supplied message", e.getMessage());
        }
    }

}
