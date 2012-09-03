/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.cdi;

import javax.inject.Inject;

import org.apache.camel.Endpoint;
import org.apache.camel.cdi.support.EndpointUriPropertyInjectedBean;
import org.apache.camel.component.mock.MockEndpoint;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Test endpoint injection using a dynamic property expression
 */
public class EndpointPropertyInjectTest extends CdiTestSupport {

    @Inject
    private EndpointUriPropertyInjectedBean bean;

    // TODO not supported yet!
    @Ignore
    public void shouldInjectEndpointByProperty() {
        assertNotNull(bean);
        Endpoint endpoint = bean.getEndpoint();
        assertNotNull("Could not find injected endpoint!", endpoint);
        assertTrue("Endpoint should be a MockEndpoint but was " + endpoint, endpoint instanceof MockEndpoint);
        assertEquals("Endpoint URI", "mock://injectedByProperty", endpoint.getEndpointUri());
    }

}
