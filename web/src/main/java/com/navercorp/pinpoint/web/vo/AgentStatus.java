/*
 * Copyright 2014 NAVER Corp.
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

package com.navercorp.pinpoint.web.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.navercorp.pinpoint.common.bo.AgentLifeCycleBo;
import com.navercorp.pinpoint.common.util.AgentLifeCycleState;
import com.navercorp.pinpoint.web.view.AgentLifeCycleStateSerializer;

/**
 * 
 * @author netspider
 * @author HyunGil Jeong
 */
public class AgentStatus {

    private String agentId;

    @JsonInclude(Include.NON_DEFAULT)
    private long startTimestamp;

    @JsonInclude(Include.NON_DEFAULT)
    private long eventTimestamp;

    @JsonSerialize(using = AgentLifeCycleStateSerializer.class)
    private AgentLifeCycleState state;

    public AgentStatus() {
    }

    public AgentStatus(AgentLifeCycleBo agentLifeCycleBo) {
        this.agentId = agentLifeCycleBo.getAgentId();
        this.startTimestamp = agentLifeCycleBo.getStartTimestamp();
        this.eventTimestamp = agentLifeCycleBo.getEventTimestamp();
        this.state = agentLifeCycleBo.getAgentLifeCycleState();
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public long getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(long startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public long getEventTimestamp() {
        return eventTimestamp;
    }

    public void setEventTimestamp(long eventTimestamp) {
        this.eventTimestamp = eventTimestamp;
    }

    public AgentLifeCycleState getState() {
        return state;
    }

    public void setState(AgentLifeCycleState state) {
        this.state = state;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((agentId == null) ? 0 : agentId.hashCode());
        result = prime * result + (int)(eventTimestamp ^ (eventTimestamp >>> 32));
        result = prime * result + (int)(startTimestamp ^ (startTimestamp >>> 32));
        result = prime * result + ((state == null) ? 0 : state.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AgentStatus other = (AgentStatus)obj;
        if (agentId == null) {
            if (other.agentId != null)
                return false;
        } else if (!agentId.equals(other.agentId))
            return false;
        if (eventTimestamp != other.eventTimestamp)
            return false;
        if (startTimestamp != other.startTimestamp)
            return false;
        if (state != other.state)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "AgentStatus [agentId=" + agentId + ", startTimestamp=" + startTimestamp + ", eventTimestamp=" + eventTimestamp + ", state=" + state + "]";
    }
}
