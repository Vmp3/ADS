SET SQL_SAFE_UPDATES = 0;
DROP DATABASE IF EXISTS DBESTACAO;
CREATE DATABASE DBESTACAO;
USE DBESTACAO;
 
-- Criação das tabelas

CREATE TABLE ESTACAO (

    IDESTACAO INT NOT NULL,
    NOME VARCHAR(100),
    DESCRICAO VARCHAR(200),
    PRIMARY KEY (IDESTACAO)
);
 
CREATE TABLE TIPOSENSOR (
    IDTIPOSENSOR INT NOT NULL,
    NOME VARCHAR(100),
    DESCRICAO VARCHAR(200),
    PRIMARY KEY (IDTIPOSENSOR)
);
 
CREATE TABLE SENSOR (
    IDSENSOR INT NOT NULL,
    IDTIPOSENSOR INT NOT NULL,
    IDESTACAO INT NOT NULL,
    DESCRICAO VARCHAR(45),
    LIMITE_INFERIOR DECIMAL(8,2),
    LIMITE_SUPERIOR DECIMAL(8,2),
    PRIMARY KEY (IDSENSOR),
    FOREIGN KEY (IDTIPOSENSOR) REFERENCES TIPOSENSOR (IDTIPOSENSOR),
    FOREIGN KEY (IDESTACAO) REFERENCES ESTACAO (IDESTACAO)
);
 
CREATE TABLE COLETA (
    IDCOLETA INT NOT NULL,
    IDSENSOR INT NOT NULL,
    DHCOLETA DATETIME,
    VALOR DECIMAL(8,2),
    PRIMARY KEY (IDCOLETA),
    FOREIGN KEY (IDSENSOR) REFERENCES SENSOR (IDSENSOR)
);
 
CREATE TABLE ALERTA (
    IDALERTA INT NOT NULL AUTO_INCREMENT,
    IDSENSOR INT NOT NULL,
    DHALERTA DATETIME,
    DESCRICAO VARCHAR(100),
    LIDA CHAR(1),
    PrIMARY KEY (IDALERTA),
    FOREIGN KEY (IDSENSOR) REFERENCES SENSOR (IDSENSOR)

);
-- Inserção de dados
INSERT INTO TIPOSENSOR VALUES (1, 'Anemômetro', 'Anemômetro 01');
INSERT INTO TIPOSENSOR VALUES (2, 'Pluviômetro', 'Pluviômetro 01');
INSERT INTO TIPOSENSOR VALUES (3, 'Sensor de Umidade', 'Sensor de Umidade 01');
INSERT INTO TIPOSENSOR VALUES (4, 'Sensor Temperatura', 'Sensor Temperatura 01');
INSERT INTO TIPOSENSOR VALUES (5, 'Sensor de Pressão', 'Sensor de Pressão 01');
INSERT INTO TIPOSENSOR VALUES (6, 'Direção do Vento', 'Direção do Vento 01');
INSERT INTO ESTACAO VALUES (1, "EFBGWEH", "FWEUFHF");
INSERT INTO SENSOR (IDSENSOR, IDTIPOSENSOR, IDESTACAO, descricao) VALUES
(1, 1, 1, "estaçao");
-- Procedimento para calcular outliers

DELIMITER $$
 
CREATE PROCEDURE CALCULAR_OUTLIERS()
BEGIN
    DECLARE sensor_id INT;
    DECLARE media DECIMAL(8,2);
    DECLARE desvio_padrao DECIMAL(8,2);
    DECLARE limite_inferior DECIMAL(8,2);
    DECLARE limite_superior DECIMAL(8,2);
 
    -- Cursor para percorrer todos os sensores
    DECLARE sensor_cursor CURSOR FOR SELECT IDSENSOR FROM SENSOR;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET sensor_id = NULL;
 
    OPEN sensor_cursor;
 
    -- Loop através de todos os sensores
    sensor_loop: LOOP
        FETCH sensor_cursor INTO sensor_id;
        IF sensor_id IS NULL THEN
            LEAVE sensor_loop;
        END IF;
 
        -- Verificar se há dados suficientes para calcular a média e o desvio padrão
        SELECT AVG(VALOR), STDDEV(VALOR)
        INTO media, desvio_padrao
        FROM COLETA
        WHERE IDSENSOR = sensor_id
        HAVING COUNT(*) > 1;
 
        IF media IS NOT NULL AND desvio_padrao IS NOT NULL THEN
            -- Cálculo dos limites inferior e superior
            SET limite_inferior = media - (2 * desvio_padrao);
            SET limite_superior = media + (2 * desvio_padrao);
 
            -- Atualização dos limites na tabela SENSOR
            UPDATE SENSOR
            SET LIMITE_INFERIOR = limite_inferior, LIMITE_SUPERIOR = limite_superior
            WHERE IDSENSOR = sensor_id;
        END IF;
    END LOOP;
 
    CLOSE sensor_cursor;
END $$
DELIMITER ;
-- Criação do Trigger
DELIMITER //
CREATE TRIGGER TRG_INSERIR_ALERTA
AFTER INSERT ON COLETA
FOR EACH ROW
BEGIN

    DECLARE lim_superior DECIMAL(8,2);

    DECLARE lim_inferior DECIMAL(8,2);

    DECLARE descricao_alerta VARCHAR(100);
 
    -- Obtém os limites superior e inferior para o sensor da coleta

    SELECT LIMITE_SUPERIOR, LIMITE_INFERIOR

    INTO lim_superior, lim_inferior

    FROM SENSOR

    WHERE IDSENSOR = NEW.IDSENSOR;
 
    -- Verifica se o valor está acima do limite superior ou abaixo do limite inferior

    IF NEW.VALOR > lim_superior OR NEW.VALOR < lim_inferior THEN

        -- Cria uma mensagem amigável para o alerta

        SET descricao_alerta = CONCAT('Valor fora dos limites: ', NEW.VALOR);
 
        -- Insere o alerta na tabela ALERTA

        INSERT INTO ALERTA ( IDSENSOR, DHALERTA, DESCRICAO, LIDA)

        VALUES (NEW.IDSENSOR, NOW(), descricao_alerta, 'N');

    END IF;

END //
DELIMITER ;
SELECT * FROM SENSOR;
INSERT INTO COLETA (IDCOLETA, IDSENSOR, DHCOLETA, VALOR) VALUES
(1, 1, '2023-11-10 12:00:00', 75.0),
(2, 1, '2023-11-10 13:30:00', 55.0),
(3, 1, '2023-11-10 14:30:00', 60.0),
(4, 1, '2023-11-10 15:30:00', 65.0),
(5, 1, '2023-11-10 16:30:00', 70.0),
(6, 1, '2023-11-10 17:30:00', 80.0),
(7, 1, '2023-11-10 18:30:00', 90.0),
(8, 1, '2023-11-10 19:30:00', 95.0);
CALL CALCULAR_OUTLIERS();
SELECT * FROM COLETA;
SELECT * FROM SENSOR;
INSERT INTO COLETA (IDCOLETA, IDSENSOR, DHCOLETA, VALOR) VALUES
(10, 1, '2023-11-10 12:00:00', 110.0),
(9, 1, '2023-11-10 13:30:00', 45.0);
select * from alerta;
 
 
 