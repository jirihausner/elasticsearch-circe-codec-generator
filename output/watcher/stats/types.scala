package com.converted.elasticsearch.watcher.stats

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._watcher._types.Execution.{ ExecutionPhase, ExecutionThreadPool }
import com.converted.elasticsearch._types.common.{ Id }
import com.converted.elasticsearch._types.Numeric.{ long }
import com.converted.elasticsearch._types.Time.{ DateString }

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
	current_watches: Array(WatchRecordStats), 
	execution_thread_pool: ExecutionThreadPool, 
	queued_watches: Array(WatchRecordQueuedStats), 
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
	executed_actions: Array(String), 
	watch_id: Id, 
	watch_record_id: Id
) extends WatchRecordQueuedStats
