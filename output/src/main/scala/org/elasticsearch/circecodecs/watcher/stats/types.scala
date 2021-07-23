/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
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

package org.elasticsearch.circecodecs.watcher.stats

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.watcher.types.Execution.{ ExecutionPhase, ExecutionThreadPool }
import org.elasticsearch.circecodecs.types.common.{ Id }
import org.elasticsearch.circecodecs.types.Numeric.{ long }
import org.elasticsearch.circecodecs.types.Time.{ DateString }

object WatcherState extends Enumeration {
	type WatcherState = Value

	val stopped = Value(0, "stopped")
	val starting = Value(1, "starting")
	val started = Value(2, "started")
	val stopping = Value(3, "stopping")
}

implicit val watcherStateDecoder: Decoder[WatcherState.Value] = Decoder.decodeEnumeration(WatcherState)
implicit val watcherStateEncoder: Encoder[WatcherState.Value] = Decoder.encodeEnumeration(WatcherState)

@JsonCodec case class WatcherNodeStats(
	current_watches: Seq[WatchRecordStats], 
	execution_thread_pool: ExecutionThreadPool, 
	queued_watches: Seq[WatchRecordQueuedStats], 
	watch_count: long, 
	watcher_state: WatcherState, 
	node_id: Id
)

object WatcherMetric extends Enumeration {
	type WatcherMetric = Value

	val _all = Value(0, "_all")
	val queued_watches = Value(1, "queued_watches")
	val current_watches = Value(2, "current_watches")
	val pending_watches = Value(3, "pending_watches")
}

implicit val watcherMetricDecoder: Decoder[WatcherMetric.Value] = Decoder.decodeEnumeration(WatcherMetric)
implicit val watcherMetricEncoder: Encoder[WatcherMetric.Value] = Decoder.encodeEnumeration(WatcherMetric)

@JsonCodec case class WatchRecordQueuedStats(
	execution_time: DateString
)

@JsonCodec case class WatchRecordStats(
	execution_phase: ExecutionPhase, 
	triggered_time: DateString, 
	executed_actions: Seq[String], 
	watch_id: Id, 
	watch_record_id: Id
) extends WatchRecordQueuedStats
