package database;

public class Monitor {
  String IP_aaddress;
  String username ;
  String password ;
  int port ;
  String Metric_type;
  String Community ;
  String version ;
  //For Windows and Linux
  public Monitor(String IP_aaddress, String username, String password, int port, String metric_type) {
    this.IP_aaddress = IP_aaddress;
    this.username = username;
    this.password = password;
    this.port = port;
    Metric_type = metric_type;
  }
  //for SNMP
  public Monitor(String IP_aaddress, String username, String password, int port, String metric_type, String community, String version) {
    this.IP_aaddress = IP_aaddress;
    this.username = username;
    this.password = password;
    this.port = port;
    Metric_type = metric_type;
    Community = community;
    this.version = version;
  }


  public String getIP_aaddress() {
    return IP_aaddress;
  }

  public void setIP_aaddress(String IP_aaddress) {
    this.IP_aaddress = IP_aaddress;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }

  public String getCommunity() {
    return Community;
  }

  public void setCommunity(String community) {
    Community = community;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }



}
