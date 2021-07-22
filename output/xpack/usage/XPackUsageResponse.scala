package com.converted.elasticsearch.xpack.usage

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.xpack.usage.{ Analytics, Base, Ccr, DataStreams, DataTiers, Eql, Flattened, FrozenIndices, Ilm, MachineLearning, Monitoring, RuntimeFieldTypes, SearchableSnapshots, Security, Slm, Sql, Vector, Watcher }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		aggregate_metric: Base, 
		analytics: Analytics, 
		watcher: Watcher, 
		ccr: Ccr, 
		data_frame: Base, 
		data_science: Base, 
		data_streams: DataStreams, 
		data_tiers: DataTiers, 
		enrich: Base, 
		eql: Eql, 
		flattened: Flattened, 
		frozen_indices: FrozenIndices, 
		graph: Base, 
		ilm: Ilm, 
		logstash: Base, 
		ml: MachineLearning, 
		monitoring: Monitoring, 
		rollup: Base, 
		runtime_fields: RuntimeFieldTypes, 
		spatial: Base, 
		searchable_snapshots: SearchableSnapshots, 
		security: Security, 
		slm: Slm, 
		sql: Sql, 
		transform: Base, 
		vectors: Vector, 
		voting_only: Base
	)
}

