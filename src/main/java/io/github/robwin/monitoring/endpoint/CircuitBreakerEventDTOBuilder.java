/*
 * Copyright 2017 Robert Winkler
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.robwin.monitoring.endpoint;

import io.github.robwin.circuitbreaker.CircuitBreaker;
import io.github.robwin.circuitbreaker.event.CircuitBreakerEvent;

import java.time.Duration;

class CircuitBreakerEventDTOBuilder {
    private String circuitBreakerName;
    private CircuitBreakerEvent.Type type;
    private String creationTime;
    private String throwable = null;
    private Long duration = null;
    private CircuitBreaker.StateTransition stateTransition = null;

    CircuitBreakerEventDTOBuilder(String circuitBreakerName, CircuitBreakerEvent.Type type, String creationTime){
        this.circuitBreakerName = circuitBreakerName;
        this.type = type;
        this.creationTime = creationTime;
    }

    CircuitBreakerEventDTOBuilder setThrowable(Throwable throwable) {
        this.throwable = throwable.toString();
        return this;
    }

    CircuitBreakerEventDTOBuilder setDuration(Duration duration) {
        this.duration = duration.toMillis();
        return this;
    }

    CircuitBreakerEventDTOBuilder setStateTransition(CircuitBreaker.StateTransition stateTransition) {
        this.stateTransition = stateTransition;
        return this;
    }

    CircuitBreakerEventDTO build() {
        return new CircuitBreakerEventDTO(circuitBreakerName, type, creationTime, throwable, duration, stateTransition);
    }
}