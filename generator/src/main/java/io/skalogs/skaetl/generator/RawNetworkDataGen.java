package io.skalogs.skaetl.generator;

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

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class RawNetworkDataGen {
    public String type;
    @JsonProperty("timestamp")
    public String timestamp;
    public String messageSend;
    public String project;
    @JsonProperty("src_ip")
    public String srcIp;
    @JsonProperty("dest_ip")
    public String destIp;
    @JsonProperty("database_ip")
    public String databaseIp;
    //metadata
    @JsonProperty("os_server")
    public String osServer;
    @JsonProperty("database_type")
    public String typeDatabase;


}
