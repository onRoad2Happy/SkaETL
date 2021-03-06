package io.skalogs.skaetl.rules;

/*-
 * #%L
 * rule-executor
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

import com.fasterxml.jackson.databind.JsonNode;
import io.skalogs.skaetl.utils.JSONUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Slf4j
public final class UtilsValidator {


    public static <T> T get(JsonNode jsonValue, String key) {
        if (!jsonValue.hasNonNull(key)) {
            return null;
        }
        JsonNode jsonNode = JSONUtils.getInstance().at(jsonValue, key);
        switch (jsonNode.getNodeType()) {
            case BOOLEAN:
                return (T) Boolean.valueOf(jsonNode.asBoolean());
            case NUMBER:
                if (jsonNode.isInt()) {
                    return (T) Integer.valueOf(jsonNode.asInt());
                }
                if (jsonNode.isDouble()) {
                    return (T) Double.valueOf(jsonNode.asDouble());
                }

            case STRING:
                return (T) jsonNode.asText();
            default:
                throw new IllegalArgumentException(jsonNode.getNodeType() + " type is not yet supported");

        }


    }

    // string

    public static boolean isEqualTo(String a, String b) {
        return StringUtils.equals(a, b);
    }

    public static boolean isDifferentFrom(String a, String b) {
        return !isEqualTo(a, b);
    }

    // numeric
    public static boolean isEqualTo(Number a, Number b) {
        return a == null ? false : a.equals(b);
    }

    public static boolean isDifferentFrom(Number a, Number b) {
        return !isEqualTo(a, b);
    }

    public static boolean isGreaterThan(Number a, Number b) {
        return a == null ? false : a.doubleValue() > b.doubleValue();
    }

    public static boolean isLowerThan(Number a, Number b) {
        return a == null ? false : a.doubleValue() < b.doubleValue();
    }

    public static boolean isGreaterThanOrEqual(Number a, Number b) {
        return a == null ? false : a.doubleValue() >= b.doubleValue();
    }

    public static boolean isLowerThanOrEqual(Number a, Number b) {
        return a == null ? false : a.doubleValue() <= b.doubleValue();
    }

    // dates

    public static boolean isGreaterThan(Date date, int count, TimeUnit unit) {
        return false;
    }

    public static boolean isLowerThan(Date date, int count, TimeUnit unit) {
        return false;
    }

    public static boolean isGreaterThanOrEqual(Date date, int count, TimeUnit unit) {
        return false;
    }

    public static boolean isLowerThanOrEqual(Date date, int count, TimeUnit unit) {
        return false;
    }

    public static Boolean checkPresent(JsonNode jsonValue, String... keys) {
        for (String key : keys) {
            if (!jsonValue.has(key)) {
                return false;
            }
        }
        return true;
    }

}
