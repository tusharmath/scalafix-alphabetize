package fix

import scalafix.v1._
import scala.meta._

class ScalafixAlphabetize extends SemanticRule("ScalafixAlphabetize") {
  def patchTemplate(t: Template): Patch = {
    val defDefinition = t.stats.collect({
      case (d: Defn.Def) => (d, d.name.value)
      case (d: Decl.Def) => (d, d.name.value)
    })

    if (defDefinition.length <= 1) return Patch.empty

    val unsortedDefs = defDefinition.map(_._1)
    val sortedDefs   = defDefinition.sortBy(_._2).map(_._1)

    (unsortedDefs zip sortedDefs).map({ case (t1, t2) => Patch.replaceTree(t1, t2.syntax) }).asPatch
  }

  override def fix(implicit doc: SemanticDocument): Patch = {
    doc.tree
      .collect({ case t: Template => patchTemplate(t) })
      .asPatch
  }
}
