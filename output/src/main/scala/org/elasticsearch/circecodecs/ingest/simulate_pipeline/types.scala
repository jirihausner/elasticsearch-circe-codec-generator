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

package org.elasticsearch.circecodecs.ingest.simulate_pipeline

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs._spec_utils.UserDefinedValue.{ UserDefinedValue }
import org.elasticsearch.circecodecs._watcher._types.Action.{ ActionStatusOptions }
import org.elasticsearch.circecodecs._types.common.{ Id, IndexName, Name, Type }
import org.elasticsearch.circecodecs._types.Time.{ DateString }

@JsonCodec case class Ingest(
	timestamp: DateString, 
	pipeline: Name
)

@JsonCodec case class PipelineSimulation(
	doc: DocumentSimulation, 
	processor_results: Seq[PipelineSimulation], 
	tag: String, 
	processor_type: String, 
	status: ActionStatusOptions
)

@JsonCodec case class Document(
	_id: Id, 
	_index: IndexName, 
	_source: UserDefinedValue
)

@JsonCodec case class DocumentSimulation(
	_id: Id, 
	_index: IndexName, 
	_ingest: Ingest, 
	_parent: String, 
	_routing: String, 
	_source: Dictionary[String, UserDefinedValue], 
	_type: Type
)
