package cz.jirihausner.es_codec_generator
package generator

import Utils._

import java.io.PrintWriter
import org.scalablytyped.converter.internal.ts._
import org.scalablytyped.converter.internal.ts.Indexing.{Dict, Single}
import org.scalablytyped.converter.internal.ts.TsExpr.format

class Generator(val output: PrintWriter, packageName: String, basePackageName: String) {

  /** stack of objects */
  var objectStack: List[(String, TsTypeObject)] = List[(String, TsTypeObject)]()

  /** padding level */
  var paddingLevel: Int = 0

  def printFile(file: TsParsedFile): Unit = {
    // print file header (package + circe imports)
    printFileHeader()

    // print AST TODO: remove
    /*file.members.foreach(m => output.println("//" + m))
    printLn*/

    // print file members
    file.members.foreach(printContainerOrDecl)
  }

  def printFileHeader(): Unit = {
    output.println(s"package ${basePackageName + '.' + packageName}")
    output.println
    output.println("import io.circe._, io.circe.generic.semiauto._")
    //output.println("import io.circe.{Decoder, Encoder, KeyDecoder, KeyEncoder}")
    output.println("import io.circe.generic.JsonCodec, io.circe.syntax._")
    output.println
  }

  /** --- TREE */

  def printTree(x: TsTree): Unit = x match {
    case x: TsContainerOrDecl => printContainerOrDecl(x)
    case x: TsEnumMember => printEnumMember(x)
    case x: TsFunSig => printFunSig(x)
    case x: TsFunParam => printFunParam(x)
    case x: TsTypeParam => printTypeParam(x)
    case x: TsLiteral => printLiteral(x)
    case x: TsIdent => printIdent(x)
    case x: TsQIdent => printQIdent(x)
    case x: TsType => printType(x)
    case x: TsMember => printMember(x)
    case x: Indexing => printIndexing(x)
    case x: TsImported => printImported(x)
    case x: TsImportee => printImportee(x)
    case x: TsExportee => printExportee(x)
    case _ => printLn(s"/*Unexpected TsTree: ${x.asString}*/")
  }

  def printContainerOrDecl(x: TsContainerOrDecl): Unit = x match {
    case x: TsDeclNamespace => printNamespace(x)
    case x: TsDeclModule => printModule(x)
    case x: TsAugmentedModule => printAugmentedModule(x)
    case x: TsGlobal => printGlobal(x)
    case x: TsDeclClass => printClass(x)
    case x: TsDeclInterface => printInterface(x)
    case x: TsDeclEnum => printEnum(x)
    case x: TsDeclVar => printVar(x)
    case x: TsDeclFunction => printFunction(x)
    case x: TsDeclTypeAlias => printTypeAlias(x)
    case x: TsImport => printImport(x)
    case x: TsExport => printExport(x)
    case x: TsExportAsNamespace => printExportAsNamespace(x)
    case _ => printLn(s"/*Unexpected TsContainerOrDecl: ${x.asString}*/")
  }

  def printEnumMember(x: TsEnumMember): Unit = {
    if (x.expr.isDefined)
      printLn(s"""val ${toLowerCamelCase(x.name.value)} = Value(${format(x.expr.get)}, "${x.name.value}")""", padding = true)
    else
      printLn(s"""val ${toLowerCamelCase(x.name.value)} = Value("${x.name.value}")""", padding = true)
  }

  def printFunSig(x: TsFunSig, declared: Boolean = false): Unit = {
    // begin function signature
    print("(")

    // print each function param if its not declaration
    // otherwise print type param
    if (!declared) {
      x.params.foreach(p => {
        printFunParam(p)
        print(", ")
      })
    }
    else {
      x.tparams.foreach(p => {
        printTypeParam(p)
        print(", ")
      })
    }

    // end function signature
    print(")")

    // print function result type
    if (!declared && x.resultType.isDefined) {
      print(": ")
      printType(x.resultType.get)
    }
  }

  def printFunParam(x: TsFunParam): Unit = {
    // print param name
    print(s"${x.name.value}")

    // print param type
    if (x.tpe.isDefined) {
      print(": ")
      printType(x.tpe.get)
    }
  }

  def printTypeParam(x: TsTypeParam): Unit = {
    // print param name
    print(s"${x.name.value}")

    // print param type
    if (x.upperBound.isDefined) {
      print(": ")
      printType(x.upperBound.get)
    }

    // print param default value
    if (x.default.isDefined) {
      print(" = ")
      printType(x.default.get)
    }
  }

  def printLiteral(x: TsLiteral): Unit = x match {
    case TsLiteral.Num(value) => print(value)
    case TsLiteral.Str(value) => print(s""""$value""""")
    case TsLiteral.Bool(value) => print(value.toString)
  }

  def printIdent(x: TsIdent): Unit = x match {
    case TsIdentSimple(value) => print(scalaEscape(value))
    case TsIdentImport(from) => printIdentModule(from.scopeOpt, from.fragments)
    case TsIdentModule(scopeOpt, fragments) => printIdentModule(scopeOpt, fragments)
    case library: TsIdentLibrary => printIdentLibrary(library)
  }

  def printQIdent(x: TsQIdent): Unit =
    x.parts.map(i => parseTsPrimitives(i.value)).foreach(i => print(i))

  def printType(x: TsType, name: String = ""): Unit = x match {
    case x: TsTypeRef => printTypeRef(x)
    case x: TsTypeLiteral => printTypeLiteral(x)
    case x: TsTypeObject => printTypeObject(x, name)
    case x: TsTypeFunction => printTypeFunction(x)
    case x: TsTypeConstructor => printTypeConstructor(x)
    case x: TsTypeIs => printTypeIs(x)
    case x: TsTypeAsserts => printTypeAssers(x)
    case x: TsTypeTuple => printTypeTuple(x)
    case x: TsTypeQuery => printTypeQuery(x)
    case x: TsTypeRepeated => printTypeRepeated(x)
    case x: TsTypeKeyOf => printTypeKeyOf(x)
    case x: TsTypeLookup => printTypeLookup(x)
    case x: TsTypeThis => printTypeThis(x)
    case x: TsTypeIntersect => printTypeIntersect(x)
    case x: TsTypeUnion => printTypeUnion(x)
    case x: TsTypePredicate => printTypePredicate(x)
    case _ => print(s"/*Unexpected TsType: ${x.asString}*/")
  }

  def printMember(x: TsMember): Unit = x match {
    case x: TsMemberCall => printMemberCall(x)
    case x: TsMemberCtor => printMemberConstructor(x)
    case x: TsMemberFunction => printMemberFunction(x)
    case x: TsMemberIndex => printMemberIndex(x)
    case x: TsMemberTypeMapped => printMemberTypeMapped(x)
    case x: TsMemberProperty => printMemberProperty(x)
  }

  def printIndexing(x: Indexing): Unit = x match {
    case Dict(name, tpe) =>
      printIdent(name)
      printType(tpe)
    case Single(name) => printQIdent(name)
  }

  def printImported(x: TsImported): Unit = x match {
    case x: TsImported.Ident => printIdent(x.ident)
    case x: TsImported.Destructured => print("{ " +
      x.idents.map(i => i._1.value + (if (i._2.isEmpty) "" else " as " + i._2.get.value)).mkString(", ") + " }")
    case _: TsImported.Star => print("_")
  }

  def printImportee(x: TsImportee): Unit = x match {
    case TsImportee.Required(from) => printIdentModule(from.scopeOpt, from.fragments)
    case TsImportee.From(from) => printIdentModule(from.scopeOpt, from.fragments)
    case TsImportee.Local(qident) => printQIdent(qident)
  }

  def printExportee(x: TsExportee): Unit = x match {
    case TsExportee.Names(idents, fromOpt) => // TODO
    case TsExportee.Tree(decl) => printContainerOrDecl(decl)
    case TsExportee.Star(as, from) => // TODO
  }

  /** --- CONTAINER OR DECLARATION */

  def printNamespace(x: TsDeclNamespace): Unit = {}

  def printModule(x: TsDeclModule): Unit = {
    // print module name
    print("object ", padding = true)
    printIdentModule(x.name.scopeOpt, x.name.fragments)
    printLn(" {")

    // print each member
    pushPadding
    x.members.foreach(printContainerOrDecl)
    popPadding

    // end module
    printLn("}")
  }

  def printAugmentedModule(x: TsAugmentedModule): Unit = {
    // print module name
    print("object ", padding = true)
    print(x.asString) // TODO: workaround
    //printIdentModule(x.name.scopeOpt, x.name.fragments)
    printLn(" {")

    // print each member
    pushPadding
    x.members.foreach(printContainerOrDecl)
    popPadding

    // end module
    printLn("}")
  }

  def printGlobal(x: TsGlobal): Unit = {
    // TODO fix global
    printLn(s"[[GLOBAL: $x]]")

    // print members
    //x.members.foreach(printContainerOrDecl)
  }

  def printClass(x: TsDeclClass): Unit = {
    // print name ident if declared
    if (x.declared) {
      printIdent(x.name)
      return
    }

    // is trait?
    val isTrait = x.members.isEmpty && x.parent.isEmpty && x.implements.isEmpty

    // print trait if no parameter and no member, otherwise print class
    printLn
    if (isTrait) {
      print(s"@JsonCodec sealed trait ", padding = true)
      printIdent(x.name)
    } else {
      print(s"@JsonCodec case class ", padding = true)
      printIdent(x.name)
    }

    // print generic type parameters
    if (x.tparams.nonEmpty) {
      print("[")
      printTypeParam(x.tparams.head)
      x.tparams.tail.foreach(p => {
        print(", ")
        printTypeParam(p)
      })
      print("]")
    }

    // print members
    if (x.members.nonEmpty) {
      printLn("(")
      pushPadding
      printMember(x.members.head)
      x.members.tail.foreach(m => {
        printLn(", ")
        printMember(m)
      })
      popPadding
      print("\n)")
    }

    // print inheritance
    if (x.parent.nonEmpty) {
      print(s" extends ")
      printTypeRef(x.parent.get)
    }

    // print implements
    if (x.implements.nonEmpty) {
      if (x.parent.isEmpty) print(" extends ")
      else print(", ")
      printTypeRef(x.implements.head)
      x.implements.tail.foreach(i => {
        print(", ")
        printTypeRef(i)
      })
    }

    printLn

    // print companion object if neccessary
    if (objectStack.nonEmpty) {
      printLn
      print("object ")
      printIdent(x.name)
      pushPadding
      printLn(" {")
      objectStack.reverse.foreach(o => printTypeObject(o._2, o._1))
      printLn("}")
      popPadding
      objectStack = List()
      printLn
    }

    /*// print circe codec
    if (!isTrait) {
      printLn
      printLn(s"implicit val ${toLowerCamelCase(x.name.value)}Decoder: Decoder[${x.name.value}] = deriveDecoder")
      printLn(s"implicit val ${toLowerCamelCase(x.name.value)}Encoder: Encoder[${x.name.value}] = deriveEncoder")
    }
    else {
      printLn
      printLn(s"implicit val ${toLowerCamelCase(x.name.value)}Decoder: Decoder[${x.name.value}] = deriveDecoder")
      printLn(s"implicit val ${toLowerCamelCase(x.name.value)}Encoder: Encoder[${x.name.value}] = deriveEncoder")
    }*/
  }

  def printInterface(x: TsDeclInterface): Unit = {
    // print name ident if declared
    if (x.declared) {
      printIdent(x.name)
      return
    }

    // is trait?
    val isTrait = x.members.isEmpty && x.inheritance.isEmpty

    // print trait if no parameter and no member, otherwise print case class with params
    printLn
    if (isTrait) {
      print(s"@JsonCodec sealed trait ", padding = true)
      printIdent(x.name)
    }
    else {
      print("@JsonCodec case class ", padding = true)
      printIdent(x.name)
    }

    // print generic type parameters
    if (x.tparams.nonEmpty) {
      print("[")
      printTypeParam(x.tparams.head)
      x.tparams.tail.foreach(p => {
        print(", ")
        printTypeParam(p)
      })
      print("]")
    }

    // print members
    if (x.members.nonEmpty) {
      printLn("(")
      pushPadding
      printMember(x.members.head)
      x.members.tail.foreach(m => {
        printLn(", ")
        printMember(m)
      })
      popPadding
      print("\n)")
    }

    // print implements
    if (x.inheritance.nonEmpty) {
      print(" extends ")
      printTypeRef(x.inheritance.head)
      x.inheritance.tail.foreach(i => {
        print(", ")
        printTypeRef(i)
      })
    }

    printLn

    // print companion object if neccessary
    if (objectStack.nonEmpty) {
      printLn
      print("object ")
      printIdent(x.name)
      pushPadding
      printLn(" {")
      objectStack.reverse.foreach(o => printTypeObject(o._2, o._1))
      printLn("}")
      popPadding
      objectStack = List()
      printLn
    }

    // print circe codec
    /*printLn
    printLn(s"implicit val ${toLowerCamelCase(x.name.value)}Decoder: Decoder[${x.name.value}] = deriveDecoder")
    printLn(s"implicit val ${toLowerCamelCase(x.name.value)}Encoder: Encoder[${x.name.value}] = deriveEncoder")
    printLn*/
  }

  def printEnum(x: TsDeclEnum): Unit = {
    // print name ident if declared
    if (x.declared) {
      printIdent(x.name)
      return
    }

    // print enumeration name
    printLn
    printLn(s"object ${x.name.value} extends Enumeration {")

    // print its type
    pushPadding
    printLn(s"type ${x.name.value} = Value", padding = true)
    printLn

    // print each enumeration members
    if (x.members.nonEmpty)
      x.members.foreach(printEnumMember)
    popPadding

    // close enumeration class
    printLn("}")

    // print circe codec
    printLn
    printLn(s"implicit val ${toLowerCamelCase(x.name.value)}Decoder: Decoder" +
      s"[${x.name.value}.Value] = Decoder.decodeEnumeration(${x.name.value})")
    printLn(s"implicit val ${toLowerCamelCase(x.name.value)}Encoder: Encoder" +
      s"[${x.name.value}.Value] = Decoder.encodeEnumeration(${x.name.value})")
  }

  def printVar(x: TsDeclVar): Unit = {
    // print name ident if declared
    if (x.declared) {
      printIdent(x.name)
      return
    }

    // print definition of variable
    print(s"var ", padding = true)

    // print variable name
    printIdent(x.name)

    // print type
    if (x.tpe.isDefined) {
      print(": ")
      printType(x.tpe.get)
    }

    // print expression
    if (x.expr.isDefined)
      print(s" = ${format(x.expr.get)}")

    // end line
    printLn
  }

  def printFunction(x: TsDeclFunction): Unit = {
    // print definition
    if (!x.declared)
      print("def ", padding = true)

    // print function name
    print(s"${x.name.value}")

    // print function signature
    printFunSig(x.signature)
    printLn
  }

  def printTypeAlias(x: TsDeclTypeAlias): Unit = {
    // print name ident if declared
    if (x.declared) {
      printIdent(x.name)
      return
    }

    // print type alias
    print(s"type ", padding = true)
    printIdent(x.name)

    // print generic template
    if (x.tparams.nonEmpty) {
      print("[")
      printTypeParam(x.tparams.head)
      x.tparams.tail.foreach(_ => {
        print(", ")
        printTypeParam _
      })
      print("] ")
    }

    // print alias
    print(s" = ")
    printType(x.alias)
    printLn
  }

  def printImport(x: TsImport): Unit = {
    // exclude standard libraries
    // TODO

    // print import and base package name
    print(s"import $basePackageName.")

    // print importee (package that we are importing)
    printImportee(x.from)

    // print dot
    print(".")

    // print imported (what we are importing from said package)
    x.imported.foreach(printImported)
    printLn
  }

  def printExport(x: TsExport): Unit = printExportee(x.exported)

  def printExportAsNamespace(x: TsExportAsNamespace): Unit = printIdent(x.ident)

  /** --- IDENT */

  def printIdentImport(x: TsIdentImport): Unit =
    printIdentModule(x.from.scopeOpt, x.from.fragments)

  def printIdentModule(scopedOpt: Option[String], fragments: List[String]): Unit = {
    // print scoped module (refers to root folder)
    if (scopedOpt.isDefined) {
      if (scopedOpt.get.charAt(0) != '_') print("_")
      print(scopedOpt.get + ".")
      print(fragments.mkString("."))
    }
    else {
      val backs = fragments.count(_ == "..")
      val skipped = fragments.takeWhile(_ == "..").takeWhile(_ == ".")
      val index = packageName.lastIndexOf(".", backs)
      if (index != -1)
        print(packageName.substring(0, index))
      else
        print(packageName)
      print(skipped.mkString("."))
    }
  }

  def printIdentLibrary(x: TsIdentLibrary): Unit = print(x.value)

  /** --- TYPE */

  def printTypeRef(x: TsTypeRef): Unit = {
    // print type name
    printQIdent(x.name)

    // print type params
    if (x.tparams.nonEmpty) {
      print("(")
      printType(x.tparams.head)
      x.tparams.tail.foreach(p => {
        print(", ")
        printType(p)
      })
      print(")")
    }
  }

  def printTypeLiteral(x: TsTypeLiteral): Unit =
    printLiteral(x.literal)

  def printTypeObject(x: TsTypeObject, name: String): Unit = {
    print(s"@JsonCodec case class $name(", padding = true)
    if (x.members.nonEmpty) {
      printLn
      printPadding
      printMember(x.members.head)
      x.members.tail.foreach(m => {
        printLn(", ")
        printPadding
        printMember(m)
      })
    }
    printLn
    printLn(")", padding = true)
    //printLn
  }

  def printTypeFunction(x: TsTypeFunction): Unit =
    printFunSig(x.signature)

  def printTypeConstructor(x: TsTypeConstructor): Unit =
    printTypeFunction(x.signature)

  def printTypeIs(x: TsTypeIs): Unit = {
    printIdent(x.ident)
    print(".isInstanceOf(")
    printType(x.tpe)
    print(")")
  }

  def printTypeAssers(x: TsTypeAsserts): Unit = {
    if (x.isOpt.isDefined) {
      print(s"assert(${x.ident}.isInstanceOf(")
      printType(x.isOpt.get)
      print(")")
    }
  }

  def printTypeTuple(x: TsTypeTuple): Unit = {
    if (x.elems.nonEmpty) {
      print("(")
      printType(x.elems.head.tpe)
      x.elems.tail.foreach(e => {
        print(", ")
        printType(e.tpe)
      })
      print(")")
    }
  }

  def printTypeQuery(x: TsTypeQuery): Unit = {
    if (x.expr.parts.nonEmpty) {
      print("[")
      printIdent(x.expr.parts.head)
      x.expr.parts.tail.foreach(p => {
        print(", ")
        printIdent(p)
      })
      print("]")
    }
  }

  def printTypeRepeated(x: TsTypeRepeated): Unit =
    printType(x.underlying)

  def printTypeKeyOf(x: TsTypeKeyOf): Unit = {
    // TODO ???
    print(s"[[KEYOF: $x]]")
  }

  def printTypeLookup(x: TsTypeLookup): Unit = {
    printType(x.from)
    print(".")
    printType(x.key)
  }

  def printTypeThis(x: TsTypeThis): Unit = print("this")

  def printTypeIntersect(x: TsTypeIntersect): Unit = {
    val types = x.types.filter(t => t.asString != "undefined")
    if (types.nonEmpty) {
      printType(types.head)
      types.tail.foreach(t => {
        print(" & ")
        printType(t)
      })
    }
  }

  def printTypeUnion(x: TsTypeUnion): Unit = {
    val types = x.types.filter(t => typeHelper(t) != "undefined")
    if (types.nonEmpty) {
      printType(types.head)
      types.tail.foreach(t => {
        print(" | ")
        printType(t)
      })
    }
  }

  def typeHelper(x: TsType): String = x match {
    case TsTypeRef(comments, name, tparams) => name.parts.head.value
    case TsTypeLiteral(literal) => literal.literal
    case _ => ""
  }

  def printTypePredicate(x: TsTypePredicate): Unit = x match {
    case TsTypeConditional(pred, ifTrue, ifFalse) =>
      // TODO
    case TsTypeExtends(tpe, extend) =>
      printType(tpe)
      print(" extends ")
      printType(extend)
    case TsTypeInfer(tparam) => printTypeParam(tparam)
  }

  /** --- MEMBER */
  // TODO: member

  def printMemberCall(x: TsMemberCall): Unit =
    printFunSig(x.signature, declared = true)

  def printMemberConstructor(x: TsMemberCtor): Unit =
    printFunSig(x.signature, declared = true)

  def printMemberFunction(x: TsMemberFunction): Unit = {
    // TODO
    print(s"[MemberFunction[: $x]]")
  }

  def printMemberIndex(x: TsMemberIndex): Unit = {
    // TODO
    print(s"[[MemberIndex: $x]]")
  }

  def printMemberTypeMapped(x: TsMemberTypeMapped): Unit = {
    // TODO
    print(s"[[MemberTypeMapped: $x]]")
  }

  def printMemberProperty(x: TsMemberProperty): Unit = {
    // print name
    printPadding
    printIdent(x.name)

    // print type
    if (x.tpe.isDefined) {
      print(": ")
      x.tpe.get match {
        case typeObject: TsTypeObject =>
          var name = x.name.value.split('_').map(toUpperCamelCase).mkString
          if (name == x.name.value) name = "_" + name
          print(name)
          pushObject(name, typeObject)
        case union: TsTypeUnion =>
          union.types.head match {
            case typeObject: TsTypeObject =>
              var name = x.name.value.split('_').map(toUpperCamelCase).mkString
              if (name == x.name.value) name = "_" + name
              print(name)
              pushObject(name, typeObject)
            case _ => printType(x.tpe.get)
          }
        case _ => printType(x.tpe.get)
      }
    }

    // print expression
    if (x.expr.isDefined)
      print(format(x.expr.get))
  }

  /** object stack */
  def pushObject(obj: (String, TsTypeObject)): Unit =
    objectStack = obj :: objectStack

  /** helpers */

  def print(x: String, padding: Boolean = false): Unit = {
    if (padding) printPadding
    output.print(x)
  }

  def printLn(x: String = "", padding: Boolean = false): Unit = {
    if (padding) printPadding
    output.println(x)
  }

  def printLn: Unit = output.println()
  def printPadding: Unit = output.print("\t" * paddingLevel)
  def pushPadding: Unit = paddingLevel += 1
  def popPadding: Unit = if (paddingLevel > 0) paddingLevel -= 1
}