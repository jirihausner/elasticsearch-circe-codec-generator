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

package org.elasticsearch.circecodecs.global.get

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs.spec_utils.UserDefinedValue.{ UserDefinedValue }
import org.elasticsearch.circecodecs.types.common.{ Id, IndexName, SequenceNumber, Type, VersionNumber }
import org.elasticsearch.circecodecs.types.Numeric.{ long }

@JsonCodec case class Response[TDocument](
	body: Body
)

object Response {
	@JsonCodec case class Body(
		_index: IndexName, 
		fields: Dictionary[String, UserDefinedValue], 
		found: Boolean, 
		_id: Id, 
		_primary_term: long, 
		_routing: String, 
		_seq_no: SequenceNumber, 
		_source: TDocument, 
		_type: Type, 
		_version: VersionNumber
	)
}
