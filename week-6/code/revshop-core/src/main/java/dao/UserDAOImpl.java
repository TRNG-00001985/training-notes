package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import dto.UserRequest;
import dto.UserResponse;
import model.Role;
import utils.ConnectionFactory;

@Component
public class UserDAOImpl implements UserDAO{
	
	private Connection con;
	
	public UserDAOImpl() {
		
		con = ConnectionFactory.getConnectionFactory().getConnection();
	}
	

	@Override
    public boolean createUser(UserRequest userRequest) {
        String sql = "INSERT INTO users (first_name, last_name, email, password, role) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, userRequest.getfirstName());
            ps.setString(2, userRequest.getlastName());
            ps.setString(3, userRequest.getEmail());
            ps.setString(4, userRequest.getPassword());
            ps.setString(5, String.valueOf(userRequest.getRole()));            

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public UserResponse getUserById(long id) {
        String sql = "SELECT id, first_name, last_name, email, role FROM users WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                UserResponse user = new UserResponse();
                user.setId(rs.getLong("id"));
                user.setfirstName(rs.getString("first_name"));
                user.setlastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setRole(Role.valueOf(rs.getString("role")));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UserResponse updateUserById(UserRequest userRequest, long id) {
        String sql = "UPDATE users SET first_name = ?, last_name = ?, email = ?, password = ?, role = ? WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, userRequest.getfirstName());
            ps.setString(2, userRequest.getlastName());
            ps.setString(3, userRequest.getEmail());
            ps.setString(4, userRequest.getPassword());
            ps.setString(5, String.valueOf(userRequest.getRole()));            
            ps.setLong(6, id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                return getUserById(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteUserById(long id) {
        String sql = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, id);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public UserResponse login(String email, String password) {
        String sql = "SELECT id, first_name, last_name, email, role FROM users WHERE email = ? AND password = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                UserResponse user = new UserResponse();
                user.setId(rs.getLong("id"));
                user.setfirstName(rs.getString("first_name"));
                user.setlastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setRole(Role.valueOf(rs.getString("role")));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
	

}
