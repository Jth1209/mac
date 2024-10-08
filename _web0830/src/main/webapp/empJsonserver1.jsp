<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, org.json.*" %>
<%
    String jdbcUrl = "jdbc:mysql://localhost:3306/your_database";
    String jdbcUser = "your_username";
    String jdbcPassword = "your_password";
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String action = request.getParameter("action");
    String responseJson = "";

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);

        if ("create".equalsIgnoreCase(action)) {
            String name = request.getParameter("name");
            String job = request.getParameter("job");
            int manager = Integer.parseInt(request.getParameter("manager"));
            String hireDate = request.getParameter("hireDate");
            double salary = Double.parseDouble(request.getParameter("salary"));
            double commission = Double.parseDouble(request.getParameter("commission"));
            int deptId = Integer.parseInt(request.getParameter("deptId"));

            String sql = "INSERT INTO emp (name, job, manager, hireDate, salary, commission, deptId) VALUES (?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, job);
            pstmt.setInt(3, manager);
            pstmt.setString(4, hireDate);
            pstmt.setDouble(5, salary);
            pstmt.setDouble(6, commission);
            pstmt.setInt(7, deptId);
            int rows = pstmt.executeUpdate();
            responseJson = "{\"status\":\"success\",\"rows\":" + rows + "}";

        } else if ("read".equalsIgnoreCase(action)) {
            String sql = "SELECT * FROM emp";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            JSONArray jsonArray = new JSONArray();
            while (rs.next()) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id", rs.getInt("id"));
                jsonObject.put("name", rs.getString("name"));
                jsonObject.put("job", rs.getString("job"));
                jsonObject.put("manager", rs.getInt("manager"));
                jsonObject.put("hireDate", rs.getDate("hireDate"));
                jsonObject.put("salary", rs.getDouble("salary"));
                jsonObject.put("commission", rs.getDouble("commission"));
                jsonObject.put("deptId", rs.getInt("deptId"));
                jsonArray.put(jsonObject);
            }
            responseJson = jsonArray.toString();

        } else if ("update".equalsIgnoreCase(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String job = request.getParameter("job");
            int manager = Integer.parseInt(request.getParameter("manager"));
            String hireDate = request.getParameter("hireDate");
            double salary = Double.parseDouble(request.getParameter("salary"));
            double commission = Double.parseDouble(request.getParameter("commission"));
            int deptId = Integer.parseInt(request.getParameter("deptId"));

            String sql = "UPDATE emp SET name=?, job=?, manager=?, hireDate=?, salary=?, commission=?, deptId=? WHERE id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, job);
            pstmt.setInt(3, manager);
            pstmt.setString(4, hireDate);
            pstmt.setDouble(5, salary);
            pstmt.setDouble(6, commission);
            pstmt.setInt(7, deptId);
            pstmt.setInt(8, id);
            int rows = pstmt.executeUpdate();
            responseJson = "{\"status\":\"success\",\"rows\":" + rows + "}";

        } else if ("delete".equalsIgnoreCase(action)) {
            int id = Integer.parseInt(request.getParameter("id"));

            String sql = "DELETE FROM emp WHERE id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            responseJson = "{\"status\":\"success\",\"rows\":" + rows + "}";
        }

    } catch (Exception e) {
        e.printStackTrace();
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        responseJson = "{\"error\":\"An error occurred while processing the request.\"}";
    } finally {
        if (rs != null) try { rs.close(); } catch (SQLException ignore) {}
        if (pstmt != null) try { pstmt.close(); } catch (SQLException ignore) {}
        if (conn != null) try { conn.close(); } catch (SQLException ignore) {}
    }

    out.print(responseJson);
%>