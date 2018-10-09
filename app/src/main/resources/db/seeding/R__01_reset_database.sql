DELETE FROM voo_segmento;
DELETE FROM segmento;
DELETE FROM voo;
DELETE FROM itinerario;
DELETE FROM aeroporto;

ALTER SEQUENCE voo_segmento_id_seq RESTART WITH 1;
ALTER SEQUENCE segmento_id_seq RESTART WITH 1;
ALTER SEQUENCE voo_id_seq RESTART WITH 1;
ALTER SEQUENCE itinerario_id_seq RESTART WITH 1;
ALTER SEQUENCE aeroporto_id_seq RESTART WITH 1;
