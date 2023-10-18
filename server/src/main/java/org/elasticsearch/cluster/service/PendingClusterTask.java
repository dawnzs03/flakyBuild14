/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.cluster.service;

import java.io.IOException;

import org.elasticsearch.common.Priority;
import org.elasticsearch.common.io.stream.StreamInput;
import org.elasticsearch.common.io.stream.StreamOutput;
import org.elasticsearch.common.io.stream.Writeable;

import io.crate.common.unit.TimeValue;

public class PendingClusterTask implements Writeable {

    private final long insertOrder;
    private final Priority priority;
    private final String source;
    private final long timeInQueue;
    private final boolean executing;

    public PendingClusterTask(long insertOrder, Priority priority, String source, long timeInQueue, boolean executing) {
        assert timeInQueue >= 0 : "got a negative timeInQueue [" + timeInQueue + "]";
        assert insertOrder >= 0 : "got a negative insertOrder [" + insertOrder + "]";
        this.insertOrder = insertOrder;
        this.priority = priority;
        this.source = source;
        this.timeInQueue = timeInQueue;
        this.executing = executing;
    }

    public long getInsertOrder() {
        return insertOrder;
    }

    public Priority getPriority() {
        return priority;
    }

    public String getSource() {
        return source;
    }

    public long getTimeInQueueInMillis() {
        return timeInQueue;
    }

    public TimeValue getTimeInQueue() {
        return new TimeValue(getTimeInQueueInMillis());
    }

    public boolean isExecuting() {
        return executing;
    }

    public PendingClusterTask(StreamInput in) throws IOException {
        insertOrder = in.readVLong();
        priority = Priority.readFrom(in);
        source = in.readString();
        timeInQueue = in.readLong();
        executing = in.readBoolean();
    }

    @Override
    public void writeTo(StreamOutput out) throws IOException {
        out.writeVLong(insertOrder);
        Priority.writeTo(priority, out);
        out.writeString(source);
        out.writeLong(timeInQueue);
        out.writeBoolean(executing);
    }
}
