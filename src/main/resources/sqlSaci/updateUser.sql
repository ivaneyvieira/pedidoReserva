UPDATE sqldados.users AS U
SET
    auxLong1 = :storeno
WHERE no = :no;

INSERT  INTO sqldados.userApp(userno, appName, bitAcesso)
VALUES(:no, 'pedidoReserva', :bitAcesso)
ON DUPLICATE KEY UPDATE bitAcesso = :bitAcesso

