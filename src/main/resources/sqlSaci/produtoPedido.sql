SELECT I.storeno                              AS loja,
       I.ordno                                AS numPedido,
       I.prdno                                AS codigo,
       MAX(IFNULL(B.barcode, P.barcode))      AS barcode,
       I.grade                                AS grade,
       mfno_ref                               AS refFab,
       TRIM(MID(P.name, 1, 37))               AS descricao,
       TRIM(MID(P.name, 37, 3))               AS unidade,
       IFNULL(L.localizacao, '')              AS localizacao,
       ROUND(I.qtty / 1000)                   AS qtty,
       I.price / 100                          AS valorUnit,
       ROUND(I.qtty / 1000) * (I.price / 100) AS valorTotal
FROM sqldados.eoprd          AS I
  INNER JOIN sqldados.prd    AS P
	       ON I.prdno = P.no
  LEFT JOIN  sqldados.prdbar AS B
	       ON I.prdno = B.prdno AND I.grade = B.grade
  LEFT JOIN  sqldados.prdloc AS L
	       ON I.prdno = L.prdno AND I.grade = L.grade AND L.storeno = 4
WHERE I.storeno = :loja
  AND I.ordno = :numPedido
GROUP BY I.storeno, I.ordno, I.prdno, I.grade