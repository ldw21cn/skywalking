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

package org.skywalking.apm.collector.cluster.zookeeper.service;

import org.skywalking.apm.collector.cluster.ModuleRegistration;
import org.skywalking.apm.collector.cluster.service.ModuleRegisterService;
import org.skywalking.apm.collector.cluster.zookeeper.ClusterZKDataMonitor;

/**
 * 基于 Zookeeper 的模块注册服务实现类
 *
 * @author peng-yongsheng
 */
public class ZookeeperModuleRegisterService implements ModuleRegisterService {

    private final ClusterZKDataMonitor dataMonitor;

    public ZookeeperModuleRegisterService(ClusterZKDataMonitor dataMonitor) {
        this.dataMonitor = dataMonitor;
    }

    @Override public void register(String moduleName, String providerName, ModuleRegistration registration) {
        String path = "/" + moduleName + "/" + providerName;
        dataMonitor.register(path, registration);
    }
}
