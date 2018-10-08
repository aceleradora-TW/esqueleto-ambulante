CREATE TABLE segmento (
  id SERIAL PRIMARY KEY,
  itinerario_id INTEGER,
  horario_decolagem TIMESTAMP,
  horario_pouso TIMESTAMP,

  CONSTRAINT fk_itinerario FOREIGN KEY (itinerario_id) REFERENCES itinerario(id)
);