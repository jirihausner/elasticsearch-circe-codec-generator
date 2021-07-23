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

package org.elasticsearch.circecodecs.types.analysis

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.types.analysis.{ AnalyzerBase }
import org.elasticsearch.circecodecs.types.analysis.{ CharFilterBase }
import org.elasticsearch.circecodecs.types.analysis.{ TokenizerBase }
import org.elasticsearch.circecodecs.types.analysis.{ TokenFilterBase }

@JsonCodec case class IcuTransformTokenFilter(
	dir: IcuTransformDirection, 
	id: String
) extends TokenFilterBase

@JsonCodec case class IcuTokenizer(
	rule_files: String
) extends TokenizerBase

@JsonCodec case class IcuNormalizationTokenFilter(
	name: IcuNormalizationType
) extends TokenFilterBase

@JsonCodec case class IcuNormalizationCharFilter(
	mode: IcuNormalizationMode, 
	name: IcuNormalizationType
) extends CharFilterBase

@JsonCodec case class IcuFoldingTokenFilter(
	unicode_set_filter: String
) extends TokenFilterBase

@JsonCodec case class IcuCollationTokenFilter(
	alternate: IcuCollationAlternate, 
	caseFirst: IcuCollationCaseFirst, 
	caseLevel: Boolean, 
	country: String, 
	decomposition: IcuCollationDecomposition, 
	hiraganaQuaternaryMode: Boolean, 
	language: String, 
	numeric: Boolean, 
	strength: IcuCollationStrength, 
	variableTop: String, 
	variant: String
) extends TokenFilterBase

@JsonCodec case class IcuAnalyzer(
	method: IcuNormalizationType, 
	mode: IcuNormalizationMode
) extends AnalyzerBase

object IcuTransformDirection extends Enumeration {
	type IcuTransformDirection = Value

	val forward = Value(0, "forward")
	val reverse = Value(1, "reverse")
}

implicit val icuTransformDirectionDecoder: Decoder[IcuTransformDirection.Value] = Decoder.decodeEnumeration(IcuTransformDirection)
implicit val icuTransformDirectionEncoder: Encoder[IcuTransformDirection.Value] = Decoder.encodeEnumeration(IcuTransformDirection)

object IcuNormalizationMode extends Enumeration {
	type IcuNormalizationMode = Value

	val decompose = Value(0, "decompose")
	val compose = Value(1, "compose")
}

implicit val icuNormalizationModeDecoder: Decoder[IcuNormalizationMode.Value] = Decoder.decodeEnumeration(IcuNormalizationMode)
implicit val icuNormalizationModeEncoder: Encoder[IcuNormalizationMode.Value] = Decoder.encodeEnumeration(IcuNormalizationMode)

object IcuNormalizationType extends Enumeration {
	type IcuNormalizationType = Value

	val nfc = Value(0, "nfc")
	val nfkc = Value(1, "nfkc")
	val nfkc_cf = Value(2, "nfkc_cf")
}

implicit val icuNormalizationTypeDecoder: Decoder[IcuNormalizationType.Value] = Decoder.decodeEnumeration(IcuNormalizationType)
implicit val icuNormalizationTypeEncoder: Encoder[IcuNormalizationType.Value] = Decoder.encodeEnumeration(IcuNormalizationType)

object IcuCollationAlternate extends Enumeration {
	type IcuCollationAlternate = Value

	val shifted = Value(0, "shifted")
	val non-ignorable = Value(1, "non-ignorable")
}

implicit val icuCollationAlternateDecoder: Decoder[IcuCollationAlternate.Value] = Decoder.decodeEnumeration(IcuCollationAlternate)
implicit val icuCollationAlternateEncoder: Encoder[IcuCollationAlternate.Value] = Decoder.encodeEnumeration(IcuCollationAlternate)

object IcuCollationCaseFirst extends Enumeration {
	type IcuCollationCaseFirst = Value

	val lower = Value(0, "lower")
	val upper = Value(1, "upper")
}

implicit val icuCollationCaseFirstDecoder: Decoder[IcuCollationCaseFirst.Value] = Decoder.decodeEnumeration(IcuCollationCaseFirst)
implicit val icuCollationCaseFirstEncoder: Encoder[IcuCollationCaseFirst.Value] = Decoder.encodeEnumeration(IcuCollationCaseFirst)

object IcuCollationDecomposition extends Enumeration {
	type IcuCollationDecomposition = Value

	val no = Value(0, "no")
	val identical = Value(1, "identical")
}

implicit val icuCollationDecompositionDecoder: Decoder[IcuCollationDecomposition.Value] = Decoder.decodeEnumeration(IcuCollationDecomposition)
implicit val icuCollationDecompositionEncoder: Encoder[IcuCollationDecomposition.Value] = Decoder.encodeEnumeration(IcuCollationDecomposition)

object IcuCollationStrength extends Enumeration {
	type IcuCollationStrength = Value

	val primary = Value(0, "primary")
	val secondary = Value(1, "secondary")
	val tertiary = Value(2, "tertiary")
	val quaternary = Value(3, "quaternary")
	val identical = Value(4, "identical")
}

implicit val icuCollationStrengthDecoder: Decoder[IcuCollationStrength.Value] = Decoder.decodeEnumeration(IcuCollationStrength)
implicit val icuCollationStrengthEncoder: Encoder[IcuCollationStrength.Value] = Decoder.encodeEnumeration(IcuCollationStrength)
