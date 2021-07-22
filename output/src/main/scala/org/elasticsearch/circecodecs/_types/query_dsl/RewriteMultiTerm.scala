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

package org.elasticsearch.circecodecs._types.query_dsl

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

object RewriteMultiTerm extends Enumeration {
	type RewriteMultiTerm = Value

	val constant_score = Value(0, "constant_score")
	val scoring_boolean = Value(1, "scoring_boolean")
	val constant_score_boolean = Value(2, "constant_score_boolean")
	val top_terms_N = Value(3, "top_terms_N")
	val top_terms_boost_N = Value(4, "top_terms_boost_N")
	val top_terms_blended_freqs_N = Value(5, "top_terms_blended_freqs_N")
}

implicit val rewriteMultiTermDecoder: Decoder[RewriteMultiTerm.Value] = Decoder.decodeEnumeration(RewriteMultiTerm)
implicit val rewriteMultiTermEncoder: Encoder[RewriteMultiTerm.Value] = Decoder.encodeEnumeration(RewriteMultiTerm)
