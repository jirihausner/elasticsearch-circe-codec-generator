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

package org.elasticsearch.circecodecs.ml.explain_data_frame_analytics

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.ml.types.DataframeAnalytics.{ DataframeAnalysisAnalyzedFields, DataframeAnalysisContainer, DataframeAnalyticsDestination, DataframeAnalyticsSource }
import org.elasticsearch.circecodecs.types.Base.{ RequestBase }
import org.elasticsearch.circecodecs.types.common.{ ByteSize, Id }
import org.elasticsearch.circecodecs.types.Numeric.{ integer }

@JsonCodec case class Request(
	path_parts: PathParts, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		id: Id
	)
	@JsonCodec case class Body(
		source: DataframeAnalyticsSource, 
		dest: DataframeAnalyticsDestination, 
		analysis: DataframeAnalysisContainer, 
		description: String, 
		model_memory_limit: String, 
		max_num_threads: integer, 
		analyzed_fields: DataframeAnalysisAnalyzedFields, 
		allow_lazy_start: Boolean
	)
}
