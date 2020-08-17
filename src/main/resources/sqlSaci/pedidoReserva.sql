DROP TABLE IF EXISTS T;
CREATE TEMPORARY TABLE T (
  PRIMARY KEY (custno)
)
SELECT C.no AS custno, S.no AS storeno
FROM sqldados.custp         AS C
  INNER JOIN sqldados.store AS S
	       ON S.cgc = C.cpf_cgc;

SELECT O.storeno                                  AS loja,
       O.ordno                                    AS numPedido,
       cast(O.date AS DATE)                       AS dataPedido,
       O.custno                                   AS codigoCliente,
       C.name                                     AS cliente,
       IF(O.nfno = 0, O.nfno_futura, O.nfno)      AS nfno,
       IF(O.nfno = 0, O.nfse_futura, O.nfse)      AS nfse,
       CAST(CONCAT(O.storeno, T.storeno) AS CHAR) AS rota,
       ''                                         AS notaTransf,
       cast(NULL AS DATE)                         AS notaTransfData,
       O.status                                   AS status
FROM sqldados.eord          AS O
  INNER JOIN sqldados.custp AS C
	       ON C.no = O.custno
  INNER JOIN T
	       ON T.custno = O.custno
WHERE ((O.storeno = :loja OR :loja = 0) AND (O.ordno = :numPedido) AND (:tipo = 'P') AND
       (O.storeno != T.storeno))
UNION
SELECT O.storeno                                AS loja,
       O.ordno                                  AS numPedido,
       cast(O.date AS DATE)                     AS dataPedido,
       custno                                   AS codigoCliente,
       C.name                                   AS cliente,
       IF(O.nfno = 0, O.nfno_futura, O.nfno)    AS nfno,
       IF(O.nfno = 0, O.nfse_futura, O.nfse)    AS nfse,
       O.c4                                     AS rota,
       O.c5                                     AS notaTransf,
       cast(IF(O.l12 = 0, NULL, O.l12) AS DATE) AS notaTransfData,
       O.status                                 AS status
FROM sqldados.eord          AS O
  INNER JOIN sqldados.custp AS C
	       ON C.no = O.custno
WHERE ((O.storeno = :loja OR :loja = 0) AND (O.c5 != '') AND (:tipo = 'R'))