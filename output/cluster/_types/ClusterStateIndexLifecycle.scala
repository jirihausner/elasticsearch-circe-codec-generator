package com.converted.elasticsearch.cluster._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Lifecycle.{ LifecycleOperationMode }
import com.converted.elasticsearch._ilm._types.Phase.{ Phases }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.common.{ HttpHeaders, IndexName, VersionNumber }
import com.converted.elasticsearch._types.Numeric.{ long }
import com.converted.elasticsearch._types.Time.{ DateString }

@JsonCodec case class ClusterStateIndexLifecycle(
	policies: Dictionary(IndexName, ClusterStateIndexLifecycleSummary), 
	operation_mode: LifecycleOperationMode
)


@JsonCodec case class ClusterStateIndexLifecycleSummary(
	policy: ClusterStateIndexLifecyclePolicy, 
	headers: HttpHeaders, 
	version: VersionNumber, 
	modified_date: long, 
	modified_date_string: DateString
)


@JsonCodec case class ClusterStateIndexLifecyclePolicy(
	phases: Phases
)

