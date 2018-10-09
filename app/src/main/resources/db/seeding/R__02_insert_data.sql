--
--
--  AEROPORTOS
--
--
INSERT INTO aeroporto (iata, nome, cidade) VALUES
--   1
  ('POA', 'Aeroporto Internacional Salgado Filho', 'Porto Alegre'),
--   2
  ('GRU', 'Aeroporto Internacional de Guarulhos', 'Sao Paulo'),
--   3
  ('MIA', 'Miami International Airpot', 'Miami'),
--   5
  ('CGH', 'Aeroporto Internacional de Congonhas', 'Sao Paulo'),
--   5
  ('FLN', 'Aeroporto Internacional Hercilio Luz', 'Florianopolis'),
--   6
  ('CWB', 'Aeroporto Internacional Afonso Pena', 'Curitiba');

--
--
--  ITINERARIOS
--
--
INSERT INTO itinerario(origem_aeroporto_id, destino_aeroporto_id, horario_decolagem, horario_pouso) VALUES
--   1: POA > MIA
  (1, 3, NOW() + '50 hour', NOW() + '66 hour'),

--   2: POA > GRU
  (1, 2, NOW() + '50 hour', NOW() + '52 hour'),

--   3: GRU > MIA
  (2, 3, NOW() + '60 hour', NOW() + '66 hour'),

--   4: POA > CWB
  (1, 6, NOW() + '51 hour', NOW() + '52 hour');

--
--
--  VOOS
--
--

--   1: POA > MIA
INSERT INTO voo(itinerario_id) VALUES (1);

--   2: POA > CWB
INSERT INTO voo(itinerario_id) VALUES (4);

--
--
--  SEGMENTOS
--
--

-- 1: POA > GRU
INSERT INTO segmento(itinerario_id) VALUES (2);

-- 2: GRU > MIA
INSERT INTO segmento(itinerario_id) VALUES (3);

-- 3: POA > CWB
INSERT INTO segmento(itinerario_id) VALUES (4);

--
--
--  VOOS-SEGMENTOS
--
--

-- POA > MIA
INSERT INTO voo_segmento(voo_id, segmento_id) VALUES (1, 1);
INSERT INTO voo_segmento(voo_id, segmento_id) VALUES (1, 2);

--   POA > CWB
INSERT INTO voo_segmento(voo_id, segmento_id) VALUES (2, 3);
