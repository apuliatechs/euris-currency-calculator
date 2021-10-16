/*
 * Copyright (C) 2021, Apuliatechs. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are not permitted without explicit signed consent.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package it.apuliatechs.euris.service.calculator.currency.test.unit;

import it.apuliatechs.euris.service.calculator.currency.engine.BritishCalculatorEngine;
import it.apuliatechs.euris.service.calculator.currency.entity.OldFashionPound;
import it.apuliatechs.euris.service.calculator.currency.normalizer.BritishCurrencyNormalizer;
import it.apuliatechs.euris.service.calculator.exception.CalculationException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The SimpleCalculatorTest class.
 *
 * @author Apuliatechs
 * @version 1.0.0
 * @since 1.0.0
 */
public class BritishCalculatorEngineTest {

    private static BritishCalculatorEngine engine;

    @BeforeAll
    public static void setUp() {
        engine = new BritishCalculatorEngine(new BritishCurrencyNormalizer());
    }

    @Test
    void sum() {
        OldFashionPound first = new OldFashionPound(5L, 17L, 8L);
        OldFashionPound second = new OldFashionPound(3L, 4L, 10L);
        OldFashionPound result = new OldFashionPound(0L, 0L, 0L);
        try {
            result = engine.sum(first, second);
        } catch (CalculationException e) {
            fail("Sum execution failed", e);
        }
        assertEquals(9L, result.getPounds());
        assertEquals(2L, result.getShillings());
        assertEquals(6L, result.getPennies());
    }

    @Test
    void subtract() {
        OldFashionPound first = new OldFashionPound(5L, 17L, 8L);
        OldFashionPound second = new OldFashionPound(3L, 4L, 10L);
        OldFashionPound result = new OldFashionPound(0L, 0L, 0L);
        try {
            result = engine.subtract(first, second);
        } catch (CalculationException e) {
            fail("Sum execution failed", e);
        }
        assertEquals(2L, result.getPounds());
        assertEquals(12L, result.getShillings());
        assertEquals(10L, result.getPennies());
    }

    @Test
    void divide() {
        OldFashionPound first = new OldFashionPound(5L, 17L, 8L);
        OldFashionPound result = new OldFashionPound(0L, 0L, 0L);
        try {
            result = engine.divide(first, 3L);
        } catch (CalculationException e) {
            fail("Sum execution failed", e);
        }
        assertEquals(1L, result.getPounds());
        assertEquals(19L, result.getShillings());
        assertEquals(2L, result.getPennies());
    }

    @Test
    void mod() {
        OldFashionPound first = new OldFashionPound(5L, 17L, 8L);
        OldFashionPound result = new OldFashionPound(0L, 0L, 0L);
        try {
            result = engine.mod(first, 3L);
        } catch (CalculationException e) {
            fail("Sum execution failed", e);
        }
        assertEquals(0L, result.getPounds());
        assertEquals(0L, result.getShillings());
        assertEquals(2L, result.getPennies());
    }

    @Test
    void mod2() {
        OldFashionPound first = new OldFashionPound(18L, 16L, 1L);
        OldFashionPound result = new OldFashionPound(0L, 0L, 0L);
        try {
            result = engine.mod(first, 15L);
        } catch (CalculationException e) {
            fail("Sum execution failed", e);
        }
        assertEquals(0L, result.getPounds());
        assertEquals(1L, result.getShillings());
        assertEquals(1L, result.getPennies());
    }

    @Test
    void multiply() {
        OldFashionPound first = new OldFashionPound(5L, 17L, 8L);
        OldFashionPound result = new OldFashionPound(0L, 0L, 0L);
        try {
            result = engine.multiply(first, 2L);
        } catch (CalculationException e) {
            fail("Sum execution failed", e);
        }
        assertEquals(11L, result.getPounds());
        assertEquals(15L, result.getShillings());
        assertEquals(4L, result.getPennies());
    }


}
