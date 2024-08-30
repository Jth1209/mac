<%@ page language="java" contentType="application/json; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, org.json.*" %>
<%
    String jdbcUrl = "jdbc:mysql://localhost:3306/spring5fs";
    String jdbcUser = "root";
    String jdbcPassword = "k1030112233!@#";
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String action = "";
    String responseJson = "";

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);

        // JSON 데이터 파싱
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = request.getReader().readLine()) != null) {
            sb.append(line);
        }
        JSONObject jsonData = new JSONObject(sb.toString());
        action = jsonData.getString("action");//action을 키값으로 가지고있는 데이터 정보를 json정보로 받아오는 경우

        if ("create".equalsIgnoreCase(action)) {
            String name = jsonData.getString("ename");
            String job = jsonData.getString("job");
            int manager = jsonData.getInt("mgr");
            String hireDate = jsonData.getString("hiredate");
            double salary = jsonData.getDouble("sal");
            double commission = jsonData.getDouble("comm");
            int deptId = jsonData.getInt("deptno");

            String sql = "INSERT INTO emp (ename, job, mgr, hiredate, sal, comm, deptno) VALUES (?, ?, ?, ?, ?, ?, ?)";
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
                jsonObject.put("id", rs.getInt("empno"));//json array에 값을 넣어줄 떄, map과 같은 방식으로 put을 사용한다.
                jsonObject.put("name", rs.getString("ename"));
                jsonObject.put("job", rs.getString("job"));
                jsonObject.put("manager", rs.getInt("mgr"));
                jsonObject.put("hireDate", rs.getDate("hiredate"));
                jsonObject.put("salary", rs.getDouble("sal"));
                jsonObject.put("commission", rs.getDouble("comm"));
                jsonObject.put("deptId", rs.getInt("deptno"));
                jsonArray.put(jsonObject);
            }
            responseJson = jsonArray.toString();

        } else if ("update".equalsIgnoreCase(action)) {
            int id = jsonData.getInt("empno");
            String name = jsonData.getString("ename");
            String job = jsonData.getString("job");
            int manager = jsonData.getInt("mgr");
            String hireDate = jsonData.getString("hiredate");
            double salary = jsonData.getDouble("sal");
            double commission = jsonData.getDouble("comm");
            int deptId = jsonData.getInt("deptno");

            String sql = "UPDATE emp SET ename=?, job=?, mgr=?, hiredate=?, sal=?, comm=?, deptno=? WHERE empno=?";
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
            int id = jsonData.getInt("empno");

            String sql = "DELETE FROM emp WHERE empno=?";
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