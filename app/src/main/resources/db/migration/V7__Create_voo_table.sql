CREATE TABLE voo (
  id SERIAL PRIMARY KEY,
  itinerario_id INTEGER,

  CONSTRAINT fk_itinerario FOREIGN KEY (itinerario_id) REFERENCES itinerario(id)
);
