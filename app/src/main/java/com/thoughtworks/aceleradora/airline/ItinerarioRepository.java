package com.thoughtworks.aceleradora.airline;

import com.thoughtworks.aceleradora.airline.dominio.Itinerario;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import static org.springframework.data.jpa.domain.Specification.where;

@Repository
public interface ItinerarioRepository extends CrudRepository<Itinerario, Long>, JpaSpecificationExecutor<Itinerario> {


    class CriteriosDeBusca {

        public static Specification<Itinerario> porOrigemDestino(String origem, String destino) {
            return origemIgualA(origem).and(destinoIgualA(destino));
        }

        private static Specification<Itinerario> origemIgualA(String origemProcurada) {

            String origemLowerCase = origemProcurada.toLowerCase();


            Specification<Itinerario> likeIata = (root, query, criteriaBuilder) -> criteriaBuilder
                    .like(criteriaBuilder
                            .lower(root.join("origem").get("iata")), origemLowerCase);

            Specification<Itinerario> likeCidade = (root, query, criteriaBuilder) -> criteriaBuilder
                    .like(criteriaBuilder
                            .lower(root.join("origem").get("cidade")), origemLowerCase);

            Specification<Itinerario> likeNome = (root, query, criteriaBuilder) -> criteriaBuilder
                    .like(criteriaBuilder
                            .lower(root.join("origem").get("nome")), origemLowerCase);

            return where(likeIata).or(likeCidade).or(likeNome);

        }

        private static Specification<Itinerario> destinoIgualA(String destinoProcurado) {

            String destinoLowerCase = destinoProcurado.toLowerCase();

            Specification<Itinerario> likeIata = (root, query, criteriaBuilder) -> criteriaBuilder
                    .like(criteriaBuilder
                            .lower(root.join("destino").get("iata")), destinoLowerCase);

            Specification<Itinerario> likeCidade = (root, query, criteriaBuilder) -> criteriaBuilder
                    .like(criteriaBuilder
                            .lower(root.join("destino").get("cidade")), destinoLowerCase);

            Specification<Itinerario> likeNome = (root, query, criteriaBuilder) -> criteriaBuilder
                    .like(criteriaBuilder
                            .lower(root.join("destino").get("nome")), destinoLowerCase);

            return where(likeIata).or(likeCidade).or(likeNome);
        }
    }

}
