package io.skalogs.skaetl.generator.secuRules;

/*-
 * #%L
 * generator
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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestGen {
    public String cookieSession;
    public String remoteIp;
    public String urlHost;
    public int urlPort;
    public int urlStatus;
    public String urlMethod;
    public String userAgent;
    public int sizeResponse;
    public int sizeRequest;
    public String typeHTTP;
    public String uri;

}
