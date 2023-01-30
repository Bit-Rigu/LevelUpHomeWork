package bit.rigu.homework.lesson7.dao.impl;

import bit.rigu.homework.lesson7.dao.UniversityDao;
import bit.rigu.homework.lesson7.model.University;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UniversityDaoImpl implements UniversityDao {
    private final NamedParameterJdbcOperations jdbcOperations;
    private final RowMapper<University> universityRowMapper =
            (rs, row) -> new University(rs.getInt("id"),
                                        rs.getString("name"),
                                        rs.getString("country"),
                                        rs.getInt("year_of_establishment"));

    @Override
    public List<University> findAll() {
        final String sql = "SELECT * FROM university";
        return jdbcOperations.query(sql, universityRowMapper);
    }

    @Override
    public int create(University university) {
        final String sql = "INSERT INTO university " +
                "(id, name, country, year_of_establishment) values " +
                "(:id, :name, :country, :yearOfEstablishment)";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        final Integer id = university.getId();
        namedParameters.addValue("id", id, Types.INTEGER);
        namedParameters.addValue("name", university.getName(),
                Types.VARCHAR);
        namedParameters.addValue("country", university.getCountry(),
                Types.VARCHAR);
        namedParameters.addValue("yearOfEstablishment",
                university.getYearOfEstablishment(), Types.INTEGER);
        jdbcOperations.update(sql, namedParameters);
        return id;
    }

    @Override
    public Optional<University> getById(int id) {
        final String sql = "SELECT * FROM university WHERE id = :id";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", id, Types.INTEGER);
        try {
            return Optional.of(jdbcOperations.queryForObject(
                    sql, namedParameters, universityRowMapper));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public void deleteById(int id) {
        final String sql = "DELETE FROM university WHERE id=:id";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", id, Types.INTEGER);
        jdbcOperations.update(sql, namedParameters);
    }

    @Override
    public void update(University university) {
        final String sql = "UPDATE university SET name = :name," +
                "country = :country, year_of_establishment = :yearOfEstablishment " +
                "WHERE id = :id";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        final Integer id = university.getId();
        namedParameters.addValue("id", id, Types.INTEGER);
        namedParameters.addValue("name", university.getName(),
                Types.VARCHAR);
        namedParameters.addValue("country", university.getCountry(),
                Types.VARCHAR);
        namedParameters.addValue("yearOfEstablishment",
                university.getYearOfEstablishment(), Types.INTEGER);
        jdbcOperations.update(sql, namedParameters);
    }

}
