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
package it.apuliatechs.euris.service.calculator.currency.engine;

import it.apuliatechs.euris.service.calculator.currency.entity.OldFashionPound;
import it.apuliatechs.euris.service.calculator.currency.normalizer.BritishCurrencyNormalizer;
import it.apuliatechs.euris.service.calculator.engine.AbstractCalculatorEngine;
import it.apuliatechs.euris.service.calculator.exception.CalculationException;

/**
 * The BritishCalculatorEngine class.
 *
 * @author Apuliatechs
 * @version 1.0.0
 * @since 1.0.0
 */
public class BritishCalculatorEngine extends AbstractCalculatorEngine<OldFashionPound, Long> {

    BritishCurrencyNormalizer normalizer;

    public BritishCalculatorEngine(BritishCurrencyNormalizer normalizer) {
        this.normalizer = normalizer;
    }

    @Override
    public OldFashionPound sum(OldFashionPound first, OldFashionPound second) throws CalculationException {
        Long normFirst = normalizer.normalize(first);
        Long normSecond = normalizer.normalize(second);
        Long normSum = Math.addExact(normFirst, normSecond);
        return normalizer.deNormalize(normSum);
    }

    @Override
    public OldFashionPound subtract(OldFashionPound first, OldFashionPound second) throws CalculationException {
        Long normFirst = normalizer.normalize(first);
        Long normSecond = normalizer.normalize(second);
        Long normSubtract = Math.subtractExact(normFirst, normSecond);
        return normalizer.deNormalize(normSubtract);
    }

    @Override
    public OldFashionPound divide(OldFashionPound first, Long second) throws CalculationException {
        Long normFirst = normalizer.normalize(first);
        Long normSum = Math.floorDiv(normFirst, second);
        System.out.println(normSum);
        return normalizer.deNormalize(normSum);
    }

    public OldFashionPound mod(OldFashionPound first, Long second) throws CalculationException {
        Long normFirst = normalizer.normalize(first);
        Long normSum = Math.floorMod(normFirst, second);
        System.out.println(normSum);
        return normalizer.deNormalize(normSum);
    }

    @Override
    public OldFashionPound multiply(OldFashionPound first, Long second) throws CalculationException {
        Long normFirst = normalizer.normalize(first);
        Long normMultiply = Math.multiplyExact(normFirst, second);
        return normalizer.deNormalize(normMultiply);
    }

}
