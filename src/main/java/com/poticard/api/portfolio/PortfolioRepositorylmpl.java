package com.poticard.api.portfolio;

import com.poticard.api.portfolio.model.PortfolioDto;
import javax.sql.DataSource;
import java.sql.*;

public class PortfolioRepositorylmpl implements PortfolioRepository {
    private final DataSource ds;

    public PortfolioRepositorylmpl(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public Integer create(PortfolioDto.CreateRequest dto) {
        Connection conn = null;
        try {
            conn = ds.getConnection();
            conn.setAutoCommit(false);


            String sql = "INSERT INTO portfolio (user_id, title, period) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setLong(1, dto.getUserId());
            pstmt.setString(2, dto.getTitle());
            pstmt.setString(3, dto.getPeriod());
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            int portfolioId = rs.next() ? rs.getInt(1) : -1;


            if (portfolioId != -1 && dto.getSections() != null) {
                String sSql = "INSERT INTO portfolio_section (portfolio_id, section_type, section_title, body_markdown, sort_order) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement sPstmt = conn.prepareStatement(sSql);

                for (PortfolioDto.SectionRequest s : dto.getSections()) {
                    sPstmt.setInt(1, portfolioId);
                    sPstmt.setString(2, s.getSectionType());
                    sPstmt.setString(3, s.getSectionTitle());
                    sPstmt.setString(4, s.getBodyMarkdown());
                    sPstmt.setInt(5, s.getSortOrder());
                    sPstmt.addBatch();
                }
                sPstmt.executeBatch();
            }

            conn.commit();
            return portfolioId;
        } catch (Exception e) {
            if (conn != null) try {
                conn.rollback();
            } catch (SQLException ex) {
            }
            throw new RuntimeException(e);
        } finally {
            if (conn != null) try {
                conn.close();
            } catch (SQLException e) {
            }
        }
    }
}