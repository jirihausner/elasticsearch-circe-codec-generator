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

package org.elasticsearch.circecodecs.ml.types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.types.common.{ Field }
import org.elasticsearch.circecodecs.types.Numeric.{ integer }
import org.elasticsearch.circecodecs.ml.types.{ DetectionRule }

@JsonCodec case class Detector(
	by_field_name: Field, 
	custom_rules: Seq[DetectionRule], 
	detector_description: String, 
	detector_index: integer, 
	exclude_frequent: ExcludeFrequent, 
	field_name: Field, 
	function: String, 
	use_null: Boolean, 
	over_field_name: Field, 
	partition_field_name: Field
)

object ExcludeFrequent extends Enumeration {
	type ExcludeFrequent = Value

	val all = Value(0, "all")
	val none = Value(1, "none")
	val by = Value(2, "by")
	val over = Value(3, "over")
}

implicit val excludeFrequentDecoder: Decoder[ExcludeFrequent.Value] = Decoder.decodeEnumeration(ExcludeFrequent)
implicit val excludeFrequentEncoder: Encoder[ExcludeFrequent.Value] = Decoder.encodeEnumeration(ExcludeFrequent)
