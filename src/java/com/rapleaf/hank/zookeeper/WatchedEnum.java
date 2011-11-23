/**
 *  Copyright 2011 Rapleaf
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.rapleaf.hank.zookeeper;

import org.apache.zookeeper.KeeperException;

import java.util.HashSet;
import java.util.Set;

public class WatchedEnum<E extends Enum<E>> implements WatchedNodeListener<String> {

  private final Class clazz;
  private final WatchedString watchedString;
  private Set<WatchedNodeListener<E>> listeners = new HashSet<WatchedNodeListener<E>>();
  private E cachedValue = null;

  public WatchedEnum(final Class clazz,
                     final ZooKeeperPlus zk,
                     final String nodePath,
                     boolean waitForCreation) throws KeeperException, InterruptedException {
    this.clazz = clazz;
    this.watchedString = new WatchedString(zk, nodePath, waitForCreation);
    this.watchedString.addListener(this);
    onWatchedNodeChange(watchedString.get());
  }

  public WatchedEnum(final Class clazz,
                     final ZooKeeperPlus zk,
                     final String nodePath,
                     final E initValue) throws KeeperException, InterruptedException {
    this.clazz = clazz;
    this.watchedString = new WatchedString(zk, nodePath, initValue.toString());
    this.watchedString.addListener(this);
    onWatchedNodeChange(watchedString.get());
  }

  public E get() {
    return cachedValue;
  }

  public void addListener(WatchedNodeListener<E> listener) {
    synchronized (listeners) {
      listeners.add(listener);
    }
  }

  public void removeListener(WatchedNodeListener<E> listener) {
    synchronized (listeners) {
      listeners.remove(listener);
    }
  }

  @Override
  public void onWatchedNodeChange(String value) {
    cachedValue = getEnumValue(value);
    synchronized (listeners) {
      for (WatchedNodeListener<E> listener : listeners) {
        listener.onWatchedNodeChange(cachedValue);
      }
    }
  }

  private E getEnumValue(String s) {
    if (s == null) {
      return null;
    } else {
      return (E) E.valueOf(clazz, s);
    }
  }

  public void cancelWatch() {
    watchedString.cancelWatch();
  }
}
