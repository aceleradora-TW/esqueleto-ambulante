CREATE TABLE itinerario(
  id SERIAL PRIMARY KEY,
  origem_aeroporto_id INTEGER,
  destino_aeroporto_id INTEGER,
  CONSTRAINT fk_aeroporto_origem FOREIGN KEY (origem_aeroporto_id) REFERENCES aeroporto(id),
  CONSTRAINT fk_aeroporto_destino FOREIGN KEY (destino_aeroporto_id) REFERENCES aeroporto(id)
);