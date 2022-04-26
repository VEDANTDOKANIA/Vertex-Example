package database;

import io.vertx.core.json.JsonObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;



public class DynamicQuery {

  public static void main(String[] args) {
    String select ="select column from table where condition";
    JsonObject jsonObject = new JsonObject();
    jsonObject.put("IP_address","10.20.40.140");
    jsonObject.put("Metric_Type","linux");
   /* String column =

    String query = select.replace("column",));*/

  try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nms","vedant.dokania","Mind@123");
    Statement stmt = conn.createStatement();
    Monitor monitor = new Monitor("10.20.40.140","vedant","Mind@123",22,"linux");
    HashMap<Field,Object> hashMap = new HashMap<>();
    Field field =  new Field("Ip_address", monitor.getIP_aaddress(), "Null");
    hashMap.put(field,monitor.IP_aaddress);
    hashMap.put(new Field("username",monitor.username,"Null"),monitor.username);
    hashMap.put(new Field("password",monitor.password,"Null"),monitor.password);
    hashMap.put(new Field("port",monitor.port,"Null"),monitor.port);
    hashMap.put(new Field("Metric_type",monitor.Metric_type,"Null"),monitor.Metric_type);

    String table = "monitor";
    boolean result = dynamicInsert(hashMap,table);
    ArrayList<String> arrayList = new ArrayList<>();
    arrayList.add("Ip_address");
    arrayList.add("Metric_type");
    arrayList.add("port");
    HashMap<String,Object> hashMap1 = new HashMap<>();
    hashMap1.put("port",22);
    hashMap1.put("Metric_type","linux");
    String query = dynamicSelect(arrayList,table,hashMap1,"and");
    ResultSet rs=stmt.executeQuery("select * from monitor");
    while(rs.next())
      System.out.println(rs.getString(1)+"  "+rs.getString(2)+" "+rs.getString(3));
    conn.close();
  } catch (Exception e) {
    System.out.println(e.fillInStackTrace());
  }
  }

  private static boolean dynamicInsert(HashMap<Field, Object> hashMap, String table) {
    StringBuilder query = new StringBuilder();
    query.append("insert into "+table+" (");
    ArrayList<String> column = new ArrayList<>();
    ArrayList<Object> value = new ArrayList<>();
    hashMap.forEach((key,data)->{
      Field field = new Field();
      field = key;
      column.add(field.columName);
      query.append(field.columName+",");
      if(field.getColumnType() =="Integer"){
        value.add(data);
      }else if (field.getColumnType() =="String") {
        value.add("\""+data+"\"");
      }
    });
  query.setLength(query.length()-1);
  query.append(")");
    query.append(" values (");
    value.forEach(columnValue ->{
      query.append(columnValue+",");
    });
    query.setLength(query.length()-1);
    query.append(");");
    System.out.println(query);
    //System.out.println(column);
    //System.out.println(value);

    return true;
  }
  private static String dynamicSelect(ArrayList<String> columns ,String table, HashMap<String,Object> compare,String condition){
    StringBuilder query = new StringBuilder();
    query.append("Select ");
    columns.forEach(column ->{
      query.append(column+",");
    });
    query.setLength(query.length()-1);
    query.append(" from "+ table +" "+"where ");
    compare.forEach((Column,value) ->{
      if(value instanceof String){
        query.append(Column +"="+"\""+value+"\" " + condition+" ");
      }else if (value instanceof Integer){
        query.append(Column +"="+value+ condition+" ");
      }

    });
    if(condition=="and"){
      query.setLength(query.length()-4);
    }else if(condition=="or"){
      query.setLength(query.length()-3);
    }
    query.append(";");
    System.out.println(query.toString());
    return query.toString();

  }






}
