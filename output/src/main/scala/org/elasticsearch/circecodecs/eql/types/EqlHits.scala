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

package org.elasticsearch.circecodecs.eql.types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.global.search.types.hits.{ TotalHits }
import org.elasticsearch.circecodecs.spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs.spec_utils.UserDefinedValue.{ UserDefinedValue }
import org.elasticsearch.circecodecs.types.common.{ Field, Id, IndexName }

@JsonCodec case class EqlHits[TEvent](
	total: TotalHits, 
	events: Seq[HitsEvent[TEvent]], 
	sequences: Seq[HitsSequence[TEvent]]
)

@JsonCodec case class HitsEvent[TEvent](
	_index: IndexName, 
	_id: Id, 
	_source: TEvent, 
	fields: Dictionary[Field, Seq[UserDefinedValue]]
)

@JsonCodec case class HitsSequence[TEvent](
	events: Seq[HitsEvent[TEvent]], 
	join_keys: Seq[UserDefinedValue]
)
