package fix

import scalafix.v1._
import scala.meta._

class ScalafixAlphabetize extends SemanticRule("ScalafixAlphabetize") {
  def patchTemplate(t: Template): Patch = {
    val defDefinition = t.stats.collect({
      case d: Defn.Def => (d, d.name.value)
      case d: Decl.Def => (d, d.name.value)
    })

    val defDefinitionSorted = defDefinition.sortBy(_._2).map(_._1)
    val finalDef            = defDefinition
      .map(_._1)
      .zip(defDefinitionSorted)
      .map({ case (d1, d2) =>
        Patch.replaceTree(d1, d2.syntax)
      })

    Patch.fromIterable(finalDef)
  }

  override def fix(implicit doc: SemanticDocument): Patch = {
    doc.tree
      .collect({ case t: Template => patchTemplate(t) })
      .asPatch
  }
}
