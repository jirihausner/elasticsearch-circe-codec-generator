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

package org.elasticsearch.circecodecs.indices.analyze

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._types.analysis.char_filters.{ CharFilter }
import org.elasticsearch.circecodecs._types.analysis.tokenizers.{ Tokenizer }
import org.elasticsearch.circecodecs._types.analysis.token_filters.{ TokenFilter }
import org.elasticsearch.circecodecs._types.Base.{ RequestBase }
import org.elasticsearch.circecodecs._types.common.{ Field, IndexName }
import org.elasticsearch.circecodecs.indices.analyze.{ TextToAnalyze }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		index: IndexName
	)
	@JsonCodec case class QueryParameters(
	)
	@JsonCodec case class Body(
		analyzer: String, 
		attributes: Seq[String], 
		char_filter: Seq[String | CharFilter], 
		explain: Boolean, 
		field: Field, 
		filter: Seq[String | TokenFilter], 
		normalizer: String, 
		text: TextToAnalyze, 
		tokenizer: String | Tokenizer
	)
}

