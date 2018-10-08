CREATE TABLE voo_segmento (
  id SERIAL PRIMARY KEY,
  voo_id INTEGER,
  segmento_id INTEGER,

  CONSTRAINT fk_voo FOREIGN KEY (voo_id) REFERENCES voo(id),
  CONSTRAINT fk_segmento FOREIGN KEY (segmento_id) REFERENCES segmento(id)
);