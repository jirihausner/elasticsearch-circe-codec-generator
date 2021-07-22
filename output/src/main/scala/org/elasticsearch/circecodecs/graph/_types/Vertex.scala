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

package org.elasticsearch.circecodecs.graph._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._types.common.{ Field }
import org.elasticsearch.circecodecs._types.Numeric.{ double, integer, long }

@JsonCodec case class Vertex(
	depth: long, 
	field: Field, 
	term: String, 
	weight: double
)

@JsonCodec case class VertexDefinition(
	exclude: Seq[String], 
	field: Field, 
	include: Seq[VertexInclude], 
	min_doc_count: long, 
	shard_min_doc_count: long, 
	size: integer
)

@JsonCodec case class VertexInclude(
	boost: double, 
	term: String
)
