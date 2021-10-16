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
package it.apuliatechs.euris.service.calculator.currency.normalizer;

import it.apuliatechs.euris.service.calculator.currency.entity.OldFashionPound;

/**
 * The BritishCurrencyNormalizer class.
 *
 * @author Apuliatechs
 * @version 1.0.0
 * @since 1.0.0
 */
public class BritishCurrencyNormalizer implements INormalizer<OldFashionPound, Long> {

    @Override
    public Long normalize(OldFashionPound amount) {
        long totalShillings = 0L;
        long totalPennies = 0L;
        if(amount.getPounds() != null) {
            totalShillings = fromPoundsToShillings(amount.getPounds());
        }
        if(amount.getShillings() != null) {
            totalShillings += amount.getShillings();
        }
        if(amount.getPennies() != null) {
            totalPennies = amount.getPennies();
        }
        totalPennies += fromShillingsToPennies(totalShillings);
        return totalPennies;
    }

    @Override
    public OldFashionPound deNormalize(Long amount) {
        long pennies = modPenniesToShillings(amount);
        long tempShillings = fromPenniesToShillings(amount);
        long shillings = modShillingsToPounds(tempShillings);
        long Pounds = fromShillingsToPounds(tempShillings);
        return new OldFashionPound(Pounds, shillings, pennies);
    }

    private Long fromPoundsToShillings(Long Pounds) {
        return Math.multiplyExact(Pounds, 20L);
    }

    private Long fromShillingsToPennies(Long shillings) {
        return Math.multiplyExact(shillings, 12L);
    }

    private Long fromPenniesToShillings(Long pennies) {
        return Math.floorDiv(pennies, 12L);
    }

    private Long modPenniesToShillings(Long pennies) {
        return Math.floorMod(pennies, 12L);
    }

    private Long fromShillingsToPounds(Long Pounds) {
        return Math.floorDiv(Pounds, 20L);
    }

    private Long modShillingsToPounds(Long Pounds) {
        return Math.floorMod(Pounds, 20L);
    }

}
