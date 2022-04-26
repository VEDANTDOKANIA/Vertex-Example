package database;

public class Field {
  public Field(){

  }
  String columName;
  String columnType;
  String defaultValue;

  public Field(String columName, Object columnType, String defaultValue) {
    this.columName = columName;
    if(columnType instanceof Integer){
      this.columnType = "Integer";
    }
    if(columnType instanceof String){
      this.columnType = "String";
    }

    this.defaultValue = defaultValue;
  }

  public String getColumName() {
    return columName;
  }

  public void setColumName(String columName) {
    this.columName = columName;
  }

  public String getColumnType() {
    return columnType;
  }

  public void setColumnType(String columnType) {
    this.columnType = columnType;
  }

  public String getDefaultValue() {
    return defaultValue;
  }

  public void setDefaultValue(String defaultValue) {
    this.defaultValue = defaultValue;
  }
}
