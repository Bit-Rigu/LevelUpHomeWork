package bit.rigu.homework.lesson7.dao.impl;

import bit.rigu.homework.lesson7.dao.MathematicianDao;
import bit.rigu.homework.lesson7.dao.UniversityDao;
import bit.rigu.homework.lesson7.model.Mathematician;
import bit.rigu.homework.lesson7.model.University;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;
import java.util.Optional;

@Repository
public class MathematicianDaoImpl implements MathematicianDao {

    private final NamedParameterJdbcOperations jdbcOperations;
    private final RowMapper<Mathematician> mathRowMapper;

    public MathematicianDaoImpl(NamedParameterJdbcOperations jdbcOperations,
                                UniversityDao universityDao) {
        this.jdbcOperations = jdbcOperations;
        this.mathRowMapper = (rs, row) -> {
            final Mathematician math = new Mathematician();
            math.setId(rs.wasNull() ? null : rs.getInt("math_id"));
            math.setName(rs.getString("name"));
            math.setYearOfAward(rs.wasNull() ? null : rs.getInt("year_of_award"));
            math.setNationality(rs.getString("nationality"));
            math.setResearchArea(rs.getString("research_area"));
            University university = universityDao.getById(
                    rs.getInt("university_id")).orElse(null);
            math.setAlmaMater(university);
            return math;
        };
    }
    @Override
    public List<Mathematician> findAll() {
        final String sql = "SELECT * FROM mathematician";
        return jdbcOperations.query(sql, mathRowMapper);
    }

    @Override
    public int create(Mathematician math) {
        final String sql = "INSERT INTO mathematician" +
                "(math_id, name, year_of_award, " +
                "nationality, research_area, university_id)" +
                "values (:id, :name, :yearOfAward, " +
                ":nationality, :researchArea, :index)";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        final Integer id = math.getId();
        namedParameters.addValue("id", id, Types.INTEGER);
        namedParameters.addValue("name", math.getName(), Types.VARCHAR);
        namedParameters.addValue("yearOfAward", math.getYearOfAward(),
                Types.INTEGER);
        namedParameters.addValue("nationality", math.getNationality(),
                Types.VARCHAR);
        namedParameters.addValue("researchArea", math.getResearchArea(),
                Types.VARCHAR);
        namedParameters.addValue("index",
                math.getAlmaMater() == null ? null : math.getAlmaMater().getId(),
                Types.INTEGER);
        jdbcOperations.update(sql, namedParameters);
        return id;
    }

    @Override
    public Optional<Mathematician> getById(int id) {
        final String sql = "SELECT * FROM mathematician WHERE math_id = :id";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", id, Types.INTEGER);
        try {
            return Optional.of(jdbcOperations.queryForObject(
                    sql, namedParameters, mathRowMapper));
            } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public void deleteById(int id) {
        final String sql = "DELETE FROM mathematician WHERE math_id=:id";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", id, Types.INTEGER);
        jdbcOperations.update(sql, namedParameters);
    }

    @Override
    public void update(Mathematician math) {
        final String sql = "UPDATE mathematician SET name = :name," +
                "year_of_award = :yearOfAward, nationality = :nationality," +
                "research_area = :researchArea, university_id = :index " +
                "WHERE math_id = :id";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        final Integer id = math.getId();
        namedParameters.addValue("id", id, Types.INTEGER);
        namedParameters.addValue("name", math.getName(),
                Types.VARCHAR);
        namedParameters.addValue("yearOfAward", math.getYearOfAward(),
                Types.INTEGER);
        namedParameters.addValue("nationality", math.getNationality(),
                Types.VARCHAR);
        namedParameters.addValue("researchArea", math.getResearchArea(),
                Types.VARCHAR);
        namedParameters.addValue("index",
                math.getAlmaMater() == null ? null : math.getAlmaMater().getId(),
                Types.INTEGER);
        jdbcOperations.update(sql, namedParameters);
    }
}
