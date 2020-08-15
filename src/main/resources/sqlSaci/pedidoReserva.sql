SELECT O.storeno                              AS loja,
       O.ordno                                AS numPedido,
       cast(O.date AS DATE)                   AS dataPedido,
       custno                                 AS codigoCliente,
       C.name                                 AS cliente,
       IF(O.nfno = 0, O.nfno_futura, O.nfno)  AS nfno,
       IF(O.nfse = '', O.nfse_futura, O.nfse) AS nfse,
       O.status                               AS status
FROM sqldados.eord          AS O
  INNER JOIN sqldados.custp AS C
	       ON C.no = O.custno
WHERE ((O.storeno = :loja OR :loja = 0) AND (O.ordno = :numPedido) AND ((O.s16 & POW(2, 3)) = 0) AND
       (:tipo = 'P'))
   OR ((O.storeno = :loja OR :loja = 0) AND ((O.s16 & POW(2, 3)) != 0) AND (:tipo = 'R'))