package com.benutzerverwaltung.beispiel;

public interface ComparableContent<ContentType> {

  /**
   * Wenn festgestellt wird, dass das Objekt, von dem die Methode aufgerufen
   * wird, bzgl. der gewuenschten Ordnungsrelation groesser als das Objekt
   * pContent ist, wird true geliefert. Sonst wird false geliefert.
   *
   * @param pContent
   *          das mit dem aufrufenden Objekt zu vergleichende Objekt vom
   *          Typ ContentType
   * @return true, wenn das aufrufende Objekt groesser ist als das Objekt
   *         pContent, sonst false
   */
  public boolean isGreater(ContentType pContent);

  /**
   * Wenn festgestellt wird, dass das Objekt, von dem die Methode aufgerufen
   * wird, bzgl. der gewuenschten Ordnungsrelation gleich gross wie das Objekt
   * pContent ist, wird true geliefert. Sonst wird false geliefert.
   *
   * @param pContent
   *          das mit dem aufrufenden Objekt zu vergleichende Objekt vom
   *          Typ ContentType
   * @return true, wenn das aufrufende Objekt gleich gross ist wie das Objekt
   *         pContent, sonst false
   */
  public boolean isEqual(ContentType pContent);

  /**
   * Wenn festgestellt wird, dass das Objekt, von dem die Methode aufgerufen
   * wird, bzgl. der gewuenschten Ordnungsrelation kleiner als das Objekt
   * pContent ist, wird true geliefert. Sonst wird false geliefert.
   *
   * @param pContent
   *          das mit dem aufrufenden Objekt zu vergleichende Objekt vom
   *          Typ ContentType
   * @return true, wenn das aufrufende Objekt kleiner ist als das Objekt
   *         pContent, sonst false   
   */     
  public boolean isLess(ContentType pContent);

}
