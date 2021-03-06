/*
 * Copyright 2017, OpenSkywalking Organization All rights reserved.
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
 *
 * Project repository: https://github.com/OpenSkywalking/skywalking
 */

package org.skywalking.apm.commons.datacarrier.partition;

/**
 * use threadid % total to partition
 *
 * 基于线程编号分配策略的数据分配者实现类
 *
 * Created by wusheng on 2016/10/25.
 */
public class ProducerThreadPartitioner<T> implements IDataPartitioner<T> {

    private int retryTime = 3;

    public ProducerThreadPartitioner() {
    }

    public ProducerThreadPartitioner(int retryTime) {
        this.retryTime = retryTime;
    }

    @Override
    public int partition(int total, T data) {
        return (int)Thread.currentThread().getId() % total;
    }

    @Override
    public int maxRetryCount() {
        return 1;
    }

}
