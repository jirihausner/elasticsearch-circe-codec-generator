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

package org.elasticsearch.circecodecs.rollup._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._types.common.{ Field, Fields }
import org.elasticsearch.circecodecs._types.Numeric.{ long }
import org.elasticsearch.circecodecs._types.Time.{ Time }

@JsonCodec case class Groupings(
	date_histogram: DateHistogramGrouping, 
	histogram: HistogramGrouping, 
	terms: TermsGrouping
)

@JsonCodec case class DateHistogramGrouping(
	delay: Time, 
	field: Field, 
	format: String, 
	interval: Time, 
	calendar_interval: Time, 
	fixed_interval: Time, 
	time_zone: String
)

@JsonCodec case class TermsGrouping(
	fields: Fields
)

@JsonCodec case class HistogramGrouping(
	fields: Fields, 
	interval: long
)
