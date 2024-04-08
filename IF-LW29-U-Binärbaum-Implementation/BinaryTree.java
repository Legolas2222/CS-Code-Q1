
/**
 * <p>
 * Materialien zu den zentralen NRW-Abiturpruefungen im Fach Informatik ab 2017.
 * </p>
 * <p>
 * Generische Klasse BinaryTree<ContentType>
 * </p>
 * <p>
 * Mithilfe der generischen Klasse BinaryTree koennen beliebig viele
 * Inhaltsobjekte vom Typ ContentType in einem Binaerbaum verwaltet werden. Ein
 * Objekt der Klasse stellt entweder einen leeren Baum dar oder verwaltet ein
 * Inhaltsobjekt sowie einen linken und einen rechten Teilbaum, die ebenfalls
 * Objekte der generischen Klasse BinaryTree sind.
 * </p>
 * 
 * @author Qualitaets- und UnterstuetzungsAgentur - Landesinstitut fuer Schule,
 *         Materialien zum schulinternen Lehrplan Informatik SII
 * @version Generisch_03 2014-03-01
 */
public class BinaryTree<ContentType> {

  /* --------- Anfang der privaten inneren Klasse -------------- */

  /**
   * Durch diese innere Klasse kann man dafuer sorgen, dass ein leerer Baum
   * null ist, ein nicht-leerer Baum jedoch immer eine nicht-null-Wurzel sowie
   * nicht-null-Teilbaeume, ggf. leere Teilbaeume hat.
   */
  private class BTNode<CT> {
    public CT content;
    public BinaryTreeCustom<ContentType> left;
    public BinaryTreeCustom<ContentType> right;

    public BTNode(CT value) {
      this.content = value;
    }

    public BTNode(CT value, BinaryTreeCustom<ContentType> left, BinaryTreeCustom<ContentType> right) {
      this.content = value;
      this.left = left;
      this.right = right;
    }

    public BTNode() {

    }
  }

  /* ----------- Ende der privaten inneren Klasse -------------- */

  private BTNode node;
  /**
   * Nach dem Aufruf des Konstruktors existiert ein leerer Binaerbaum.
   */
  public BinaryTree() {
    this.node = new BTNode<ContentType>();
  }

  /**
   * Wenn der Parameter pContent ungleich null ist, existiert nach dem Aufruf
   * des Konstruktors der Binaerbaum und hat pContent als Inhaltsobjekt und
   * zwei leere Teilbaeume. Falls der Parameter null ist, wird ein leerer
   * Binaerbaum erzeugt.
   * 
   * @param pContent
   *                 das Inhaltsobjekt des Wurzelknotens vom Typ ContentType
   */
  public BinaryTree(ContentType pContent) {
    this.node = new BTNode<ContentType>(pContent); 
  }

  /**
   * Wenn der Parameter pContent ungleich null ist, wird ein Binaerbaum mit
   * pContent als Inhalt und den beiden Teilbaeume pLeftTree und pRightTree
   * erzeugt. Sind pLeftTree oder pRightTree gleich null, wird der
   * entsprechende Teilbaum als leerer Binaerbaum eingefuegt. So kann es also
   * nie passieren, dass linke oder rechte Teilbaeume null sind. Wenn der
   * Parameter pContent gleich null ist, wird ein leerer Binaerbaum erzeugt.
   * 
   * @param pContent
   *                   das Inhaltsobjekt des Wurzelknotens vom Typ ContentType
   * @param pLeftTree
   *                   der linke Teilbaum vom Typ BinaryTree<ContentType>
   * @param pRightTree
   *                   der rechte Teilbaum vom Typ BinaryTree<ContentType>
   */
  public BinaryTree(ContentType pContent, BinaryTree<ContentType> pLeftTree, BinaryTree<ContentType> pRightTree) {
    this.node = new BTNode<ContentType>(pContent, pLeftTree, pRightTree); 
  }

  /**
   * Diese Anfrage liefert den Wahrheitswert true, wenn der Binaerbaum leer
   * ist, sonst liefert sie den Wert false.
   * 
   * @return true, wenn der Binaerbaum leer ist, sonst false
   */
  public boolean isEmpty() {
    return this.node == null;
  }

  /**
   * Wenn pContent null ist, geschieht nichts. <br />
   * Ansonsten: Wenn der Binaerbaum leer ist, wird der Parameter pContent als
   * Inhaltsobjekt sowie ein leerer linker und rechter Teilbaum eingefuegt.
   * Ist der Binaerbaum nicht leer, wird das Inhaltsobjekt durch pContent
   * ersetzt. Die Teilbaeume werden nicht geaendert.
   * 
   * @param pContent
   *                 neues Inhaltsobjekt vom Typ ContentType
   */
  public void setContent(ContentType pContent) {
    this.node.content = pContent;
  }

  /**
   * Diese Anfrage liefert das Inhaltsobjekt des Binaerbaums. Wenn der
   * Binaerbaum leer ist, wird null zurueckgegeben.
   * 
   * @return das Inhaltsobjekt der Wurzel vom Typ ContentType bzw. null, wenn
   *         der Binaerbaum leer ist
   */
  public ContentType getContent() {
    return this.node.content;
  }

  /**
   * Falls der Parameter null ist, geschieht nichts. Wenn der Binaerbaum leer
   * ist, wird pTree nicht angehaengt. Andernfalls erhaelt der Binaerbaum den
   * uebergebenen BinaryTree als linken Teilbaum.
   * 
   * @param pTree
   *              neuer linker Teilbaum vom Typ BinaryTree<ContentType>
   */
  public void setLeftTree(BinaryTree<ContentType> pTree) {
    this.node.left = pTree;
  }

  /**
   * Falls der Parameter null ist, geschieht nichts. Wenn der Binaerbaum leer
   * ist, wird pTree nicht angehaengt. Andernfalls erhaelt der Binaerbaum den
   * uebergebenen BinaryTree als rechten Teilbaum.
   * 
   * @param pTree
   *              neuer linker Teilbaum vom Typ BinaryTree<ContentType>
   */
  public void setRightTree(BinaryTree<ContentType> pTree) {
    this.node.right = pTree;
  }

  /**
   * Diese Anfrage liefert den linken Teilbaum des Binaerbaumes. Wenn der
   * Binaerbaum leer ist, wird null zurueckgegeben.
   * 
   * @return linker Teilbaum vom Typ BinaryTree<ContentType> oder null, wenn
   *         der aktuelle Binaerbaum leer ist
   */
  public BinaryTree<ContentType> getLeftTree() {
    return this.node.left;
  }

  /**
   * Diese Anfrage liefert den rechten Teilbaum des Binaerbaumes. Wenn der
   * Binaerbaum (this) leer ist, wird null zurueckgegeben.
   * 
   * @return rechter Teilbaum vom Typ BinaryTree<ContentType> oder null, wenn
   *         der aktuelle Binaerbaum (this) leer ist
   */
  public BinaryTree<ContentType> getRightTree() {
    return this.node.right;
  }

}
