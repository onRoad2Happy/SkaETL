package io.skalogs.skaetl.rules.metrics.udaf;

/*-
 * #%L
 * metric-api
 * %%
 * Copyright (C) 2017 - 2018 SkaLogs
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import static com.google.common.base.Preconditions.checkState;
import static java.lang.Double.NaN;
import static java.lang.Double.isNaN;

public class StdDevPopulationFunction extends StdDevFunction {
    private Double populationVariance() {
        checkState(getCount() != 0);
        if (isNaN(getSumOfSquaresOfDeltas())) {
            return NaN;
        }
        if (getCount() == 1) {
            return 0.0;
        }
        return ensureNonNegative(getSumOfSquaresOfDeltas()) / getCount();
    }

    @Override
    public Double compute() {
        if (getCount() == 0) {
            return Double.NaN;
        }
        return Math.sqrt(populationVariance());
    }
}
