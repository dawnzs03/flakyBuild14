/*
 * Copyright (c) 2008-2023, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.map.impl.record;

import com.hazelcast.config.MapConfig;
import com.hazelcast.internal.serialization.Data;

import static com.hazelcast.internal.nio.Bits.INT_SIZE_IN_BYTES;
import static com.hazelcast.internal.util.TimeStripUtil.recomputeWithBaseTime;
import static com.hazelcast.internal.util.TimeStripUtil.stripBaseTime;
import static com.hazelcast.map.impl.record.RecordReaderWriter.SIMPLE_DATA_RECORD_WITH_LRU_EVICTION_READER_WRITER;

/**
 * Used when {@link MapConfig#isPerEntryStatsEnabled()} is {@code false}
 * and eviction is configured.
 *
 * @see SimpleRecordWithLFUEviction
 */
class SimpleRecordWithLRUEviction<V> extends SimpleRecord<V> {
    private volatile int lastAccessTime;

    SimpleRecordWithLRUEviction() {
    }

    SimpleRecordWithLRUEviction(V value) {
        super(value);
    }

    @Override
    public long getLastAccessTime() {
        return recomputeWithBaseTime(lastAccessTime);
    }

    @Override
    public void setLastAccessTime(long lastAccessTime) {
        this.lastAccessTime = stripBaseTime(lastAccessTime);
    }

    @Override
    public int getRawLastAccessTime() {
        return lastAccessTime;
    }

    @Override
    public void setRawLastAccessTime(int lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    @Override
    public RecordReaderWriter getMatchingRecordReaderWriter() {
        return SIMPLE_DATA_RECORD_WITH_LRU_EVICTION_READER_WRITER;
    }

    @Override
    public long getCost() {
        return value instanceof Data
                ? super.getCost() + INT_SIZE_IN_BYTES : 0;
    }

    @Override
    public void onAccess(long now) {
        setLastAccessTime(now);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }

        SimpleRecordWithLRUEviction that = (SimpleRecordWithLRUEviction) o;
        return lastAccessTime == that.lastAccessTime;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + lastAccessTime;
        return result;
    }

    @Override
    public String toString() {
        return "SimpleRecordWithLRUEviction{"
                + "lastAccessTime=" + lastAccessTime
                + "} " + super.toString();
    }
}
