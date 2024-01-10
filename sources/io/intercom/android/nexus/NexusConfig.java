package io.intercom.android.nexus;

import java.util.ArrayList;
import java.util.List;

public class NexusConfig {
    private final int connectionTimeout;
    private final List<String> endpoints;
    private final int presenceHeartbeatInterval;

    public NexusConfig() {
        this(new Builder());
    }

    public NexusConfig(Builder builder) {
        this.endpoints = builder.endpoints == null ? new ArrayList<>() : builder.endpoints;
        this.presenceHeartbeatInterval = builder.presence_heartbeat_interval;
        this.connectionTimeout = builder.connection_timeout;
    }

    public List<String> getEndpoints() {
        return this.endpoints;
    }

    public int getPresenceHeartbeatInterval() {
        return this.presenceHeartbeatInterval;
    }

    public int getConnectionTimeout() {
        return this.connectionTimeout;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NexusConfig nexusConfig = (NexusConfig) obj;
        if (this.connectionTimeout == nexusConfig.connectionTimeout && this.presenceHeartbeatInterval == nexusConfig.presenceHeartbeatInterval && this.endpoints.equals(nexusConfig.endpoints)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((this.endpoints.hashCode() * 31) + this.presenceHeartbeatInterval) * 31) + this.connectionTimeout;
    }

    public static class Builder {
        int connection_timeout;
        List<String> endpoints;
        int presence_heartbeat_interval;

        public NexusConfig build() {
            return new NexusConfig(this);
        }

        public Builder withEndpoints(List<String> list) {
            this.endpoints = list;
            return this;
        }

        public Builder withPresenceHeartbeatInterval(int i) {
            this.presence_heartbeat_interval = i;
            return this;
        }

        public Builder withConnectionTimeout(int i) {
            this.connection_timeout = i;
            return this;
        }
    }
}
