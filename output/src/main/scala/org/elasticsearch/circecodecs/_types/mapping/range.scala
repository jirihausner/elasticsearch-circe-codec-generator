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

package org.elasticsearch.circecodecs._types.mapping

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._types.Numeric.{ double }
import org.elasticsearch.circecodecs._types.mapping.{ DocValuesPropertyBase }

@JsonCodec case class RangePropertyBase(
	boost: double, 
	coerce: Boolean, 
	index: Boolean
) extends DocValuesPropertyBase
type RangeProperty = LongRangeProperty | IpRangeProperty | IntegerRangeProperty | FloatRangeProperty | DoubleRangeProperty | DateRangeProperty

@JsonCodec case class DateRangeProperty(
	format: String, 
	`type`: "date_range""
) extends RangePropertyBase

@JsonCodec case class DoubleRangeProperty(
	`type`: "double_range""
) extends RangePropertyBase

@JsonCodec case class FloatRangeProperty(
	`type`: "float_range""
) extends RangePropertyBase

@JsonCodec case class IntegerRangeProperty(
	`type`: "integer_range""
) extends RangePropertyBase

@JsonCodec case class IpRangeProperty(
	`type`: "ip_range""
) extends RangePropertyBase

@JsonCodec case class LongRangeProperty(
	`type`: "long_range""
) extends RangePropertyBase
